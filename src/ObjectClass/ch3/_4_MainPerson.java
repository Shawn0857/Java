package ObjectClass.ch3;

public class _4_MainPerson {

	public static void main(String[] args) {
//		_3_Person p1 = new _3_Person();
		_3_Person p1;
		p1 = new _3_Person();
		p1.id = "A109222010";
		p1.name = "�L��޳";
		//p.score = 60;
		System.out.printf("p��id��%s, �m�W��%s\n", p1.id, p1.name);
		
		_3_Person p2 = new _3_Person("123456","������");
		System.out.printf("p2��id��%s, �m�W��%s\n", p2.id, p2.name);
		
		_3_Person p3 = p2;
		p3.name="�s��������";
		System.out.printf("p2��id��%s, �m�W��%s\n", p2.id, p2.name);
		System.out.printf("p3��id��%s, �m�W��%s\n", p3.id, p3.name);
		
		p3.setScore(100);
		System.out.printf("p3��id��%s, �m�W��%s", "���Z��%d", p3.id, p3.name,
				p3.getScore());
		
	}

}
