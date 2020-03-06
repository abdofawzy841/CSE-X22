package eg.edu.alexu.csd.datastructure.hangman.csed;
import java.util.ArrayList;
import java.io.*;
import java.util.Random; 


public class hungman implements IHangman {
 public String[] words;
 public ArrayList<String>list=new ArrayList<String>(); 
 public String secret_word;
 public String guessedWord;
 public int MaxWrongGuesses;
 public int WrongGuesses=0;
 public Boolean h;
 public String chars="";
 
 
 public  String selectRandomSecretWord() {
	 
		Random rand=new Random();  
		secret_word=words[rand.nextInt(list.size())];
		secret_word=secret_word.toLowerCase();
		guessedWord=secret_word;
		for (int i=0;i<secret_word.length();i++) {
			guessedWord=guessedWord.replace(guessedWord.charAt(i), '-');
			}
		return secret_word;
		 
	 }
	 
 public void setDictionary(String[] words)
 {
	 
   
    for (int i=0;i< list.size();i++) {
     words[i]=list.get(i);
        }
   
 }
 
 public void readDictionary() {
	
	 try{ 
	 FileInputStream fstream = new FileInputStream("C:\\Users\\USER\\Desktop\\hangman\\bin\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\csed\\Dictionary.text");
	 DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  while ((strLine = br.readLine()) != null)   {
		 
		list.add(strLine);
		  }
		  //Close the input stream
		  in.close();
		    }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		  }
	 words =new String[list.size()];
	
	 
 }

 
 
 
  public String guess(Character c)throws Exception {
     h=false;	
	  if(!secret_word.matches("^[a-zA-Z]*$")){
		throw new Exception ("Buggy Secret Word");
	}
	
	if(!(c.toString()).matches("^[a-zA-Z]")) {
		System.out.print("please enter a character from a to z ");
	return null;
	}
	
	c=Character.toLowerCase(c);
	
	 
  if (chars.contains(c.toString()) ) {
		System.out.print("you intered this character befor, Enter anther one ");
		return null;
  }
  chars=chars+c;
	if(WrongGuesses!= MaxWrongGuesses && guessedWord!=secret_word) {
	 
	          for(int i=0;i<secret_word.length();i++) {
	                  
	        	  if(c==(secret_word.charAt(i))) {
	        		  guessedWord=guessedWord.substring(0,i)+c+guessedWord.substring(i+1);
		                  h=true;
		                 
	        	     }
	        	  }
	          if(h) { System.out.printf(" well doen \n %s \n remaining gusses= %d" , guessedWord  ,(MaxWrongGuesses - WrongGuesses));}
	        	  if(!h) {
	        		  WrongGuesses++;
	        		  System.out.printf(" wrong guesse\n %s \n remaining gusses= %d" , guessedWord  , (MaxWrongGuesses - WrongGuesses));
	        		 
	        	  }
	        	     }
	
if (guessedWord.equals(secret_word)){
	 System.out.print("\nyou hve won\n " + secret_word);
	 return null;
       }
if (WrongGuesses==MaxWrongGuesses) {
	 System.out.print("\nyou hve lost \n the word is " +secret_word);
}

	return guessedWord;
  }
		
	
	     
		
	 
 public void setMaxWrongGuesses(Integer max) {
	 if (max != null && max>0)	
		MaxWrongGuesses = max;
		else 
			MaxWrongGuesses=1;
	 
 
	
	 
	 
 }
}
 
 
 
 
 
 
 
 
