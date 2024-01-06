package ObjectClass.ch9_10;

public class Dog extends Animal{

	public Dog(String _name) {
		super(_name);
	}
	
	@Override
	public void shout() {
		super.shout();
		System.out.println(name+"汪汪叫");
		
	}
	
	public void tailwagging() {
		System.out.println(name+"在搖尾巴");
		//System.out.println(super.name+"在搖尾巴");
	}
	
}
