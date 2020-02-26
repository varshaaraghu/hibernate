package com.orm.run;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.orm.model.Dept;
import com.orm.model.Emp;
import com.orm.model.Person;
import com.orm.utils.SessionProvider;

public class HibernateRun2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=SessionProvider.getSessionFactory();
		Session session=sf.openSession();
		Query q = session.createQuery("from Dept");
		List<Dept> list =q.list();
		for(Dept d :list) {
			System.out.println(d.getDno() + " "+d.getName());
			System.out.println("---------------------------------");
			for(Emp x:d.getEmployees())
				System.out.println(x.getName()+" "+x.getCity()+" "+x.getDesig());
		}
	/*	Transaction t=session.beginTransaction();
		Dept d = new Dept(2,"MARKETING");
		Emp e1 = new Emp(4,"A","Chennai","Manager");
		Emp e2 = new Emp(5,"B","Bangalore","TL");
		Emp e3 = new Emp(6,"C","Mumbai","PL");
		Emp e4 = new Emp(7,"D","Coimbatore","TM");
		e1.setDept(d);
		e2.setDept(d);
		e3.setDept(d);
		e4.setDept(d);
		
		Set<Emp> set = new HashSet<Emp>();
		
		set.add(e1);
		set.add(e2);
		set.add(e3);
		set.add(e4);
		
		d.setEmployees(set);//one to Many
		session.saveOrUpdate(d);
		t.commit();*/
		
	}

}
