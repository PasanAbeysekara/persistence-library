package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long>
{
	List<Organization> findByCode( @Param("code") String code );
}
