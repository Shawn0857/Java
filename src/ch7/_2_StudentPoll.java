package ch7;

public class _2_StudentPoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] responses = {1,3,40,6,5,5,6,2,1,2,3,4,5,6};
		int[] frequency = new int[6];
		for(int i = 0; i<responses.length; i++) 
		{
			//frequency[responses[i]-1]++;
			try 
			{
				frequency[responses[i]-1]++;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("資料陣列有問題:"+e.getMessage());
			}
			catch(Exception e)
			{
				System.out.println("Error:"+e.getMessage());
			}
		}
		for(int i = 0; i<frequency.length; i++) 
		{
			System.out.printf("點數%d出現%d次\n",i+1,frequency[i]);
		}
	}

}
