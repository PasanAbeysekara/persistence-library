package com.solution.x.repo;

import com.solution.x.dao.WidenPropData;
import com.solution.x.dao.key.WidenDataGridKey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 * @since 6/10/2020 12:10 AM
 */
public interface AvailDataRepository extends JpaRepository<WidenPropData, WidenDataGridKey>
{

	@Query(value = "SELECT w FROM WidenPropData w where w.widenDataGridKey.propId = :propId " +
			"and w.contractId = :contractId " +
			"and w.widenDataGridKey.date between :dateFrom and :dateTo " +
			"and w.widenDataGridKey.timeSlot between :timeFrom and :timeTo " +
			"and w.widenDataGridKey.availUnitId in :availUnitIds " +
			"and w.bookable > 0")
	Page<WidenPropData> getPropertyAvailabilitiesPaged( @Param("propId") long propertyId,
														@Param("contractId") long contractId,
														@Param("dateFrom") LocalDate dateFrom,
														@Param("dateTo") LocalDate dateTo,
														@Param("timeFrom") LocalTime timeFrom,
														@Param("timeTo") LocalTime timeTo,
														@Param("availUnitIds") List<Integer> availUnitIds,
														Pageable pageable );

}
