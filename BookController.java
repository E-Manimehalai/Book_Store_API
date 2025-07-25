package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable; // ✅ Correct import
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;

@RestController
@RequestMapping("/api/book")
public class BookController 
{
	private BookRepository bookrepo;
	
	@Autowired
	public BookController(BookRepository bookrepo)
	{
		this.bookrepo=bookrepo;
	}
	@GetMapping
	public Page<Book> getAll(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "5") int size,
	        @RequestParam(defaultValue = "id") String sortBy,
	        @RequestParam(defaultValue = "asc") String direction
	    ) {
	        Sort sort = direction.equalsIgnoreCase("desc")
                    ? Sort.by(sortBy).descending()
                    : Sort.by(sortBy).ascending();
                    
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookrepo.findAll(pageable);
	}
	@GetMapping("/{id}")
	public Book getById(@PathVariable Long id)
	{
		return bookrepo.findById(id).orElseThrow();
	}
	@PostMapping
	public Book create(@RequestBody Book b) 
	{
		return bookrepo.save(b);
	}
	@PutMapping("/{id}")
	public Book update(@PathVariable Long id,@RequestBody Book b)
	{
		b.setId(id);
		return bookrepo.save(b);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id)
	{
		bookrepo.deleteById(id);
	}
}
