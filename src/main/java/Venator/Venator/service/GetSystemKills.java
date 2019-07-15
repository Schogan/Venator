package Venator.Venator.service;

import com.squareup.okhttp.*;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class GetSystemKills {
  public String getSystemKills() throws IOException {
    OkHttpClient client = new OkHttpClient();

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

    return response.body().string();
  }
}
