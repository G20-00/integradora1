public enum Place {
	NORTH("Norte"),CENTER("Centro"),SOUTH("Sur");
	
	private String House ;
	private Place(String c){
		 House = c;
	} 
	public String getPlace (){
		return House;
	}
}	