package ObjectClass.ch9_10_2;

import java.io.Serializable;

public class HourlyEmployee extends Employee implements Serializable{
	private double wage; // 一個小時多少錢
	private double hours; // 一個月做多少小時

	public HourlyEmployee(String _firstName, String _lastName, String _socialSecurityNumber, double _wage,
			double _hours) {
		super(_firstName, _lastName, _socialSecurityNumber);
		setWage(_wage);
		setHours(_hours);
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double _wage) {
		this.wage = (_wage > 165) ? _wage : 165;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double _hours) {
		this.hours = (_hours > 0) ? _hours : 0;
	}

	@Override
	public double earnings() {
		return getWage() * getHours() * 12;
	}

	@Override
	public String toString() {
		return String.format("HourlyEmployee : %s,月薪:%,.0f,年薪:%,.0f", super.toString(), getWage() * getHours(),
				earnings());
	}
}