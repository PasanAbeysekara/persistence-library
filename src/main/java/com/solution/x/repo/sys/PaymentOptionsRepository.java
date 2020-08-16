package com.solution.x.repo.sys;

import com.solution.x.dao.sys.PaymentOptions;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface PaymentOptionsRepository extends JpaRepository<PaymentOptions, Short> {
}
