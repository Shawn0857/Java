package ObjectClass.ch9_10;

public class Cat extends Animal{

	public Cat(String _name) {
		super(_name);
	}

	@Override
	public void shout() {
		System.out.println(name+"在咪喵叫");
	}
	
	public void Coquettish() {
		System.out.println(name+"在撒嬌");
	}
}
