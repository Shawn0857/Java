package ObjectClass.ch3;

public class _3_Person {
	String id; //�w�]friendly
	String name;
	private int score; //�~���{���L�k�����I�s�o�ӰѼ�
	// public, private, protect, friendly
	
	public _3_Person() {} //(�w�])
	
	/*public _3_Person(String _id, String _name) {  //constructor �غc�l
		id = _id;
		name = _name;
	} */
	
	public _3_Person(String id, String name) {  //constructor �غc�l
		this.id = id;   //�bJava���󪺦ۤv�sthis
		this.name = name;
	} 
	public void setScore(int _score) {
		if(_score >=0 && _score<=100)
			score = _score;
		else {
			score = 0;
		}
	}
	public int getScore() {
		return score;
	}
	
}
