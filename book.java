public class book {
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private int publishYear;
	private int quantity;
	private double price;
	
	public book() {
		
	}
	
	public book(String isbn, String title, String author, String publisher, int publishYear, int quantity,
			double price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "isbn: " + isbn + ", Title: " + title + ", Author: " + author + ", Publisher: " + publisher
				+ ", PublishYear: " + publishYear + ", Quantity: " + quantity + ", Price: €" + price;
	}
	
	

}