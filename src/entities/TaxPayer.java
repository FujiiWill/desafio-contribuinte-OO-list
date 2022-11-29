package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	public TaxPayer() {
		
	}
	
	public TaxPayer(Double salaryIncome, Double serviceIncome, Double capitalIncome,
			Double healthSpending,Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = serviceIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServiceIncome() {
		return servicesIncome;
	}

	public void setServiceIncome(Double serviceIncome) {
		this.servicesIncome = serviceIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}

	public Double salaryTax() {
		if(salaryIncome < 36000.00) {
			return 0.00;
		}
		else if(salaryIncome < 50000.00) {
			return salaryIncome * 0.10;
		}
		else {
			return salaryIncome * 0.20;
		}
	}
	
	public Double servicesTax() {
		return servicesIncome * 0.15;
	}
	
	public Double capitalTax() {
		return capitalIncome * 0.20;
	}
	
	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public Double taxRebate() {
		double grossRebate = healthSpending + educationSpending;
		double maxRebate = grossTax() * 0.30;
		
		if(grossRebate <= maxRebate) {
			return grossRebate;
		}
		else {
			return maxRebate;
		}
	}
	
	public Double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return 	"Imposto bruto total: " + String.format("%.2f", grossTax()) + "\n"
				+ "Abatimento: " + String.format("%.2f", taxRebate()) + "\n"
				+ "Imposto devido: " + String.format("%.2f", netTax()) + "\n";
	}
	
}
