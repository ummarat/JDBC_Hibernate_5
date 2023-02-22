package org.example;

import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BookHelper {
    private SessionFactory sessionFactory;
    public BookHelper(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    /*Завдання 4 - Метод оновлення назв книг за ID*/
    public Book updateBookById(long id, String name) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        book.setName(name);
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    /*Завдання 5 - Метод отримання назви книги та автора*/
    public void getAutorAndBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        Author author = session.get(Author.class, id);
        session.close();
        System.out.println(author.getName() + " " + author.getLastName() + " " + book.getName());
    }

   public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = (Book) session.get(Book.class, id); // получение объекта по id
        return book;
    }

    public Book addBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }
}
