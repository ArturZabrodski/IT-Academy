package credit.ex9;

public abstract class HomeTechnique implements СonnectionEquipmentToThePower {

    private String category;
    private String type;
    private int power;
    private int voltage;
    private int currentStrength;
    private String brand;
    private boolean button;
    private static int powerConsumption;
    private int countName = 0;
    private int countPower = 0;

    public HomeTechnique(String category, String type, int voltage, int currentStrength,
                         String brand) {
        this.category = category;
        this.type = type;
        this.voltage = voltage;
        this.currentStrength = currentStrength;
        this.brand = brand;
        this.power = currentStrength * voltage;
        this.button = false;
    }

    @Override
    public void onOffConnection() {
        button = !button;
        if (button) {
            powerConsumption += power;
        } else {
            powerConsumption -= power;
        }
    }

    public static void powerConsumption() {
        System.out.format(
                "Потребляемая мощность приборов, включенных в розетку = %d Вт\n", powerConsumption);
    }

    @Override
    public void isConnectedToPower() {
        if (button) {
            System.out.format("%s включен(а) в розетку.\n", category);
        } else {
            System.out.format("%s не включен(а) в розетку.\n", category);
        }
    }

    @Override
    public String toString() {
        return "\n" + category +
                " \"" + brand +
                "\", мощность = " + power +
                " Вт, сила тока = " + currentStrength +
                "А, тип: \"" + type + "\";";
    }
}
