package com.java.last.project.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.AUTO) // id'nin nasıl arttığını belirtiriz
	@JsonIgnore
	private Long bookId;

	@Column(name = "bookName")
	@JsonIgnore
	private String bookName;
	@Column(name = "publicationYear")
	@JsonIgnore
	private Date publicationYear;
	@Column(name = "bookNote")
	@JsonIgnore
	private String bookNote;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "book_authors", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	@JsonIgnore
	private Set<Authors> authors = new HashSet<>();

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Set<Authors> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Authors> authors) {
		this.authors = authors;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Date publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getBookNote() {
		return bookNote;
	}

	public void setBookNote(String bookNote) {
		this.bookNote = bookNote;
	}

}
