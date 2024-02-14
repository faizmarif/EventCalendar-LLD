package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class User {
  private String userName;
  private List<Event> eventList;
  private TimeRange workingHour;
  private Team team;

  public User() {
    eventList = new ArrayList<>();
  }

  public String getUserName() {
    return userName;
  }

  public List<Event> getEventList() {
    return eventList;
  }

  public TimeRange getWorkingHour() {
    return workingHour;
  }

  public Team getTeam() {
    return team;
  }

  public User setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public User setWorkingHour(TimeRange workingHour) {
    this.workingHour = workingHour;
    return this;
  }

  public User setTeam(Team team) {
    this.team = team;
    return this;
  }

  @Override
  public String toString() {
    return "User{"
        + "userName='"
        + userName
        + '\''
        + ", eventList="
        + eventList
        + ", workingHour="
        + workingHour
        + ", team="
        + team
        + '}';
  }
}
