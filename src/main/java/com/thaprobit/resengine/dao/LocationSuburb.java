package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.SuburbID;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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
