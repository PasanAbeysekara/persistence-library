package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropChoiceID implements Serializable
{
	@Column(name = "choice_id")
	private Integer choiceId;

	@Column(name = "prop_id")
	private Long propId;
}
