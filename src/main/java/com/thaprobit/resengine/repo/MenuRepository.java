package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Aththanayake
 */
public interface MenuRepository extends JpaRepository<Menu, Long>
{
	@Query(value = "select nextval('{h-schema}menu_seq')", nativeQuery = true)
	public Long getNextVal();
}
