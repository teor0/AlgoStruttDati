package daEserciziari;
import alberi.*;
/**
 * @author matteo.orlando
 */
public class Tranche1 {
    
    public Tranche1(){}


    /*scrivere un metodo che ritorna true se tutte le foglie sono pari */
    public static boolean fogliePari(AlberoBin<Integer> a){
        if(a==null)
            return true; //in quanto non ci sono nodi foglia su cui verificare la condizione
        else if(a.sin()==null && a.des()==null)
            return a.val()%2==0;
        return fogliePari(a.sin()) && fogliePari(a.des());
    }

    /* CTM ho subito una foglia come figlio sinistro che è dispari quindi il costo è pari a theta(1)
     * CSM ho chiamate costanti attive sullo stack quindi theta(1)
     * CTP devo esaminare tutte le foglie di un albero perciò nel caso peggiore ho costo theta(n)
     * CSP ho n chiamate sullo stack ipotizzando un albero degenere quindi theta(n)
     */


    /*scrivere un metodo che ritorna true se l'albero B è contenuto in A */
    public static boolean eContenuto(AlberoBin<Integer> a, AlberoBin<Integer> b){
        if(a==null || b==null)
            return true;
        return ricerca(a,b.val()) && eContenuto(a, b.sin()) && eContenuto(a, b.des());
        //cerco il nodo a partire dalla radice e faccio lo stesso per i figli fino ad ricercare tutto l'albero
    }

    private static boolean ricerca(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;//non ho trovato il nodo quindi restituisco false
        //ritorno true se il nodo che sto valutando è quello che voglio altrimenti cerco a destra o sinistra
        return a.val()==x || ricerca(a.sin(), x) || ricerca(a.des(), x);
    }

    /* CTM è quando la radice di B non è contenuta quindi dopo aver scandito A si finisce quindi theta(n)
     * CTP è quando l'albero è contenuto quindi scandisco sia A che B si ha perciò theta(n*m)
     * CSM è quando ho un albero bilanciato e le chiamate sono proporzionali all'altezza di A theta(log n)
     * CSP è quando ho alberi degeneri quindi ho chiamate attive massime pari a theta(n*m)
    */



    /*scrivere un metodo che ritorna true se l'albero A è vuoto oppure se il valore della radice non è contenuto in altri nodi */
    public static boolean nonRipetutoNullo(AlberoBin<Integer> a){
        if(a==null)
            return true;
        return nonCompare(a.des(),a.val()) && nonCompare(a.sin(),a.val());
    }

    private static boolean nonCompare(AlberoBin<Integer> a, int x){
        if(a==null)
            return true;//nodo nullo quindi non ho trovato il valore della radice
        return a.val()!=x && nonCompare(a.sin(), x) && nonCompare(a.des(), x);   
    }

    /* CTM ho subito che il figlio sinistro della radice è uguale alla radice theta(1)
     * CTP devo scandire tutto l'albero e non trovo valori pari a quello della radice theta(n)
     * CSM ho chiamate costanti essendo nel CTM quindi theta(1)
     * CSP mi trovo in un albero degenere e vado a scandire tutti nodi quindi avrò theta(n)
    */



    /*scrivere un metodo che ritorna true se e solo se l'albero A e B sono identici */
    public static boolean identici(AlberoBin a, AlberoBin b){
        if(a==null && b==null)
            return true;
        else if(a==null ||  b==null)
            return false;
        return a.val().equals(b.val()) && identici(a.sin(), b.sin()) && identici(a.des(), b.des());
    }

    /* CTM radici sono diverse quindi ho theta(1)
     * CTP gli alberi sono identici quindi scandisco A e B assieme quindi avrò theta(n)
     * CSM è quando sono nel CTM quindi avrò theta(1)
     * CSP è quando ho alberi degeneri identici quindi avrò theta(n)
    */

    /*scrivere un metodo che restituisce true se tutte le foglie di A contengono un valore del albero B */
    public static boolean analizzaFoglie(AlberoBin<Integer> a, AlberoBin<Integer> b){
        if(a==null)
            return true;
        if(a.sin()==null && a.des()==null)
            return supporto(b,a.val());
        return analizzaFoglie(a.sin(),b) && analizzaFoglie(a.des(),b);
    }

    private static boolean supporto(AlberoBin<Integer> b, int x){
        if(b==null)
            return false;
        return b.val()==x || supporto(b.sin(), x) || supporto(b.des(), x);
    }

    /* CTM è quando il figlio sinistro della radice è una foglia e non verifica la condizione quindi ho theta(m) 
     *   dove m è il numero di nodi di B
     * CTP è quando ho la condizione verificata quindi ho theta(n*m)
     * CSP ho alberi degeneri quindi ho theta(n*m)
     * CSM ho alberi bilanciati theta(log n)
     * 
    */

