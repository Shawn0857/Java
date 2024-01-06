package ObjectClass.ch9_10_2;

import java.io.Serializable;

public class BasePlusCommissionEmployee extends CommissionEmployee implements Serializable{
	private double baseSalary;// 月底薪

	public BasePlusCommissionEmployee(String _firstName, String _lastName, String _socialSecurityNumber,
			double _grossSales, double _commissionRate, double _baseSalary) {
		super(_firstName, _lastName, _socialSecurityNumber, _grossSales, _commissionRate);
		setBaseSalary(_baseSalary);
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double _baseSalary) {
		this.baseSalary = (_baseSalary > 0) ? _baseSalary : 0;
	}

	@Override
	public double earnings() {
		return super.earnings() + getBaseSalary() * 12;
	}

	@Override
	public String toString() {
//		return String.format(
//				"BasePlusCommissionEmployee : %s %s social securitynumber:%s," + "銷售金額:%,.0f,抽傭比例:%,.2f,年薪:%,.0f",
//				getLastName(), getFirstName(), getSocialSecurityNumber(), getGrossSales(), getCommissionRate(),
//				getBaseSalary(), earnings());
		return String.format(
				"BasePlusCommissionEmployee : %s %s social securitynumber:%s," + "銷售金額:%,.0f,抽傭比例:%,.2f,年薪:%,.0f",
				getLastName(), getFirstName(), getSocialSecurityNumber(), grossSales, commissionRate,
				getBaseSalary(), earnings());
	}
}
