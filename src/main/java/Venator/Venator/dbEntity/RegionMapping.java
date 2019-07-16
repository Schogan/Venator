package Venator.Venator.dbEntity;

public class RegionMapping {

  private final Long id;
  private final Long regionId;
  private final String regionName;
  private final Long ConstellationId;
  private final String ConstellationName;
  private final Long systemId;
  private final String systemName;

  public RegionMapping(
      Long id,
      Long regionId,
      String regionName,
      Long constellationId,
      String constellationName,
      Long systemId,
      String systemName) {
    this.id = id;
    this.regionId = regionId;
    this.regionName = regionName;
    this.ConstellationId = constellationId;
    this.ConstellationName = constellationName;
    this.systemId = systemId;
    this.systemName = systemName;
  }

  public Long getId() {
    return id;
  }

  public Long getRegionId() {
    return regionId;
  }

  public String getRegionName() {
    return regionName;
  }

  public Long getConstellationId() {
    return ConstellationId;
  }

  public String getConstellationName() {
    return ConstellationName;
  }

  public Long getSystemId() {
    return systemId;
  }

  public String getSystemName() {
    return systemName;
  }

  @Override
  public String toString() {
    return "RegionMapping{"
        + "id="
        + id
        + ", regionId="
        + regionId
        + ", regionName='"
        + regionName
        + '\''
        + ", ConstellationId="
        + ConstellationId
        + ", ConstellationName='"
        + ConstellationName
        + '\''
        + ", systemId="
        + systemId
        + ", systemName='"
        + systemName
        + '\''
        + '}';
  }
}
