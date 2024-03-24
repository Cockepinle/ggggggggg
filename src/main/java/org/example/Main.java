package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создание массива строк с именами фирм
        String[] nameFirmа = new String[]{"Cartier", "Armani", "Tissot"};

        // Создание двумерного массива Object для хранения информации о товарах
        Object[][] markaWatch = new Object[][] {
                {nameFirmа[0], ":", "TANK FRANÇAISE", ",", "TANK CINTRÉE"},
                {nameFirmа[1], ":", "Emporio Armani AR0389", ",", "Emporio Armani AR1908"},
                {nameFirmа[2], ":", "T116.617.11.047.01", ",", "T120.210.17.116.00"}
        };
        // Создание ArrayList для хранения информации о покупателях и заказах
        ArrayList<Object[]> data = new ArrayList<>();

        // Создание экземпляра класса Scanner для ввода данных
        Scanner scanner = new Scanner(System.in);

        // Вывод сообщения о продолжении шопинга
        System.out.println("Хотите ли продолжить шопинг: 1.ДА, 2.НЕТ");
        int vibor = scanner.nextInt();
        int i = 0;
        String name = null;
        String email = null;
        String number = null;

        // Цикл для продолжения шопинга
        while(vibor == 1){
            System.out.println("Заказ - " +  (i + 1) +" "+ "Введите данные: ");
            int nomer = i + 1;

            // Если данные еще не введены, запрашиваем их у пользователя
            if (name == null || email == null || number == null){
                System.out.println("ФИО- ");
                scanner.nextLine();
                name = scanner.nextLine();
                System.out.println("Email- ");
                email = scanner.nextLine();
                System.out.println("Number- ");
                number = scanner.nextLine();
            }

            // Вывод списка товаров в магазине
            System.out.println("Список товара в магазине: ");
            for (int f = 0; f < markaWatch.length; f++) {
                for (int j = 0; j < markaWatch[i].length; j++) {
                    System.out.print(markaWatch[f][j] + " ");
                }
                System.out.println();
            }

            // Запрос на выбор фирмы часов
            scanner.nextLine();
            System.out.println("Выберите фирму часов (Cartier, Armani, Tissot): ");
            String firm = "";
            boolean firmaVibor = false;

            // Проверка наличия выбранной фирмы в списке товаров
            while (!firmaVibor){
                firm = scanner.nextLine();

                for (Object[] row : markaWatch) {
                    if (row[0].equals(firm)) {
                        firmaVibor = true;
                        break;
                    }
                }

                // Если выбранная фирма не найдена, запрашиваем ее повторно
                if (!firmaVibor) {
                    System.out.println("Такой фирмы нет в магазине. Пожалуйста, выберите фирму часов из следующих: Cartier, Armani, Tissot");
                }
            }
            System.out.print("Выберите марку часов из следующих: ");

            for (Object[] row : markaWatch) {
                if (row[0].equals(firm)) {
                    for (int j = 2; j < row.length; j++) {
                        System.out.print(row[j] + " ");
                    }
                    System.out.println();
                }
            }

            String mark = "";
            boolean markaVibor = false;

            while (!markaVibor) {
                mark = scanner.nextLine();

                for (Object[] row : markaWatch) {// Цикл for-each, проходится по каждой строке в массиве markaWatch
                    if (row[0].equals(firm)) { // Проверка, соответствует ли нулевой элемент строки переменной firm
                        for (int j = 2; j < row.length; j++) {
                            if (row[j].equals(mark)) {
                                markaVibor = true;
                                break;
                            }
                        }
                    }
                }

                if (!markaVibor) { // Если markaVibor все еще false
                    System.out.println("Такой марки нет в магазине. Пожалуйста, выберите марку часов из предложенных вами фирмой.");
                }
            }

            System.out.println("Количество товара- ");
            String count = scanner.nextLine();
            Object[] zakaz = {name, email, number, firm, mark, count, nomer};// Создание массива данных заказа
            data.add(zakaz); // Добавление заказа в коллекцию данных

            System.out.println("Хотите ли продолжить шопинг: 1.ДА, 2.НЕТ");// Вывод вопроса о продолжении шопинга
            vibor = scanner.nextInt();
            scanner.nextLine();

            i++;// Увеличение счетчика итераций
        }

        System.out.println("Информация о покупателях:");// Вывод информации о покупателях
        for (Object[] zakaz : data) { // Цикл for-each, проходится по каждому заказу в коллекции данных
            System.out.println("Номер заказа: " + zakaz[6]);
            System.out.println("ФИО: " + zakaz[0]);
            System.out.println("Email: " + zakaz[1]);
            System.out.println("Номер телефона: " + zakaz[2]);
            System.out.println("Фирма часов: " + zakaz[3]);
            System.out.println("Марка часов: " + zakaz[4]);
            System.out.println("Количество: " + zakaz[5]);
            System.out.println();
        }
    }
}