package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropTags;
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
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_tags")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "tagId")
public class Tags extends RepresentationModel<Tags>
{
	@Id
	@SequenceGenerator(
			name = "tags_gen",
			sequenceName = "tags_tag_id_seq",
			initialValue = 100,
			allocationSize = 1
	)
	@GeneratedValue(generator = "tags_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "tag_id", updatable = false, nullable = false)
	private int tagId;

	@NotBlank
	@Size(max = 10, message = "Tag code cannot exceed 10 characters")
	@Column(name = "code", unique = true)
	private String code;

	@Size(max = 100, message = "Tag name cannot exceed 100 characters")
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column( name = "icon" )
	private String icon;

	@JsonBackReference // Could not write JSON: Infinite recursion (StackOverflowError)
	@OneToMany(mappedBy = "sysTags", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Set<PropTags> propTags;
}
