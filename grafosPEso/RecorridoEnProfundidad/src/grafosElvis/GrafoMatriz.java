package grafosElvis;

import java.util.List;
import java.util.ArrayList;

public class GrafoMatriz {

	int numVerts;

	static int MaxVerts = 20; 

	Vertice [] verts;

	int [][] matAd;

	//CONSTRUCTORES



	public GrafoMatriz() {

		this( MaxVerts);

	}

	//

	public GrafoMatriz(int mx)

	{

		matAd = new int [mx][mx];//matAd es la matriz cuadrada de el numero que iresa en (mx)

		verts = new Vertice[mx];//columna de vertices

		for (int i = 0; i < mx; i++)//El for recorre la matriz y llena de ceros la matriz

			for (int j = 0; i < mx; i++)

				matAd[i][j] = 0;

		numVerts = 0;

	}

	//AGREAR UN NUEVO VERTICE AL GRAFO

	public void nuevoVertice (String nom)

	{

		boolean esta = numVertice(nom) >= 0;

		if (!esta) 

		{

			Vertice v = new Vertice(nom); 

			v.asigVert(numVerts);

			verts[numVerts++] = v;

		}

	}

	//OBTENER EL INDICE DEL VERTICE EN EL ARREGLO

	int numVertice(String vs)

	{

		Vertice v = new Vertice(vs);

		boolean encontrado = false;

		int i = 0;

		for (; (i < numVerts) && !encontrado;)

		{

			encontrado = verts[i].equals(v);

			if (!encontrado) i++ ; 

		}

		return (i < numVerts) ? i : -1 ;

	}

	//AÑADIR UNA NUEVA ARISTA ENTRE DOS VERTICES POR SU NOMBRE

	public void nuevoArco(String a, String b)throws Exception

	{

		int va, vb;

		va = numVertice(a);

		vb = numVertice(b);

		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");//PORQUE PREGUNTA SI ES MENOR QUE CERO= CUANDO YA EXITEN VAN A TENER UN VALOR ENTRE 0 A 1 Y SI ES NEGATICO NO ESTA

		matAd[va][vb] = 1;//LE AGREGA UNO AL MATRIZ DE ADYACENCIA

	}



	//AGREGAR UNA NUEVA ARISTA ENTRE DOS VERTICES POR SU INDICE

	public void nuevoArco(int va, int vb)throws Exception

	{

		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");

		matAd[va][vb] = 1;

	}



	//VERIFICAR SI DOS VERTICES POR SUS NOMBRES SON ADYACENTES

	public boolean adyacente(String a, String b)throws Exception

	{

		int va, vb;

		va = numVertice(a);

		vb = numVertice(b);

		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");//Todos los metodos que tengan thows obligados deben de estar dentro de try cash en la implementacion(clase main)

		return matAd[va][vb] == 1;

	}

	public boolean adyacente(int va, int vb)throws Exception

	{

		if (va < 0 || vb < 0) throw new Exception ("Vértice no existe");

		return matAd[va][vb] == 1;

	}



	public List<Vertice> verticesAdyacentes(int indiceVertice) throws Exception {

		if (indiceVertice < 0 || indiceVertice >= numVerts) throw new Exception("Vértice no existe");



		List<Vertice> verticesAdyacentes = new ArrayList<>();

		for (int i = 0; i < numVerts; i++) {

			if (matAd[indiceVertice][i] == 1) {

				verticesAdyacentes.add(verts[i]);

			}

		}

		return verticesAdyacentes;

	}

	public int numeroDeVertices() {
	    return numVerts;
	}





}