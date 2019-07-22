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
import org.springframework.stereotype.Component;

// @EnableScheduling
@Component
public class GetSovereignty {

  @Autowired private SovereigntyRepository sovereigntyRepository;
  @Autowired private GetCorporationInformation getCorporationInformation;
  @Autowired private GetAllianceInformation getAllianceInformation;

  // @Scheduled(fixedRate = 86400000)
  public String getSovereigntyMapping() throws IOException, ParseException {
    Long allianceId;
    Long corporationId;
    Long systemId;
    String allianceName = null;
    String corporationName = null;

    sovereigntyRepository.deleteAll();

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
        allianceName = null;
      } else {
        allianceId = Long.valueOf(obj.get("alliance_id").toString());
        allianceName = getAllianceInformation.getAllianceInformation(allianceId);
      }

      if (obj.get("corporation_id") == null) {
        corporationId = null;
        corporationName = null;
      } else {
        corporationId = Long.valueOf(obj.get("corporation_id").toString());
        corporationName = getCorporationInformation.getCorporationInformation(corporationId);
      }

      systemId = Long.valueOf(obj.get("system_id").toString());

      System.out.println(
          allianceId
              + " /// "
              + allianceName
              + " /// "
              + corporationId
              + " /// "
              + corporationName
              + " /// "
              + systemId);

      SovereigntyEntity SE = new SovereigntyEntity();
      SE.setAllianceId(allianceId);
      SE.setAllianceName(allianceName);
      SE.setCorporationId(corporationId);
      SE.setCorporationName(corporationName);
      SE.setSystemId(systemId);

      sovereigntyRepository.save(SE);
    }

    return response.body().string();
  }
}
