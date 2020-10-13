package com.solution.x.dao.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Tharindu Aththanayake
 * @since 09/02/2020 00:20 A.M.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PropMediaID implements Serializable
{
	@Column(name = "prop_id")
	private Long propId;

	@Column(name = "media_id")
	private Integer mediaId;

}
