package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.SuburbID;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * @author Tharindu Aththanayake
 * @since 12/29/2020 07:30 PM
 */
@Data
@Entity
@ToString
@Table(name = "location_suburb")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "suburbID")
public class LocationSuburb
{
	@EmbeddedId
	private SuburbID suburbID;

	@Size(max = 50)
	@Column(name = "name")
	private String name;
}
