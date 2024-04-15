package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.Size;
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

	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "unit_id")
	private Integer availableUnitId;

	@Size(max = 10)
	@Column(name = "unit_type")
	private String availableUnitType;

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

	@JsonBackReference(value = "property")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;

	@JsonBackReference(value = "propAvailabilityUnit")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
			@JoinColumn(name = "unit_id", referencedColumnName = "unit_id", insertable = false, updatable = false)
	})
	@ToString.Exclude
	private PropAvailabilityUnit propAvailabilityUnit;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_reservation",
			joinColumns = @JoinColumn(name = "reservation_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private Set<User> users;

}
