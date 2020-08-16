package com.solution.x.repo;

import com.solution.x.dao.MenuCategory;
import com.solution.x.dao.key.MenuCategoryID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, MenuCategoryID>
{
}
