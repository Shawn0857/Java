package ObjectClass.ch3;

public class _3_Person {
	String id; //預設friendly
	String name;
	private int score; //外面程式無法直接呼叫這個參數
	// public, private, protect, friendly
	
	public _3_Person() {} //(預設)
	
	/*public _3_Person(String _id, String _name) {  //constructor 建構子
		id = _id;
		name = _name;
	} */
	
	public _3_Person(String id, String name) {  //constructor 建構子
		this.id = id;   //在Java物件的自己叫this
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
