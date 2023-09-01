package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 12/29/2020 07:45 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SuburbID implements Serializable
{
	@Column(name = "suburb_id")
	private Short suburbId;

	@Column(name = "city_id")
	private Long cityId;
}
