package Venator.Venator.service;

import Venator.Venator.dbEntity.SystemKillsEntity;
import Venator.Venator.dbRepo.SystemKillsRepository;
import com.squareup.okhttp.*;
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
public class GetSystemKills {

  @Autowired SystemKillsRepository systemKillsRepository;

  @Scheduled(fixedRate = 3600000)
  public String getSystemKills() throws IOException, ParseException {
    Long systemId;
    Long npcKills;
    Long podKills;
    Long shipKills;

    OkHttpClient client = new OkHttpClient();

    systemKillsRepository.deleteAll();

    Request request =
        new Request.Builder()
            .url(
                "https://esi.evetech.net/latest/universe/system_kills/?datasource=tranquility&language=en-us")
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
      systemId = Long.valueOf(obj.get("system_id").toString());
      npcKills = Long.valueOf(obj.get("npc_kills").toString());
      podKills = Long.valueOf(obj.get("pod_kills").toString());
      shipKills = Long.valueOf(obj.get("ship_kills").toString());

      System.out.println(+systemId + " /// " + npcKills + " /// " + podKills + " /// " + shipKills);

      SystemKillsEntity SKE = new SystemKillsEntity();
      SKE.setSystemId(systemId);
      SKE.setNpcKills(npcKills);
      SKE.setPodKills(podKills);
      SKE.setShipKills(shipKills);

      systemKillsRepository.save(SKE);
    }

    return response.body().string();
  }
}
