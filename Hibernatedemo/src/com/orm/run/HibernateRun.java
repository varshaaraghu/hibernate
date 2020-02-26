package com.orm.run;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.orm.model.Person;
import com.orm.utils.SessionProvider;

public class HibernateRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=SessionProvider.getSessionFactory();
		Session session=sf.openSession();
		
		//Transaction t=session.beginTransaction();
		/*Person p=new Person(2,"B","mumbai");//still object not a part of hibernate
		session.saveOrUpdate(p);//A new object is added to hibernate session pi is a managed object
		Person p1 = new Person*/
		//t.commit();
		/*Query q=session.createQuery("from Person");
		List<Person> list =q.list();
		for(Person x:list)
			System.out.println(x.getName()+" "+x.getCity()+" "+ x.getSno());
		System.out.println("A new record is added");*/
		Criteria q=session.createCriteria(Person.class);
		//Criterion c = Restrictions.like("name", "A%");
		//q.add(c);
		Order o=Order.desc("name");
		q.addOrder(o);
		List<Person> list =q.list();
		for(Person x:list)
			System.out.println(x.getName()+" "+x.getCity()+" "+ x.getSno());
		
		

	}

}
