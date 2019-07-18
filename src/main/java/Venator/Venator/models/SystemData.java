package Venator.Venator.models;

public class SystemData {
  private String region;
  private String constellation;
  private String systemName;
  private Long systemId;
  private Long npcKills;
  private Long podKills;
  private Long shipKills;
  private Long systemJumps;

  public SystemData(
      String region,
      String constellation,
      String systemName,
      Long systemId,
      Long npcKills,
      Long podKills,
      Long shipKills,
      Long systemJumps) {
    this.region = region;
    this.constellation = constellation;
    this.systemName = systemName;
    this.systemId = systemId;
    this.npcKills = npcKills;
    this.podKills = podKills;
    this.shipKills = shipKills;
    this.systemJumps = systemJumps;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getConstellation() {
    return constellation;
  }

  public void setConstellation(String constellation) {
    this.constellation = constellation;
  }

  public String getSystemName() {
    return systemName;
  }

  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }

  public Long getSystemId() {
    return systemId;
  }

  public void setSystemId(Long systemId) {
    this.systemId = systemId;
  }

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

  public Long getSystemJumps() {
    return systemJumps;
  }

  public void setSystemJumps(Long systemJumps) {
    this.systemJumps = systemJumps;
  }
}
