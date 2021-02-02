package com.thaprobit.resengine.repo;

import com.thaprobit.resengine.dao.PropTags;
import com.thaprobit.resengine.dao.key.PropTagID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropTagsRepository extends JpaRepository<PropTags, PropTagID>
{
	@Query(value = "SELECT prop_id FROM {h-schema}prop_tags where tag_id =:tagId", nativeQuery = true)
	List<Long> findPropertiesForTags( @Param("tagId") Integer tagId );
}