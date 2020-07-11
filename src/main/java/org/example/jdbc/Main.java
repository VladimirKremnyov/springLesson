package org.example.jdbc;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BooksRepository repository = new BooksRepository();
        List<BookEntity> allBooks = repository.findAll();
        System.out.println(allBooks);
    }

}
