package ObjectClass.ch9_10;

public class Animal {
	String name;
	public Animal(String _name) {
		this.name = _name;
	}
	public void shout() {
		System.out.println(name + "在叫");
	}
}
