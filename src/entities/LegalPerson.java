package entities;

public class LegalPerson extends Person
{
	private Integer employeesNumber;
	
	public LegalPerson()
	{
		super();
	}
	
	public LegalPerson(String name, Double annualIncome, Integer employeesNumber)
	{
		super(name, annualIncome);
		this.employeesNumber = employeesNumber;
	}
	
	public Integer getEmployeesNumber()
	{
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber)
	{
		this.employeesNumber = employeesNumber;
	}

	public double tax()
	{
		double tax = 0.0;
		
		if(employeesNumber > 10)
			tax = annualIncome * 0.14;
		else
			tax = annualIncome * 0.16;
		
		return tax;
	}

	@Override
	public String toString()
	{
		return name + ": $ " + String.format("%.2f", tax());
	}
	
}
