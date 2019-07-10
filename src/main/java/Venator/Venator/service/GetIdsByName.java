package Venator.Venator.service;

import Venator.Venator.models.TestModel;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;

public class GetIdsByName {
    @Autowired
    public TestModel testModel;

    //@RequestMapping("/getIdsByName/{Character}")
    @RequestMapping("/getIdsByNamePost")
    public String getIdsByName() throws IOException {
//        public String getIdsByName(@PathVariable("Character") String Character) throws IOException {
        OkHttpClient client = new OkHttpClient();
//            ArrayList ids = new ArrayList();
//            System.out.println(Character);
//            ids.add(Character);
        ArrayList ids = testModel.getIdRequest();
        String newIds = new Gson().toJson(ids);

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, newIds);
        Request request = new Request.Builder()
                .url("https://esi.evetech.net/latest/universe/ids/?datasource=tranquility&language=en-us")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("Accept-Language", "en-us")
                .build();

        Response response = client.newCall(request).execute();

        return response.body().string();
    }
}
