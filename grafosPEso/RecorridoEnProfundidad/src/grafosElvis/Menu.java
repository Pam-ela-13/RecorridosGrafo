package grafosElvis;
import java.util.Scanner;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GrafoMatriz grafo = new GrafoMatriz();

		// Menú para el grafo
		int opcion;
		do {
			System.out.println("=== Menú del Grafo ===");
			System.out.println("1. Agregar vértice");
			System.out.println("2. Agregar arco");
			System.out.println("3. Recorrer en Profundidad (DFS)");
			System.out.println("4. Recorrer en Anchura ");
			System.out.println("5. Encontrar camino mínimo desde un vértice (Dijkstra)");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea

			switch (opcion) {
			case 1:
				if (grafo.numeroDeVertices() < 20) {
					System.out.print("Ingrese el nombre del vértice a agregar: ");
					String nombreVertice = scanner.nextLine();
					grafo.nuevoVertice(nombreVertice);
					System.out.println("Vértice agregado correctamente.");
				} else {
					System.out.println("No se pueden agregar más vértices. Límite de 20 alcanzado.");
				}
				break;
			case 2:
				System.out.print("Ingrese el nombre del vértice de inicio del arco: ");
				String inicioArco = scanner.nextLine();
				System.out.print("Ingrese el nombre del vértice de destino del arco: ");
				String destinoArco = scanner.nextLine();
				try {
					grafo.nuevoArco(inicioArco, destinoArco);
					System.out.println("Arco agregado correctamente.");
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 3:
				System.out.print("Ingrese el nombre del vértice de origen para recorrer en Profundidad: ");
				String origenDFS = scanner.nextLine();
				try {
					int[] marcadosDFS = RecorrerGrafo.recorrerProf(grafo, origenDFS);

					System.out.println("Marcados en el recorrido en Profundidad:");
					for (int i = 0; i < marcadosDFS.length; i++) {
						if (marcadosDFS[i] != -1) {
							System.out.println("Vértice " + grafo.verts[i] + " visitado");
						}
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;
			case 4:
				System.out.print("Ingrese el nombre del vértice de origen para recorrer en Anchura: ");
				String origenBFS = scanner.nextLine();
				try {
					int[] marcadosBFS = RecorrerGrafo.recorrerAnchura(grafo, origenBFS);

					System.out.println("Marcados en el recorrido en Anchura:");
					for (int i = 0; i < marcadosBFS.length; i++) {
						if (marcadosBFS[i] != RecorrerGrafo.CLAVE) {
							System.out.println("Vértice " + grafo.verts[i] + " visitado con " + marcadosBFS[i] + " arcos");
						}
					}
				} catch (Exception e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			case 5:
				System.out.print("Ingrese el nombre del vértice de origen para encontrar el camino mínimo: ");
				String origenDijkstra = scanner.nextLine();
				int origenIndex = grafo.numVertice(origenDijkstra);
				if (origenIndex >= 0) {
					CaminoMinimo caminoMinimo = new CaminoMinimo(new GrafoMatriz(), origenIndex);
					caminoMinimo.caminoMinimos();
					int[] distancias = caminoMinimo.getDistancias();
					System.out.println("Camino mínimo encontrado desde el vértice " + grafo.verts[origenIndex] + ":");
					for (int i = 0; i < distancias.length; i++) {
						if (distancias[i] == CaminoMinimo.INFINITO) {
							System.out.println("No hay camino al vértice " + grafo.verts[i]);
						} else {
							System.out.println("Distancia al vértice " + grafo.verts[i] + ": " + distancias[i]);
						}
					}
				} else {
					System.out.println("Vértice no encontrado.");
				}
				break;

			case 6:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida.");
			}

			System.out.println();
		} while (opcion != 6);

		scanner.close();
	}
}
