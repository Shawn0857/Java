package ObjectClass.ch9_10;

public class testAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a1 = new Animal("皮卡丘");
		a1.shout();
		Dog d1 = new Dog("小黑");
		d1.tailwagging();
		d1.shout();
		Cat c1 = new Cat("小花");
		c1.shout();
		c1.Coquettish();
		
		System.out.println("---------------------");
		
//		Cat c1 = new Animal(""); //不能把父類別放入子類別中
//		Dog d2 = new Animal("");
//		Dog d3 = new Cat("");
		Animal a2 = new Cat("花花");//可以把子類別放入父類別中
		a2.shout();
//		a2.Coquettish(); //貓喪失撒嬌能力
		Animal a3 = new Dog("老黑");//可以把子類別放入父類別中
		a3.shout();
//		a3.tailwagging();
	}

}
