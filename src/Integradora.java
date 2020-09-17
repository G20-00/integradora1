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
		while(run) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Comparar una serie de productos y añadir a la lista el de menor precio.");
			System.out.println("2. Mostar lista en pantalla los mejores precios.");
			System.out.println("3. Mostrar mejores precios para obra negra.");
			System.out.println("4. Mostrar mejores precios para obra blanca.");
			System.out.println("5. Mostrar mejores precios para obra pintura.");
			System.out.println("6. Finalizar programa.");
			
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: compararProductos(scan, intencion , nombres, mejorPrecio,LugarMejorPrecio);
					break;
			case 2: mostrarEnPantalla( nombres, mejorPrecio,LugarMejorPrecio,intencion);					
					System.out.println();
					break;
			case 3: 	mostrarEnPantallaObraNegra( nombres, mejorPrecio,LugarMejorPrecio,intencion);
					System.out.println();
					break;
			case 4: mostrarEnPantallaObraBlanca( nombres, mejorPrecio,LugarMejorPrecio,intencion);
					System.out.println();
					break;
			case 5: mostrarEnPantallaObraPintura( nombres, mejorPrecio,LugarMejorPrecio,intencion);
					System.out.println();
					break;		
					
			case 6: run = false;
					System.out.println("BYE BYE");
					break;
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
					System.out.println();
			}
		}
		
	
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
	public static void compararProductos(Scanner scan,String[] intencion, String[] nombres, double[] mejorPrecio,String[] LugarMejorPrecio) {
		System.out.println("Compara los productos:");
		System.out.println("Cuantos productos ingresaras para comparar?");
		
		int cantidad = Integer.parseInt(scan.nextLine());
		double[] HomeCenter = new double[cantidad];
		double[] FerreteriaCentro = new double[cantidad];
		double[] FerreteríaDelBarrio = new double[cantidad];
		String[] compararNombre = new String[cantidad];
		String[] compararIntencionalidad = new String[cantidad];
		double precioUnitario= 0;
		for(int i = 0; i<cantidad; i++) {
			System.out.println("Ingrese el nombre del producto numero " + (i+1));	
			compararNombre[i] = scan.nextLine();
			nombres[i]= compararNombre[i];
			
			System.out.println("Cuantos unidades necesita del producto");
			int Unidades = Integer.parseInt(scan.nextLine());
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"En HomeCenter");
			precioUnitario = Double.parseDouble(scan.nextLine());
			HomeCenter[i] = precioUnitario * Unidades;
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferreteria del centro");
			precioUnitario = Double.parseDouble(scan.nextLine());
			FerreteriaCentro[i] = precioUnitario * Unidades;
			
			System.out.println("Ingrese el precio del producto numero " + (i+1) +"Ferretería del barrio");
			precioUnitario = Double.parseDouble(scan.nextLine());
			FerreteríaDelBarrio[i] = precioUnitario * Unidades;
			
			
			compararIntencionalidad[i] =  obtenerIntecionalidad(scan);
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
			if((HomeCenter[i] < FerreteriaCentro[i]) &&(HomeCenter[i] < FerreteríaDelBarrio[i])) {
				mejorPrecio[i]= HomeCenter[i];
				LugarMejorPrecio[i]= HomeC ;
				intencion[i]=compararIntencionalidad[i];
			}
			else
			{
				if((FerreteriaCentro[i]< HomeCenter[i])&&(FerreteriaCentro[i]<FerreteríaDelBarrio[i])){
					mejorPrecio[i]=FerreteriaCentro[i];
					LugarMejorPrecio[i]= Ferrec;
					intencion[i]=compararIntencionalidad[i];
				} 
				
				else
				{
					if((FerreteríaDelBarrio[i]< HomeCenter[i])&&(FerreteriaCentro[i]>FerreteríaDelBarrio[i])){
						mejorPrecio[i]=FerreteríaDelBarrio[i];
						LugarMejorPrecio[i]= FerreB;
						intencion[i]=compararIntencionalidad[i];
						
					}
				}
			}
		}
		
	}
	public static void mostrarEnPantalla ( String[] nombres, double[] precios,String[] LugarMejorPrecio,String[] intencion ) {
		int x = 1;
		boolean completo = false;
		System.out.println("Los mejores precios y sus puntos de venta son:");
		for (int i = 0; i < precios.length && !completo; i++) {
			if(nombres[i] != null) {
				System.out.println(x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Lugar de compra " +LugarMejorPrecio[i] +"  "+  intencion[i]);
				x++;
			}else {
				completo=true;
			}
		}
	}
	public static void mostrarEnPantallaObraNegra ( String[] nombres, double[] precios,String[] LugarMejorPrecio,String[] intencion ) {
		int x = 1;
		boolean completo = false;
		System.out.println("Los mejores precios la obra negra son:");
		for (int i = 0; i < precios.length && !completo; i++) {
			if( intencion[i] == OBRA_NEGRA) {
				System.out.println(x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Lugar de compra " +LugarMejorPrecio[i] +"  "+  intencion[i]);
				x++;
			}else {
				completo=true;
			}
		}
	}
	public static void mostrarEnPantallaObraBlanca ( String[] nombres, double[] precios,String[] LugarMejorPrecio,String[] intencion ) {
		int x = 1;
		boolean completo = false;
		System.out.println("Los mejores precios la obra blanca son:");
		for (int i = 0; i < precios.length && !completo; i++) {
			if( intencion[i] == OBRA_BLANCA) {
				System.out.println(x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Lugar de compra " +LugarMejorPrecio[i] +"  "+  intencion[i]);
				x++;
			}else {
				completo=true;
			}
		}
	}
	public static void mostrarEnPantallaObraPintura( String[] nombres, double[] precios,String[] LugarMejorPrecio,String[] intencion ) {
		int x = 1;
		boolean completo = false;
		System.out.println("Los mejores precios la obra pintura son:");
		for (int i = 0; i < precios.length && !completo; i++) {
			if( intencion[i] == OBRA_PINTURA) {
				System.out.println(x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Lugar de compra " +LugarMejorPrecio[i] +"  "+  intencion[i]);
				x++;
			}else {
				completo=true;
			}
		}
	} 
}		