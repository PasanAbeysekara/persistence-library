package com.thaprobit.resengine.repo.sys;

import com.thaprobit.resengine.dao.sys.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 * @since 12/29/2020 08:45 PM
 */
public interface EventsRepository extends JpaRepository<Event, Integer>
{
}
