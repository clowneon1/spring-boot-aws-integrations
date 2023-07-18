package com.clowneon1.aws.springbootrdssecretsmanager.repository;

import com.clowneon1.aws.springbootrdssecretsmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
