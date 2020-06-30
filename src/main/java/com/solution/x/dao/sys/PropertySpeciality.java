package com.solution.x.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.solution.x.dao.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 * @since 4/23/2020 10:58 PM
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "property_speciality")
@ToString
public class PropertySpeciality extends RepresentationModel<PropertySpeciality>
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "speciality_id", updatable = false, nullable = false)
	private Short specialityId;

	@Size(max = 20)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "prop_speciality",
			inverseJoinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
			joinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "speciality_id")
	)
	@ToString.Exclude
	private Set<Property> weekDefinitions;
}
