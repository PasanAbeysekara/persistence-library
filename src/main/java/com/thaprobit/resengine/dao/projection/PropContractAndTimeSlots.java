package com.thaprobit.resengine.dao.projection;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Tharindu Aththanayake
 */
public interface PropContractAndTimeSlots
{
	Integer getCurrentContId();

	List<LocalTime> getTimeSlots();
}
