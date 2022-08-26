package com.jupiter.oppsservice.domain.entity;

import com.jupiter.oppsservice.domain.converter.LevelEnumConverter;
import com.jupiter.oppsservice.domain.enums.Level;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "opp_requirement")
public class OpportunityRequirement {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "position")
    private String position;

    @Column(name = "exp")
    private Double exp;

    @Column(name = "skill_stack")
    private String skillStack;

    @Column(name = "note")
    private String note;

    @Convert(converter = LevelEnumConverter.class)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "opp_id", referencedColumnName = "id")
    private Opportunity opportunity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "oppRequirement", cascade = CascadeType.ALL)
    private List<OpportunityEmpSuggestion> opportunityEmpSuggestions = new ArrayList<>();
}
