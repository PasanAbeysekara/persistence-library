package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.OrderID;
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
import java.math.BigDecimal;
import java.util.Set;

/**
 * @author Tharindu Aththanayake
 * @since 01/16/2021 08:18 PM
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "order")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "orderId")
public class Order
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private OrderID orderId;

	@Column( name = "total_amount")
	private BigDecimal totalAmount;

	@Size( max = 20 )
	@Column(name = "amount_currency")
	private String amountCurrency;

	@JsonBackReference
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "reservation_id", insertable = false, updatable = false )
	private Reservation reservation;

	@OneToMany( mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true )
	private Set<OrderChoices> orderChoices;

}
