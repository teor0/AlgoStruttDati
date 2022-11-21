package backtracking;

public abstract class ProblemaBack {

	public ProblemaBack() {
	}

	//il parametro liv corrisponde al punto di scelta in un certo momento
	public boolean risolvi(int l){
		if(!primaScelta(l)) //se non si può fare un assegnamento al livello corrente si ritorna false
			return false;
		 while (true) {
			if(verificaVincoli(l)){ //verifico i vincoli dopo la prima scelta
				if(solCompleta(l)){ //se la soluzione è completa allora si costruisce
					costruisciSoluzione(l);
					return true;
				}
				if(risolvi(l+1)) //passiamo alla prossima posizione per completare la soluzione
					return true;
			}
			if(!successivaScelta(l)) //se ritorna false allora abbiamo finito di esplorare l'albero e non ci sono soluzioni
		 		return false;
		 }
		 
	}

	
	public boolean risolvi(){
		int liv = 0;
		boolean rivedi = false; //variabile per tornare indietro. se true ho finito le scelte
		if (!primaScelta(liv)) //si prova la prima scelta
			return false;
		while (liv >=0){
			if(verificaVincoli(liv)){
				if(solCompleta(liv)) {
					costruisciSoluzione(liv);
					return true;
				}
				liv++; //aumento il livello se non trovo una soluzione e richiamo prima scelta
				if(!primaScelta(liv)){
					rivedi= true;
				}
			}
			else{ //se i vincoli non sono soddisfatti non avanzo di livello ma provo a fare una scelta diversa sul livello corrente
				if(!successivaScelta(liv)){
					rivedi = true;
				}
			}
			while(rivedi&& liv>=0){ //blocco per ritornare indietro
				liv--;
				if(liv>=0 && successivaScelta(liv))
					rivedi= false;
			}
		}
		return false;
	}
	
	protected abstract boolean successivaScelta(int liv); //prova ad assegnare una scelta


	protected abstract boolean solCompleta(int liv); //fine dell'algoritmo


	protected abstract boolean verificaVincoli(int liv); //verifica se i vincoli sono soddisfatti


	protected abstract boolean primaScelta(int liv); //prova ad assegnare la prima scelta
	
	protected abstract void costruisciSoluzione(int liv);


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
