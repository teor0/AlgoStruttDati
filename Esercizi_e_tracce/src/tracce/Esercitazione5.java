package tracce;

import alberi.ABR;
import alberi.AlberoBin;

public class Esercitazione5 {

    /*scrivere un metodo che ritorna true se tutte le foglie hanno un valore uguale a quello della radice */

    public static boolean analizzaFoglie(AlberoBin a){
        if(a==null)
            return true;
        return analizza(a,a.val());
    }

    private static boolean analizza(AlberoBin a, Object radice){
        if(a==null)
            return true; //non ho foglie di fatto la proprietà è soddisfatta
        if(a.sin()==null && a.des()==null)
            return a.val().equals(radice);
        return analizza(a.sin(), radice) && analizza(a.des(), radice);
    }

    /*CTM è quando ho subito una foglia come figlio sinistro che non ha valore uguale alla radice quindi theta(1) 
     * CTP è quando devo esaminare tutti i nodi quindi ho theta(n)
     * CSM è quando si verifica il caso migliore temporale ed ho numero di chiamate costante quindi theta(1)
     * CSP è quando ho un albero albero degenere quindi ho altezza pari ad n e n chiamate perciò theta(n)
    */

    /*dato un ABR di interi, l e u contare il numero di nodi che hanno valore x tale che l<x<u */

    public static int conteggioNodi(ABR<Integer> a, int l, int u){
        if(a==null)
            return 0;
        if(a.val()<=l)//se ho radice minore di l è inutile andare a sinistra essendo un ABR
            return conteggioNodi(a.des(), l, u);
        if(a.val()>=u)//se ho radice maggiore di u è inutile andare a destra essendo un ABR
            return conteggioNodi(a.sin(), l, u);
        return 1+conteggioNodi(a.sin(), l, u) +conteggioNodi(a.des(), l, u);
    }

    /* CTP è quando tutti i nodi sono da contare quindi theta(n)
     * CTM è quando la radice è >= u quindi esamino solo il sottoalbero sinistro che contiene solo un nodo quindi theta(1)
     * caso simile quello speculare in cui la radice è <= di l
     * CSM se mi trovo nel CTM ho che le chiamate da fare sono costanti quindi theta(1)
     * CSP ho un ABR degenere ED IN PIU ho valori di l ed u che permettono di avere tutti i nodi nel range
     */
    
}
