package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Aththanayake
 * @since 01/09/2021 01:10 AM
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long>
{
	@Query(value = "select nextval('{h-schema}reservation_id_seq')", nativeQuery = true)
	public Long getNextVal();
}
