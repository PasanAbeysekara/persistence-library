package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity

@ToString
@Table(name = "organization")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "orgId")
public class Organization extends RepresentationModel<Organization>
{
	@Id
	@SequenceGenerator(
			name = "organization_gen",
			sequenceName = "organization_org_id_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "organization_gen", strategy = GenerationType.SEQUENCE)
	private long orgId;

	@NotBlank
	@Size(max = 10)
	private String code;

	@Size(max = 100)
	private String name;

	//@JsonManagedReference
	@ToString.Exclude
	@OneToMany(mappedBy = "organizations", fetch = FetchType.LAZY)
	private Set<Property> properties;
}
