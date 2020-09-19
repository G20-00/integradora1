
import java.util.Scanner;
public class Integradora{

	public static final int CANTIDAD_MAXIMA = 1000;
	public static final String OBRA_NEGRA = "Obra negra";
	public static final String OBRA_BLANCA = "Obra blanca";
	public static final String OBRA_PINTURA = "Obra pintura";
	
	
	public static void main (String [] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		String[] nombres = new String[CANTIDAD_MAXIMA];
		String[] intencion = new String[CANTIDAD_MAXIMA];
		double[] mejorPrecio = new double[CANTIDAD_MAXIMA];
		String[] LugarMejorPrecio = new String[CANTIDAD_MAXIMA];
		double [] listaHomcenter = new double[CANTIDAD_MAXIMA];
		double [] listaFerreteriBarrio =new double[CANTIDAD_MAXIMA];
		double [] listaFerreteriaCentro = new double[CANTIDAD_MAXIMA];
		String[] casa = new String[CANTIDAD_MAXIMA];
		while(run) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Comparar una serie de productos y añadir a la lista el de menor precio.");
			System.out.println("2. Mostar lista en pantalla los mejores precios.");
			System.out.println("3. Mostrar  productos para obra negra.");
			System.out.println("4. Mostrar  productos para obra blanca.");
			System.out.println("5. Mostrar  productos para obra pintura.");
			System.out.println("6. Mostrar  precios de Homcenter");
			System.out.println("7. Mostrar  precios de ferreteria del barrio.");
			System.out.println("8. Mostrar mejores de ferreteria del centro.");
			System.out.println("9. Finalizar programa.");
			
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: compararProductos(scan,listaHomcenter,listaFerreteriBarrio,listaFerreteriaCentro, intencion 
					, nombres, mejorPrecio,LugarMejorPrecio,casa);
					break;
			case 2: mostrarEnPantalla(scan,nombres, mejorPrecio,LugarMejorPrecio,intencion,casa);					
					System.out.println();
					break;
			case 3: mostrarEnPantallaObraNegra( nombres,intencion);
					System.out.println();
					break;
			case 4: mostrarEnPantallaObraBlanca( nombres, intencion);
					System.out.println();
					break;
			case 5: mostrarEnPantallaObraPintura( nombres, intencion);
					System.out.println();
					break;		
			case 6: ValoresHomecenter( nombres,listaHomcenter,LugarMejorPrecio, intencion);
					System.out.println();
					break;
			case 7: ValoresFerreteriaBarrio( nombres,listaFerreteriBarrio,LugarMejorPrecio, intencion);
					System.out.println();
					break;
			case 8: ValoresFerreteriaCentro( nombres,listaFerreteriaCentro,LugarMejorPrecio, intencion);
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
	public static String obtenerLugar(Scanner scan){
	String lugarObtenido = null ;	
	Lugar l = null ;
	int contador =1;
	for (Lugar residencia : Lugar.values()){ // values para obtener todos los valores "objetos"
			
			System.out.println(contador + ". "+ residencia.getLugar());
			contador++;
		}
	
	
		int opcion =  Integer.parseInt(scan.nextLine());
		switch(opcion) {
			case 1: lugarObtenido = l.NORTE.getLugar();
					break;
					
			case 2: lugarObtenido	= l.CENTRO.getLugar();				
					
					break;
			case 3: lugarObtenido = l.SUR.getLugar();
					break;
		
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
					System.out.println();
		}
		return lugarObtenido;
	}
	public static String obtenerIntecionalidad(Scanner scan) {
		boolean escogido = false;
		String intencion = null;
		while(!escogido) {
			System.out.println("Escoja la opcion de la intencion con la obtiene el producto: ");
			System.out.println("1. " + OBRA_NEGRA);
			System.out.println("2. " + OBRA_BLANCA);
			System.out.println("3. " + OBRA_PINTURA);
			 
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: intencion = OBRA_NEGRA;
						
						
					escogido = true;
					break;
			case 2: intencion = OBRA_BLANCA;	
					
					escogido = true;
					break;
			case 3: intencion = OBRA_PINTURA;
					
					escogido = true;
					break;
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
			}
		}
		return intencion;
	}
	public static void compararProductos(Scanner scan, double[] listaHomcenter,double[] listaFerreteriBarrio,double[] listaFerreteriaCentro,String[] intencion,
	String[] nombres, double[] mejorPrecio,String[] LugarMejorPrecio,String[] casa) {
		System.out.println("Compara los productos:");
		System.out.println("Cuantos productos ingresaras para comparar?");
		
		int cantidad = Integer.parseInt(scan.nextLine());
		double[] HomeCenter = new double[cantidad];
		double[] FerreteriaCentro = new double[cantidad];
		double[] FerreteríaDelBarrio = new double[cantidad];
		String[] compararNombre = new String[cantidad];
		String[] compararIntencionalidad = new String[cantidad];
		
		double precioUnitario= 0;
		String lugar = obtenerLugar(scan );
		casa[0] = lugar;
		
		for(int i = 0; i<cantidad; i++) {
			
			compararIntencionalidad[i] =  obtenerIntecionalidad(scan);
			
			System.out.println("Ingrese el nombre del producto numero " + (i+1));	
			compararNombre[i] = scan.nextLine();
			nombres[i]= compararNombre[i];
			
			System.out.println("Cuantos unidades necesita del producto");
			int Unidades = Integer.parseInt(scan.nextLine());
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"En HomeCenter");
			precioUnitario = Double.parseDouble(scan.nextLine());
			HomeCenter[i] = precioUnitario * Unidades;
			listaHomcenter[i]= HomeCenter[i]; 
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferreteria del centro");
			precioUnitario = Double.parseDouble(scan.nextLine());
			FerreteriaCentro[i] = precioUnitario * Unidades;
			listaFerreteriaCentro[i]=FerreteriaCentro[i];
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferretería del barrio");
			precioUnitario = Double.parseDouble(scan.nextLine());
			FerreteríaDelBarrio[i] = precioUnitario * Unidades;
			listaFerreteriBarrio[i]= FerreteríaDelBarrio[i];
			
			
		}
		
		
		ComparacionValores(intencion ,compararIntencionalidad , HomeCenter , FerreteriaCentro , FerreteríaDelBarrio , compararNombre , nombres , mejorPrecio , cantidad , LugarMejorPrecio);
	}
	public static void ComparacionValores(String[] intencion ,String[] compararIntencionalidad,double[] HomeCenter, double[]FerreteriaCentro , double[] FerreteríaDelBarrio ,String[] compararNombre 
			, String[] nombres, double[] mejorPrecio , int cantidad,String[] LugarMejorPrecio) {
				
		double menorValor = 0;
		
		String HomeC = " en Homcenter";
		String Ferrec = " en Ferreteria centro ";
		String FerreB = "en Ferreteria del barrio";
		for (int i = 0; i < cantidad; i++) {
		if((HomeCenter[i] <= FerreteriaCentro[i]) &&(HomeCenter[i] <= FerreteríaDelBarrio[i]) && (HomeCenter[i] != 0)) {
				mejorPrecio[i]= HomeCenter[i];
				LugarMejorPrecio[i]= HomeC ;
				intencion[i]=compararIntencionalidad[i];
			}
			else
			{
				if((FerreteriaCentro[i]<= HomeCenter[i])&&(FerreteriaCentro[i]<=FerreteríaDelBarrio[i]) && (FerreteriaCentro[i] != 0 )){
					mejorPrecio[i]=FerreteriaCentro[i];
					LugarMejorPrecio[i]= Ferrec;
					intencion[i]=compararIntencionalidad[i];
				} 
				
				else
				{
					if((FerreteríaDelBarrio[i]<= HomeCenter[i])&&(FerreteriaCentro[i]>=FerreteríaDelBarrio[i]) && (FerreteríaDelBarrio[i] != 0)){
						mejorPrecio[i]=FerreteríaDelBarrio[i];
						LugarMejorPrecio[i]= FerreB;
						intencion[i]=compararIntencionalidad[i];
						
					}
				}
			}
		}
		
	}
	public static void mostrarEnPantalla ( Scanner scan,String[] nombres, double[] precios,
						String[] LugarMejorPrecio,String[] intencion,String[] casa ) {
		int x = 1;
		double costototal = 0;
		boolean completo = false;
		int manoDeObraNegra= 0;
		int manoDeObraBlanca= 0;
		int manoDeObraPintura= 0;
		int valorDomicilio = 0;
		
				
		System.out.println("Los mejores precios y sus puntos de venta son : ");
		for (int i = 0; i < precios.length && !completo; i++) {
			if(nombres[i] != null) {
				System.out.println( x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Lugar de compra " +LugarMejorPrecio[i] +"  "+  intencion[i]);
				x++;
			costototal = costototal + precios[i];
			}else {
				completo=true;
			}
		}
		if (casa[0] == "Norte"){
			if (costototal < 80000){
				valorDomicilio = 120000 ;
			}
			else if((costototal < 300000)&& (costototal>80000)){
				valorDomicilio = 28000 ;
			}
			else if(costototal >= 300000){
				valorDomicilio = 0 ;
			}
			
		}
		System.out.println("El costo de domicilio: "+ valorDomicilio);
		System.out.println("El costo de materiales es: "+ costototal);
		
		for (int i=0; i< intencion.length;i++){
			if(intencion[i]== "Obra negra" ){
				manoDeObraNegra = 1300000 ;
			}else{
				if(intencion[i]== "Obra blanca" ){
					manoDeObraBlanca = 2600000;
				}
				else{
					if (intencion[i]== "Obra pintura" )
					manoDeObraPintura = 980000;
			
				}
			}
			
		}
		costototal = costototal+manoDeObraBlanca+manoDeObraNegra+manoDeObraPintura;
		System.out.println("El costo total es : "+ costototal);
	}
	public static void mostrarEnPantallaObraNegra ( String[] nombres, String[] intencion ) {
		int x = 1;
		
		System.out.println("Los productos de la obra negra son:");
		for (int i = 0; i < intencion.length ; i++) {
			if( intencion[i] == OBRA_NEGRA) {
				System.out.println( x + ". Nombre: " + nombres[i] );
				x++;
			}
		}
	}
	public static void mostrarEnPantallaObraBlanca ( String[] nombres, String[] intencion ) {
		int x = 1;
		
		System.out.println("productos de la obra blanca son:");
		for (int i = 0; i < intencion.length; i++) {
			if( intencion[i] == OBRA_BLANCA) {
				System.out.println( x + ". Nombre: " + nombres[i]);
				x++;
			}
		}
	}
	public static void mostrarEnPantallaObraPintura( String[] nombres, String[] intencion ) {
		int x = 1;
		
		System.out.println("productos de  la obra pintura son:");
		for (int i = 0; i < intencion.length ; i++) {
			if( intencion[i] == OBRA_PINTURA) {
				System.out.println( x + ". Nombre: " + nombres[i] );
				x++;
			
			}
		}
	} 
	public static void ValoresHomecenter( String[] nombres,double[] listaHomcenter,String[] LugarMejorPrecio, String[] intencion ) {
		int x = 1;
		double costototal = 0;
		boolean completo = false;
		System.out.println("Lista de precios en HomeCenter:");
		for (int i = 0; i < listaHomcenter.length ; i++) {
			if(nombres[i] != null) {
			System.out.println( x + ". Nombre: " + nombres[i] + "  Valor:  "+ listaHomcenter[i] + " para : "+  intencion[i]);
				x++;
				costototal = costototal + listaHomcenter[i];
			}
		}
		System.out.println("El costo total en materiales en Homecenter es : " + costototal);
	}
	public static void ValoresFerreteriaBarrio( String[] nombres,double[] listaFerreteriBarrio,String[] LugarMejorPrecio,String[] intencion ) {
		int x = 1;
		double costototal = 0;
		
		System.out.println("Lista de precios en ferreteria del barrio :");
		for (int i = 0; i < listaFerreteriBarrio.length ; i++) {
			if(nombres[i] != null) {
			System.out.println( x + ". Nombre: " + nombres[i] + " Valor : "+ listaFerreteriBarrio[i] + " para : " + intencion[i]);
				x++;
				costototal = costototal + listaFerreteriBarrio[i];
			}
		}
		System.out.println("El costo total en materiales en ferreteria del barrio es : " + costototal);
	}
	public static void ValoresFerreteriaCentro( String[] nombres,double[] listaFerreteriaCentro,String[] LugarMejorPrecio, String[] intencion ) {
		int x = 1;
		double costototal = 0;
		boolean completo = false;
		System.out.println("Lista de precios en ferreteria del centro:");
		for (int i = 0; i < listaFerreteriaCentro.length ; i++) {
			if(nombres[i] != null) {
				System.out.println( x + ". Nombre: " + nombres[i] + " Valor"+ listaFerreteriaCentro[i] +" para:  "+  intencion[i]);
				x++;
				costototal = costototal + listaFerreteriaCentro[i];
			}
		}
		System.out.println("El costo total en materiales en ferreteria del centro es :" + costototal);
	}
	
	
}		