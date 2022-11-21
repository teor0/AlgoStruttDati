/**
 * 
 */
package backtracking;

import java.util.Arrays;

import grafi.*;

/**
 * @author sflesca
 *
 */

 //versione per il problema con grafi orientati
 //obiettivo è trovare un sottoinsieme di k nodi che è una cricca del grafo
 //per cricca si intende un insieme di nodi tale per cui ogni nodo è collegato con tutti gli altri con archi entranti ed uscenti
public class Cricca extends ProblemaBack {
	
	protected int[] nodes;
	protected Grafo g;

	/**
	 * 
	 */
	public Cricca(Grafo g, int k) {
		this.g=g;
		nodes = new int[k]; //vettore soluzione di dimensione k
	}

	//le scelte sono i nodi del grafo, i punti di scelta sono i k nodi che cerchiamo

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#successivaScelta(int)
	 */
	@Override
	protected boolean successivaScelta(int liv) {
		if (nodes[liv]>=g.getN()-1)	return false;
		nodes[liv]++;
		return true;
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#solCompleta(int)
	 */
	@Override
	protected boolean solCompleta(int liv) {
		return liv==nodes.length-1; //se la cricca è piena ho la soluzione
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#verificaVincoli(int)
	 */
	@Override
	protected boolean verificaVincoli(int liv) {
		System.out.println("VERIFICAVINCOLI"+Arrays.toString(nodes)+" LIV:"+liv);
		for(int i=0; i<liv; i++)
			if(!g.arco(nodes[i], nodes[liv])) //verifico che il nodo aggiunto al livello l sia collegato con tutti gli altri
				return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#primaScelta(int)
	 */
	@Override
	protected boolean primaScelta(int liv) {
		//proviamo ad assegnare i nodi alla cricca in ordine dei loro indici evitando soluzioni con ordine diverso
		if(liv==0){
			nodes[liv]=0;
			return true;
		}
		if (nodes[liv-1]>=g.getN()-1) return false;
		nodes[liv]=nodes[liv-1]+1;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo<Arco> g = new GrafoMA<Arco>(7);
		g.aggiungiArco(new Arco(0,6));
		g.aggiungiArco(new Arco(6,0));
		g.aggiungiArco(new Arco(0,5));
		g.aggiungiArco(new Arco(5,0));
		g.aggiungiArco(new Arco(5,6));
		g.aggiungiArco(new Arco(6,5));
		g.aggiungiArco(new Arco(0,4));
		g.aggiungiArco(new Arco(4,0));
		g.aggiungiArco(new Arco(2,1));
		g.aggiungiArco(new Arco(1,2));
		
		Cricca c = new Cricca(g,3);
		System.out.println("Esiste:"+c.risolvi());
		System.out.println(Arrays.toString(c.nodes));
	}

	@Override
	protected void costruisciSoluzione(int liv) {
		// TODO Auto-generated method stub
		return;
	}

}
