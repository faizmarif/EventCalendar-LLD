package org.example.models;

import java.time.LocalDateTime;

public class DateTimeRange {
  private LocalDateTime startTime;
  private LocalDateTime endTime;

  public DateTimeRange(LocalDateTime startTime, LocalDateTime endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  @Override
  public String toString() {
    return "DateTimeRange{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
  }
}
