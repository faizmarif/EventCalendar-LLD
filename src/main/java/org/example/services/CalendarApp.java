package org.example.services;

import org.example.models.Event;
import org.example.models.Team;
import org.example.models.DateTimeRange;
import org.example.models.TimeRange;
import org.example.models.User;
import org.example.repository.AppRepo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class CalendarApp implements CalendarInterface {
  private static Logger logger = Logger.getLogger(CalendarApp.class);
  AppRepo appRepo = AppRepo.getInstance();
  TimeRangeService timeRangeService = new TimeRangeService();

  @Override
  public User createUser(String userName, TimeRange workingHour) {
    User user = new User().setUserName(userName).setWorkingHour(workingHour);
    logger.debug(userName + " is created");
    return user;
  }

  @Override
  public Team createTeam(String teamName, List<User> userList) {
    Team team = new Team().setTeamName(teamName);
    for (User user : userList) {
      team.getUserList().add(user);
    }
    logger.debug(teamName + " is created");
    return team;
  }

  @Override
  public Event createEvent(
      String eventName,
      List<User> userList,
      List<Team> teamList,
      int requiredFromEachTeam,
      DateTimeRange dateTimeRange) {
    List<User> participants = new ArrayList<>();
    for (User user : userList) {
      if (timeRangeService.isUserAvailable(user, dateTimeRange)) {
        participants.add(user);
      } else {
        System.out.println(user.getUserName() + " is not available");
        return null;
      }
    }

    for (Team team : teamList) {
      int repsNum = 0;
      for (User user : team.getUserList()) {
        if (timeRangeService.isUserAvailable(user, dateTimeRange)) {
          repsNum++;
          participants.add(user);
          if (repsNum == requiredFromEachTeam) {
            break;
          }
        }
      }
      if (repsNum < requiredFromEachTeam) {
        System.out.println("Not enough members available from " + team.getTeamName());
        return null;
      }
    }
    Event event = new Event().setEventName(eventName).setTimeRange(dateTimeRange);

    for (User participant : participants) {
      event.getParticipantList().add(participant);
      participant.getEventList().add(event);
    }
    logger.debug(eventName + " is created");

    return event;
  }

  @Override
  public List<Event> getEvents(User user, DateTimeRange dateTimeRange) {
    List<Event> events = new ArrayList<>();
    for (Event event : user.getEventList()) {
      if (timeRangeService.isTimeRangeOverlapping(event.getTimeRange(), dateTimeRange)) {
        events.add(event);
      }
    }
    logger.debug(user.getUserName() + " has to attend these events :" + events);
    return events;
  }
}
