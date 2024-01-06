package ObjectClass.ch9_10;

public class BasePlusCommissionEmployee extends CommissionEmployee {

	private double baseSalary; //月底薪
	
	public BasePlusCommissionEmployee(String _firstName, String _lastName, String _socialSecurityNumber,
			double _grossSalaes, double _commissionRate, double _baseSalary) {
		super(_firstName, _lastName, _socialSecurityNumber, _grossSalaes, _commissionRate);
		setBaseSalary(_baseSalary);
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double _baseSalary) {
		this.baseSalary = (_baseSalary > 0)? _baseSalary : 0;
	}

	
	@Override
	public double earnings() {
		return super.earnings() + getBaseSalary()*12; //把它當月底新
	}
	
	@Override
	public String toString() {
		/*return String.format("BasePlusCommissionEmployee : %s %s social security number : %s, " 
				+ "銷售額度:%,.0f, 抽傭比率:%,.2f, 底薪:%,.0f, 年薪:%,.0f",
				getLastName(), getFirstName() ,getSocialSecurityNumber(),
				getGrossSales(), getCommissionRate() ,getBaseSalary(), earnings());*/
		return String.format("BasePlusCommissionEmployee : %s %s social security number : %s, " 
				+ "銷售額度:%,.0f, 抽傭比率:%,.2f, 底薪:%,.0f, 年薪:%,.0f",
				getLastName(), getFirstName() ,getSocialSecurityNumber(),
				grossSales, commissionRate ,getBaseSalary(), earnings());
	}

	
}
