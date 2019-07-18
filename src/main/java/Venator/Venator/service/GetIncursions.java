package Venator.Venator.service;

import Venator.Venator.dbEntity.ConstellationIncursionEntity;
import Venator.Venator.dbRepo.ConstellationIncursionRepository;
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
public class GetIncursions {

  @Autowired ConstellationIncursionRepository constellationIncursionRepository;

  @Scheduled(fixedRate = 86400000)
  public String getIncursions() throws IOException, ParseException {
    Long constellationId;
    Boolean isIncursion = true;

    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url("https://esi.evetech.net/latest/incursions/?datasource=tranquility&language=en-us")
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
      constellationId = Long.valueOf(obj.get("constellation_id").toString());

      System.out.println(+constellationId + " /// " + isIncursion);

      ConstellationIncursionEntity CIE = new ConstellationIncursionEntity();
      CIE.setConstellationId(constellationId);
      CIE.setIncursion(isIncursion);

      constellationIncursionRepository.save(CIE);
    }

    return response.body().string();
  }
}
