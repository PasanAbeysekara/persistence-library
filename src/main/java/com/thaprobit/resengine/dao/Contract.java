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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false) //Lombok HashCode issues , Need to explicitly add include with onlyExplicitlyIncluded = true
@ToString
@Table(name = "contracts")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "contractId")
public class Contract extends RepresentationModel<Contract>
{
	@Id
	//	@SequenceGenerator(
	//			name = "contracts_gen",
	//			sequenceName = "contract_seq",
	//			initialValue = 0,
	//			allocationSize = 1
	//	)
	//	@GeneratedValue(generator = "contracts_gen", strategy = GenerationType.SEQUENCE )
	@Column(name = "contract_id")
	@EqualsAndHashCode.Include
	private Long contractId;

	@Column(name = "version")
	@EqualsAndHashCode.Include
	private Short version;

	@Column(name = "prop_id")
	private Long propId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Column(name = "from_date")
	private Date validFrom;

	@Column(name = "to_date")
	private Date validTo;

	@Size(max = 50)
	@Column(name = "version_txt")
	@EqualsAndHashCode.Include
	private String versionTxt;

	@Column(name = "bookable_horizon")
	private Short bookableHorizon;

	@OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Seasons> seasons;

	//region Reverse FK mappings

	@JsonBackReference
	@ToString.Exclude
	@OneToOne(mappedBy = "currentContract", fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id")
	private Property property;

	//endregion

}
