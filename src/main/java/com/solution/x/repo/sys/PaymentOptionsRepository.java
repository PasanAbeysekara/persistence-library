package com.solution.x.repo.sys;

import com.solution.x.dao.sys.PaymentOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Aththanayake
 */
public interface PaymentOptionsRepository extends JpaRepository<PaymentOptions, Short>
{

	@Query(value = "SELECT coalesce( max( option_id ) + 1 , 0) AS next_option_id FROM {h-schema}payment_options", nativeQuery = true)
	Short nextOptionId();
}
