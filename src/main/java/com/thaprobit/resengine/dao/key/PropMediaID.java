package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 09/02/2020 12:20 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropMediaID implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "media_id")
	private Integer mediaId;

}
