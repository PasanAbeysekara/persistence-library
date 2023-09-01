package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MenuChoiceID implements Serializable
{
	@Column(name = "menu_id")
	private Long menuId;

	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "cat_id")
	private Short categoryId;

	@Column(name = "choice_id")
	private Integer choiceId;
}
