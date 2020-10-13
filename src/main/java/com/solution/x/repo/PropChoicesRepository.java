package com.solution.x.repo;

import com.solution.x.dao.PropChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Tharindu Aththanayake
 */
public interface PropChoicesRepository extends JpaRepository<PropChoices, Integer>
{
	@Query(value = "SELECT coalesce( max( prop_ch_id ) , 0) AS current_prop_choice_id FROM {h-schema}prop_choices", nativeQuery = true)
	Integer currentPropChoiceId();
}
