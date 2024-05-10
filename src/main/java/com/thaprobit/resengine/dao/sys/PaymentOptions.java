package com.thaprobit.resengine.dao.sys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.thaprobit.resengine.dao.Property;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * @author Tharinda Wickramaarachchi
 * @since 4/23/2020 10:58 PM
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "payment_options")
@ToString
public class PaymentOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "option_id", updatable = false, nullable = false)
	private Integer optionId;

	@Size(max = 20)
	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "prop_payment_options",
			joinColumns = @JoinColumn(name = "option_id", referencedColumnName = "option_id"),
			inverseJoinColumns = @JoinColumn(name = "prop_id", referencedColumnName = "prop_id")
	)
	@ToString.Exclude
	private Set<Property> properties;
}

