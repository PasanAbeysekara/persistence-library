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

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
	//@MapsId("prop_id")
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;

}
