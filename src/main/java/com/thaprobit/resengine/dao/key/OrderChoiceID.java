package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 01/16/2021 08:37 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderChoiceID implements Serializable
{
	@Column( name = "reservation_id" )
	private Long reservationId;

	@Column( name = "prop_id" )
	private Long propId;

	@Column( name = "order_id" )
	private Short orderId;

	@Column( name = "choice_id" )
	private Integer choiceId;

	@Column( name = "order_ch_sub_id")
	private Short orderChoiceSubId;
}
