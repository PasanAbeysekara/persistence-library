package com.solution.x.dao;

import com.fasterxml.jackson.annotation.*;
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
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString
@Table(name = "menu")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "menuId"
)
public class Menu extends RepresentationModel<Menu> {

    @Id
    /*@SequenceGenerator(
            name = "menu_gen",
            sequenceName = "menu_seq",
            initialValue = 0,
            allocationSize = 1
    )
    @GeneratedValue(generator = "menu_gen", strategy = GenerationType.SEQUENCE)*/
    @Column(name = "menu_id", updatable = false, nullable = false)
    @EqualsAndHashCode.Include
    private Long menuId;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @Size(max = 2000)
    @Column(name = "description")
    private String description;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "prop_menu",
            inverseJoinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    )
    @ToString.Exclude
    private Set<Property> properties;

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<MenuCategory> menuCategories;

}
