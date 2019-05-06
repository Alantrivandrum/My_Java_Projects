import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class onlineBookStore {
	public static int ISBN_INDEX = 0;
	public static int TITLE_INDEX = 1;
	public static int AUTHOR_INDEX = 2;
	public static int PUBLISHER_INDEX = 3;
	public static int PUBLISHER_YEAR_INDEX = 4;
	public static int QUANTITY_INDEX = 5;
	public static int PRICE_INDEX = 6;

	public static void main(String[] args) {
		ArrayList<book> bookList = new ArrayList<book>();
		try {
			FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
			BufferedReader bufferedReader = new BufferedReader(fileReader);  
			boolean endOfFile = false;
			while(!endOfFile){
				String bookLine = bufferedReader.readLine();
				if (bookLine != null) {
					String[] bookData = bookLine.split(", ");
					String isbn = bookData[ISBN_INDEX];
					String title = bookData[TITLE_INDEX];
					String author = bookData[AUTHOR_INDEX];
					String publisher = bookData[PUBLISHER_INDEX];
					int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
					int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
					double price = Double.parseDouble (bookData[PRICE_INDEX]);
					book book = new book(isbn, title, author, publisher, publishYear, quantity, price);
					bookList.add(book);

				} else {
					endOfFile = true;
				}
			}

			bufferedReader.close();    
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		printBookDetails(bookList);
		purchaseBook(bookList);
	}

	public static void printBookDetails(ArrayList <book> bookList)
	{
		for (int i = 0; i < bookList.size(); i++)
		{
			book aBook = bookList.get(i);
			System.out.print(aBook);

		}
	}

	public static book getBook (ArrayList <book> bookList, String title)
	{
		for (int i = 0; i < bookList.size(); i++)
		{
			book aBook = bookList.get(i);
			if(title == aBook.getTitle())
			{
				return aBook;
			}
		}
		return null;
	}

	public static void topUpCard (chargeCard card, double amount)
	{
		card.setFunds(amount);
	}

	public static void purchaseBook (ArrayList <book> bookList)
	{

		Scanner inputScanner = new Scanner (System.in);
		System.out.print("Enter the amount of money you have on you.");
		double amount = inputScanner.nextDouble();
		chargeCard card = new chargeCard();
		topUpCard(card, amount);
		boolean finished = false;
		boolean incorrectTitle = false;
		do {
			System.out.print("Enter the book title you wish to purchase? (or enter quit)");
			if (inputScanner.hasNext("quit"))
				finished = true;
			else
			{	
				String enteredBook = inputScanner.next();
				book aBook = getBook(bookList, enteredBook);
				if (aBook == null)
				{
					System.out.print("Thats an incorrect title. Try again.");
				}
				else
				{
					if (aBook.getQuantity() <= 0)
					{
						System.out.print("Sorry that book is out of stock.");
						
					}
					
					else
					{
						if (card.getFunds() < aBook.getPrice())
						{
							System.out.print("You don't have enough money to purchase that book.");
						}
						else
						{
							//aBook.quantity() = aBook.getQuantity() - 1;
							card.removeFunds(aBook.getPrice());

						}
					}
				}		
			}
			System.out.print("Enter the amount of money you wish to deposit (if none, enter 0)");
			card.topUpFunds(inputScanner.nextInt());
		} while (!false);
		//inputScanner.close();
	}
}

