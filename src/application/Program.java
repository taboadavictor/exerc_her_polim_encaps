package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Locale.setDefault(Locale.US);
		
		List <Employee> list = new ArrayList<>();
		
		System.out.println("Enter the number of employess:");
		int hiringEmployees = sc.nextInt();
		
		for (int i = 1; i <= hiringEmployees; i++ ) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char verifyEmployee = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if (verifyEmployee == 'y') {
				System.out.print("Additional charge: ");
				double addCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, addCharge));
				
			} else {
				list.add(new Employee (name, hours, valuePerHour));
			}
			
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS: ");
		
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		sc.close();
	}
}
