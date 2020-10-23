package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.*;
import com.thaprobit.resengine.dao.key.MenuCategoryID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "menu_category")
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "menuCategoryId"
)
public class MenuCategory
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private MenuCategoryID menuCategoryId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@MapsId("menu_id")
	@JoinColumn(name = "menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Menu menu;

	@OneToMany(mappedBy = "choiceCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<MenuChoices> categoryChoices;
}
