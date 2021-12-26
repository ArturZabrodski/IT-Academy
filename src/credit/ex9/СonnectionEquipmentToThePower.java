package credit.ex9;

public interface СonnectionEquipmentToThePower {

    boolean button = false;

    default void onOffConnection() {
    }

    default void isConnectedToPower() {
        if (button) {
            System.out.format("Техника включена в розетку.");
        } else {
            System.out.format("Техника не включена в розетку.");
        }
    }
}