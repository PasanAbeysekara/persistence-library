package com.solution.x.repo;

import com.solution.x.dao.Menu;
import com.solution.x.dao.sys.AvailabilityUnit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Tharinda Wickramaarachchi
 */
public interface PropAvailabilityUnitRepository extends JpaRepository<AvailabilityUnit, Integer>
{
}
