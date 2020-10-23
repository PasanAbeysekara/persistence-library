package com.thaprobit.resengine.repo.sys;

import com.thaprobit.resengine.dao.sys.PropertySpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Aththanayake
 */
public interface PropertySpecialityRepository extends JpaRepository<PropertySpeciality, Short>
{
	@Query(value = "SELECT coalesce( max( speciality_id ) + 1 , 0) AS next_option_id FROM {h-schema}property_speciality", nativeQuery = true)
	Short nextSpecialityId();
}
