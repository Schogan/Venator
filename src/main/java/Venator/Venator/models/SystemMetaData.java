package Venator.Venator.models;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class SystemMetaData {
  private Long npcKills;
  private Long podKills;
  private Long shipKills;
  private Long jumps;

  public Long getNpcKills() {
    return npcKills;
  }

  public void setNpcKills(Long npcKills) {
    this.npcKills = npcKills;
  }

  public Long getPodKills() {
    return podKills;
  }

  public void setPodKills(Long podKills) {
    this.podKills = podKills;
  }

  public Long getShipKills() {
    return shipKills;
  }

  public void setShipKills(Long shipKills) {
    this.shipKills = shipKills;
  }

  public Long getJumps() {
    return jumps;
  }

  public void setJumps(Long jumps) {
    this.jumps = jumps;
  }

  public ArrayList getSystemMetaData() {
    ArrayList systemInfo = new ArrayList();
    systemInfo.add(npcKills);
    systemInfo.add(podKills);
    systemInfo.add(shipKills);
    systemInfo.add(jumps);
    return systemInfo;
  }
}
