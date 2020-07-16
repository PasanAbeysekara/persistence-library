package com.solution.x.repo;

import com.solution.x.dao.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface MenuRepository extends JpaRepository<Menu, Long>
{
}
