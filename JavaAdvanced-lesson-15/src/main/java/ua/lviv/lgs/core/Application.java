package ua.lviv.lgs.core;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ua.lviv.lgs.util.HibernateAnnotationUtil;

public class Application {
	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;

		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();

		Post post1 = new Post();
		post1.setTitle("test title name 1");
		Post post2 = new Post();
		post2.setTitle("test title name 2");

		Comment comment1 = new Comment("author name 1", post1);
		Comment comment2 = new Comment("author name 2", post1);
		Comment comment3 = new Comment("author name 3", post1);
		Comment comment4 = new Comment("author name 4", post2);
		Comment comment5 = new Comment("author name 5", post2);

		Set<Comment> comm = new HashSet<>();
		comm.add(comment1);
		comm.add(comment2);
		comm.add(comment3);

		Set<Comment> comm2 = new HashSet<>();
		comm2.add(comment4);
		comm2.add(comment5);

		post1.setComments(comm);
		post2.setComments(comm2);

		/*
		 * session.save(post1); session.save(post2);
		 */

		transaction.commit();

		Post postDB = (Post) session.get(Post.class, 1);
		System.out.println(postDB + "-> " + postDB.getComments());
		
		Comment commentDB = (Comment) session.get(Comment.class, 4);
		System.out.println(commentDB + "-> " + commentDB.getPost());

		session.close();
	}
}