package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PropChoiceID;
import com.thaprobit.resengine.dao.sys.Choices;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Tharindu Aththanayake
 */
@Data
@Entity
@Table(name = "prop_choices")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "propChoiceId"
)
public class PropChoices
{

	@EmbeddedId
	@EqualsAndHashCode.Include
	private PropChoiceID propChoiceId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Size(max = 2000)
	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private BigDecimal amount;

	@Column(name = "amount_currency")
	private String amountCurrency;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property property;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("choiceId")
	@JoinColumn(name = "choice_id")
	@ToString.Exclude
	private Choices sysChoice;

    /*@JsonBackReference
    @ToString.Exclude
    @OneToOne(mappedBy = "propChoice", fetch = FetchType.LAZY)
    private MenuChoices menuChoice;*/
}
