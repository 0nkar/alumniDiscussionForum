package dac.forum.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dac.forum.pojos.Book;

@Transactional
@Repository
public class BookDao  {
	@Autowired
	private SessionFactory factory;
	private Session session;
	// open connection
	@PostConstruct
	public void open() throws Exception {
		session = factory.openSession();
	}
	// close connection
	@PreDestroy
	public void close() {
		if(session!=null)
			session.close();		
	}
	
	public Book findBook(int id) {
		Book b = (Book) session.get(Book.class, id);
		return b;
	}
	public List<Book> getBooks(String subject) {
		String hql = "from dac.shop.pojos.Book b where b.subject=:p_subject";
		Query q = session.createQuery(hql);
		q.setString("p_subject", subject);
		return q.list();
	}
	public List<String> getSubjects() {
		String sql = "SELECT DISTINCT SUBJECT FROM BOOKS";
		SQLQuery q = session.createSQLQuery(sql);
		return q.list();
	}
}
