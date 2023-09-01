package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropTagID;
import com.thaprobit.resengine.dao.sys.Tags;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@Entity
@Table(name = "prop_tags")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propTagID")
@ToString
public class PropTags extends RepresentationModel<PropTags>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropTagID propTagID;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "fav_order")
	private int order;

	//@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("tagId")
	@JoinColumn(name = "tag_id")
	@ToString.Exclude
	private Tags sysTags;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property properties;
}
