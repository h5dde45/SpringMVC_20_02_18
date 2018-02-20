package net.bookmanager.dao;

import net.bookmanager.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
        System.out.println("Book successfully saved. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
        System.out.println("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        if (book != null) {
            session.delete(book);
            System.out.println("Book successfully delete. Book details: " + book);
        }
    }

    @Override
    public Book getBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        System.out.println("Book successfully loaded. Book details: " + book);
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getListBooks() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> list = session.createQuery("from Book").list();
        for (Book book:list){
            System.out.println("Book successfully loaded. Book details: " + book);
        }
        return list;
    }
}
