package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropFacilities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_facilities")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "facilityId")
public class Facilities extends RepresentationModel<Facilities>
{
	@Id
	@SequenceGenerator(
			name = "facilities_gen",
			sequenceName = "facilities_facility_id_seq",
			allocationSize = 1
	)
	@GeneratedValue(generator = "facilities_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "facility_id", updatable = false, nullable = false)
	private Integer facilityId;

	@NotBlank
	@Size(max = 10, message = "Facility code cannot exceed 10 characters")
	@Column(name = "code", unique = true)
	private String code;

	@Size(max = 100, message = "Facility name cannot exceed 100 characters")
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column( name = "icon" )
	private String icon;

	@JsonBackReference // Could not write JSON: Infinite recursion (StackOverflowError)
	@OneToMany(mappedBy = "sysFacility", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Set<PropFacilities> propFacilities;

}
