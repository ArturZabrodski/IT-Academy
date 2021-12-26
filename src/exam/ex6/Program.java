package exam.ex6;

/**
 * Реализовать иерархию цветов (розы, гвоздики, тюльпаны, лилии и... что-то на свой вкус).
 * Создать несколько объектов-цветов.
 * Собрать букет и определить его стоимость.
 * Определить все цвета, используемые в букете.
 * Определить когда весь букет завянет.
 * В букет может входить несколько цветов одного типа.
 */

public class Program {

    public static void main(String[] args) {

        Flower flower1 = new Rose("Red", 5);
        Flower flower2 = new Rose("White", 4);
        Flower flower3 = new Rose("Pink", 4.5);
        Flower flower4 = new Carnation("Red", 3.5);
        Flower flower5 = new Carnation("Yellow", 3.6);
        Flower flower6 = new Tulip("White", 3.1);
        Flower flower7 = new Tulip("Pink", 3.2);
        Flower flower8 = new Lily("White", 2.1);
        Flower flower9 = new Pion("Orange", 1.5);
        Flower flower10 = new Pion("Red", 1.7);

        Bouquet<Flower> bouquet = new Bouquet<>();
        bouquet.addInBouqeut(flower1);
        bouquet.addInBouqeut(flower2);
        bouquet.addInBouqeut(flower3);
        bouquet.addInBouqeut(flower4, 3);
        bouquet.addInBouqeut(flower5, 3);
        bouquet.addInBouqeut(flower6, 5);
        bouquet.addInBouqeut(flower7, 5);
        bouquet.addInBouqeut(flower8, 3);
        bouquet.addInBouqeut(flower9, 3);
        bouquet.addInBouqeut(flower10, 5);

        System.out.println(bouquet.getBouquetAndPrice());
        System.out.println();

        System.out.println(bouquet.getColorsBouquet());
        System.out.println();

        System.out.println(bouquet.getWitheringTime());
        System.out.println();
    }
}
