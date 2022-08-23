package com.hexaware.crudwithhibernate;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hexaware.crudwithhibernate.service.VegetableService;
//import com.mouritech.crudwithhibernate.util.HibernateUtil;

public class VegetableCrud {

	//private static final Logger logger = LogManager.getLogger(EmployeeCRUDExample.class); 
	public static void main(String[] args) {
		char ch = 'y';
		String transaction = null;
		Scanner sc = new Scanner(System.in);
		VegetableService vegService = new VegetableService();
		while(ch == 'y') {
			System.out.println("Enter the transaction type");
			System.out.println("save : to insert a new Vegetable");
			System.out.println("update : to update a Vegetable");
			System.out.println("delete : to delete a  Vegetable");
			System.out.println("delete1 : to delete a Vegetable");
			System.out.println("getall : to get all  Vegetable details");
			System.out.println("get : to get a Vegetable detail");
			System.out.println("deletebyname : to delete a Vegetable by name");
			System.out.println("searchempbyname : to search a Vegetable using name");
			transaction = sc.next();
			switch (transaction) {
			case "save":
				vegService.vegetableSave();
				break;
			case "getall":
				vegService.getAllVegetable();
				break;
			case "delete":
				vegService.deleteVegetable();
				break;
			case "deletebyname":
				vegService.deleteByName();
				break;
				
			case "delete1":
				vegService.deleteVegetable1();
				break;
			case "update":
				vegService.getDetailsToUpdate();
				break;
			case "get":
				vegService.getVegetableById();
				break;
			case "searchempbyname":
				vegService.getVegetableByName();
				break;
				default:
				System.out.println("Not a valid transaction");
				break;
			}
			System.out.println("Do you want to continue (y-yes/n-no)");
			ch = sc.next().charAt(0);
		}

		sc.close();
	}

}