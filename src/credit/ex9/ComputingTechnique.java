package credit.ex9;

public class ComputingTechnique extends HomeTechnique {

    public enum CategoryCompTech {
        CALCULATOR("Калькулятор"),
        LAPTOP("Ноутбук"),
        PRINTER("Принтер"),
        SCANNER("Сканер"),
        MODEM("Модем"),
        COMPUTER("Компьютер");

        private String name;
        private static String type = "Вычислительная техника";

        CategoryCompTech(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public ComputingTechnique(String category, int voltage, int currentStrength, String brand) {
        super(category, ComputingTechnique.CategoryCompTech.type, voltage, currentStrength, brand);
    }
}
