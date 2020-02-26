package com.orm.run;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.orm.model.Contact;
import com.orm.model.Dept;
import com.orm.model.Emp;
import com.orm.model.Person;
import com.orm.utils.SessionProvider;

public class HibernateRun3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=SessionProvider.getSessionFactory();
		Session session=sf.openSession();
		
	    Transaction t=session.beginTransaction();
		Dept d = new Dept(1,"MARKETING");
		Emp e1 = new Emp(1,"A","Chennai","Manager");
		Emp e2 = new Emp(2,"B","Bangalore","TL");
		Emp e3 = new Emp(3,"C","Mumbai","PL");
		Emp e4 = new Emp(4,"D","Coimbatore","TM");
		
		Contact c1=new Contact(1,"12/2","Gandhi Road","123456789");
		Contact c2=new Contact(2,"12/2","a Road","645257777");
		Contact c3=new Contact(3,"12/2","b Road","123456789");
		Contact c4=new Contact(4,"12/2","c Road","123456789");
		e1.setDept(d);
		e2.setDept(d);
		e3.setDept(d);
		e4.setDept(d);
		e1.setContact(c1);
		e2.setContact(c2);
		e3.setContact(c3);
		e4.setContact(c4);
		
		Set<Emp> set = new HashSet<Emp>();
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
	
		
		d.setEmployees(set);//one to Many
		session.saveOrUpdate(d);
		t.commit();
		
	}

}
