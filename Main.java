import java.util.Arrays;
import java.util.Scanner;
import java.lang.String;

public class Main {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        final String WORD_OF_DAY_STR = "PARTY";
        final char[] WORD_OF_DAY = WORD_OF_DAY_STR.toCharArray();
        final String ALPHABET_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] alphabet = ALPHABET_STR.toCharArray();
        char[] solution = new char[5];

        int guessNum = 1;
        char[] guess = processGuess(guessNum, WORD_OF_DAY_STR, WORD_OF_DAY, ALPHABET_STR, alphabet, solution);
        while (guessNum < 6 && !Arrays.equals(guess, WORD_OF_DAY)) {
            guessNum++;
            guess = processGuess(guessNum, WORD_OF_DAY_STR, WORD_OF_DAY, ALPHABET_STR, alphabet, solution);
        }

        if (Arrays.equals(solution, WORD_OF_DAY)){
            System.out.println("Congrats! You got it");
        } else {
            System.out.println("Out of guesses! Better luck next time.");
        }
    }

    public static char[] getGuess(int number){
        Scanner input = new Scanner(System.in);
        System.out.print("Guess #" + number + ": ");
        String guess = input.nextLine();
        guess = guess.toUpperCase();
        
        return stringToChars(guess);
        
    }

    public static char[] stringToChars(String str){
        return str.toCharArray();
    }

    public static char[] processGuess(int num, String WORD_OF_DAY_STR, char[] WORD_OF_DAY, String ALPHABET_STR, char[] alphabet, char[] solution){
        char[] guess = getGuess(num);
        for (int i = 0; i < Math.max(5, guess.length); i++){
            char guessLetter = guess[i];
            char realLetter = WORD_OF_DAY[i];
            int alphaIdx = ALPHABET_STR.toUpperCase().indexOf(guessLetter);

            if (guessLetter == realLetter){
                solution[i] = guess[i];
                alphabet[alphaIdx] = '\u0000';
            }
            else if (WORD_OF_DAY_STR.indexOf(guessLetter) > -1){
                alphabet[alphaIdx] = Character.toString(guessLetter).toLowerCase().charAt(0);
            }
            else {
                alphabet[alphaIdx] = '\u0000';
            }
        }
        System.out.print("Available letters: ");
        displayCharList(alphabet);

        System.out.print("Solution: ");
        displayCharList(solution);

        return guess;
    }

    public static void displayCharList(char[] arr){
        for (char c: arr){
            if (c == '\u0000'){
                System.out.print("_");
            } else {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}