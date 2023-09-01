package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.StateID;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 * @since 4/24/2020 10:20 PM
 */
@Data
@Entity
@Table(name = "location_state")
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "stateId")
public class LocationState
{
	@EmbeddedId
	private StateID stateId;

	@Size(max = 50)
	@Column(name = "name")
	private String name;

	@JsonBackReference
	@ToString.Exclude
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
	private Set<LocationBased> basedLocation;

	//@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("countryId")
	@JoinColumn(name = "country_id")
	private LocationCountry country;

}
