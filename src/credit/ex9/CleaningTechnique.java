package credit.ex9;

public class CleaningTechnique extends HomeTechnique {

    public enum CategoryCleanTech {
        VACUUM_CLEANER("Пылесос"),
        STEAM_CLEANER("Пароочиститель"),
        IRON("Утюг"),
        STEAMER("Отпариватель"),
        ROBOT_WINDOW_CLEANER("Робот-мойщик окон");

        private String name;
        private static String type = "Техника для уборки";

        CategoryCleanTech(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public CleaningTechnique(String category, int voltage, int currentStrength, String brand) {
        super(category, CategoryCleanTech.type, voltage, currentStrength, brand);
    }
}

