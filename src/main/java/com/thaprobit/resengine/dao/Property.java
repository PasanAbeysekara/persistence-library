package com.thaprobit.resengine.dao;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.sys.PaymentOptions;
import com.thaprobit.resengine.dao.sys.PropertySpeciality;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) //Lombok HashCode issues , Need to explicitly add include with onlyExplicitlyIncluded = true
@ToString
@Entity
@Table(name = "property")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propId")
public class Property extends RepresentationModel<Property>
{
	@Id
	@SequenceGenerator(
			name = "prop_gen",
			sequenceName = "property_prop_id_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "prop_gen", strategy = GenerationType.SEQUENCE)
	@EqualsAndHashCode.Include //Lombok HashCode issues , Need to explicitly add include with onlyExplicitlyIncluded = true
	@Column(name = "prop_id")
	private long propId;

	@NotBlank
	@Size(max = 10, message = "Property code cannot exceed 10 characters")
	@Column(name = "code")
	@EqualsAndHashCode.Include //Lombok HashCode issues , Need to explicitly add include with onlyExplicitlyIncluded = true
	private String code;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Size(min = 10)
	@Column(name = "description",columnDefinition = "TEXT")
	private String description;

	/*@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "geo_location", column = @Column(name = "x")),
			@AttributeOverride(name = "geo_location", column = @Column(name = "y"))
	})
	private Point point;*/

	// @Column(columnDefinition="Geometry")
	//@Type(type="org.hibernate.spatial.GeometryType")    //"org.hibernatespatial.GeometryUserType" seems to be for older versions of Hibernate Spatial
	// private Point geoLocation;

	/*@Column(name = "geo_location", columnDefinition = "POINT")
	// @JsonDeserialize( contentUsing = )
	private Point geoLocation;*/
	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "current_cont_id")
	private Integer currentContId;

	@Column(name = "start_time")
	private LocalTime startTime;

	//@JsonIgnore
	@Column(name = "end_time")
	private LocalTime endTime;

	@Column(name = "timeslot")
	private Short timeSlotMinutes; // In minutes , 30 (1/2 hr), 60 (1hr) , 90 (1 1/2 hr) , 120 (2hr)

	@Column(name = "avg_rating")
	private BigDecimal avgRating; //8.5

	@Column(name = "total_rating")
	private Integer totalRating; //525

	@Column(name = "amount")
	private BigDecimal amount; //5500

	@Column(name = "amount_currency")
	private String amountCurrency; //LKR

	@Column(name = "amount_condition")
	private String amountCondition; //Approx 2 People

	@Column(name = "res_slot_minutes")
	private Short reservationSlotMinutes;

	@Column(name = "res_slot_length")
	private Short reservationSlotLength;

	@Column(name = "booking_note")
	private String bookingNote;

	@Column(name = "based_location_id",insertable=false, updatable=false)
	private Long basedLocationId;

	@Column(name = "contact_id",insertable=false, updatable=false)
	private Long contactId;


	@OneToMany(mappedBy = "properties", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//	@OrderBy("time_start ASC")
	private Set<OperationHours> operationHours;

	@ToString.Exclude
	@OneToMany(mappedBy = "properties", fetch = FetchType.LAZY)
	private Set<PropAvailabilityUnit> availabilityUnits;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "based_location_id")
	@ToString.Exclude
	private LocationBased basedLocation;

	// Remove availability contract temporarily
//	@ToString.Exclude
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "current_cont_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
//	private Contract currentContract;

	@OneToMany(mappedBy = "properties", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PropFacilities> facilities;

	@OneToMany(mappedBy = "properties", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PropTags> tags;

	@ToString.Exclude
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private ContactDetails contactDetails;

	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "prop_speciality",
			joinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
			inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "speciality_id")
	)
	private Set<PropertySpeciality> propertySpecialities;

	//@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "prop_payment_options",
			joinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
			inverseJoinColumns = @JoinColumn(name = "option_id", referencedColumnName = "option_id")
	)
	private Set<PaymentOptions> paymentOptions;

	@OneToMany(mappedBy = "properties", fetch = FetchType.LAZY)
	@Where(clause = "live = true")
	private Set<Promotion> livePromotions;

	@JsonBackReference
	@ToString.Exclude
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "org_id")
	private Organization organizations;

	@Transient
	//TODO Cache this value using ehcache
	private List<LocalTime> timeSlots;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "prop_menu",
			joinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id", insertable = false, updatable = false),
			inverseJoinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
	)
	private Set<Menu> menus;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "property", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PropChoices> choices;

	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PropMedia> propertyMedia;

	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PropEvent> events;

	@OneToMany(mappedBy = "property", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservations;

	public List<LocalTime> getTimeSlots()
	{

		List<OperationHours> sortedOperationHours = operationHours.stream().sorted( Comparator.comparing( OperationHours::getTimeStart ) ).collect( Collectors.toList() );

		List<LocalTime> timeSlots = new ArrayList<>();

		for( OperationHours operationHour : sortedOperationHours )
		{
			LocalTime timeStart = operationHour.getTimeStart();
			timeSlots.add( timeStart );

			LocalTime currentTime = timeStart;
			while( currentTime.isBefore( operationHour.getTimeEnd().minusMinutes( timeSlotMinutes ) ) )
			{
				currentTime = currentTime.plusMinutes( timeSlotMinutes );
				timeSlots.add( currentTime );
			}
		}

		return timeSlots;

	}

}
