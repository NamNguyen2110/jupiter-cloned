package com.jupiter.oppsservice.domain.entity;

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
public class OppRequirement extends AbstractEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "position")
    private String position;

    @Column(name = "level")
    private String level;

    @Column(name = "exp")
    private Double exp;

    @Column(name = "skill")
    private String skill;

    @Column(name = "language")
    private String language;

    @Column(name = "notes")
    private String notes;

    @Column(name = "attach_file_url")
    private String attachFileUrl;

    @ManyToOne
    @JoinColumn(name = "opp_id", referencedColumnName = "id")
    private Opp opp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "oppRequirement", cascade = CascadeType.ALL)
    private List<OppEmployeeSuggestion> oppEmployeeSuggestions = new ArrayList<>();

}
