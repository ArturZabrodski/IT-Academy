package exam.ex6;

abstract public class Flower {

  private String name;
  private String color;
  private double price;

  public Flower(String name, String color, double price) {
    this.name = name;
    this.color = color;
    this.price = price;
  }

  @Override
  public String toString() {
    return name + ", " + color + ", " + price;
  }
}
