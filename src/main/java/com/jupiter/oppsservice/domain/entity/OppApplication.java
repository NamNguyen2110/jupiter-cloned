package com.jupiter.oppsservice.domain.entity;

import com.jupiter.oppsservice.domain.converter.ApplicationTypeEnumConverter;
import com.jupiter.oppsservice.domain.converter.OppApplicationStatusEnumConverter;
import com.jupiter.oppsservice.domain.enums.ApplicationStatus;
import com.jupiter.oppsservice.domain.enums.ApplicationType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "opp_application")
public class OppApplication {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "employee_id")
    private String employeeId;

    @ManyToOne
    @JoinColumn(name = "opp_id", referencedColumnName = "id")
    private Opp opp;

    @ManyToOne
    @JoinColumn(name = "opp_requirement_id", referencedColumnName = "id")
    private OppRequirement oppoRequirement;

    @Convert(converter = OppApplicationStatusEnumConverter.class)
    @Column(name = "status")
    private ApplicationStatus status;

    @Convert(converter = ApplicationTypeEnumConverter.class)
    @Column(name = "process_type")
    private ApplicationType applicationType;

}

