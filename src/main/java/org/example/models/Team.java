package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
  private String teamName;
  private List<User> userList;

  public Team() {
    userList = new ArrayList<>();
  }

  public String getTeamName() {
    return teamName;
  }

  public Team setTeamName(String teamName) {
    this.teamName = teamName;
    return this;
  }

  public List<User> getUserList() {
    return userList;
  }

  @Override
  public String toString() {
    return "Team{" + "teamName='" + teamName + '\'' + ", userList=" + userList + '}';
  }
}
