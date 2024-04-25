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

        char[] guess = getGuess(1);
        for (int i = 0; i < Math.max(5, guess.length); i++){
            char guessLetter = guess[i];
            char realLetter = WORD_OF_DAY[i];
            int alphaIdx = ALPHABET_STR.indexOf(guessLetter);

            if (guessLetter == realLetter){
                solution[i] = guess[i];
            }
            else if (WORD_OF_DAY_STR.indexOf(guessLetter) > -1){
                alphabet[alphaIdx] = Character.toString(guessLetter).toLowerCase().charAt(0);
            }
            else {
                alphabet[alphaIdx] = (Character) null;
            }
        }
        
    }

    public static char[] getGuess(int number){
        Scanner input = new Scanner(System.in);

        System.out.print("Guess #" + number + ": ");
        String guess = input.nextLine();
        input.close();

        return stringToChars(guess);
    }

    public static char[] stringToChars(String str){
        return str.toCharArray();
    }
}
