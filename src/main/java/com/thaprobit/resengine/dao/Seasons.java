package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.SeasonID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 * @since 4/18/2020 10:56 AM
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Lombok HashCode issues , Need to explicitly add include with onlyExplicitlyIncluded = true
@ToString
@Table(name = "contract_season")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "seasonId")
public class Seasons
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private SeasonID seasonId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "from_date")
	private LocalDate from;

	@Column(name = "to_date")
	private LocalDate to;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Contract contract;


	//	@OneToMany(fetch = FetchType.LAZY)
	//	@JoinTable(
	//			name = "contract_availability",
	//			joinColumns = {
	//					@JoinColumn(name = "contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false),
	//					@JoinColumn(name = "season_id", referencedColumnName = "season_id", insertable = false, updatable = false)},
	//			inverseJoinColumns = @JoinColumn(name = "week_def_id", insertable = false, updatable = false)
	//	)
	//	private Set<WeekDefinition> weekDefinitions;

	//@JsonManagedReference
	@OneToMany(mappedBy = "seasons", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ContractAvailability> availabilities;
}

