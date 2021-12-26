package exam.ex6;

import java.text.DecimalFormat;
import java.util.HashSet;

public class Bouquet<Flower> {

  private HashSet hashSetColor = new HashSet();
  private double price;
  String bouquet = "Bouquet of flowers: \n";
  private int witheringTime = 0;

  public void addInBouqeut(Flower flower) {
    setBouquet(flower, 1);
  }

  public void addInBouqeut(Flower flower, int pieces) {
    setBouquet(flower, pieces);
  }

  private void setBouquet(Flower flower, int pieces) {
    String[] arrayStr = String.valueOf(flower).split(", ");

    bouquet += "\t" + arrayStr[0] + " " + arrayStr[1] + " - " + pieces + " pcs;\n";
    price += Double.parseDouble(arrayStr[2]) * pieces;

    hashSetColor.add(arrayStr[1]);

    if (arrayStr[0].equals(FlowersNames.ROSE.getName())
        && witheringTime < FlowersNames.ROSE.getWitheringTime()) {
      witheringTime = FlowersNames.ROSE.getWitheringTime();
    } else if (arrayStr[0].equals(FlowersNames.CARNATION.getName())
        && witheringTime < FlowersNames.CARNATION.getWitheringTime()) {
      witheringTime = FlowersNames.CARNATION.getWitheringTime();
    } else if (arrayStr[0].equals(FlowersNames.TULIP.getName())
        && witheringTime < FlowersNames.TULIP.getWitheringTime()) {
      witheringTime = FlowersNames.TULIP.getWitheringTime();
    } else if (arrayStr[0].equals(FlowersNames.LILY.getName())
        && witheringTime < FlowersNames.TULIP.getWitheringTime()) {
      witheringTime = FlowersNames.LILY.getWitheringTime();
    } else if (arrayStr[0].equals(FlowersNames.PION.getName())
        && witheringTime < FlowersNames.PION.getWitheringTime()) {
      witheringTime = FlowersNames.PION.getWitheringTime();
    }
  }

  public String getBouquetAndPrice() {
    DecimalFormat dF = new DecimalFormat("#.##");
    return bouquet + "The price of the bouquet is equal to " + dF.format(price) + " $";
  }

  public String getColorsBouquet() {
    return "Colors in Bouquet: " + hashSetColor;
  }

  public String getWitheringTime() {
    return "The bouquet will wither in " + witheringTime + " days";
  }
}
