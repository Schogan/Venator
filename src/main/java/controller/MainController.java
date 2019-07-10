package controller;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import com.squareup.okhttp.RequestBody;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class MainController {

        //@RequestMapping("/getIdsByName/{Character}")
        @RequestMapping("/getIdsByName")
        public String getIdsByName() throws IOException {
//        public String getIdsByName(@PathVariable("Character") String Character) throws IOException {
            OkHttpClient client = new OkHttpClient();
//            ArrayList ids = new ArrayList();
//            System.out.println(Character);
//            ids.add(Character);
            ArrayList ids = getIdRequest();
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

        //populate this through some user interface

        public ArrayList getIdRequest(){
            //JSONObject obj = new JSONObject(message);
            ArrayList<String> ids = new ArrayList(Arrays.asList("Jita","Schogan","Asakai"));

            return ids;
        }
}
