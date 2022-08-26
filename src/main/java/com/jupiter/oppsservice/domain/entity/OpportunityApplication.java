package com.jupiter.oppsservice.domain.entity;
import com.jupiter.oppsservice.domain.converter.OppAppStatusEnumConverter;
import com.jupiter.oppsservice.domain.converter.ProcessTypeEnumConverter;
import com.jupiter.oppsservice.domain.converter.OppStatusEnumConverter;
import com.jupiter.oppsservice.domain.enums.OppAppStatus;
import com.jupiter.oppsservice.domain.enums.ProcessType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "opp_application")
public class OpportunityApplication {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "employee_id")
    private String employeeId;

    @Convert(converter = OppAppStatusEnumConverter.class)
    @Column(name = "status")
    private OppAppStatus status;

    @Convert(converter = ProcessTypeEnumConverter.class)
    @Column(name = "process_type")
    private ProcessType processType;

    @ManyToOne
    @JoinColumn(name = "opp_id", referencedColumnName = "id")
    private Opportunity opportunity;

    @ManyToOne
    @JoinColumn(name = "opp_requirement_id", referencedColumnName = "id")
    private OpportunityRequirement oppoRequirement;

}
