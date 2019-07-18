package Venator.Venator.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GetAllianceInformation {

    public String getAllianceInformation(Long allianceId) throws IOException, ParseException {
        String allianceName = null;

        OkHttpClient client = new OkHttpClient();

        Request request =
                new Request.Builder()
                        .url(
                                "https://esi.evetech.net/latest/alliances/"+allianceId+"/?datasource=tranquility&language=en-us")
                        .get()
                        .addHeader("Accept", "*/*")
                        .addHeader("Host", "esi.evetech.net")
                        .addHeader("Connection", "keep-alive")
                        .addHeader("cache-control", "no-cache")
                        .build();

        Response response = client.newCall(request).execute();
        JSONParser jsonParser = new JSONParser();

        JSONObject obj = (JSONObject) jsonParser.parse(response.body().string());

            if (obj.get("name") == null) {
                allianceName = null;
            } else {
                allianceName = obj.get("name").toString();
            }
        return allianceName;
    }
}
