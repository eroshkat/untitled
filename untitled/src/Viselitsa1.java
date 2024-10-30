import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Viselitsa1 {
    private static final List<String> WORDS = Arrays.asList("шкаф", "полночь", "мельница", "свитер", "виселица");
    private static final int MAX_LIVES = 6; // максимальное количество попыток

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS.get(random.nextInt(WORDS.size())); // случайное слово для отгадывания
        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_'); // заполняем массив подчеркиваниями

        int livesLeft = MAX_LIVES;
        boolean gameOver = false;

        while (!gameOver && livesLeft > 0) {
            System.out.println("\nУгадайте слово: " + new String(guessedWord));
            System.out.printf("Осталось жизней: %d\n", livesLeft);
            System.out.print("Введите букву: ");

            char inputChar = scanner.next().charAt(0); // считываем только первую букву ввода
            if (wordToGuess.contains(Character.toString(inputChar))) { // проверяем наличие буквы в слове
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (inputChar == wordToGuess.charAt(i)) {
                        guessedWord[i] = inputChar; // заменяем подчеркивание на правильную букву
                    }
                }

                if (new String(guessedWord).equals(wordToGuess)) {
                    gameOver = true;
                    System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
                }
            } else {
                livesLeft--; // теряем жизнь при неверной попытке
                System.out.println("Буквы нет в слове.");
            }
        }

        if (livesLeft == 0) {
            System.out.println("\nК сожалению, Вы проиграли. Загаданное слово было: " + wordToGuess);
        }
    }
}