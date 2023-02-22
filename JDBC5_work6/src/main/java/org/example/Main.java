package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.jboss.logging.Logger;

public class Main {

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        Author author = new Author();

//        ah.add200Author(author);
//        ah.updateAuthorById(6, "Pavlo", "Tychyna");

        BookHelper bh = new BookHelper();
        Book book = new Book();

//        bh.updateBookById(6, "Viter z Ukraiiny");
//        bh.getAutorAndBookById(6);
    }
}
