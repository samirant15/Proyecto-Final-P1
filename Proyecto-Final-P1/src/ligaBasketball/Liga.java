package ligaBasketball;


public class Liga {

	private static Liga LIGA = null;
	private Liga(){};
	public static Liga getInstance(){
		if(LIGA == null)
			LIGA = new Liga();
		return LIGA;
		
	}
	
	
	
	
}
	
	

