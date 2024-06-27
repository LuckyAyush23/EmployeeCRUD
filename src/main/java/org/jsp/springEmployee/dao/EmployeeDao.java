package org.jsp.springEmployee.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import org.jsp.springEmployee.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
	@Autowired
	private EntityManager entityManager;
	
	public Employee saveEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();
		entityManager.persist(employee);
		transaction.begin();
		transaction.commit();
		return employee;
	}
	
	public Employee updateEmp(Employee emp)
	{
		EntityTransaction transaction = entityManager.getTransaction();
		Employee dbemp = entityManager.find(Employee.class, emp.getId());
		if(dbemp!=null)
		{
			dbemp.setId(emp.getId());
			dbemp.setName(emp.getName());
			dbemp.setGender(emp.getGender());
			dbemp.setDesg(emp.getDesg());
			dbemp.setSalary(emp.getSalary());
			dbemp.setPhone(emp.getPhone());
			dbemp.setEmail(emp.getEmail());
			dbemp.setPassword(emp.getPassword());
			transaction.begin();
			transaction.commit();
			return dbemp;
		}else {
			return null;
		}
	}
	public Employee findById(int id) {
		Employee dbemp = entityManager.find(Employee.class, id);
		if(dbemp!=null) {
			return dbemp;
		}else {
			return null;
		}
	}
	
	public Employee verify (long phone,String password) {
		try {
			return (Employee)entityManager.createQuery("select e from Employee e where e.phone=?1 and e.password=?2").
					setParameter(1,phone).setParameter(2, password).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Employee verify (String email,String password) {
		try {
			return (Employee)entityManager.createQuery("select e from Employee e where e.email=?1 and e.password=?2").
					setParameter(1,email).setParameter(2, password).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Employee verify (int id,String password) {
		try {
			return (Employee)entityManager.createQuery("select e from Employee e where e.id=?1 and e.password=?2").
					setParameter(1,id).setParameter(2, password).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public boolean deleteById(int id) {
		EntityTransaction transaction = entityManager.getTransaction();
		Employee employee = findById(id);
		if(employee!=null) {
			entityManager.remove(employee);
			transaction.begin();
			transaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
}
