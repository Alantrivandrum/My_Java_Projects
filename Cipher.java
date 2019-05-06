/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 5.
        Comment: Yes, all of the variable names are meaningful and are in lowerCamelCase

 2. Did I indent the code appropriately?

        Mark out of 5: 5.
        Comment:  yes

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20.
        Comment: yes I think I wrote this function  correctly.

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20.
        Comment: This function takes in user input then returns cipher code.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20.
        Comment: This function takes in cipher language input and returns a string in English 

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25 : 25.
        Comment: Yes.I did so using a while loop

 7. How well did I complete this self-assessment?

        Mark out of 5: 5.
        Comment: I think I answered this self assessment well

 Total Mark out of 100 (Add all the previous marks): 100.

 */ 


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cipher {

	static char[] cipherArray = new char[27];
	static String alphabetString = "abcdefghijklmnopqrstuvwxyz ";
	static char[] charArray = alphabetString.toCharArray();


	public static void main(String args[]) {

		boolean quit = true;
		while(quit) {
			System.out.println("Please input the text you would like to have encrypted (or type 'exit' to stop the program) :");

			Scanner input = new Scanner(System.in);
			String userInput = input.nextLine();

			if(userInput.equalsIgnoreCase("exit"))
			{
				quit=false;
				System.out.println("Goodbye!");
				break;
			}

			createCipher();

			System.out.print("Encrypted Text: ");
			System.out.println(encrypt(userInput));

			System.out.print("Decrypted Text: ");
			System.out.println(decrypt(encrypt(userInput)));
		}
	}



	public static void createCipher() {


		Random  randomizeAlphabet = new Random();
		int alphabetNumber =0;
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();

		while (alphabetNumber < 27) {

			int randomAlphabetNumber = randomizeAlphabet.nextInt(27);
			if(!usedNumbers.contains(randomAlphabetNumber)) 
			{
				cipherArray[alphabetNumber] = charArray[randomAlphabetNumber];
				usedNumbers.add(randomAlphabetNumber);
				alphabetNumber++;
			}
		}
		System.out.print("Encryption Pattern: ");
		System.out.println(cipherArray);
	}

	public static char[] encrypt(String userInput) {


		char[] userInputArray = userInput.toCharArray();
		char[] encryptedArray = new char[userInput.length()];
		int a = 0;



		for(int c=0; c<userInput.length(); c++) {
			for(int b=0; b<27; b++) {
				if(charArray[b] == userInputArray[c]) 
				{
					encryptedArray[a] = cipherArray[b];
					a++;
				}
			}
		}


		return encryptedArray;
	}

	public static char[] decrypt(char[] encrytpedUserInputArray) {

		char[] decryptedArray = new char[encrytpedUserInputArray.length];
		int y = 0;

		for(int x=0; x<encrytpedUserInputArray.length; x++) {
			for(int i=0; i<27; i++) {
				if(cipherArray[i] == encrytpedUserInputArray[x])
				{
					decryptedArray[y] = charArray[i];
					y++;
				}
			}
		}

		return decryptedArray;

	}

}



