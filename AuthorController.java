package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepository;
import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController 
{
	private AuthorRepository authorrepo;
	
	@Autowired
	public AuthorController(AuthorRepository authorrepo)
	{
		this.authorrepo=authorrepo;
	}
	
	@GetMapping
	public List<Author> getAll()
	{
		return authorrepo.findAll();
	}
	@GetMapping("/{id}")
	public Author getById(@PathVariable Long id)
	{
		return authorrepo.findById(id).orElseThrow();
	}
	@PostMapping
	public Author create(@RequestBody Author a)
	{
		return authorrepo.save(a);
	}
	@PutMapping("/{id}")
	public Author update(@PathVariable Long id,@RequestBody Author a)
	{
		a.setId(id);
		return authorrepo.save(a);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		authorrepo.deleteById(id);
	}
}
