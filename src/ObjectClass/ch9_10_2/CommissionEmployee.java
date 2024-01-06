package ObjectClass.ch9_10_2;

import java.io.Serializable;

public class CommissionEmployee extends Employee implements Serializable{
	
	protected double grossSales; // 一年的銷售額度
	protected double commissionRate;// 抽傭比例
	
	// protected 建構這個次物件的可以直接呼叫他跟public 一樣,繼承他的物件也可以呼叫.
	// 跟 public 的唯一差別是其他 package 不能呼叫
	// 其他 package 不能呼叫.
	
	public CommissionEmployee(String _firstName, String _lastName, String _socialSecurityNumber
			,double _grossSales,double _commissionRate) {
		super(_firstName, _lastName, _socialSecurityNumber);
		setGrossSales(_grossSales);
		setCommissionRate(_commissionRate);
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double _grossSales) {
		this.grossSales = (_grossSales>0)? _grossSales : 0;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double _commissionRate) {
		this.commissionRate = (_commissionRate>0 && _commissionRate <=1)? _commissionRate : 0;
	}

	@Override
	public double earnings() {
		
		return getGrossSales()*getCommissionRate();
	}
	
	@Override
	public String toString() {
		return String.format("CommissionEmployee : %s,銷售金額:%,.0f,抽傭比例:%,.2f,年薪:%,.0f", super.toString()
				,getGrossSales(),getCommissionRate() ,earnings());
	}
}
