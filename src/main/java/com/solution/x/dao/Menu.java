package com.solution.x.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "menu")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "menuId"
)
public class Menu extends RepresentationModel<Menu>
{

    @Id
    @SequenceGenerator(
            name = "menu_gen",
            sequenceName = "menu_seq",
            initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(generator = "menu_gen", strategy = GenerationType.SEQUENCE)
    @Column(name = "menu_id", updatable = false, nullable = false)
    private Long menuId;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Size(max = 2000)
    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private Set<PropMenu> properties;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<MenuCategory> menuCategories;

    /*@OneToMany(mappedBy = "choiceMenu", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Set<MenuChoices> menuChoices;*/
}
