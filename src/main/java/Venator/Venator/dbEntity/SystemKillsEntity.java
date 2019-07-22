package Venator.Venator.dbEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(
    name = "SystemKillsMapping",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"SystemId"})})
public class SystemKillsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "SystemId",unique=true)
  @NotNull
  private Long systemId;

  @Column(name = "NpcKills")
  private Long npcKills;

  @Column(name = "PodKills")
  private Long podKills;

  @Column(name = "ShipKills")
  private Long shipKills;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
