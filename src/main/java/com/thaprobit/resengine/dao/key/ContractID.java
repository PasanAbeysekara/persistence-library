package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.io.Serializable;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ContractID implements Serializable
{
	@Id
	@SequenceGenerator(
			name = "contracts_gen",
			sequenceName = "contracts_contract_id_seq",
			initialValue = 0,
			allocationSize = 1
	)
	@GeneratedValue(generator = "contracts_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "contract_id")
	private long contractId;

	@Column(name = "version")
	private Short version;

}
