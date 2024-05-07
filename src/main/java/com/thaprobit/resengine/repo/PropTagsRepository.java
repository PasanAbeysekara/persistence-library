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

	@Query(value = "SELECT DISTINCT s.name " +
			"FROM sys_tags s " +
			"INNER JOIN prop_tags p ON s.tag_id = p.tag_id " +
			"INNER JOIN user_preferred_properties u ON u.prop_id = p.prop_id " +
			"WHERE u.user_id = :userId", nativeQuery = true)
	List<String> findPreferredTagNamesByUserId(@Param("userId") Long userId);
}