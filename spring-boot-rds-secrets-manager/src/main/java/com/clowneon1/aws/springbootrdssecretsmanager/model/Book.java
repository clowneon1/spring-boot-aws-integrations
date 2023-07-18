package com.clowneon1.aws.springbootrdssecretsmanager.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    double price;
    String name;
}
