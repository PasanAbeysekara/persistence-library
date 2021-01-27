package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.PropEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

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