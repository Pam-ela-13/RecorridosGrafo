package grafosElvis;

public class Vertice {

	String nombre;

	int numVertice;

	

	//constructor 

	public Vertice (String x) {

		nombre=x;

		numVertice=-1;

	}

	//get

	public String numVertice () {//devuelve el identificador del vertice 

		return nombre;

	}

	public boolean equals (Vertice n) {//true, si dos vertices son iguales

		return nombre.equals(n.nombre);

	}

	public void asigVert(int n) {

		numVertice=n;

	}

	@Override

	public String toString() {//caracteristicas del vertice

		return  "Vertice [nombre=" + nombre + ", numVertice=" + numVertice + "]";

	}
}
