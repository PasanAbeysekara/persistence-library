package com.solution.x.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.solution.x.dao.PropChoices;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_choices")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "choiceId")
public class Choices extends RepresentationModel<Choices>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choice_id", updatable = false, nullable = false)
    private Long choiceId;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sysChoice", orphanRemoval = false)
    @PrimaryKeyJoinColumn
    private Set<PropChoices> propChoices;
}
