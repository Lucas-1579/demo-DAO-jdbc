package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
			
		System.out.println("=== TEST 1: department findById ====");
		Department department = depDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ====");
		List<Department> list = depDao.findAll();
		list.forEach(x -> System.out.println(x));
		
		System.out.println("\n=== TEST 3: department insert ====");
		Department newDep = new Department(null, "Music");
		depDao.insert(newDep);
		System.out.println("Inserted! new id = " + newDep.getId());
		
		
		System.out.println("\n=== TEST 4: department update ====");
		department = depDao.findById(1);
		department.setName("Marketing");
		depDao.update(department);
		System.out.println("Update Complete!");
		
		System.out.println("\n=== TEST 5: department delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete complete!");
		
		sc.close();
		
	}

}
