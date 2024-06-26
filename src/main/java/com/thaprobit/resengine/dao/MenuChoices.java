package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.MenuChoiceID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "menu_choices")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "menuChoiceID")
public class MenuChoices
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private MenuChoiceID menuChoiceID;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "cat_id", referencedColumnName = "cat_id", insertable = false, updatable = false),
			@JoinColumn(name = "menu_id", referencedColumnName = "menu_id", insertable = false, updatable = false)
	})
	@ToString.Exclude
	private MenuCategory choiceCategory;

    /*@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prop_ch_id", insertable = false, updatable = false)
    private PropChoices propChoice;*/
}
