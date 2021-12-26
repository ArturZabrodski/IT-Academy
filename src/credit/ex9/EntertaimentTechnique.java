package credit.ex9;

public class EntertaimentTechnique extends HomeTechnique {

    public enum CategoryEntTech {
        TV("Телевизор"),
        COMPUTER("Компьютер"),
        MUSIC_CENTER("Музыкальный центр"),
        MP3_PLAYER("MP3-плеер"),
        DVD_PLAYER("DV-плеер"),
        GAME_CONSOLE("Игровая приставка");

        private String name;
        private static String type = "Техника для отдыха и развлечения";

        CategoryEntTech(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public EntertaimentTechnique(String category, int voltage, int currentStrength, String brand) {
        super(category, CategoryEntTech.type, voltage, currentStrength, brand);
    }
}
