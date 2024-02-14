package org.example.models;

import java.time.LocalTime;

public class TimeRange {
  private LocalTime startTime;
  private LocalTime endTime;

  public TimeRange(LocalTime startTime, LocalTime endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  @Override
  public String toString() {
    return "TimeRange{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
  }
}
