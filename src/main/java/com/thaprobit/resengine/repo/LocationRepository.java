package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.LocationBased;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface LocationRepository extends JpaRepository<LocationBased, Long>
{
}
