package phanvanhuy.entity;


public class Book {
	private String bookId;
	private String title;
	private String author;
	private int release;
	private float price;
	private String picture;

    

	public Book() {
		super();
	}

	public Book(String bookId, String title, String author, int release, float price, String picture) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.release = release;
		this.price = price;
		this.picture = picture;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRelease() {
		return release;
	}

	public void setRelease(int release) {
		this.release = release;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
    
    	
    
    
}
