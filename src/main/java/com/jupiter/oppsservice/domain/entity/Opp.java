package com.jupiter.oppsservice.domain.entity;

import com.jupiter.oppsservice.domain.converter.OppTypeEnumConverter;
import com.jupiter.oppsservice.domain.converter.OppStatusEnumConverter;
import com.jupiter.oppsservice.domain.enums.OppStatus;
import com.jupiter.oppsservice.domain.enums.OppType;
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

    @Column(name = "opp_name")
    private String oppName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "sale_pic_id")
    private String salesPic;

    @Column(name = "du_pic")
    private String duPic;

    @Convert(converter = OppStatusEnumConverter.class)
    @Column(name = "status")
    private OppStatus status;

    @Convert(converter = OppTypeEnumConverter.class)
    @Column(name = "opp_type")
    private OppType oppType;

    @OneToMany(mappedBy = "opp")
    private List<OppPosition> oppPositions = new ArrayList<>();

    @OneToMany(mappedBy = "opp")
    private List<OppApplication> oppApplications = new ArrayList<>();
}
