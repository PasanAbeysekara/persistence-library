package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.PropChoices;
import com.thaprobit.resengine.dao.key.PropChoiceID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Tharindu Aththanayake
 */
public interface PropChoicesRepository extends JpaRepository<PropChoices, PropChoiceID>
{
	@Query(value = "SELECT prop_id FROM {h-schema}prop_choices where choice_id =:choiceId", nativeQuery = true)
	List<Long> findPropertiesForChoice( @Param("choiceId") Integer choiceId );

	@Query(value = "SELECT choice_id FROM {h-schema}prop_choices WHERE prop_id = :propId", nativeQuery = true)
	List<Integer> findChoicesByPropertyId(@Param("propId") Long propId);

	@Query(value = "SELECT * FROM {h-schema}prop_choices WHERE prop_id = :propId", nativeQuery = true)
	List<PropChoices> findByPropertyId(@Param("propId") Long propId);

	Optional<PropChoices> findByPropChoiceId(PropChoiceID propChoiceId);

}
