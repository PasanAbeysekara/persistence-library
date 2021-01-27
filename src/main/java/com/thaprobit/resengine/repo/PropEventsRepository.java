package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.PropEvent;
import com.thaprobit.resengine.dao.key.PropEventID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharinda Wickramaarachchi
 * @since 21/Jan/2021 10:58 PM
 */
public interface PropEventsRepository extends JpaRepository<PropEvent, PropEventID>
{
	@Query(value = "SELECT * FROM {h-schema}prop_events pe where pe.event_id =:eventId", nativeQuery = true)
	List<Long> findPropertiesForEvent(  @Param("eventId") Integer eventId );
}
