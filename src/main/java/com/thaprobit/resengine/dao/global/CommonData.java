package com.thaprobit.resengine.dao.global;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * @author Tharinda Wickramaarachchi
 * @since 8/31/2020 11:57 PM
 */
public class CommonData
{
	@Column(name = "created")
	private LocalDateTime createdDateTime;

	@Column(name = "modified")
	private LocalDateTime modifiedDateTime;
}
