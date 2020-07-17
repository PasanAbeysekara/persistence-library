package com.solution.x.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.solution.x.dao.key.MenuCategoryID;
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
@EqualsAndHashCode(callSuper = false)
@Table(name = "menu_category")
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "menuCategoryID"
)
public class MenuCategory extends RepresentationModel<MenuCategory>
{
    @EmbeddedId
    @ToString.Include
    private MenuCategoryID menuCategoryID;

    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menu_id")
    @JoinColumn(name = "menu_id", insertable = false, updatable = false)
    @ToString.Exclude
    private Menu menu;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "choiceMenuCategory")
    @ToString.Exclude
    private Set<MenuChoices> categoryChoices;*/
}
