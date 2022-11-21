package tracce;
import alberi.*;
/**
 * @author matteo.orlando
 */
public class Esercitazione3 {
    

    /*scrivere un metodo che dato una albero binario, ritorna true se
     * tutti i nodi foglia abbiano un valore > di un intero k
     */

    public static boolean foglieMaggiori(AlberoBin<Integer> a, int k){
        if(a==null)
            return true; //se sono su un albero vuoto non ho foglie da valutare quindi restituisco true!
            //si capisce anche perché se ho 2 foglie ed una è null allora la return finale restituisce sempre false
            //indipendentemente dal fatto che l'altra foglia sia >=k o meno
        else if(a.sin()==null && a.des()==null)
            return a.val()>k;
        return foglieMaggiori(a.sin(), k) && foglieMaggiori(a.des(), k);
    }
    /* CTM è quando il figlio sinistro della radice è una foglia con valore <= k 
     * quindi dico subito che la proprietà non è valida e il caso migliore temporale è:
     * theta(1)
     * CSM il numero di chiamate ricorsive sullo stack è una nel caso migliore e non alloca nulla che dipende dai nodi
     * in più la singola chiamata ha costo costante quindi possiamo dire che la complessità spaziale migliore è:
     * theta(1) 
     */

     /* CTP è quando tutte le foglie sono >k quindi andrò ad iterare tutti i nodi perciò:
      * theta(n)
      * CSP è quando l'albero è degenere (ovvero diventa una lista) quindi
      * il numero di chiamate attive sarà proprio il numero di nodi perciò:
      * theta(n)
      */

      /*scrivere un metodo che dato un albero binario, ritorna il cammino con costo massimo, dato dalla somma dei valori
       * dei nodi che vengono attraversati, dalla radice ad una foglia
       */

       public static int camminoMassimo(AlberoBin<Integer> a){
        //radice vuota o nodo nullo
        if(a==null)
            return 0;
        return a.val()+Math.max(camminoMassimo(a.sin()),camminoMassimo(a.des()));
       }
       /* caso migliore e peggiore temporale devo comunque esaminare i nodi per calcolare il costo del cammino
        * theta(n)
        * CSM è quando l'albero è bilanciato quindi si hanno chiamata attive sulle foglie perciò
        * theta(log n)
        * CSP è quando l'albero è degenere quindi si hanno n chiamate attive perciò
        * theta(n)
        */



}
