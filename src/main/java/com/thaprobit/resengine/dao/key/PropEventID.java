package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 12/29/2020 08:29 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropEventID implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "event_id")
	private Integer eventId;
}
