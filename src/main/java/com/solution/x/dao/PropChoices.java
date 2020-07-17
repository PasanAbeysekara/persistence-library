package com.solution.x.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.solution.x.dao.sys.Choices;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "prop_choices")
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "propChoiceId"
)
public class PropChoices extends RepresentationModel<PropChoices>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prop_ch_id", updatable = false, nullable = false)
    private int propChoiceId;

    @Column(name = "prop_id", updatable = false, insertable = false)
    private Long propId;

    @Column(name = "choice_id", updatable = false, insertable = false)
    private Long choiceId;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Size(max = 2000)
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prop_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Property property;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "choice_id")
    @ToString.Exclude
    private Choices sysChoice;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "propChoice", orphanRemoval = true)
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    private Set<MenuChoices> menuChoices;*/
}
