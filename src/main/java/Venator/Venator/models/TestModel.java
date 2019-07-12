package Venator.Venator.models;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class TestModel {

  private static final Log logger = LogFactory.getLog(TestModel.class);

  private String character;
  private String system;
  private String WickedCreek;
  private String TheForge;
  private String BleakLands;

  public String getWickedCreek() {
    return WickedCreek;
  }

  public void setWickedCreek(String wickedCreek) {
    this.WickedCreek = wickedCreek;
  }

  public String getTheForge() {
    return TheForge;
  }

  public void setTheForge(String theForge) {
    this.TheForge = theForge;
  }

  public String getBleakLands() {
    return BleakLands;
  }

  public void setBleakLands(String bleakLands) {
    this.BleakLands = bleakLands;
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
