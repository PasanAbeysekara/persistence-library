package com.thaprobit.resengine.dao;

import com.thaprobit.resengine.dao.global.CommonData;

import java.math.BigDecimal;

/**
 * @author Tharinda Wickramaarachchi
 * @since 8/31/2020 11:45 PM
 */
public class UserReview extends CommonData
{
	//TODO define key
	//TODO relate reviewer (user)

	private BigDecimal starRating;
	private String reviewTitle;
	private String comment;
	private Boolean accepted;

	private Integer upVotes;
	private Integer downVotes;

	//TODO implement review reply


}
