package tracce;

import alberi.AlberoBin;

public class Esercitazione7 {
    

    /*scrivere un metodo che restituisce true se esiste almeno un cammino dalla radice ad una foglia e la media dei valori
     * sul cammino è maggiore di x
    */

    public static boolean camminoMedia(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        return supportoCamminoMedia(a, x, 0, 0);
    }

    private static boolean supportoCamminoMedia(AlberoBin<Integer> a, int x, int sum, int c ){
        if(a==null)
            return false;
        sum+=a.val();
        c+=1;
        if(a.sin()==null && a.des()==null)
            return (sum/c) >x;
        return supportoCamminoMedia(a.sin(), x,sum,c) ||supportoCamminoMedia(a.des(), x, sum, c);
    }

    /*
     * CTM è quando la radice ha un figlio sinistro foglia e la media tra essi è maggiore di x quindi theta(1)
     * CTP è quando non ho nessun cammino che soddisfa la condizione theta(n)
     * CSM è quando mi trovo in CTM quindi il costo relativo alle chiamate ricorsive non dipende dal numero di nodi dell'albero
     * theta(1)
     * CSP è quando l'albero degenera a lista quindi avrò un numero di chiamate pari ai nodi dell'albero quindi theta(n)
     */ 


     /*scrivere un metodo che ritorna true se la foglia a minor profondità appare ad un livello minore di l */

     public static boolean fogliaMinoreProfondita(AlberoBin<Integer> a, int l, int lc){
        if(a==null || lc>=l)
            return false;
        if(a.sin()==null && a.des()==null && lc<l)
            return true;
        return fogliaMinoreProfondita(a.sin(), l, lc+1) || fogliaMinoreProfondita(a.des(), l,lc+1);
     }

}
