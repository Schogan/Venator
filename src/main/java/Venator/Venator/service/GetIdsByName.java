package Venator.Venator.service;

import Venator.Venator.models.TestModel;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetIdsByName {

  @Autowired public TestModel testModel;

  private static final Log logger = LogFactory.getLog(GetIdsByName.class);

  public String getIdsByName() throws IOException {
    OkHttpClient client = new OkHttpClient();

    ArrayList names = getListOfNames();
    //    ArrayList<String> names = new
    // ArrayList<>(Arrays.asList(testModel.getMultiCheckboxSelectedValues()));
    String newIds = new Gson().toJson(names);

    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, newIds);
    Request request =
        new Request.Builder()
            .url(
                "https://esi.evetech.net/latest/universe/ids/?datasource=tranquility&language=en-us")
            .post(body)
            .addHeader("accept", "application/json")
            .addHeader("Accept-Language", "en-us")
            .build();

    Response response = client.newCall(request).execute();

    return response.body().string();
  }

  public ArrayList getListOfNames() {
    ArrayList<String> names =
        new ArrayList<>(Arrays.asList(testModel.getMultiCheckboxSelectedValues()));

    return names;
  }
}
