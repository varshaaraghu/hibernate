package com.orm.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
    @Id 
	public  Integer dno;
    @Column
    public String name;
    @OneToMany(mappedBy ="dept",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Emp> employees;
    
    public Dept() {}

	public Dept(Integer dno, String name) {
		super();
		this.dno = dno;
		this.name = name;
	}

	public Integer getDno() {
		return dno;
	}

	public void setDno(Integer dno) {
		this.dno = dno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Set<Emp> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Emp> employees) {
		this.employees = employees;
	}
	
}
