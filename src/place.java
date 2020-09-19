public enum place {
	NORTH("North"),CENTER("Center"),SOUTH("South");
	
	private String House ;
	private place(String c){
		 House = c;
	} 
	public String getPlace (){
		return House;
	}
}	