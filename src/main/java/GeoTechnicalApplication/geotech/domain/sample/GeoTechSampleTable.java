package GeoTechnicalApplication.geotech.domain.sample;

import GeoTechnicalApplication.geotech.domain.AuditBase;
import jakarta.persistence.*;
import lombok.Data;

import static GeoTechnicalApplication.geotech.domain.sample.GeoTechSampleTable.TBL_SAMPLE;

@Data
@Entity
@Table(name = TBL_SAMPLE)
@AttributeOverride(name = "id", column = @Column(name = GeoTechSampleTable.S_SAMPLE_ID))
public class GeoTechSampleTable extends AuditBase {
    public static final String TBL_SAMPLE = "TBL_SAMPLE";
    public static final String S_SAMPLE_ID = "S_SAMPLE_ID";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = S_SAMPLE_ID, nullable = false)
    private Long id;


}
