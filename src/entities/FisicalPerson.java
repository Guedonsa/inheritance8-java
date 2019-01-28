package entities;

public class FisicalPerson extends Person
{
	private Double healthSpending;
	
	public FisicalPerson()
	{
		super();
	}

	public FisicalPerson(String name, Double annualIncome, Double healthSpending)
	{
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

	public Double getHealthSpending()
	{
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending)
	{
		this.healthSpending = healthSpending;
	}
	
	public double tax()
	{
		double tax = 0.0;
		
		if(annualIncome >= 20000)
			tax = annualIncome * 0.25;
		else
			tax = annualIncome * 0.15;
		
		if(healthSpending > 0)
			tax = tax - (healthSpending * 0.50);
		
		return tax;
	}
	
	@Override
	public String toString()
	{
		return name + ": $ " + String.format("%.2f", tax());
	}
	
}
