package ObjectClass.ch9_10;

public class SalariedEmployee extends Employee {
	
	private double salary;
	private double payMonthPerYear;
	
	public SalariedEmployee(String _firstName, String _lastName
			, String _socialSecurityNumber,double _salary, double _payMonthPerYear) {
		super(_firstName, _lastName, _socialSecurityNumber);
		setSalary(_salary);
		setPayMonthPerYear(_payMonthPerYear);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double _salary) {
		this.salary = (_salary > 0)? _salary : 0;
		//this.salary = _salary;
	}

	public double getPayMonthPerYear() {
		return payMonthPerYear;
	}

	public void setPayMonthPerYear(double _payMonthPerYear) {
		this.payMonthPerYear = (_payMonthPerYear > 12)? _payMonthPerYear : 12;
	}
	
	@Override
	public String toString() {
		return String.format("SalariedEmployee : %s, 月薪:%,.0f, 年薪:%,.0f", super.toString(),getSalary(),earnings());
	}
	
	@Override
	public double earnings() {
		return  getSalary() * getPayMonthPerYear();
}
	
}
