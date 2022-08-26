package com.jupiter.oppsservice.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "opp_sale")
public class OppSale {
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
}