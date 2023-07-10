package GeoTechnicalApplication.geotech.domain;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class AuditBase {

    @CreatedDate
    @Column(name = "d_created") private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "t_createdby", length = 50) private String createdBy;

    @LastModifiedDate
    @Column(name = "d_updated") private LocalDateTime lastUpdatedDate;

    @LastModifiedBy
    @Column(name = "t_updatedby", length = 50) private String lastUpdatedBy;


}
