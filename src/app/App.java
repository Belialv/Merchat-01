package app;

import java.util.Scanner;

// Класс-входная точка в приложение.
// App launcher.
public class App {

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;

    // Делаем метод main() наименее загруженным логикой
    public static void main(String[] args) {
        initVars();
        showData(processData());
    }

    // Инициализация переменных.
    // Имитация ввода данных пользователем.
    private static void initVars() {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите имя продавца:");
        merchantName = s.nextLine();
        System.out.println("Введите почту продавца:");
        email = s.nextLine();
        System.out.println("Введите телефонный номер продавца:");
        phone = s.nextLine();
        System.out.println("Введите название товара:");
        productName = s.nextLine();
        System.out.println("Введите количество проданного товара:");
        quantity = s.nextInt();
        System.out.println("Введите цену на товар:");
        price = s.nextDouble();
    }

    // Передача данных на обработку.
    // Вызовы методов через экземпляры классов
    // для получения результатов расчетов.
    // Здесь же получение расчета и округления бонуса.
    // Получение шаблона для вывода.
    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    // Вывод данных
    private static void showData(String output) {
        System.out.println(output);
    }
}
// Где тут нужен Scanner