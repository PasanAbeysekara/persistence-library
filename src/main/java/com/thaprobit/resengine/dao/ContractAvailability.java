package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.AvailabilityID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Tharinda Wickramaarachchi
 * @since 4/21/2020 2:28 PM
 */
@Data
@Entity
@Table(name = "contract_availability")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "availabilityID")
public class ContractAvailability
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private AvailabilityID availabilityID;

	@Column(name = "count")
	private Short count;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false),
			@JoinColumn(name = "season_id", referencedColumnName = "season_id", insertable = false, updatable = false)
	})
	@ToString.Exclude
	private Seasons seasons;
}
