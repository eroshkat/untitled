import java.util.Random;
import java.util.Scanner;

public class Converter2 {
    // Обменные курсы относительно рубля
    private static final double RUB_TO_USD = 0.010275;   // Рубль -> Доллар США
    private static final double RUB_TO_EUR = 0.009504;   // Рубль -> Евро
    private static final double RUB_TO_GBP = 0.007906;   // Рубль -> Британский фунт
    private static final double RUB_TO_CNY = 0.073554;   // Рубль -> Китайский юань
    private static final double RUB_TO_TRY = 0.352588;   // Рубль -> Турецкая лира

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Выбор случайной валюты для ввода
        String[] currencies = {"USD", "EUR", "GBP", "CNY", "TRY"};
        int currencyIndex = random.nextInt(currencies.length);
        String inputCurrency = currencies[currencyIndex];

        System.out.printf("Введите сумму в %s: ", inputCurrency);
        double amountInInputCurrency = scanner.nextDouble();

        // Конвертируем сумму в рубли
        double rubles;
        switch (inputCurrency) {
            case "USD":
                rubles = amountInInputCurrency * (1 / RUB_TO_USD);
                break;
            case "EUR":
                rubles = amountInInputCurrency * (1 / RUB_TO_EUR);
                break;
            case "GBP":
                rubles = amountInInputCurrency * (1 / RUB_TO_GBP);
                break;
            case "CNY":
                rubles = amountInInputCurrency * (1 / RUB_TO_CNY);
                break;
            case "TRY":
                rubles = amountInInputCurrency * (1 / RUB_TO_TRY);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + inputCurrency);
        }

        // Конвертация рублей в другие валюты
        double usdAmount = rubles * RUB_TO_USD;
        double eurAmount = rubles * RUB_TO_EUR;
        double gbpAmount = rubles * RUB_TO_GBP;
        double cnyAmount = rubles * RUB_TO_CNY;
        double tryAmount = rubles * RUB_TO_TRY;

        // Вывод результатов
        System.out.println("\nКонвертация:");
        System.out.printf("Рубли: %.2f₽%n", rubles);
        System.out.printf("Доллары США: %.2f$%n", usdAmount);
        System.out.printf("Евро: %.2f€%n", eurAmount);
        System.out.printf("Британские фунты: %.2f£%n", gbpAmount);
        System.out.printf("Китайские юани: %.2f¥%n", cnyAmount);
        System.out.printf("Турецкие лиры: %.2f₺%n", tryAmount);

        scanner.close();
    }
}