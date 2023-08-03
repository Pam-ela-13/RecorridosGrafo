package grafosElvis;

public class GrafoMatPeso extends GrafoMatriz {

	private static final int INFINITO = Integer.MAX_VALUE;

	int[][] matPeso;

    public GrafoMatPeso() {
        this(MaxVerts);
    }

    public GrafoMatPeso(int mx) {
        super(mx);
        matPeso = new int[mx][mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matPeso[i][j] = INFINITO;
            }
        }
    }

    public void nuevoArco(int va, int vb, int peso) throws Exception {
        super.nuevoArco(va, vb);
        matPeso[va][vb] = peso;
    }
/*
    public void nuevoArco(String a, String b, int peso) throws Exception {
        int va = numVertice(a);
        int vb = numVertice(b);
        if (va < 0 || vb < 0)
            throw new Exception("Vértice no existe");
        nuevoArco(va, vb, peso);
    }
    */
   

}