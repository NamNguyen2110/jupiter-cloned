package com.jupiter.oppsservice.domain.entity;

import com.jupiter.oppsservice.domain.converter.ActivityTypeEnumConverter;
import com.jupiter.oppsservice.domain.converter.ProjectTypeEnumConverter;
import com.jupiter.oppsservice.domain.converter.OppStatusEnumConverter;
import com.jupiter.oppsservice.domain.enums.ActivityType;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.ProjectType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "opp")
public class Opp extends AbstractEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "project_code")
    private String projectCode;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "du_pic")
    private String duPic;

    @Column(name = "sale_pic_id")
    private String salePicId;

    @OneToMany(mappedBy = "opp")
    private List<OppRequirement> oppRequirements = new ArrayList<>();

    @OneToMany(mappedBy = "opp")
    private List<OppSale> oppSales = new ArrayList<>();

    @OneToMany(mappedBy = "opp")
    private List<OppApplication> oppApplications = new ArrayList<>();

    @Convert(converter = ProjectTypeEnumConverter.class)
    @Column(name = "project_type")
    private ProjectType projectType;

    @Convert(converter = ActivityTypeEnumConverter.class)
    @Column(name = "activity_type")
    private ActivityType activityType;

    @Convert(converter = OppStatusEnumConverter.class)
    private OppStatus status;
}
