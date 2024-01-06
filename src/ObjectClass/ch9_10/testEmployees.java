package ObjectClass.ch9_10;

public class testEmployees {

	public static void main(String[] args) {
//		Employee e1 = new Employee("廷瑋","林","A109222010"); //不能用
		SalariedEmployee e2 = 
				new SalariedEmployee("廷瑋", "林", "A109222010", 35000, 14);
		System.out.println(e2.toString());
		
		HourlyEmployee e3 = new HourlyEmployee("廷瑋", "林", "A109222010", 170, 40*4);
		System.out.println(e3.toString());
		
		CommissionEmployee e4 = new CommissionEmployee("廷瑋", "林", "A109222010", 10000000, 0.3);
		System.out.println(e4.toString());
//		System.out.println(e4.grossSales);
		
		BasePlusCommissionEmployee e5 = new BasePlusCommissionEmployee
				("廷瑋", "林", "A109222010", 9000000, 0.25, 10000);
		System.out.println(e5.toString());
		
	}

}
