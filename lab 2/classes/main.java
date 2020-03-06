package eg.edu.alexu.csd.datastructure.hangman.csed;
import java.util.Scanner;
import java.io.Console;
public class main {

	public static void main(String[] args)throws Exception {
		Scanner input = new Scanner(System.in);
		hungman test= new hungman();
		test.readDictionary();
		test. setDictionary(test.words);
		test.secret_word= test.selectRandomSecretWord(); 
		System.out.print("enter the MaxWrongGuesses ");
		test.setMaxWrongGuesses(input.nextInt());
	while((!test.guessedWord.equals(test.secret_word))&&(test.WrongGuesses!=test.MaxWrongGuesses)) {
		Console myConsole = System.console();
		System.out.print("\nenter your guesse ");
		
		test.guess(input.next().charAt(0));
		
	}


}
	}