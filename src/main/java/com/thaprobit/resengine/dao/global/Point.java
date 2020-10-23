package com.thaprobit.resengine.dao.global;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @author Tharinda Wickramaarachchi
 */
@Embeddable
public class Point
{
	private BigDecimal x;
	private BigDecimal y;
}
