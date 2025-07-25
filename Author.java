package com.example.bookstore.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Author 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String name;
	
	@OneToMany(mappedBy="author",cascade=CascadeType.ALL)
	private List<Book> book;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
