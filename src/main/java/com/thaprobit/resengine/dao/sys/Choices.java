package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropChoices;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_choices")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "choiceId")
public class Choices extends RepresentationModel<Choices>
{
	@Id
	@SequenceGenerator(
			name = "choices_gen",
			sequenceName = "choices_choice_id_seq",
			allocationSize = 1
	)
	@GeneratedValue(generator = "choices_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "choice_id", updatable = false, nullable = false)
	private Long choiceId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sysChoice")
	@PrimaryKeyJoinColumn
	private Set<PropChoices> propChoices;
}
