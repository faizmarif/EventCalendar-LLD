package org.example.services;

import org.example.models.DateTimeRange;
import org.example.models.Event;
import org.example.models.TimeRange;
import org.example.models.User;

public class TimeRangeService {

  public boolean isUserAvailable(User user, DateTimeRange dateTimeRange) {
    TimeRange workingHour = user.getWorkingHour();
    if (workingHour.getStartTime().isAfter(dateTimeRange.getStartTime().toLocalTime())
        || workingHour.getEndTime().isBefore(dateTimeRange.getEndTime().toLocalTime())) {
      return false;
    }
    for (Event event : user.getEventList()) {
      DateTimeRange occupiedTime = event.getTimeRange();
      if (!dateTimeRange.getStartTime().isAfter(occupiedTime.getEndTime())
          && !dateTimeRange.getEndTime().isBefore(occupiedTime.getStartTime())) {
        return false;
      }
    }
    return true;
  }

  public boolean isTimeRangeOverlapping(
      DateTimeRange dateTimeRange1, DateTimeRange dateTimeRange2) {
    if (dateTimeRange1.getStartTime().isAfter(dateTimeRange2.getEndTime())
        || dateTimeRange1.getEndTime().isBefore(dateTimeRange2.getStartTime())) {
      return false;
    }
    return true;
  }
}
