package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropAvailabilityUnitKey implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "unit_id")
	private Integer unit_id;
}
