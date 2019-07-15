package Venator.Venator.models;

import java.awt.*;
import org.springframework.stereotype.Component;

@Component
public class TestModel {
  private String character;
  private String system;
  String[] multiCheckboxSelectedValues;

  public String[] getMultiCheckboxSelectedValues() {
    return multiCheckboxSelectedValues;
  }

  public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
    this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
  }

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
