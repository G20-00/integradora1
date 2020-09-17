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
		double[] precios = new double[CANTIDAD_MAXIMA];
		while(run) {
			System.out.println("Escoja una opcion:");
			System.out.println("1. Comparar una serie de productos y añadir a la lista el de menor precio.");
			System.out.println("2. Mostar lista en pantalla.");
			System.out.println("3. Finalizar programa.");
			
			int opcion =  Integer.parseInt(scan.nextLine());
			switch(opcion) {
			case 1: compararProductos(scan, nombres, precios);
					break;
			case 2: mostrarEnPantalla( nombres, precios);
					System.out.println();
					break;
			case 3: run = false;
					System.out.println("BYE BYE");
					break;
			default:System.out.println("Opcion no valida, por favor escoja una opcion correcta.");
					System.out.println();
			}
		}
		
	
	}	
	public static void compararProductos(Scanner scan, String[] nombres, double[] precios) {
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
			
			
			//compararIntencionalidad[i] =  obtenerIntecionalidad(scan);
		}
		
		add(HomeCenter , FerreteriaCentro , FerreteríaDelBarrio , compararNombre , nombres , precios , cantidad);
	}
	public static void add(double[] HomeCenter, double[]FerreteriaCentro , double[] FerreteríaDelBarrio ,String[] compararNombre 
			, String[] nombres, double[] precios , int cantidad) {
				
		double[] menorValor = new double[cantidad];
		int posicionMenor=0;
		
		for (int i = 0; i < cantidad; i++) {
			if((HomeCenter[i] < FerreteriaCentro[i]) &&(HomeCenter[i] < FerreteríaDelBarrio[i])) {
				menorValor[i]=HomeCenter[i];
			}
			else
			{
				if((FerreteriaCentro[i]< HomeCenter[i])&&(FerreteriaCentro[i]<FerreteríaDelBarrio[i])){
					menorValor[i]=FerreteriaCentro[i];
				} 
				else
				{
					if((FerreteríaDelBarrio[i]< HomeCenter[i])&&(FerreteriaCentro[i]>FerreteríaDelBarrio[i])){
						menorValor[i]=FerreteríaDelBarrio[i];
					}
				}
			}
		}
		
	}
	public static void mostrarEnPantalla ( String[] nombres, double[] precios ) {
		int x = 1;
		boolean completo = false;
		for (int i = 0; i < precios.length && !completo; i++) {
			if(nombres[i] != null) {
				System.out.println(x + ". Nombre: " + nombres[i] + ". Precio: " + precios[i] + " Intencion: " );
				x++;
			}else {
				completo=true;
			}
		}
	}
}		