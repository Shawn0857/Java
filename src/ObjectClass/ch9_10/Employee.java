package ObjectClass.ch9_10;

import java.io.Serializable;

public abstract class Employee implements Serializable{
	// abstract 不能 new Employee,不能建立 Employee 的物件.
	//final 給定後就不可再修改
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	
	public Employee(String _firstName, String _lastName,
			String _socialSecurityNumber) {
		firstName = _firstName;
		lastName = _lastName;
		socialSecurityNumber = _socialSecurityNumber;
	}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getSocialSecurityNumber() {return socialSecurityNumber;}
	
	@Override
	public String toString() {
		return String.format("%s %s social security number : %s",
				getLastName(),getFirstName(),getSocialSecurityNumber());
	}
	
	// abstract 所有繼承我 Employee 的物件都要實作這個 method
	public abstract double earnings();
}
