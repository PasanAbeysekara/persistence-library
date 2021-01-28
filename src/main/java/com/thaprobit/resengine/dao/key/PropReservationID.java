package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 01/28/2021 01:34 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropReservationID implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "res_id")
	private Long reservationId;
}
