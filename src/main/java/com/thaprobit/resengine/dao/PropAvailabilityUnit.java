package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropAvailabilityUnitKey;
import com.thaprobit.resengine.dao.sys.AvailabilityUnit;
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
@Table(name = "prop_availability_unit")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propAvailabilityUnitId")
@ToString
public class PropAvailabilityUnit extends RepresentationModel<PropAvailabilityUnit>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropAvailabilityUnitKey propAvailabilityUnitId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "capacity")
	private Short capacity;

	//@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("unit_id")
	@JoinColumn(name = "unit_id")
	@ToString.Exclude
	private AvailabilityUnit sysAvailabilityUnit;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property properties;
}
