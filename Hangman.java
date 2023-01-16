import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class Hangman {
   
    
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};
    public static  String randomWord = getRandom(words);
    public static char[] wordToGuess = randomWord.toCharArray();
    public static char[] placeHolder;
    Scanner scan = new Scanner(System.in);
    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int misses = 0;
         placeHolder = new char[wordToGuess.length];
        for (int i = 0; i < placeHolder.length; i++) {
            placeHolder[i] = '_';
        }
        char[] missedGuesses = new char[6];
        while(misses<6){
            System.out.println(gallows[misses]);

            System.out.print("Word:   ");
            printPlaceHolders(placeHolder);
            System.out.println();
            System.out.print("\n");

            System.out.print("Misses:   ");
            printMissedGuesses(missedGuesses);
            System.out.print("\n\n");

            System.out.print("Guess:   ");
            char guess = scan.next().charAt(0);
            System.out.print("\n");
            if(!checkGuess(randomWord, guess)){
                missedGuesses[misses] = guess;
                misses++;
            }
            else{
                System.out.println(placeHolder);
            }
            if (Arrays.equals(placeHolder, randomWord.toCharArray())) {
                System.out.print(gallows[misses]);
                System.out.print("\nWord:   ");
                printPlaceHolders(placeHolder);
                System.out.println("\nCongratulations! You Won!");                
                break;
            }
        }

        if (misses == 6) {
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + randomWord + "'");
        }
        scan.close();
    }

    // this function will get a random word from the wordbank string.
    public static String getRandom(String[] words){
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
    
    public static void printPlaceHolders(char [] placeHolder){
     for(int i=0; i<wordToGuess.length; i++){
        System.out.print(placeHolder[i]);
        System.out.print(" ");
     }
 }
  
    public static boolean checkGuess(String wordToGuess, char guess){
        boolean foundLetter = false;
      for(int i=0; i<placeHolder.length; i++){
        if(wordToGuess.charAt(i)==guess){
            placeHolder[i] = guess;
            foundLetter = true;
        }
      }
      return foundLetter;
    }
    
    
          
            
            
            
        
          
        
    public static void printMissedGuesses(char[] misses){
        for(int i=0; i<misses.length; i++){
            System.out.print(misses[i]);
        }
    } 
                
  
}





