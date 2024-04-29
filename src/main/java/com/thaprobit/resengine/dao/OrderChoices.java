package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.OrderChoiceID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author Tharindu Aththanayake
 * @since 01/16/2021 08:36 PM
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "order_choices")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "orderChoiceId")
public class OrderChoices
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private OrderChoiceID orderChoiceId;

	@Column( name = "quantity" )
	private Short quantity;

	@Column( name = "sub_amount" )
	private BigDecimal subAmount;

	@Size( max = 20 )
	@Column(name = "amount_currency")
	private String amountCurrency;

	@Column(name = "size")
	private String size;

	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY , cascade = CascadeType.ALL )
	@JoinColumns(
			{
					@JoinColumn( name = "reservation_id", referencedColumnName = "reservation_id", insertable = false, updatable = false),
					@JoinColumn( name = "order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
			}
	)
	private Orders order;
}
