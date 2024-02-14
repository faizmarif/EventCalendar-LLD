package org.example.services;

import org.example.models.Event;
import org.example.models.Team;
import org.example.models.DateTimeRange;
import org.example.models.TimeRange;
import org.example.models.User;
import java.util.List;

public interface CalendarInterface {

  User createUser(String userName, TimeRange workingHour);

  Team createTeam(String teamName, List<User> userList);

  Event createEvent(
      String eventName,
      List<User> userList,
      List<Team> teamList,
      int requiredFromEachTeam,
      DateTimeRange dateTimeRange);

  List<Event> getEvents(User user, DateTimeRange dateTimeRange);
}
