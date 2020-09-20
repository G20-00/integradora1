
import java.util.Scanner;
public class Integradora{

	public static final int maximumQuantity = 1000; // global variable with the maximum size of products to compare
	public static final String WORK_BLACK = "Obra negra"; //global variable string for black work
	public static final String WORK_WHITE = "Obra blanca"; //  global variable string for white work
	public static final String WORK_PAINTING = "Obra pintura"; // variable global string for painting work
	
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true; // variable that controls the user's choice
		String[] names = new String[maximumQuantity]; // is responsible for storing the name of the products
		String[] intention = new String[maximumQuantity]; //is in charge of storing what the product will be used for
		double[] bestPrice = new double[maximumQuantity]; // is responsible for saving the lowest value of the products
		String[] placeBestPrice = new String[maximumQuantity]; // is responsible for storing the place of the lowest price
		double [] listHomecenter = new double[maximumQuantity]; //  is in charge of storing the list of homcenter products
		double [] neighborhoodHardwarList =new double[maximumQuantity]; //is in charge of storing the list of hardware products in the neighborhood
		double [] hardwareCenterList = new double[maximumQuantity]; //is in charge of storing the list of hardware products of the center
		String[] house = new String[maximumQuantity]; //is responsible for storing the location of the home
		while(run) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Comparar una serie de productos y añadir a la lista el de menor precio.");
			System.out.println("2. Mostar lista en pantalla los mejores precios.");
			System.out.println("3. Mostrar  productos para obra negra.");
			System.out.println("4. Mostrar  productos para obra blanca.");
			System.out.println("5. Mostrar  productos para obra pintura.");
			System.out.println("6. Mostrar  precios de Homcenter");
			System.out.println("7. Mostrar  precios de ferreteria del barrio.");
			System.out.println("8. Mostrar  precios de ferreteria del centro.");
			System.out.println("9. Finalizar programa.");
			
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: compareProducts(scan,listHomecenter,neighborhoodHardwarList,hardwareCenterList, intention 
					, names, bestPrice,placeBestPrice,house);
					break;
			case 2: showOnScreen(names, bestPrice,placeBestPrice,intention,house);					
					System.out.println();
					break;
			case 3: showOnScreenWorkBlack( names,intention);
					System.out.println();
					break;
			case 4: showOnScreenWhiteWork( names, intention);
					System.out.println();
					break;
			case 5: showOnScreenWorkPainting( names, intention);
					System.out.println();
					break;		
			case 6: homecenterValues( names,listHomecenter,placeBestPrice, intention , house);
					System.out.println();
					break;
			case 7: neighborhoodHardwareValues( names,neighborhoodHardwarList,placeBestPrice, intention ,house);
					System.out.println();
					break;
			case 8: valuesHardwareCenter( names,hardwareCenterList,placeBestPrice, intention , house);
					System.out.println();
					break;		
			case 9: run = false;
					System.out.println("BYE BYE");
					break;
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
					System.out.println();
			}
		}
		
	
	}
	/**
	*getPlace the location of the house
	*<b> pre: </b>
	*<b> pos: </b> the house is located
	*@param  scan it's the scanner
	*@return String placeObtained
	*/
	public static String getPlace(Scanner scan){
	String placeObtained = null ;	
	place l = null ;
	int accountant =1;
	for (place home : place.values()){ // values para obtener todos los valores "objetos"
			
			System.out.println(accountant + ". "+ home.getPlace());
			accountant++;
		}
	
	
		int opcion =  Integer.parseInt(scan.nextLine());
		switch(opcion) {
			case 1: placeObtained = l.NORTH.getPlace();
					break;
					
			case 2: placeObtained	= l.CENTER.getPlace();				
					
					break;
			case 3: placeObtained = l.SOUTH.getPlace();
					break;
		
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
					System.out.println();
		}
		return placeObtained;
	}
	/**
	*getIntentionality save product utility
	*<b> pre: </b>
	*<b> pos: </b> get the use for the product
	*@param  scan it's the scanner
	*@return intention  product utility
	*/
	public static String getIntentionality(Scanner scan) {
		boolean selected = false;
		String intention = null;
		while(!selected) {
			System.out.println("Escoja la opcion de la intencion con la obtiene el producto: ");
			System.out.println("1. " + WORK_BLACK);
			System.out.println("2. " + WORK_WHITE);
			System.out.println("3. " + WORK_PAINTING);
			 
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: intention = WORK_BLACK;
					selected  = true;
					break;
			case 2: intention = WORK_WHITE;	
					selected  = true;
					break;
			case 3: intention = WORK_PAINTING;
					
					selected  = true;
					break;
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
			}
		}
		return intention;
	}
	
	// method in charge of asking for the name and price of the products
	/**
	*compareProducts save the values ​​of each store
	*<b> pre: </b>
	*<b> pos: </b> generates least value array and arrays for store values
	*@param scan it's the scanner
	*@param listHomecenter arrangement in charge of saving the value of the Homcenter 
	*@param neighborhoodHardwarList arrangement in charge of saving the value of the neighborhood hardware store
	*@param placeBestPrice save the best price place
	*@param bestPrice save the best price
	*@param	names save the name of products 
	*@param house save the location of the house
	*@param hardwareCenterList arrangement in charge of saving the value of the center hardware store
	*@param intention save product utility
	*/
	public static void compareProducts(Scanner scan, double[] listHomecenter,double[] neighborhoodHardwarList,double[] hardwareCenterList,String[] intention,
	String[] names, double[] bestPrice,String[] placeBestPrice,String[] house) {
		System.out.println("Compara los productos:");
		
		System.out.println( " ¿En que parte se debe entregar el domicilio?" );
		
		String place = getPlace(scan );
		
		System.out.println("¿Cuantos productos ingresaras para comparar?");
		
		int quantity = Integer.parseInt(scan.nextLine());
		double[] HomeCenter = new double[quantity]; // variable assigned to store, the values ​​for the Homcenter
		double[] hardwareCenter = new double[quantity]; // variable assigned to store, the values ​​for the neighborhood hardware store
		double[] hardwareStore = new double[quantity]; //  variable assigned to store, the values ​​for the center hardware store
		String[] compareName = new String[quantity]; //  variable assigned to partially save the name
		String[] compareIntentionality = new String[quantity];  // variable used to call the method, of intentionality
		
		double unitPrice= 0; //variable that stores the unit value of the product
		
		house[0] = place;
		
		for(int i = 0; i<quantity; i++) { //condition to order all products

			
			compareIntentionality[i] =  getIntentionality(scan);
			
			System.out.println("Ingrese el nombre del producto numero " + (i+1));	
			compareName[i] = scan.nextLine();
			names[i]= compareName[i];
			
			System.out.println("Cuantos unidades necesita del producto");
			int Units = Integer.parseInt(scan.nextLine()); //variable used to know how many units you need of the product
			if ( Units >  0 ) {
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"En HomeCenter");
			unitPrice = Double.parseDouble(scan.nextLine());
			HomeCenter[i] = unitPrice * Units;
			listHomecenter[i]= HomeCenter[i]; 
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferreteria del centro");
			unitPrice = Double.parseDouble(scan.nextLine());
			hardwareCenter[i] = unitPrice * Units;
			hardwareCenterList[i]=hardwareCenter[i];
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferretería del barrio");
			unitPrice = Double.parseDouble(scan.nextLine());
			hardwareStore[i] = unitPrice * Units;
			neighborhoodHardwarList[i]= hardwareStore[i];
			}
			else
			System.out.println("Las unidades que necesita, no son posibles ");
			
		}
		//method initialization, in charge of comparing values
		
		comparisonValues(intention ,compareIntentionality,HomeCenter,hardwareCenter,hardwareStore,names,bestPrice,quantity,placeBestPrice);
			
	}
	/**
	*compareProducts save the values ​​of each store
	*<b> pre: </b>
	*<b> pos: </b> generates least value array  
	*@param compareIntentionality save the purposes for each product
	*@param HomeCenter arrangement in charge of saving the value of the Homcenter 
	*@param hardwareStore arrangement in charge of saving the value of the neighborhood hardware store
	*@param placeBestPrice save the best price place
	*@param bestPrice save the best price
	*@param	names save the name of products 
	*@param quantity save the location of the house
	*@param hardwareCenter arrangement in charge of saving the value of the center hardware store
	*@param intention save product utility	
	*/
	
	public static void comparisonValues(String[] intention ,String[] compareIntentionality,double[] HomeCenter, double[]hardwareCenter , double[] hardwareStore 
			, String[] names, double[] bestPrice , int quantity,String[] placeBestPrice) {
				
		double lowerValue = 0;
		
		String HomeC = " en Homecenter"; // string variable that stores the value of a store

		String Ferrec = " en Ferreteria centro "; // string variable that stores the value of a store

		String FerreB = "en Ferreteria del barrio";  // string variable that stores the value of a store

		for (int i = 0; i < quantity; i++) {
		if((HomeCenter[i] <= hardwareCenter[i]) &&(HomeCenter[i] <= hardwareStore[i]) ) {
				if (HomeCenter[i] > 0) {
					bestPrice[i]= HomeCenter[i];
					placeBestPrice[i]= HomeC ;
					intention[i]=compareIntentionality[i];
				}else if((hardwareCenter[i] < hardwareStore[i])&&(hardwareCenter[i] > 0) && (hardwareStore[i] > 0)){ 
					bestPrice[i]=hardwareCenter[i];
					placeBestPrice[i]= Ferrec;
					intention[i]=compareIntentionality[i];
					}else if ((hardwareCenter[i] > hardwareStore[i])&&(hardwareStore[i] > 0) && (hardwareCenter[i] > 0)) {
						bestPrice[i]=hardwareStore[i];
						placeBestPrice[i]= FerreB;
						intention[i]=compareIntentionality[i];
						}else if (hardwareCenter[i] > 0) {
							bestPrice[i]=hardwareCenter[i];
							placeBestPrice[i]= Ferrec;
							intention[i]=compareIntentionality[i];
							} else if (hardwareStore[i] > 0){
								bestPrice[i]=hardwareStore[i];
								placeBestPrice[i]= FerreB;
								intention[i]=compareIntentionality[i];
								}
			}
			else
			{
				if((hardwareCenter[i]<= HomeCenter[i])&&(hardwareCenter[i]<=hardwareStore[i])  ){
					if (hardwareCenter[i]> 0){
						bestPrice[i]=hardwareCenter[i];
						placeBestPrice[i]= Ferrec;
						intention[i]=compareIntentionality[i];
					}else if((HomeCenter[i] < hardwareStore[i])&&(HomeCenter[i] > 0) && (hardwareStore[i] > 0)){ 
						bestPrice[i]= HomeCenter[i];
						placeBestPrice[i]= HomeC ;
						intention[i]=compareIntentionality[i];
						}else if ((HomeCenter[i] > hardwareStore[i])&&(hardwareStore[i] > 0) && (HomeCenter[i] > 0)) {
							bestPrice[i]=hardwareStore[i];
							placeBestPrice[i]= FerreB;
							intention[i]=compareIntentionality[i];
							}else if (HomeCenter[i] > 0) {
								bestPrice[i]= HomeCenter[i];
								placeBestPrice[i]= HomeC ;
								intention[i]=compareIntentionality[i];
								} else if (hardwareStore[i] > 0){
									bestPrice[i]=hardwareStore[i];
									placeBestPrice[i]= FerreB;
									intention[i]=compareIntentionality[i];
									}
				} 
				
				else
				{
					if((hardwareStore[i]<= HomeCenter[i])&&(hardwareCenter[i]>=hardwareStore[i]) ){
						if (hardwareStore[i] > 0){
							bestPrice[i]=hardwareStore[i];
							placeBestPrice[i]= FerreB;
							intention[i]=compareIntentionality[i];
							}else if((HomeCenter[i] < hardwareCenter[i])&&(HomeCenter[i] > 0) && (hardwareCenter[i] > 0)){ 
								bestPrice[i]= HomeCenter[i];
								placeBestPrice[i]= HomeC ;
								intention[i]=compareIntentionality[i];
								}else if ((HomeCenter[i] > hardwareCenter[i])&&(hardwareCenter[i] > 0) && (HomeCenter[i] > 0)) {
									bestPrice[i]=hardwareCenter[i];
									placeBestPrice[i]= Ferrec;
									intention[i]=compareIntentionality[i];
										}else if (HomeCenter[i] > 0) {
											bestPrice[i]= HomeCenter[i];
											placeBestPrice[i]= HomeC ;
											intention[i]=compareIntentionality[i];
											} else if (hardwareCenter[i] > 0){
												bestPrice[i]=hardwareCenter[i];
												placeBestPrice[i]= Ferrec;
												intention[i]=compareIntentionality[i];
												}
						
					}
				}
			}
		}
		
	}
	/**
	*showOnScreen print the arrangement with the lowest prices
	*<b> pre: </b> must have products entered and prices greater than 0
	*<b> pos: </b> print the arrangement with the lowest prices
	*@param names  the names of the products
	*@param bestPrice the better price
	*@param placeBestPrice   the place that has the cheapest prices
	*@param intention save product utility	
	*@param house where is the house located
	*/
	public static void showOnScreen ( String[] names, double[] bestPrice,
						String[] placeBestPrice,String[] intention,String[] house ) {
		int x = 1; // counter variable used to display the product number
		double totalCost = 0; //  counter in charge of storing the sum of the values ​​of all products
		boolean complete = false; 
		int blackWorkManShip= 0; // variables in charge of accounting for labor
		int whiteWorkforce= 0;  //variables in charge of accounting for labor
		int workmanshipPainting= 0; //variables in charge of accounting for labor
		int addressValue = 0; //is used for the address value
				
		System.out.println("Los mejores precios y sus puntos de venta son : ");
		
		//it is used to go all the way through the entire array and save the smallest value
		for (int i = 0; i < bestPrice.length && !complete; i++) {
			if (bestPrice[i]> 0){
				if(names[i] != null) {
				System.out.println( x + ". Nombre: " + names[i] + ". Precio: " + bestPrice[i] + " Lugar de compra " +placeBestPrice[i] +"  "+  intention[i]);
				x++;
				totalCost = totalCost + bestPrice[i];
					}else {
					complete=true;
					}
			}	
		}
		// in charge of determining the value of the domicile
		if (house[0] == "North"){
			if (totalCost < 80000){
				addressValue = 120000 ;
			}
			else if((totalCost < 300000)&& (totalCost>80000)){
				addressValue = 28000 ;
			}
			else if(totalCost >= 300000){
				addressValue = 0 ;
			}
			
		}
		else if  (house[0] == "Center"){
			
				if (totalCost < 50000){
				addressValue = 50000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 0 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
			
			}
			else if (house[0] == "South"){
				if (totalCost < 80000){
				addressValue = 120000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 55000 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
						
			}
		
		if (totalCost > 0){
			System.out.println("El costo de domicilio: "+ addressValue);
		}
		System.out.println("El costo de materiales es: "+ totalCost);
		// in charge of determining the value of labor
		for (int i=0; i< intention.length;i++){
			if(intention[i]== "Obra negra" ){
				blackWorkManShip = 1300000 ;
			}else{
				if(intention[i]== "Obra blanca" ){
					whiteWorkforce = 2600000;
				}
				else{
					if (intention[i]== "Obra pintura" )
					workmanshipPainting = 980000;
			
				}
			}
			
		}
		if (totalCost> 0){
		totalCost = totalCost+whiteWorkforce+blackWorkManShip+workmanshipPainting+addressValue;
		System.out.println("El costo total es : "+ totalCost);
		}
	}
	//method in charge of printing the names of the products of the black work
/**
	*showOnScreenWorkBlack print the names of the black work
	*<b> pre: </b> must have names other than null
	*<b> pos: </b> prints on screen the materials of the black work
	*@param names  the names of the products
	*@param intention save product utility	
	*/
	public static void showOnScreenWorkBlack ( String[] names, String[] intention ) {
		int x = 1; // counter variable used to display the product number
		
		System.out.println("Los productos de la obra negra son:");
		for (int i = 0; i < intention.length ; i++) {
			if( intention[i] == WORK_BLACK) {
				System.out.println( x + ". Nombre: " + names[i] );
				x++;
			}
		}
	}
	//method in charge of printing the names of the products of the with work
	/**
	*showOnScreenWhiteWork print the names of the with work
	*<b> pre: </b> must have names other than null
	*<b> pos: </b> prints on screen the materials of the with work
	*@param names  the names of the products
	*@param intention save product utility	
	*/
	public static void showOnScreenWhiteWork ( String[] names, String[] intention ) {
		int x = 1; //counter variable used to display the product number
		
		System.out.println("productos de la obra blanca son:");
		for (int i = 0; i < intention.length; i++) {
			if( intention[i] == WORK_WHITE) {
				System.out.println( x + ". Nombre: " + names[i]);
				x++;
			}
		}
	}
	//method in charge of printing the names of the products of the Painting work
	/**
	*showOnScreenWorkPainting print the names of the Painting work
	*<b> pre: </b> must have names other than null
	*<b> pos: </b> prints on screen the materials of the Painting work
	*@param names  the names of the products
	*@param intention save product utility	
	*/
	public static void showOnScreenWorkPainting( String[] names, String[] intention ) {
		int x = 1; //counter variable used to display the product number
		
		System.out.println("productos de  la obra pintura son:");
		for (int i = 0; i < intention.length ; i++) {
			if( intention[i] == WORK_PAINTING) {
				System.out.println( x + ". Nombre: " + names[i] );
				x++;
			
			}
		}
	} 
	/**
	*homecenterValues  print homecenter products and values
	*<b> pre: </b> must have products entered and prices greater than 0
	*<b> pos: </b>  
	*@param listHomecenter arrangement in charge of saving the value of the Homcenter 
	*@param placeBestPrice save the best price place
	*@param	names save the name of products 
	*@param intention save product utility	
	*@param house save the location of the house
	*/
	public static void homecenterValues( String[] names,double[] listHomecenter,String[] placeBestPrice,
	String[] intention,String[] house ) {
		int x = 1; //counter variable used to display the product number
		double totalCost = 0; //  counter in charge of storing the sum of the values ​​of all products
		boolean complete = false; 
		int blackWorkManShip= 0;// variables in charge of accounting for labor
		int whiteWorkforce= 0; //variables in charge of accounting for labor
		int workmanshipPainting= 0;  //variables in charge of accounting for labor
		int addressValue = 0; //is used for the address value
		int missingProduct = 0 ; //variable in charge of finding a product with value 0
		System.out.println("Lista de precios en HomeCenter:");
		for (int i = 0; i < listHomecenter.length ; i++) {
			if(names[i] != null) {
			System.out.println( x + ". Nombre: " + names[i] + "  Valor:  "+ listHomecenter[i] + " para : "+  intention[i]);
				x++;
				totalCost = totalCost + listHomecenter[i];
			}
		}
		System.out.println("El costo total en materiales en Homecenter es : " + totalCost);
		if (house[0] == "North"){
			if (totalCost < 80000){
				addressValue = 120000 ;
			}
			else if((totalCost < 300000)&& (totalCost>80000)){
				addressValue = 28000 ;
			}
			else if(totalCost >= 300000){
				addressValue = 0 ;
			}
			
		}
		else if  (house[0] == "Center"){
			
				if (totalCost < 80000){
				addressValue = 50000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 0 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
			
			}
			else if (house[0] == "South"){
				if (totalCost < 80000){
				addressValue = 120000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 55000 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
						
			}
		for (int i=0; i< intention.length;i++){
			if(intention[i]== "Obra negra" ){
				if (listHomecenter[i]> 0)
					blackWorkManShip = 1300000 ;
				else 
					missingProduct=1 + missingProduct;
			}else{
				if(intention[i]== "Obra blanca" ){
					if (listHomecenter[i]> 0)
						whiteWorkforce = 2600000;
					else 
						missingProduct=1 + missingProduct ;
				}
				else{
					if (intention[i]== "Obra pintura" )
						if (listHomecenter[i]> 0)
							workmanshipPainting = 980000;
						else
							missingProduct=1 + missingProduct;
			
				}
			}
			
		}
		if (missingProduct > 0);{
			System.out.println("En este establecimiento no puede conseguir "+ missingProduct+ " productos" );
		}
		if (totalCost > 0){
		System.out.println("El costo de domicilio: "+ addressValue);
		totalCost = totalCost+whiteWorkforce+blackWorkManShip+workmanshipPainting+addressValue;
		System.out.println("El costo total es : "+ totalCost);
		}else 
			System.out.println("No tiene valor, por que no hay productos disponibles" );
	}
	/**
	* neighborhoodHardwareValues print neighborhood Hardware Values products and values
	*<b> pre: </b> must have products entered and prices greater than 0
	*<b> pos: </b>   
	*@param neighborhoodHardwarList arrangement in charge of saving the value of the neighborhood Hardwar List 
	*@param placeBestPrice save the best price place
	*@param	names save the name of products 
	*@param intention save product utility	
	*@param house save the location of the house
	*/
	public static void neighborhoodHardwareValues( String[] names,double[] neighborhoodHardwarList,
	String[] placeBestPrice,String[] intention ,String[] house) {
		int x = 1; //counter variable used to display the product number
		double totalCost = 0; //  counter in charge of storing the sum of the values ​​of all products
		int blackWorkManShip= 0; // variables in charge of accounting for labor
		int whiteWorkforce= 0; //variables in charge of accounting for labor
		int workmanshipPainting= 0;  //variables in charge of accounting for labor
		int addressValue = 0; //is used for the address value
		int missingProduct = 0 ; //variable in charge of finding a product with value 0
		
		System.out.println("Lista de precios en ferreteria del barrio :");
		for (int i = 0; i < neighborhoodHardwarList.length ; i++) {
			if(names[i] != null) {
			System.out.println( x + ". Nombre: " + names[i] + " Valor : "+ neighborhoodHardwarList[i] + " para : " + intention[i]);
				x++;
				totalCost = totalCost + neighborhoodHardwarList[i];
			}
		}
		System.out.println("El costo total en materiales en ferreteria del barrio es : " + totalCost);
		// conditional used to calculate the value of the address

		if (house[0] == "North"){
			if (totalCost < 80000){
				addressValue = 120000 ;
			}
			else if((totalCost < 300000)&& (totalCost>80000)){
				addressValue = 28000 ;
			}
			else if(totalCost >= 300000){
				addressValue = 0 ;
			}
			
		}
		else if  (house[0] == "Center"){
			
				if (totalCost < 80000){
				addressValue = 50000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 0 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
			
			}
			else if (house[0] == "South"){
				if (totalCost < 80000){
				addressValue = 120000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 55000 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
						
			}
		for (int i=0; i< intention.length;i++){
			if(intention[i]== "Obra negra" ){
				if (neighborhoodHardwarList[i]> 0)
					blackWorkManShip = 1300000 ;
				else 
					missingProduct++;
			}else{
				if(intention[i]== "Obra blanca" ){
					if (neighborhoodHardwarList[i]> 0)
						whiteWorkforce = 2600000;
					else 
						missingProduct++;
				}
				else{
					if (intention[i]== "Obra pintura" )
						if (neighborhoodHardwarList[i]> 0)
							workmanshipPainting = 980000;
						else
							missingProduct++;
			
				}
			}
			
		}
		if (missingProduct > 0);{
			System.out.println("En este establecimiento no puede conseguir "+ missingProduct+ " productos" );
		}
		if (totalCost > 0){
		System.out.println("El costo de domicilio: "+ addressValue);
		totalCost = totalCost+whiteWorkforce+blackWorkManShip+workmanshipPainting+addressValue;
		System.out.println("El costo total es : "+ totalCost);
		}else 
			System.out.println("No tiene valor, por que no hay productos disponibles" );
	}
	/**
	* valuesHardwareCenter print values Hardware Center products and values
	*<b> pre: </b> must have products entered and prices greater than 0
	*<b> pos: </b>  
	*@param hardwareCenterList arrangement in charge of saving the value of the hardware Center List 
	*@param placeBestPrice save the best price place
	*@param	names save the name of products 
	*@param intention save product utility	
	*@param house save the location of the house
	*/
	public static void valuesHardwareCenter( String[] names,double[] hardwareCenterList,
	String[] placeBestPrice, String[] intention,String[] house ) {
		int x = 1; //counter variable used to display the product number
		int missingProduct = 0; //variable in charge of finding a product with value 0
		double totalCost = 0; //  counter in charge of storing the sum of the values ​​of all products
		int blackWorkManShip= 0; // variables in charge of accounting for labor
		int whiteWorkforce= 0; //variables in charge of accounting for labor
		int workmanshipPainting= 0;  //variables in charge of accounting for labor
		int addressValue = 0; //is used for the address value
		boolean complete = false;
		System.out.println("Lista de precios en ferreteria del centro:");
		for (int i = 0; i < hardwareCenterList.length ; i++) {
			if(names[i] != null) {
				System.out.println( x + ". Nombre: " + names[i] + " Valor : "+ hardwareCenterList[i] +" para:  "+  intention[i]);
				x++;
				totalCost = totalCost + hardwareCenterList[i];
			}
		}
		// conditional used to calculate the value of the address

		if (house[0] == "North"){
			if (totalCost < 80000){
				addressValue = 120000 ;
			}
			else if((totalCost < 300000)&& (totalCost>80000)){
				addressValue = 28000 ;
			}
			else if(totalCost >= 300000){
				addressValue = 0 ;
			}
			
		}
		else if  (house[0] == "Center"){
			
				if (totalCost < 80000){
				addressValue = 50000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 0 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
			
			}
			else if (house[0] == "South"){
				if (totalCost < 80000){
				addressValue = 120000 ;
				}
					else if((totalCost < 300000)&& (totalCost>80000)){
					addressValue = 55000 ;
					}
						else if(totalCost >= 300000){
						addressValue = 0 ;
						}
						
			}	
		
		System.out.println("El costo total en materiales en ferreteria del centro es :" + totalCost);
		
		for (int i=0; i< intention.length;i++){
			if(intention[i]== "Obra negra" ){
				if (hardwareCenterList[i]> 0){
					blackWorkManShip = 1300000 ;
				}	
				else if(hardwareCenterList[i] == 0) {
							missingProduct++;
				}	
			}else{
				if(intention[i]== "Obra blanca" ){
					if (hardwareCenterList[i]> 0)
						whiteWorkforce = 2600000;
					else if(hardwareCenterList[i] == 0) {
							missingProduct++;
					}
				}
				else{
					if (intention[i]== "Obra pintura" ){
						if (hardwareCenterList[i]> 0){
							workmanshipPainting = 980000;
						}	
						else if(hardwareCenterList[i] == 0) {
							missingProduct++;
						}
					}	
				}
			}
			
		}
		
		if (missingProduct > 0);{
			System.out.println("En este establecimiento no puede conseguir "+ missingProduct+ " productos" );
		}
		if (totalCost > 0){
		System.out.println("El costo de domicilio: "+ addressValue);
		totalCost = totalCost+whiteWorkforce+blackWorkManShip+workmanshipPainting+addressValue;
		System.out.println("El costo total es : "+ totalCost);
		}else 
			System.out.println("No tiene valor, por que no hay productos disponibles" );
		
	}
	
	
}		