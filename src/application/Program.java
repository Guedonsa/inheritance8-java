package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.FisicalPerson;
import entities.LegalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Person> persons = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int taxPayers = sc.nextInt();
		
		for(int i = 1; i <= taxPayers; i++)
		{
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char option = sc.next().charAt(0);
			
			while(option != 'i' && option != 'c')
			{
				System.out.print("Individual or company (i/c)? ");
				option = sc.next().charAt(0);
			}
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();
			
			if(option == 'i')
			{
				System.out.print("Health expenditures: ");
				double healthSpending = sc.nextDouble();
				persons.add(new FisicalPerson(name, annualIncome, healthSpending));
			}
			else
			{
				System.out.print("Number of employees: ");
				int employeesNumber = sc.nextInt();
				persons.add(new LegalPerson(name, annualIncome, employeesNumber));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		double total = 0.0;
		for(Person p : persons)
		{
			System.out.println(p);
			total = total + p.tax();
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + String.format("%.2f", total));
		
		sc.close();
	}

}