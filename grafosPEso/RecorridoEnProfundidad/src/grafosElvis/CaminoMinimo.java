package grafosElvis;

import java.util.Arrays;



public class CaminoMinimo {
    private int[][] Pesos;
    private int[] D;
    private boolean[] F;
    private int n; // número de vértices
    private int s; // vértice origen

    public static final int INFINITO = Integer.MAX_VALUE;

    public CaminoMinimo(GrafoMatriz gp, int origen) {
        n = gp.numeroDeVertices();
        s = origen;
        Pesos = gp.matAd;
        D = new int[n];
        F = new boolean[n];
    }

    public void caminoMinimos() {
        // valores iniciales
        Arrays.fill(D, INFINITO);
    //    D[s] = 0; // Establecer la distancia del vértice de origen a sí mismo en 0

        for (int i = 0; i < n; i++) {
            int v = minimo();
            F[v] = true;
            for (int w = 0; w < n; w++) {
                if (!F[w] && Pesos[v][w] != INFINITO) {
                    if (D[v] + Pesos[v][w] < D[w]) {
                        D[w] = D[v] + Pesos[v][w];
                    }
                }
            }
        }
    }

    private int minimo() {
        int min = INFINITO;
        int v = 0;
        for (int i = 0; i < n; i++) {
            if (!F[i] && D[i] < min) {
                min = D[i];
                v = i;
            }
        }
        return v;
    }

    public int[] getDistancias() {
        return D;
    }
}
