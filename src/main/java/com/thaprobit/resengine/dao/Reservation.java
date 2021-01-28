package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 * @since 01/09/2021 01:20 AM
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "reservations")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "reservationId")
public class Reservation
{
	@Id
	@EqualsAndHashCode.Include
	@Column(name = "reservation_id")
	private Long reservationId;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "time")
	private LocalTime time;

	@Column(name = "time_slots")
	private Short timeSlots;

	@Size(max = 10)
	@Column(name = "status")
	private String status;

	@Column(name = "host_user")
	private Long hostUser;

	@Column(name = "head_count")
	private Short headCount;

	@Column(name = "special_req")
	private String specialRequest;

	@Column(name = "slot_length")
	private Short slotLength;

	@Column(name = "slot_minutes")
	private Short slotMinutes;

	@Size(max = 50)
	@Column(name = "option1")
	private String option1;

	@Size(max = 50)
	@Column(name = "option2")
	private String option2;

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "reservation", cascade = CascadeType.ALL )
	private Set<Order> orders;

	@JsonBackReference
	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Set<PropReservation> propReservations;
}
