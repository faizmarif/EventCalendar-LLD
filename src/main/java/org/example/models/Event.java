package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Event {
  private String eventName;
  private DateTimeRange dateTimeRange;
  private List<User> participantList;

  public Event() {
    participantList = new ArrayList<>();
  }

  public String getEventName() {
    return eventName;
  }

  public Event setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  public DateTimeRange getTimeRange() {
    return dateTimeRange;
  }

  public Event setTimeRange(DateTimeRange dateTimeRange) {
    this.dateTimeRange = dateTimeRange;
    return this;
  }

  public List<User> getParticipantList() {
    return participantList;
  }

  @Override
  public String toString() {
    return "Event{" + "eventName='" + eventName + '\'' + '}';
  }
}
