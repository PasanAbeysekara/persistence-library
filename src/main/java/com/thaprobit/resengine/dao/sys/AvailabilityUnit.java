package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropAvailabilityUnit;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
 * @since 4/20/2020 9:09 PM
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
@Table(name = "sys_availability_unit")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "unitId")
public class AvailabilityUnit extends RepresentationModel<AvailabilityUnit>
{
	@Id
	@SequenceGenerator(
			name = "sys_avail_unit_seq",
			sequenceName = "sys_avail_unit_seq",
			initialValue = 100,
			allocationSize = 1
	)
	@GeneratedValue(generator = "sys_avail_unit_seq", strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include
	@Column(name = "unit_id", updatable = false, nullable = false)
	private Integer unitId;

	@NotBlank
	@Size(max = 10)
	@Column(name = "code")
	@EqualsAndHashCode.Include
	private String code;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "min_capacity")
	private Short minCapacity;

	@Column(name = "max_capacity")
	private Short maxCapacity;

	@Size(max = 10)
	@Column(name = "type")
	private String type;

	@JsonBackReference
	@OneToMany(mappedBy = "sysAvailabilityUnit", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Set<PropAvailabilityUnit> propAvailabilityUnits;

}
