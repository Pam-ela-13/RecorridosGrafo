package grafosElvis;
import java.util.LinkedList;
import java.util.Deque;
public class RecorrerGrafo {

	

	public static final int CLAVE = -1;

	public static int[] recorrerAnchura(GrafoMatriz g, String org) throws Exception {
	    int w, v;
	    int[] m;
	    v = g.numVertice(org);
	    if (v < 0)
	        throw new Exception("Vértice origen no existe");
	    
	    Deque<Integer> pila = new LinkedList<>();
	    m = new int[g.numeroDeVertices()];
	    // inicializa los vértices como no marcados
	    for (int i = 0; i < g.numeroDeVertices(); i++)
	        m[i] = CLAVE;
	    m[v] = 0; // vértice origen queda marcado
	    pila.push(v);
	    
	    while (!pila.isEmpty()) {
	        Integer cw;
	        cw = pila.pop();
	        w = cw.intValue();
	        System.out.println("Vértice " + g.verts[w] + " visitado");
	        // inserta en la pila los adyacentes de w no marcados
	        for (int u = 0; u < g.numeroDeVertices(); u++) {
	            if ((g.matAd[w][u] == 1) && (m[u] == CLAVE)) {
	                // se marca vertice u con número de arcos hasta el
	                m[u] = m[w] + 1;
	                pila.push(u);
	            }
	        }
	    }
	    return m;
	}
	
	public static int[] recorrerProf(GrafoMatriz g, String org) throws Exception {
	    int v, w;
	    Deque<Integer> pila = new LinkedList<>();
	    int[] m;
	    m = new int[g.numeroDeVertices()];
	    // inicializa los vértices como no marcados
	    v = g.numVertice(org);
	    if (v < 0) throw new Exception("Vértice origen no existe");
	    for (int i = 0; i < g.numeroDeVertices(); i++)
	        m[i] = CLAVE;
	    m[v] = 0; // vértice origen queda marcado
	    pila.push(v);
	    while (!pila.isEmpty()) {
	        Integer cw;
	        cw = pila.pop();
	        w = cw.intValue();
	        System.out.println("Vértice " + g.verts[w] + " visitado");
	        // inserta en la pila los adyacentes de w no marcados
	        for (int u = 0; u < g.numeroDeVertices(); u++) {
	            if (g.matAd[w][u] == 1 && m[u] == CLAVE) {
	                pila.push(u);
	                m[u] = 1; // vértice queda marcado
	            }
	        }
	    }
	    return m;
	}
}

