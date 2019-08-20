package Venator.Venator.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@Component
public class GetRegionNames {

    private static final Log logger = LogFactory.getLog(GetRegionNames.class);

    public ArrayList<String> GetRegionNames() throws IOException, ParseException {
        ArrayList<String> regionNames = new ArrayList<>();

        FileReader reader = new FileReader("src/main/resources/json_config/RegionMappings.json");
        JSONParser jsonParser = new JSONParser();

        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
        JSONObject obj;
        for (int i = 0; i < jsonArray.size(); i++) {
            obj = (JSONObject) (jsonArray.get(i));
            String regionName = obj.get("name").toString();
            regionNames.add(regionName);
        }
        Collections.sort(regionNames);
        logger.info(regionNames);
        return regionNames;
    }
}
