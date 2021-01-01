package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;

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
