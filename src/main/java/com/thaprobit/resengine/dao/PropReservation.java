package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropReservationID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * @author Tharindu Aththanayake
 * @since 01/28/2021 01:33 AM
 */
@Data
@Entity
@Table(name = "prop_reservations")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propReservationId")
@ToString
public class PropReservation extends RepresentationModel<PropReservation>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropReservationID propReservationId;

	@Column( name = "booked_contract_id" )
	private Integer bookedContractId;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("reservationId")
	@JoinColumn(name = "res_id")
	@ToString.Exclude
	private Reservation reservation;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("propId")
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;
}
