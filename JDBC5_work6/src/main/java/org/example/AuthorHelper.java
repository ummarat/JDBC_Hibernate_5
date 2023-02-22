package org.example;

import org.example.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

        /*Завдання 6 - Додавання 200 об'єктів
        з flush() через кожні 10 об'єктів*/
    public Author add200Author(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 1; i <= 200; i++){
            session.save(new Author("NewAuthor" + i));
            if(i % 10 == 0){
                session.flush();
            }
        }
        session.getTransaction().commit();
        session.close();
        return author;
    }

        /*Завдання 4 - Метод оновлення авторів за ID*/
    public Author updateAuthorById(long id, String name, String last_name) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        author.setName(name);
        author.setLastName(last_name);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
