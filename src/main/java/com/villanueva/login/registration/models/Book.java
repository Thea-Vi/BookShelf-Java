package com.villanueva.login.registration.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 30, message = "Title must be at least 3-30 characters")
	private String title;

	@NotNull
	@Size(min = 3, max = 30, message = "Author must be at least 3-30 characters")
	private String author;

	@NotNull
	@Size(min = 3, max = 30, message = "Thoughts must be at least 3-30 characters")
	private String thoughts;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

//	MANY TO ONE
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // foreign key name = the other class from one to many
	private User user; // from the User class

	public Book() {

	}

	// loaded constructor
	public Book(String title, String author, String thoughts) {

		this.title = title;
		this.author = author;
		this.thoughts = thoughts;
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

	public String getThoughts() {
		return thoughts;
	}

	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	GETTERS AND SETTERS

}
