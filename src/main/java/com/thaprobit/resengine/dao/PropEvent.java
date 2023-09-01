package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropEventID;
import com.thaprobit.resengine.dao.sys.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "prop_events")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propEventID")
@ToString
public class PropEvent extends RepresentationModel<PropEvent>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropEventID propEventID;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("eventId")
	@JoinColumn(name = "event_id")
	@ToString.Exclude
	private Event sysEvent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;

}
