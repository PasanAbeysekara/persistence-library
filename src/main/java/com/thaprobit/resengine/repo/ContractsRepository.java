package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharinda Wickramaarachchi
 */
public interface ContractsRepository extends JpaRepository<Contract, Long>
{
	@Query(value = "select nextval('{h-schema}contract_seq')", nativeQuery = true)
	public Long getNextVal();
}
