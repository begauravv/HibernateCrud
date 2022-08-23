package com.hexaware.crudwithhibernate.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hexaware.crudwithhibernate.entity.Vegetable;
import com.hexaware.crudwithhibernate.service.VegetableService;
import com.hexaware.crudwithhibernate.util.HibernateUtil;




public class VegetableDao {

	
	public void vegetableSave(Vegetable veg) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the vegetable object in to database
			session.save(veg);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void getAllVegetables() {
		
				try (Session session = HibernateUtil.getSessionFactory().openSession()) {

					List<Vegetable> vegetableList = session.createQuery("from vegetable", Vegetable.class).list();
					vegetableList.forEach(stud -> System.out.println(stud));

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
	}
	public void deleteVegetable1(Long vegid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction1 = session1.beginTransaction();
			Vegetable deleteVeg = session1.get(Vegetable.class, vegid);
			System.out.println(deleteVeg);
			if(deleteVeg!=null) {
				session1.delete(deleteVeg);
				System.out.println("Vegetable deleted successfully");
			}
			
			
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}
	public void deleteVegetable(Class<?> type,Serializable vegid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Vegetable veg = session1.get(Vegetable.class, vegid);
			System.out.println(veg);
			if(veg!=null) {
				session1.remove(veg);
				System.out.println("Vegetable deleted successfully");
			}
			
			
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateVegetable(Long vegid, Long price) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Vegetable updatingVeg = session.get(Vegetable.class, vegid);
			System.out.println(updatingVeg);
			//do changes
			updatingVeg.setVegPrice(price);
			//update the Employee object
			session.saveOrUpdate(updatingVeg);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void getVegetableById(Long vegid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			
			
			//get entity from database
			Vegetable vegById = session.get(Vegetable.class, vegid);
			if(vegById!=null) {
				
				System.out.println("Vegetable details are = " + vegById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void deleteByName(String vegName) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			
			Query<Vegetable> deleteQuery = session1.createQuery
					("delete from Vegetable where vegName = :vegName");
			deleteQuery.setParameter("vegName",vegName);
			int deleteStatus = deleteQuery.executeUpdate();
			System.out.println(deleteStatus);
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public void getVegetableByName(String vegName) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			// start the transaction
			transaction1 = session1.beginTransaction();
			//Hibernate Named Query Example
			TypedQuery<Vegetable> vegNamedquery = session1.getNamedQuery("searchVegetableByName");
			vegNamedquery.setParameter("name", vegName);
			List<Vegetable> vegetableWithName = vegNamedquery.getResultList();
			
			Iterator<Vegetable> vegItr = vegetableWithName.iterator();
			while(vegItr.hasNext()) {
				Vegetable veg = vegItr.next();
				System.out.println(veg);
			}
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		
	}
	
}
