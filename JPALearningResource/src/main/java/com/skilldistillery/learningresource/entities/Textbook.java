package com.skilldistillery.learningresource.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Textbook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	DEPRECATED:
//	private String author = "  ";

	@ManyToMany(mappedBy = "textbooks")
	private List<Author> authors;

	private String title;

	private String subtitle;

	private Integer edition;

	private Integer year;

	private Integer length;
	
//////// ctors:
	public Textbook() {
		super();
	}

	public Textbook(List<Author> authors, String title, String subtitle, Integer edition, Integer year,
			Integer length) {
		super();
		this.authors = authors;
		this.title = title;
		this.subtitle = subtitle;
		this.edition = edition;
		this.year = year;
		this.length = length;
	}
	
	public Textbook(String title, String subtitle, Integer edition, Integer year, Integer length) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.edition = edition;
		this.year = year;
		this.length = length;
	}

//	Deprecated when `author` changed to `authors`:
//	public Textbook(String author, String title, String subtitle, Integer edition, Integer year, Integer length) {
//		super();
//		this.author = author;
//		this.title = title;
//		this.subtitle = subtitle;
//		this.edition = edition;
//		this.year = year;
//		this.length = length;
//	}

//////// get/set:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	Deprecated:
//	public String getAuthor() {
//		return author;
//	}

//	public void setAuthor(String author) {
//		this.author = author;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
//////// add/remove:
	public void addAuthor(Author author) {
		if (authors == null)
			authors = new ArrayList<>();

		if (!authors.contains(author)) {
			authors.add(author);
			author.addTextbook(this);
		}
	}

	public void removeAuthor(Author author) {
		if (authors != null && authors.contains(author)) {
			authors.remove(author);
			author.removeTextbook(this);
		}
	}
	
//////// hash, equals, toString:
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Textbook other = (Textbook) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Textbook [id=" + id + ", title=" + title + ", subtitle=" + subtitle + ", edition=" + edition + ", year="
				+ year + ", length=" + length + "]";
	}

}
