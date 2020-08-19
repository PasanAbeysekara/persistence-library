package com.solution.x.dao.projection;

import java.time.LocalTime;
import java.util.List;

public interface PropContractAndTimeSlots {
    Integer getCurrentContId();
    List<LocalTime> getTimeSlots();
}
