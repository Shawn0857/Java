package ObjectClass.ch9_10;

public class CommissionEmployee extends Employee {
	
	protected double grossSales; // 一年的銷售額度
	protected double commissionRate; // 抽傭的比率

	// protected 建構這個物件的可以直接呼叫它跟 public 一樣，繼承它的物件也可以直接呼叫
	// 跟 public 的唯一差別是其它 package 不能呼叫
	
	public CommissionEmployee(String _firstName, String _lastName, String _socialSecurityNumber,
			double _grossSalaes, double _commissionRate) {
		super(_firstName, _lastName, _socialSecurityNumber);
		setGrossSalaes(_grossSalaes);
		setCommissionRate(_commissionRate);
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSalaes(double _grossSalaes) {
		this.grossSales = (_grossSalaes > 0)? _grossSalaes : 0;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double _commissionRate) {
		this.commissionRate = (_commissionRate > 0 && _commissionRate <= 1)? _commissionRate : 0;
	}

	@Override
	public double earnings() {
		return getGrossSales() * getCommissionRate();
	}
	
	@Override
	public String toString() {
		return String.format("CommissionEmployee : %s, 銷售額度:%,.0f, 抽傭比率:%,.2f, 年薪:%,.0f",
				super.toString(),getGrossSales() ,getCommissionRate(), earnings());
	}

}