    /*scrivere un metodo che per ogni nodo dell'albero,
     * verifica che i valori contenuti nel sottoalbero sinistro di x sono uguali a quelli del sottoalbero destro
    */
    public static boolean verificaSottoalberi(AlberoBin<Integer> a){
        if(a==null)
            return false;
        if(identici(a.sin(), a.des()))
            return true;
        return verificaSottoalberi(a.sin()) && verificaSottoalberi(a.des());
    }

    /*
     * CTM ho che subito figlio sinistro e destro della radice sono diversi quindi theta(1)
     * CTP ho che la condizione è verificata perciò per ogni nodo esamino i sottoalberi quindi theta(n^2)
     * CSM è quando mi trovo in CTM quindi ho theta(1)
     * CSP è quando ho un albero degenere theta(n)
     */


    /*scrivere un metodo che ritorna true se trova un intero x pari compreso tra l e u */
    public static boolean verificaCompreso(AlberoBin<Integer> a, int l, int u){
        if(a==null)
            return false;
        if(a.val()%2==0 && a.val()>l && a.val()<u)
            return true;
        return verificaCompreso(a.sin(), l, u) || verificaCompreso(a.des(), l, u);
    }

    /*
     * CTM esiste ed è la radice quindi theta(1)
     * CTP non esiste x e mi scandisco tutto l'albero perciò theta(n)
     * CSP ho un albero degenere e mi scandisco tutto l'albero quindi avrò theta(n)
     * CSM mi trovo in CTM quindi ho chiamate attive sullo stack costanti perciò theta(1)
    */
   

    /*scrivere un metodo che ritorna true se trova almeno 2 interi pari compresi tra l e u */
    public static boolean verificaCompresi(AlberoBin<Integer> a, int l, int u){
        if(a==null)
            return false;
        if(supportoCompresi(a,l,u)>=2)
            return true;
        return false;
    }

    private static int supportoCompresi(AlberoBin<Integer> a, int l, int u){
        if(a==null)
            return 0;
        if(a.val()%2==0 && a.val()>l && a.val()<u)
            return 1+supportoCompresi(a.sin(), l, u)+supportoCompresi(a.des(), l, u);
        return supportoCompresi(a.sin(), l, u)+supportoCompresi(a.des(), l, u);
    }

    /*
     * CTM esistono e sono radice e figlio sinistro quindi theta(1)
     * CTP non esistono e mi scandisco tutto l'albero perciò theta(n)
     * CSP ho un albero degenere e mi scandisco tutto l'albero quindi avrò theta(n)
     * CSM mi trovo in CTM quindi ho chiamate attive sullo stack costanti perciò theta(1)
    */

    /*verifica se l'intero v compare nella stessa profondità di A e B oppure se non appare ne in A ne in B */
    public static boolean stessoLivelloONo(AlberoBin<Integer> a, AlberoBin<Integer> b, int l, int v){
        if(a==null && b==null)
            return true;
        if(a==null || b==null)
            return false;
        if(a.val()==v && b.val()==v)
            return true;
        return stessoLivelloONo(a.sin(), b.sin(), l, v)  || stessoLivelloONo(a.des(), b.des(), l, v) 
            || stessoLivelloONo(a.sin(), b.des(), l, v) || stessoLivelloONo(a.des(), b.sin(), l, v) ;
    }

    /*
     * CTM è quando v appare in entrambe le radici theta(1)
     * CTP è quando non appare quindi esamino gli alberi per intero theta(n*m)
     * CSM è quando mi trovo in CTM theta(1)
     * CSP è quando mi trovo in CTP con alberi degeneri theta(n*m)
    */

  

    public static void main(String[] args) {
        
        AlberoBinLF<Integer> al=new AlberoBinLF<Integer>(15);
        AlberoBinLF<Integer> al1=new AlberoBinLF<Integer>(7);
        AlberoBinLF<Integer> al2=new AlberoBinLF<Integer>(2);
        AlberoBinLF<Integer> al3=new AlberoBinLF<Integer>(8);
        AlberoBinLF<Integer> al4=new AlberoBinLF<Integer>(33);
        AlberoBinLF<Integer> al5=new AlberoBinLF<Integer>(22);
        AlberoBinLF<Integer> al6=new AlberoBinLF<Integer>(80);
        al4.setSin(al5);
        al4.setDes(al6);
        al1.setDes(al3);
        al1.setSin(al2);
        al.setSin(al1);
        al.setDes(al4);
        System.out.println(verificaCompresi(al, 1, 9));
     }


}
