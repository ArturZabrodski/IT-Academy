package extra.ex1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Игра пятнашки.
 *
 * Опишите меню:
 * new game (n)
 * save game (s)
 * load game (l)
 * quit game (q)
 *
 * Загрузите поле 4x4 заполнив рандомно:
 * 15  9 11 14
 * 5 12  7  8
 * 2 10  3  6
 * 13 []  1  4
 *
 * Победа при:
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 []
 *
 * Для то того чтобы двигать вводите номер пятнашки (от 1 до 15)
 * Добавьте проверку для неправильной команды из консол
 * Напишите проверку для проверки на победу
 * Придумайте как сохранить состояние игры в файл и потом зачитать его
 * Проверьте работоспобность программы при отсутсвующем файле сохранения
 * Или уберите пункт загрузки при отсутствующем файле(ах)
 * Научите сохранять и загружать вашу программу в несколько слотов (к примеру 5 слотов)
 */

public class Game_15 {

    public static void main(String[] args) throws IOException {

        String[][] array = new String[4][4];

        gameMenu(array);
    }

    private static void gameMenu(String[][] array) throws IOException {

        while (true) {
            System.out.println("\n\tMenu:\n"
                    + "new game (n)\n"
                    + "save game (s)\n"
                    + "load game (l)\n"
                    + "quit game (q)");

            Scanner sc = new Scanner(System.in);
            String menu = sc.nextLine();

            switch (menu) {
                case "n":
                    if (array == null) {
                        newGame();
                    } else {
                        newGame(array);
                    }
                    break;
                case "s":
                    if (array[0][0] == null) {
                        System.out.println("To save - you need to start the game.");
                    } else {
                        saveGame(array);
                    }
                    break;
                case "l":
                    if (array[0][0] == null) {
                        loadGame();
                    } else {
                        loadGame(array);
                    }

                    break;
                case "q":
                    quitGame();
                    break;
                default:
                    // checking for an incorrect command from the console
                    System.out.println("Invalid command entered!");
            }
        }
    }

