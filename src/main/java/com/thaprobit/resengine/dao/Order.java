package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.OrderID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
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
	@MapsId( "reservation_id" )
	private Reservation reservation;

	@OneToMany( mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true )
	private Set<OrderChoices> orderChoices;

}
