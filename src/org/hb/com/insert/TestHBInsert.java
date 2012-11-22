package org.hb.com.insert;

import java.util.Date;

import org.hb.com.base.ModelType;
import org.hb.com.entiy.Model;
import org.hb.com.entiy.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHBInsert {

	private Configuration configuration = null;
	private SessionFactory  sf = null;
	private  Session session  = null;
	
	
	public TestHBInsert(){
		configuration = new Configuration().configure("hibernate.cfg.xml");   
		sf = configuration.buildSessionFactory();
		session = sf.openSession();
	}
	
	/**
	 * Ã¶¾Ùinsert
	 */
	public void insertEnum(){
		Model m = new Model();
		m.setDate(new Date());
		m.setName("yamato");
		m.setType(ModelType.SHIP);
		session.beginTransaction().begin();
		session.save(m);
		session.beginTransaction().commit();
	}
	
	
	public void insert(){
		Student s = new Student();
		s.setAge(1);
		s.setKeyNumber("jj88");
		s.setName("lucene");
//		session.beginTransaction().begin();
		session.save(s);
		//SaveOrUpdateEventListenerImpl
		//s.setName(ModelType.SHIP.toString());
//		session.update(s);
//		session.flush();
		System.out.println(s.getId());
		session.beginTransaction().commit();
		System.out.println("ok");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestHBInsert t = new TestHBInsert();
		t.insert();

	}

}
