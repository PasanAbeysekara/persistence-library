package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropFacilityID;
import com.thaprobit.resengine.dao.sys.Facilities;
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
@Table(name = "prop_facilities")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propFacilityId")
@ToString
public class PropFacilities extends RepresentationModel<PropFacilities>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropFacilityID propFacilityId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	//@JsonManagedReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("facilityId")
	@JoinColumn(name = "facility_id")
	@ToString.Exclude
	private Facilities sysFacility;

	@Column(name = "fav_order")
	private int order;

	@ManyToOne(fetch = FetchType.LAZY)
	//@MapsId("propId")
	@JoinColumn(name = "prop_id", insertable = false, updatable = false) // attempted to assign id from null one-to-one property , remove @MapsId("propId")
	@ToString.Exclude
	private Property properties;
}
