package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropEvent;
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
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 * @since 12/29/2020 08:17 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sys_events")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "eventId")
public class Event extends RepresentationModel<Event>
{
	@Id
	@SequenceGenerator(
			name = "events_gen",
			sequenceName = "events_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "events_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "event_id", updatable = false, nullable = false)
	private Integer eventId;

	@Size(max = 50)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "order")
	private short order;

	@JsonBackReference
	@OneToMany(mappedBy = "sysEvent", fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Set<PropEvent> propEvents;
}
