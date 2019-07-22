package Venator.Venator.dbEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SystemJumpsMapping")
public class SystemJumpsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "SystemId", unique = true)
  @NotNull
  private Long systemId;

  @Column(name = "ShipJumps")
  private Long shipJumps;

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

  public Long getShipJumps() {
    return shipJumps;
  }

  public void setShipJumps(Long shipJumps) {
    this.shipJumps = shipJumps;
  }
}
