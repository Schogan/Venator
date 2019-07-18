package Venator.Venator.service;

import Venator.Venator.dbEntity.SovereigntyEntity;
import Venator.Venator.dbRepo.SovereigntyRepository;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class GetSovereignty {

  @Autowired SovereigntyRepository sovereigntyRepository;

  @Scheduled(fixedRate = 86400000)
  public String getSovereignty() throws IOException, ParseException {
    Long allianceId;
    Long corporationId;
    Long systemId;

    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url(
                "https://esi.evetech.net/latest/sovereignty/map/?datasource=tranquility&language=en-us")
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
    for (Object object : jsonArray) {
      obj = (JSONObject) object;

      if (obj.get("alliance_id") == null) {
        allianceId = null;
      } else {
        allianceId = Long.valueOf(obj.get("alliance_id").toString());
      }

      if (obj.get("corporation_id") == null) {
        corporationId = null;
      } else {
        corporationId = Long.valueOf(obj.get("corporation_id").toString());
      }

      systemId = Long.valueOf(obj.get("system_id").toString());

      System.out.println(allianceId + " /// " + corporationId + " /// " + systemId);

      SovereigntyEntity SE = new SovereigntyEntity();
      SE.setAllianceId(allianceId);
      SE.setCorporationId(corporationId);
      SE.setSystemId(systemId);

      sovereigntyRepository.save(SE);
    }

    return response.body().string();
  }
}
