package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.PropChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Tharindu Aththanayake
 */
public interface PropChoicesRepository extends JpaRepository<PropChoices, Integer>
{
	@Query(value = "SELECT prop_id FROM {h-schema}prop_choices where choice_id =:choiceId", nativeQuery = true)
	List<Long> findPropertiesForChoice( @Param("choiceId") Integer choiceId );

}
