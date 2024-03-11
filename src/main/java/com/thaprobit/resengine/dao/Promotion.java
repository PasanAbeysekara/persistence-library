package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.thaprobit.resengine.dao.key.PromoID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.sql.Date;

/**
 * @author Tharinda Wickramaarachchi
 * @since 5/30/2020 9:01 PM
 */

@Data
@Entity
@Table(name = "promotions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "promoId")
public class Promotion extends RepresentationModel<Promotion>
{
	@EmbeddedId
	@EqualsAndHashCode.Include
	private PromoID promoId;

	@Size(max = 200)
	@Column(name = "name")
	private String name;

	@Size(max = 2000)
	@Column(name = "description")
	private String description;

	@Column(name = "prop_id",insertable=false, updatable=false)
	private Short propId;

	@Column(name = "tier_id")
	private Short tierId;

	@Column(name = "promo_type")
	private Short promoTypeId;

	@Column(name = "start_date")
	private Date start;

	@Column(name = "end_date")
	private Date end;

	@Column(name = "live")
	private Boolean live;

	@Column(name = "maxed_out_landing")
	private Boolean maxedOutLanding;

	@Column(name = "maxed_out_search")
	private Boolean maxedOutSearch;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private PromotionStatistics statistics;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tier_id", insertable = false, updatable = false)
	private PromotionTier tier;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prop_id", insertable = false, updatable = false)
	@ToString.Exclude
	private Property properties;
}
