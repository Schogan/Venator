package Venator.Venator.models;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestModel {

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
