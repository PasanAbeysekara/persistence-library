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
public class OperationHourKey implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "op_id")
	private Short opId;
}
