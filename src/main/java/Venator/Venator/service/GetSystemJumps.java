package Venator.Venator.service;

import Venator.Venator.dbEntity.SystemJumpsEntity;
import Venator.Venator.dbRepo.SystemJumpsRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@EnableScheduling
@Component
public class GetSystemJumps {

    @Autowired
    SystemJumpsRepository systemJumpsRepository;

        @Scheduled(fixedRate = 3600000)
        public String getSystemJumps() throws IOException, ParseException {
            Long systemId;
            Long shipJumps;

            OkHttpClient client = new OkHttpClient();

            Request request =
                    new Request.Builder()
                            .url(
                                    "https://esi.evetech.net/latest/universe/system_jumps/?datasource=tranquility&language=en-us")
                            .get()
                            .addHeader("Accept", "*/*")
                            .addHeader("Host", "esi.evetech.net")
                            .addHeader("Connection", "keep-alive")
                            .addHeader("cache-control", "no-cache")
                            .build();

            Response response = client.newCall(request).execute();
            JSONParser jsonParser = new JSONParser();

            JSONArray jsonArray = (JSONArray) jsonParser.parse(response.body().string());
            JSONObject obj;
            for (Object object:jsonArray){
                obj = (JSONObject) object;
                systemId = Long.valueOf(obj.get("system_id").toString());
                shipJumps = Long.valueOf(obj.get("ship_jumps").toString());

                System.out.println(
                        + systemId
                                + " /// "
                                + shipJumps);

                SystemJumpsEntity SKE = new SystemJumpsEntity();
                SKE.setSystemId(systemId);
                SKE.setShipJumps(shipJumps);

                systemJumpsRepository.save(SKE);

            }

            return response.body().string();
        }
    }


