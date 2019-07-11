package Venator.Venator.models;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class TestModel {

  private static final Log logger = LogFactory.getLog(TestModel.class);

  private String character;
  private String system;

  public String getCharacter() {
    logger.info("Get character call: " + character);
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
    logger.info("Set character call: " + character);
  }

  public String getSystem() {
    logger.info("Get system call: " + system);
    return system;
  }

  public void setSystem(String system) {
    logger.info("Set system call: " + system);
    this.system = system;
  }
}
