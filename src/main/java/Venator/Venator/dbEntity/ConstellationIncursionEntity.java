package Venator.Venator.dbEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ConstellationIncursionMapping")
public class ConstellationIncursionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "ConstellationId")
  @NotNull
  private Long constellationId;

  @Column(name = "IsIncursion")
  @NotNull
  private Boolean isIncursion;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getConstellationId() {
    return constellationId;
  }

  public void setConstellationId(Long constellationId) {
    this.constellationId = constellationId;
  }

  public Boolean getIncursion() {
    return isIncursion;
  }

  public void setIncursion(Boolean incursion) {
    isIncursion = incursion;
  }
}
