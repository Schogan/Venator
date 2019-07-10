package Venator.Venator.models;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class TestModel {

    public ArrayList getIdRequest(){
        ArrayList<String> ids = new ArrayList(Arrays.asList("Jita","Schogan","Asakai"));

        return ids;
    }

    private String character;
    private String system;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
