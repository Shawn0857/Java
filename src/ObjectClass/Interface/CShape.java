package ObjectClass.Interface;

//因為介面只有抽象函數，abstract 的關鍵字可以省略；
//而資料成員部分：因為此值不會被更改，final 也是可以省略的。
//抽象函數的修飾子也只能使用公有 public (或不宣告)，
//為了都能取用到，所以不能宣告 私有private或保護 protected 。

public interface CShape {
	final double PI = 3.14; // final 可省略 (interface裡面的值給定的話就不能再做修改，故final可省略)
	public abstract void show(); // public abstract 可省略
}
