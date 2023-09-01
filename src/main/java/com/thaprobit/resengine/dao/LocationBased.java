package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@Entity
@Table(name = "location_city")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "locationId")
public class LocationBased
{
	@Id
	@SequenceGenerator(
			name = "location_gen",
			sequenceName = "location_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "location_gen", strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	@Column(name = "id")
	private Long locationId;

	@Size(max = 50)
	@Column(name = "name")
	private String name;

	//	@Column(name = "country_id")
	//	private Short countryId;
	//
	//	@Column(name = "state_id")
	//	private Short stateId;

	//@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns(
			{
					@JoinColumn(name = "country_id", referencedColumnName = "country_id", updatable = false, insertable = false),
					@JoinColumn(name = "state_id", referencedColumnName = "state_id", updatable = false, insertable = false)
			})
	private LocationState state;

	@JsonBackReference
	@ToString.Exclude
	@OneToMany(mappedBy = "basedLocation", fetch = FetchType.LAZY)
	private Set<Property> properties;

}
