package com.hexaware.crudwithhibernate.service;
import java.util.Scanner;

import com.hexaware.crudwithhibernate.dao.VegetableDao;
import com.hexaware.crudwithhibernate.entity.Vegetable;

public class VegetableService {
	static Scanner sc = new Scanner(System.in);
	VegetableDao vegdao = new VegetableDao();

	public void vegetableSave() {
		Vegetable veg = new Vegetable();
		System.out.println("Enter the details of the Vegetable");
		
		System.out.println("Enter the Vegetable name....");
		veg.setVegName(sc.nextLine());
		System.out.println("Enter the vegetable price....");
		veg.setVegPrice(sc.nextLong());
		
		
	}

	public void getAllVegetable() {
		
		vegdao.getAllVegetables();
	}
	
	public void deleteVegetable() {

		System.out.println("Enter the vegetable id to delete....");
		Long vegid = sc.nextLong();
		vegdao.deleteVegetable(Vegetable.class,new Long(vegid));
	}

	public void updateEmployee() {
		Vegetable veg = new Vegetable();
		System.out.println("Enter the details of the vegetable");
		//sc.nextLine()
		System.out.println("Enter the Vegetable name....");
		veg.setVegName(sc.nextLine());
		System.out.println("Enter the vegetable price....");
		veg.setVegPrice(sc.nextLong());
		
		
	}
	
	public  void getDetailsToUpdate() {
		System.out.println("Enter the vegetable id....");
		Long vegid = sc.nextLong();
		System.out.println("Enter the price");
		Long price = sc.nextLong();
		
		vegdao.updateVegetable(vegid,price);
	}

	public void getVegetableById() {
		System.out.println("Enter the vegetable id....");
		Long empid = sc.nextLong();
		vegdao.getVegetableById(empid);
	}

	public void deleteVegetable1() {
		System.out.println("Enter the vegetable id....");
		Long vegid = sc.nextLong();
		vegdao.deleteVegetable1(vegid);
		
	}

	public void deleteByName() {
		System.out.println("Enter the Vegetable name....");
		String vegName=sc.nextLine();
		vegdao.deleteByName(vegName);
	}

	public void getVegetableByName() {
		System.out.println("Enter the Vegetable name....");
		String vegName=sc.nextLine();
		vegdao.getVegetableByName(vegName);
		
	}

	}