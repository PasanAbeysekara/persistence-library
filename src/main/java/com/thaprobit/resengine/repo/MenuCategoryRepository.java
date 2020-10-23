package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.MenuCategory;
import com.thaprobit.resengine.dao.key.MenuCategoryID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Aththanayake
 */
public interface MenuCategoryRepository extends JpaRepository<MenuCategory, MenuCategoryID>
{
}
