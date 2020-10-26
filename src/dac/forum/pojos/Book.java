package dac.forum.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOKS")
public class Book {
	@Id
	@Column(name="BOOKID")
	private int id;
	private String name;
	private String author;
	private String subject;
	private float price;
	public Book() {
		this(0, "", "", "", 0.0f);
	}
	public Book(int id, String name, String author, String subject, float price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getNameAuthor() {
		return this.name + "(" + this.author + ")";
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", subject=" + subject + ", price=" + price + "]";
	}
}
