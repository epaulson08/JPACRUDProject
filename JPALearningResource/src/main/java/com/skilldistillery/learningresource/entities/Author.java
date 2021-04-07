package com.skilldistillery.learningresource.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	private String suffix;

	@ManyToMany
	@JoinTable(name = "author_textbook", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "textbook_id"))
	private List<Textbook> textbooks;

//////// ctors:
	public Author() {
		super();
	}

	public Author(String firstName, String middleName, String lastName, String suffix) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
	}

	public Author(String firstName, String middleName, String lastName, String suffix, List<Textbook> textbooks) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.textbooks = textbooks;
	}

//////// get/set:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public List<Textbook> getTextbooks() {
		return textbooks;
	}
	
	public void setTextbooks(List<Textbook> textbooks) {
		this.textbooks = textbooks;
	}
	
// add/remove:
	public void addTextbook(Textbook textbook) {
		if (textbooks == null)
			textbooks = new ArrayList<>();

		if (!textbooks.contains(textbook)) {
			textbooks.add(textbook);
			textbook.addAuthor(this);
		}
	}

	public void removeTextbook(Textbook textbook) {
		if (textbooks != null && textbooks.contains(textbook)) {
			textbooks.remove(textbook);
			textbook.removeAuthor(this);
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
		Author other = (Author) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", suffix=" + suffix + "]";
	}

}
