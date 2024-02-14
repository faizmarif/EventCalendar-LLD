package org.example.repository;

import org.example.models.Event;
import java.util.List;

public class AppRepo {
  private static AppRepo appRepo;
  private List<Event> eventList;

  private AppRepo() {}

  public static AppRepo getInstance() {
    if (appRepo == null) {
      appRepo = new AppRepo();
    }
    return appRepo;
  }
}
