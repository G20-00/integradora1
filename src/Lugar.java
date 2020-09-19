public enum Lugar {
	NORTE("Norte"),CENTRO("Centro"),SUR("Sur");
	
	private String casa ;
	private Lugar(String c){
		 casa = c;
	} 
	public String getLugar (){
		return casa;
	}
}	