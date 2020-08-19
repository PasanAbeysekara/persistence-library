package com.solution.x.repo;

import com.solution.x.dao.Menu;
import com.solution.x.dao.projection.PropContractAndTimeSlots;
import com.solution.x.dao.Property;
import com.solution.x.dao.sys.AvailabilityUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Tharinda Wickramaarachchi
 */
public interface PropertyRepository extends JpaRepository<Property, Long>
{
	List<Property> findByCode( @Param("code") String code );

	@Query(value = "SELECT count(p) FROM Property p where p.currentContId =:id")
	Integer findPropWithSameContract( @Param("id") Integer currentContId );

	@Query(value = "select nextval('{h-schema}property_prop_id_seq')", nativeQuery = true)
	public Long getNextVal();

	@Query(value = "SELECT Menu FROM Property p JOIN p.menus Menu WHERE p.propId =:id ")
	Page<Menu> findPropertyMenus(@Param("id") Long propertyId, Pageable pageable);

	Optional<PropContractAndTimeSlots> findByPropId(Long propId );

	@Query(value = "SELECT a.sysAvailabilityUnit FROM Property p JOIN p.availabilityUnits AS a WHERE p.propId = :id " +
			"AND LOWER( a.sysAvailabilityUnit.code ) LIKE LOWER( concat( '%', :code, '%' ))" +
			"AND LOWER( a.sysAvailabilityUnit.name ) LIKE LOWER( concat( '%', :name, '%' ))")
	List<AvailabilityUnit> findPropertyAvailableUnits( @Param("id") Long propertyId,@Param("code") String code, @Param("name") String name );


}
