package Venator.Venator.dbEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RegionMapping")
public class RegionMappingEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "RegionId")
  @NotNull
  private Long regionId;

  @Column(name = "RegionName")
  @NotNull
  private String regionName;

  @Column(name = "ConstellationId")
  @NotNull
  private Long constellationId;

  @Column(name = "ConstellationName")
  @NotNull
  private String constellationName;

  @Column(name = "SystemId")
  @NotNull
  private Long systemId;

  @Column(name = "SystemName")
  @NotNull
  private String systemName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getRegionId() {
    return regionId;
  }

  public void setRegionId(Long regionId) {
    this.regionId = regionId;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public Long getConstellationId() {
    return constellationId;
  }

  public void setConstellationId(Long constellationId) {
    this.constellationId = constellationId;
  }

  public String getConstellationName() {
    return constellationName;
  }

  public void setConstellationName(String constellationName) {
    this.constellationName = constellationName;
  }

  public Long getSystemId() {
    return systemId;
  }

  public void setSystemId(Long systemId) {
    this.systemId = systemId;
  }

  public String getSystemName() {
    return systemName;
  }

  public void setSystemName(String systemName) {
    this.systemName = systemName;
  }
}