    private static void newGame(String[][] array) throws IOException {

        // creating a list of values and shuffling it
        List<String> listValue = Arrays.asList(
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15", "[]"
        );
        Collections.shuffle(listValue);

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = listValue.get(count++);
            }
        }
        playGame(array);
    }

    private static void newGame() throws IOException {

        String[][] array = new String[4][4];

        // creating a list of values and shuffling it
        List<String> listValue = Arrays.asList(
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "10", "11", "12",
                "13", "14", "15", "[]"
        );
        Collections.shuffle(listValue);

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = listValue.get(count++);
            }
        }
        playGame(array);
    }

    private static void playGame(String[][] array) throws IOException {

        List<String> movements = new ArrayList<String>();

        String[][] arrayWin = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "[]"}
        };

        System.out.println("\nMake a move!\n");
        int i1 = -1;
        int j1 = -1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals("[]")) {
                    i1 = i;
                    j1 = j;
                }
                System.out.format("%4s\t", array[i][j]);
            }
            System.out.println();
        }

        // movement through the cells
        if (i1 == 0 && j1 == 0) {

            movements.add(array[i1][j1 + 1]);
            movements.add(array[i1 + 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 + 1] + " or " + array[i1 + 1][j1]);
        } else if (i1 == 0 && j1 == 3) {
            movements.add(array[i1][j1 - 1]);
            movements.add(array[i1 + 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 - 1] + " or " + array[i1 + 1][j1]);
        } else if (i1 == 3 && j1 == 0) {
            movements.add(array[i1][j1 + 1]);
            movements.add(array[i1 - 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 + 1] + " or " + array[i1 - 1][j1]);
        } else if (i1 == 3 && j1 == 3) {
            movements.add(array[i1][j1 - 1]);
            movements.add(array[i1 - 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 - 1] + " or " + array[i1 - 1][j1]);
        } else if (i1 == 0 && (j1 == 1 || j1 == 2)) {
            movements.add(array[i1][j1 - 1]);
            movements.add(array[i1][j1 + 1]);
            movements.add(array[i1 + 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 - 1] + ", " + array[i1][j1 + 1]
                    + " or " + array[i1 + 1][j1]);
        } else if (i1 == 3 && (j1 == 1 || j1 == 2)) {
            movements.add(array[i1][j1 - 1]);
            movements.add(array[i1][j1 + 1]);
            movements.add(array[i1 - 1][j1]);
            System.out.println("\nEnter a number " + array[i1][j1 - 1] + ", " + array[i1][j1 + 1]
                    + " or " + array[i1 - 1][j1]);
        } else if ((i1 == 1 || i1 == 2) && j1 == 0) {
            movements.add(array[i1 - 1][j1]);
            movements.add(array[i1 + 1][j1]);
            movements.add(array[i1][j1 + 1]);
            System.out.println("\nEnter a number " + array[i1 - 1][j1] + ", " + array[i1 + 1][j1]
                    + " or " + array[i1][j1 + 1]);
        } else if ((i1 == 1 || i1 == 2) && j1 == 3) {
            movements.add(array[i1 - 1][j1]);
            movements.add(array[i1 + 1][j1]);
            movements.add(array[i1][j1 - 1]);
            System.out.println("\nEnter a number " + array[i1 - 1][j1] + ", " + array[i1 + 1][j1]
                    + " or " + array[i1][j1 - 1]);
        } else if ((i1 == 1 || i1 == 2) && (j1 == 1 || j1 == 2)) {
            movements.add(array[i1 - 1][j1]);
            movements.add(array[i1 + 1][j1]);
            movements.add(array[i1][j1 - 1]);
            movements.add(array[i1][j1 + 1]);
            System.out.println("\nEnter a number " + array[i1 - 1][j1] + ", " + array[i1 + 1][j1]
                    + ", " + array[i1][j1 - 1] + " or " + array[i1][j1 + 1]);
        }

        System.out.println("\nBack to the menu (m)");
        System.out.println("Clear the console (с)");

        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();

        // checking for an incorrect command from the console
        if (movements.contains(value)) {
            array = swap(i1, j1, array, value);
        } else if (value.equals("m")) {
            gameMenu(array);
        } else if (value.equals("c")) {
            clearConsole();
        } else {
            System.out.println("Invalid command entered!");
        }

        // check to check for a win, else we continue to play
        if (Arrays.deepEquals(arrayWin, array)) {
            System.out.println("\nYou Win!");
            gameMenu(array);
        } else {
            playGame(array);
        }
    }

    private static String[][] swap(int i1, int j1, String[][] array, String value) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j].equals(value)) {
                    array[i][j] = array[i1][j1];
                    array[i1][j1] = value;
                    break;
                }
            }
        }
        return array;
    }

    private static void saveGame(String[][] array) throws IOException {

        slotsForSavingAndReading();

        String[] saveArray = slotsForSavingAndReading();
        boolean button = true;
        Scanner sc = new Scanner(System.in);

        while (button) {
            System.out.format("\n1 Slot: %s\n2 Slot: %s\n3 Slot: %s\n4 Slot: %s\n5 Slot: %s\n",
                    saveArray[0], saveArray[1], saveArray[2], saveArray[3], saveArray[4]);

            System.out.println("\nBack to the menu (m)");
            System.out.println("Clear the console (с)");
            System.out.println("Continue the game (g)");

            String value = sc.nextLine();

            switch (value) {
                case "1":
                    if (!saveArray[0].equals("empty")) {
                        System.out.println("The memory slot will be overwritten");
                    }
                    saveFile(array, "1");
                    button = false;
                    break;
                case "2":
                    if (!saveArray[1].equals("empty")) {
                        System.out.println("The memory slot will be overwritten");
                    }
                    saveFile(array, "2");
                    button = false;
                    break;
                case "3":
                    if (!saveArray[2].equals("empty")) {
                        System.out.println("The memory slot will be overwritten");
                    }
                    saveFile(array, "3");
                    button = false;
                    break;
                case "4":
                    if (!saveArray[3].equals("empty")) {
                        System.out.println("The memory slot will be overwritten");
                    }
                    saveFile(array, "4");
                    button = false;
                    break;
                case "5":
                    if (!saveArray[4].equals("empty")) {
                        System.out.println("The memory slot will be overwritten");
                    }
                    saveFile(array, "5");
                    button = false;
                    break;
                case "m":
                    gameMenu(array);
                    button = false;
                    break;
                case "c":
                    clearConsole();
                    break;
                case "g":
                    playGame(array);
                    button = false;
                    break;
                default:
                    System.out.println("Invalid command entered!");
            }
        }
    }

    private static void saveFile(String[][] array, String slot) throws IOException {

        try (FileWriter writer = new FileWriter("slot" + slot + ".save")) {

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    writer.write(array[i][j] + " ");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void loadGame() throws IOException {

        String[] saveArray = slotsForSavingAndReading();
        String[][] array;
        boolean button = true;

        while (button) {
            System.out.format("\n1 Slot: %s\n2 Slot: %s\n3 Slot: %s\n4 Slot: %s\n5 Slot: %s\n",
                    saveArray[0], saveArray[1], saveArray[2], saveArray[3], saveArray[4]);

            System.out.println("\nBack to the menu (m)");
            System.out.println("Clear the console (с)");

            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();

            switch (value) {
                case "1":
                    if (saveArray[0].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("1");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "2":
                    if (saveArray[1].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("2");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "3":
                    if (saveArray[2].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("3");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "4":
                    if (saveArray[3].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("4");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "5":
                    if (saveArray[4].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("5");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "m":
                    gameMenu(null);
                    button = false;
                    break;
                case "c":
                    clearConsole();
                    break;
                default:
                    System.out.println("Invalid command entered!");
            }
        }
    }

    private static void loadGame(String[][] array) throws IOException {

        String[] saveArray = slotsForSavingAndReading();
        boolean button = true;

        while (button) {
            System.out.format("\n1 Slot: %s\n2 Slot: %s\n3 Slot: %s\n4 Slot: %s\n5 Slot: %s\n",
                    saveArray[0], saveArray[1], saveArray[2], saveArray[3], saveArray[4]);

            System.out.println("\nBack to the menu (m)");
            System.out.println("Clear the console (с)");
            System.out.println("Continue the game (g)");

            Scanner sc = new Scanner(System.in);
            String value = sc.nextLine();

            switch (value) {
                case "1":
                    if (saveArray[0].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("1");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "2":
                    if (saveArray[1].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("2");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "3":
                    if (saveArray[2].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("3");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "4":
                    if (saveArray[3].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("4");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "5":
                    if (saveArray[4].equals("empty")) {
                        System.out.println("No saved game. Choose another slot.");
                    } else {
                        array = loadFile("5");
                        playGame(array);
                        button = false;
                    }
                    break;
                case "m":
                    gameMenu(array);
                    button = false;
                    break;
                case "c":
                    clearConsole();
                    break;
                case "g":
                    playGame(array);
                    button = false;
                    break;
                default:
                    System.out.println("Invalid command entered!");
            }
        }
    }

    private static String[][] loadFile(String slot) {

        String[][] array = new String[4][4];
        List<String> arrayList;
        String str = "";
        int index = 0;

        try (FileReader reader = new FileReader("slot" + slot + ".save")) {

            int c;
            while ((c = reader.read()) != -1) {
                str = str.concat(String.valueOf((char) c));
            }

            arrayList = new ArrayList<>(List.of(str.split(" ")));

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = arrayList.get(index++);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private static String[] slotsForSavingAndReading() {

        String[] saveArray = new String[5];
        File slot1 = new File("slot1.save");
        File slot2 = new File("slot2.save");
        File slot3 = new File("slot3.save");
        File slot4 = new File("slot4.save");
        File slot5 = new File("slot5.save");

        // checking whether the file is empty or not
        try {
            if (slot1.exists()) {
                if (isFileEmpty(slot1)) {
                    saveArray[0] = "empty";
                } else {
                    saveArray[0] = "saved";
                }
            } else {
                FileWriter writer1 = new FileWriter("slot1.save");
                saveArray[0] = "empty";
            }
            if (slot2.exists()) {
                if (isFileEmpty(slot2)) {
                    saveArray[1] = "empty";
                } else {
                    saveArray[1] = "saved";
                }
            } else {
                FileWriter writer2 = new FileWriter("slot2.save");
                saveArray[1] = "empty";
            }
            if (slot3.exists()) {
                if (isFileEmpty(slot3)) {
                    saveArray[2] = "empty";
                } else {
                    saveArray[2] = "saved";
                }
            } else {
                FileWriter writer3 = new FileWriter("slot3.save");
                saveArray[2] = "empty";
            }
            if (slot4.exists()) {
                if (isFileEmpty(slot4)) {
                    saveArray[3] = "empty";
                } else {
                    saveArray[3] = "saved";
                }
            } else {
                FileWriter writer4 = new FileWriter("slot4.save");
                saveArray[3] = "empty";
            }
            if (slot5.exists()) {
                if (isFileEmpty(slot5)) {
                    saveArray[4] = "empty";
                } else {
                    saveArray[4] = "saved";
                }
            } else {
                FileWriter writer5 = new FileWriter("slot5.save");
                saveArray[4] = "empty";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return saveArray;
    }

    private static void quitGame() {
        System.out.println("GoodBye");
        System.exit(0);
    }

    private static void clearConsole() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    private static boolean isFileEmpty(File file) throws IOException {
        return file.length() == 0;
    }
}
