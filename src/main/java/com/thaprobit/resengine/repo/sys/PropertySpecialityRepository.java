package com.thaprobit.resengine.repo.sys;

import com.thaprobit.resengine.dao.sys.PropertySpeciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharindu Aththanayake
 */
public interface PropertySpecialityRepository extends JpaRepository<PropertySpeciality, Short>
{
	@Query(value = "SELECT coalesce( max( speciality_id ) + 1 , 0) AS next_option_id FROM {h-schema}property_speciality", nativeQuery = true)
	Short nextSpecialityId();

	@Query(value = "SELECT DISTINCT s.name " +
			"FROM property_speciality s " +
			"INNER JOIN prop_speciality p ON s.speciality_id = p.speciality_id " +
			"INNER JOIN user_preferred_properties u ON u.prop_id = p.prop_id " +
			"WHERE u.user_id = :userId", nativeQuery = true)
	List<String> findPreferredCuisineNamesByUserId(@Param("userId") Long userId);
}
