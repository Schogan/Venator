package Venator.Venator.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class GetSystem {

  public static String getSystemId(String systemId) throws IOException {

    OkHttpClient client = new OkHttpClient();

    Request request =
        new Request.Builder()
            .url(
                "https://esi.evetech.net/latest/universe/systems/"
                    + systemId
                    + "/?datasource=tranquility&language=en-us")
            .get()
            .addHeader("Accept", "*/*")
            .addHeader("Cache-Control", "no-cache")
            .addHeader("Host", "esi.evetech.net")
            .build();

    Response response = client.newCall(request).execute();

    return response.body().string();
  }
}
