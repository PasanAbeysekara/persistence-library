package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.FeaturedLocation;
import com.thaprobit.resengine.dao.key.SuburbID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface FeaturedLocationRepository extends JpaRepository<FeaturedLocation, SuburbID>
{
}
