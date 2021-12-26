package exam.ex6;

public enum FlowersNames {
  // the name and time of flower withering in days
  ROSE("Rose", 4),
  CARNATION("Carnation", 14),
  TULIP("Tulip", 5),
  LILY("Lily", 10),
  PION("Pion", 6);

  private String name;
  private final int witheringTime;

  FlowersNames(String name, int witheringTime) {
    this.name = name;
    this.witheringTime = witheringTime;
  }

  public String getName() {
    return name;
  }

  public int getWitheringTime() {
    return witheringTime;
  }
}
