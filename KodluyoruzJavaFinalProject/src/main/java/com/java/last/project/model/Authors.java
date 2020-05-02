package com.java.last.project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Authors")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Authors {

	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // id'nin nasıl arttığını belirtiriz
	private int authorID;

	@Column(name = "authorName")
	private String authorName;

	@Column(name = "authorSurname")
	private String authorSurname;

	@OneToMany(mappedBy = "authors", cascade = CascadeType.ALL)
	private Set<Book> book;

	public Set<Book> getBook() {
		return book;
	}

	public void setBook(Set<Book> book) {
		this.book = book;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}
}
