package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "featured_location")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "featuredLocationId")
public class FeaturedLocation
{
	@Id
	@SequenceGenerator(
			name = "featured_location_gen",
			sequenceName = "featured_location_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "featured_location_gen", strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	@Column(name = "id")
	private Long featuredLocationId;

	@Size(max = 50)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			{
					@JoinColumn(name = "country_id", referencedColumnName = "country_id", updatable = false, insertable = false),
					@JoinColumn(name = "state_id", referencedColumnName = "state_id", updatable = false, insertable = false)
			})
	private LocationState state;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationBased city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
			{
					@JoinColumn(name = "suburb_id", referencedColumnName = "suburb_id", updatable = false, insertable = false),
					@JoinColumn(name = "city_id", referencedColumnName = "city_id", updatable = false, insertable = false),
			})
	private LocationSuburb suburb;

}
