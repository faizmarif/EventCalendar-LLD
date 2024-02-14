package org.example;

import org.example.models.DateTimeRange;
import org.example.models.Event;
import org.example.models.Team;
import org.example.models.TimeRange;
import org.example.models.User;
import org.example.services.CalendarApp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    CalendarApp app = new CalendarApp();
    LocalDate today = LocalDate.of(2023, Month.NOVEMBER, 5);
    LocalDate tomorrow = LocalDate.of(2023, Month.NOVEMBER, 6);

    User userA = app.createUser("User A", new TimeRange(LocalTime.of(10, 0), LocalTime.of(19, 0)));
    User userB = app.createUser("User B", new TimeRange(LocalTime.of(9, 30), LocalTime.of(17, 30)));
    User userC =
        app.createUser("User C", new TimeRange(LocalTime.of(11, 30), LocalTime.of(18, 30)));
    User userD = app.createUser("User D", new TimeRange(LocalTime.of(10, 0), LocalTime.of(18, 0)));
    User userE = app.createUser("User E", new TimeRange(LocalTime.of(11, 0), LocalTime.of(19, 30)));
    User userF = app.createUser("User F", new TimeRange(LocalTime.of(11, 0), LocalTime.of(18, 30)));

    Team team1 = app.createTeam("T1", List.of(userC, userE));
    Team team2 = app.createTeam("T2", List.of(userB, userD, userF));

    Event event1 =
        app.createEvent(
            "event 1",
            List.of(userA),
            List.of(team1),
            2,
            new DateTimeRange(
                LocalDateTime.of(tomorrow, LocalTime.of(14, 0)),
                LocalDateTime.of(tomorrow, LocalTime.of(15, 0))));

    Event event2 =
        app.createEvent(
            "event 2",
            List.of(userC),
            List.of(),
            0,
            new DateTimeRange(
                LocalDateTime.of(tomorrow, LocalTime.of(14, 0)),
                LocalDateTime.of(tomorrow, LocalTime.of(15, 0))));

    Event event3 =
        app.createEvent(
            "event 3",
            List.of(),
            List.of(team1, team2),
            2,
            new DateTimeRange(
                LocalDateTime.of(today, LocalTime.of(15, 0)),
                LocalDateTime.of(today, LocalTime.of(16, 0))));

    Event event4 =
        app.createEvent(
            "event 4",
            List.of(userA),
            List.of(team2),
            1,
            new DateTimeRange(
                LocalDateTime.of(today, LocalTime.of(15, 0)),
                LocalDateTime.of(today, LocalTime.of(16, 0))));

    Event event5 =
        app.createEvent(
            "event 5",
            List.of(userA, userF),
            List.of(),
            2,
            new DateTimeRange(
                LocalDateTime.of(today, LocalTime.of(10, 0)),
                LocalDateTime.of(today, LocalTime.of(11, 0))));

    List<Event> eventList1 =
        app.getEvents(
            userA,
            new DateTimeRange(
                LocalDateTime.of(today, LocalTime.of(10, 0)),
                LocalDateTime.of(tomorrow, LocalTime.of(17, 0))));

    List<Event> eventList2 =
        app.getEvents(
            userB,
            new DateTimeRange(
                LocalDateTime.of(today, LocalTime.of(10, 0)),
                LocalDateTime.of(tomorrow, LocalTime.of(17, 0))));
  }
}
