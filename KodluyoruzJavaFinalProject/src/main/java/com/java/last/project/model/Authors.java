package com.java.last.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Authors {

	@Id
	@Column(name = "author_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // id'nin nasıl arttığını belirtiriz
	private int authorID;

	@Column(name = "authorName")
	private String authorName;

	@Column(name = "authorSurname")
	private String authorSurname;

	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	            mappedBy = "authors")
	    private Set<Book> book = new HashSet<>();

	public Set<Book> getBooks() {
		return book;
	}

	public void setBooks(Set<Book> books) {
		this.book = books;
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
