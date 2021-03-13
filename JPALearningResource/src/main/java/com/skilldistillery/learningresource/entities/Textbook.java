package com.skilldistillery.learningresource.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Textbook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String author;
	
	private String title;

	private String subtitle;
	
	private Integer edition;
	
	private Integer year;
	
	private Integer length;
	
	public Textbook() {
		super();
	}

	public Textbook(String author, String title, String subtitle, Integer edition, Integer year,
			Integer length) {
		super();
		this.author = author;
		this.title = title;
		this.subtitle = subtitle;
		this.edition = edition;
		this.year = year;
		this.length = length;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

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

	@Override
	public String toString() {
		return "Textbook [id=" + id + ", author=" + author + ", title=" + title + "]";
	}

	
	

}
