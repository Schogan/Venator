package Venator.Venator.models;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RegionSelectModel {
  String[] multiCheckboxSelectedValues;

  public String[] getMultiCheckboxSelectedValues() {
    return multiCheckboxSelectedValues;
  }

  public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
    this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
  }

  public void resetMultiCheckboxSelectedValues(){
    multiCheckboxSelectedValues = new String[]{};
  }
}
