package credit.ex9;

public class KitchenTechnique extends HomeTechnique {

    public enum CategoryKitTech {
        FRIDGE("Холодильник"),
        DISHWASHER("Посудомойка"),
        MICROWAVE("Микроволновка"),
        ELECTRIC_KETTLE("Электрический чайник"),
        COFFEE_MAKER("Кофемашина"),
        KITCHEN_HOOD("Кухонная вытяжка"),
        ELECTRIC_STOVE("Электрическая плита");

        private String name;
        private static String type = "Кухонная техника";

        CategoryKitTech(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public KitchenTechnique(String category, int voltage, int currentStrength, String brand) {
        super(category, CategoryKitTech.type, voltage, currentStrength, brand);
    }
}
