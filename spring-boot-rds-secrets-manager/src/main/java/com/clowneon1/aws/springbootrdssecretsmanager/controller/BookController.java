package com.clowneon1.aws.springbootrdssecretsmanager.controller;

import com.clowneon1.aws.springbootrdssecretsmanager.model.Book;
import com.clowneon1.aws.springbootrdssecretsmanager.repository.BookRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    final BookRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getALlBooks(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id){
        Optional<Book> book = repository.findById(id);
        return book.orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book){
        return repository.save(book);
    }
}
