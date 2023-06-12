package battleShip;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Menu {
	public static int menu() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.printf("\n"
						+"______Batalla Naval 4K______\n"
						+"****************************"
						+ "\n[1]\tJugar"
						+ "\n[2]\tMejor Puntaje"
						+ "\n[3]\tSalir\n"
						+ "\n"
						+"****************************"
						+"\n"
						+"----------------------------"
						+"\n");
				
				opcion = Integer.parseInt(sc.nextLine().trim());			
				if (opcion == 1 || opcion == 2 ) {
//					sc.close();
					return opcion;
				}
			} catch (Exception e) {
				System.out.println("Opción inválida.");
			}
		} while( opcion != 3 );
		System.out.println("Bye-bye Marinero");
//		sc.close();
		return 3;
	}
	
	public static void mostrarTop(){
		HashMap<String, Integer> top = new HashMap<String, Integer>();	
		top = cargarTop();
		for (String i : top.keySet()) {
			System.out.println("*********************************");
			System.out.println("*\t"+i + "\t|\t" + top.get(i)+"\t*");
		}
		System.out.println("*********************************");
	}
	
	public static HashMap<String, Integer> cargarTop(){
		HashMap<String, Integer> top = new LinkedHashMap();
		top.put("SAN", 20);
		top.put("CJR", 25);
		top.put("AAA", 30 );
		top.put("BBB", 35 );
		top.put("FBS", 64 );
		
		return top;
		
		// ~ revisar inserciones en reemplazo de elementos
		// - yo digo que se guarden en un txt
		// ~ sí sí, muy buena idea
		// - gracias *se sonroja*
	}
	
}
