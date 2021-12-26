package credit.ex9;

import credit.ex9.CleaningTechnique.CategoryCleanTech;
import credit.ex9.ComputingTechnique.CategoryCompTech;
import credit.ex9.EntertaimentTechnique.CategoryEntTech;
import credit.ex9.KitchenTechnique.CategoryKitTech;

import java.util.ArrayList;
import java.util.List;

/**
 * Определить иерархию домашней техники.
 * Включить некоторые в розетку.
 * Посчитать потребляемую мощность.
 * Провести сортировку приборов в квартире на основе одного из параметров.
 * Найти кухонный прибор в квартире, соответствующий заданному диапазону параметров.
 */

public class Program {

    public static void main(String[] args) {
        List<HomeTechnique> arraylistPower = new ArrayList<>();

        HomeTechnique fridge = new KitchenTechnique(CategoryKitTech.FRIDGE.getName(),
                220, 14, "Samsung");
        HomeTechnique microwave = new KitchenTechnique(CategoryKitTech.MICROWAVE.getName(),
                220, 10, "LG");
        HomeTechnique tv = new EntertaimentTechnique(CategoryEntTech.TV.getName(),
                220, 5, "Samsung");
        HomeTechnique dvdPlayer = new EntertaimentTechnique(CategoryEntTech.DVD_PLAYER.getName(),
                220, 6, "Sharp");
        HomeTechnique scanner = new ComputingTechnique(CategoryCompTech.SCANNER.getName(),
                220, 3, "Epson");
        HomeTechnique modem = new ComputingTechnique(CategoryCompTech.MODEM.getName(),
                12, 3, "A-Data");
        HomeTechnique vacuumCleaner = new CleaningTechnique(CategoryCleanTech.VACUUM_CLEANER.getName(),
                220, 8, "Samsung");
        HomeTechnique steamer = new CleaningTechnique(CategoryCleanTech.STEAMER.getName(),
                220, 3, "Solaris");

        System.out.println("\nИнформация о домашней технике:");
        System.out.print("------------------------------");

        System.out.print(fridge);
        System.out.print(microwave);
        System.out.print(tv);
        System.out.print(dvdPlayer);
        System.out.print(scanner);
        System.out.print(modem);
        System.out.print(vacuumCleaner);
        System.out.println(steamer);

        // включаем в розетку
        fridge.onOffConnection();
        tv.onOffConnection();
        dvdPlayer.onOffConnection();
        microwave.onOffConnection();
        scanner.onOffConnection();
        modem.onOffConnection();
        vacuumCleaner.onOffConnection();
        steamer.onOffConnection();

        // микроволновку и пылесос выключаем из розетки
        microwave.onOffConnection();
        vacuumCleaner.onOffConnection();

        System.out.println("\nИнформация о технике, включенной в розетку:");
        System.out.println("------------------------------------------");

        fridge.isConnectedToPower();
        tv.isConnectedToPower();
        dvdPlayer.isConnectedToPower();
        microwave.isConnectedToPower();
        scanner.isConnectedToPower();
        modem.isConnectedToPower();
        vacuumCleaner.isConnectedToPower();
        steamer.isConnectedToPower();

        System.out.println();
        // потребляемая мощность приборов, включенных в розетку
        HomeTechnique.powerConsumption();

        arraylistPower.add(fridge);
        arraylistPower.add(tv);
        arraylistPower.add(dvdPlayer);
        arraylistPower.add(microwave);
        arraylistPower.add(scanner);
        arraylistPower.add(modem);
        arraylistPower.add(vacuumCleaner);
        arraylistPower.add(steamer);

        System.out.println("\nДо сортировки приборов по мощности:");
        System.out.println("-----------------------------------");
        System.out.println(arraylistPower);

        System.out.println("\nCортировка приборов по мощности:");
        System.out.println("--------------------------------");
        System.out.println(getSortByPower(arraylistPower));

        System.out.println("\nПоиск кухонного прибора по параметрам мощности и силы тока:");
        System.out.println("-----------------------------------------------------------");
        System.out.println(searchByParameters(arraylistPower, 100, 4000, 1, 20));
        System.out.println(searchByParameters(arraylistPower, 1500, 3000, 4, 15));
        System.out.println(searchByParameters(arraylistPower, 1000, 3500, 7, 9));
    }

    public static List<HomeTechnique> getSortByPower(List<HomeTechnique> arraylistPower) {

        for (int out = arraylistPower.size() - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                int i1 = arraylistPower.get(in).toString().indexOf("мощность = ") + 11;
                int i2 = arraylistPower.get(in).toString().indexOf(" Вт");
                int y1 = arraylistPower.get(in + 1).toString().indexOf("мощность = ") + 11;
                int y2 = arraylistPower.get(in + 1).toString().indexOf(" Вт");
                int power1 = Integer.parseInt(arraylistPower.get(in).toString().substring(i1, i2));
                int power2 = Integer.parseInt(arraylistPower.get(in + 1).toString().substring(y1, y2));
                if (power1 > power2) {
                    // ставим большим элемент перед меньшим
                    arraylistPower.add(in, arraylistPower.get(in + 1));
                    // затем удаляем этот элемент по прежнему индексу
                    arraylistPower.remove(in + 2);
                }
            }
        }
        return arraylistPower;
    }

    public static List<HomeTechnique> searchByParameters(List<HomeTechnique> arraylistPower,
                                                         int minPower, int maxPower, int minCurrentStrength, int maxcurrentStrength) {

        List<HomeTechnique> arraylistPowerNew = new ArrayList<>();

        for (HomeTechnique a : arraylistPower) {
            int i1 = a.toString().indexOf("мощность = ") + 11;
            int i2 = a.toString().indexOf(" Вт");
            int power = Integer.parseInt(a.toString().substring(i1, i2));
            int y1 = a.toString().indexOf("сила тока = ") + 12;
            int y2 = a.toString().indexOf("А");
            int currentStrength = Integer.parseInt(a.toString().substring(y1, y2));
            boolean type = a.toString().contains("Кухонная техника");
            if ((power >= minPower) && (power <= maxPower) && (currentStrength >= minCurrentStrength) && (
                    currentStrength <= maxcurrentStrength) && type) {
                arraylistPowerNew.add(a);
            }
        }

        if (arraylistPowerNew.isEmpty()) {
            System.out.println("По заданным параметрам, кухонный прибор не найден! ");
            return null;
        }

        return arraylistPowerNew;
    }
}


