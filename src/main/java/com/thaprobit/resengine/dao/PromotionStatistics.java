package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thaprobit.resengine.dao.key.PromoID;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Tharinda Wickramaarachchi
 * @since 7/4/2020 12:16 AM
 */
@Data
@Entity
@Table(name = "promotion_statistics")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class PromotionStatistics
{
	@EmbeddedId
	private PromoID promoId;

	@Column(name = "views")
	private Integer views;

	@Column(name = "clicks")
	private Integer clicks;

	@Column(name = "authentic_views")
	private Integer authenticViews;

	@Column(name = "authentic_clicks")
	private Integer authenticClicks;

	@Column(name = "converge")
	private Integer converge;

	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "statistics")
	private Promotion promotion;
}
