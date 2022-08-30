package com.jupiter.oppsservice.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "opp_employee_suggestion")
public class OppEmployeeSuggestion extends AbstractEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Column(name = "employee_id")
    private String employeeId;

    @ManyToOne
    @JoinColumn(name = "opp_requirement_id", referencedColumnName = "id")
    private OppPosition oppPosition;
}
