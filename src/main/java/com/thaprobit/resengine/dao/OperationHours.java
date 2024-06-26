package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thaprobit.resengine.dao.key.OperationHourKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;

/**
 * @author Tharinda Wickramaarachchi
 * @since 6/9/2020 7:25 PM
 */
@Data
@Entity
@Table(name = "prop_operation_hours")
@ToString
public class OperationHours
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private OperationHourKey operationHourKey;

	@Column(name = "time_start")
	private LocalTime timeStart;

	@Column(name = "time_end")
	private LocalTime timeEnd;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("propId")
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property properties;
}
