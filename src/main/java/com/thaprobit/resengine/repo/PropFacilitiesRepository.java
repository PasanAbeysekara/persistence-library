package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.PropFacilities;
import com.thaprobit.resengine.dao.key.PropFacilityID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 */
public interface PropFacilitiesRepository extends JpaRepository<PropFacilities, PropFacilityID>
{
	List<PropFacilities> findByPropFacilityIdPropId( @Param("propId") int propId );
}