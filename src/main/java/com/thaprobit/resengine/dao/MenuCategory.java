package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.MenuCategoryID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	@JoinColumn(name = "menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Menu menu;

	@OneToMany(mappedBy = "choiceCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@ToString.Exclude
	private Set<MenuChoices> categoryChoices;
}
