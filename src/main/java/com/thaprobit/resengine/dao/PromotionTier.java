package com.thaprobit.resengine.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 * @since 5/30/2020 9:01 PM
 */

@Data
@Entity
@Table(name = "promotion_tiers")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "tierId")
public class PromotionTier
{
	@Id
	@Column(name = "tier_id")
	private Short tierId;

	@Size(max = 100)
	@Column(name = "name")
	private String name;

	@Size(max = 2000)
	@Column(name = "description")
	private String description;

	@JsonBackReference
	@ToString.Exclude
	@OneToMany(mappedBy = "tier", fetch = FetchType.LAZY)
	private Set<Promotion> promotions;


}
