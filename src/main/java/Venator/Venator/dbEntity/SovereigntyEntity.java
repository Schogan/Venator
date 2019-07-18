package Venator.Venator.dbEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

    @Entity
    @Table(name = "SovereigntyMapping")
    public class SovereigntyEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "ID")
        private Long id;

        @Column(name = "SystemId")
        @NotNull
        private Long systemId;

        @Column(name = "AllianceId")
        private Long allianceId;

        @Column(name = "CorporationId")
        private Long corporationId;

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

        public Long getAllianceId() {
            return allianceId;
        }

        public void setAllianceId(Long allianceId) {
            this.allianceId = allianceId;
        }

        public Long getCorporationId() {
            return corporationId;
        }

        public void setCorporationId(Long corporationId) {
            this.corporationId = corporationId;
        }
    }
