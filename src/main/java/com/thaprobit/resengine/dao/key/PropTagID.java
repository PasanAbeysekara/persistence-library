package com.thaprobit.resengine.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharinda Wickramaarachchi
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropTagID implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "tag_id")
	private Integer tagId;
}
