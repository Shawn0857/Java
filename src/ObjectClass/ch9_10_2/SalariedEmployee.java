package ObjectClass.ch9_10_2;

import java.io.Serializable;

public class SalariedEmployee extends Employee implements Serializable{
	private double salary;
	private double payMonthPerYear;

	public SalariedEmployee(String _firstName, String _lastName
			, String _socialSecurityNumber , double _payMonthPerYear,double _salary) {
		super(_firstName, _lastName, _socialSecurityNumber);
		setSalary(_salary);
		setPayMonthPerYear(_payMonthPerYear);
	}
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double _salary) {
		this.salary = (_salary > 0)? _salary :0;
	}
		
	public double getPayMonthPerYear() {
		return payMonthPerYear;
	}
	
	public void setPayMonthPerYear(double _payMonthPerYear) {
		this.payMonthPerYear = (_payMonthPerYear>０)? _payMonthPerYear : ０;
	}
	
	public String toString() {
		return String.format("SalariedEmployee : %s,月薪:%,.0f,年薪:%,.0f",super.toString(),
				getSalary(),earnings());
	}
	@Override
	public double earnings() {
		return getSalary()*getPayMonthPerYear();
	}
}
