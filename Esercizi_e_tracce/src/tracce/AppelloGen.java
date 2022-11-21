package tracce;
import alberi.*;
public class AppelloGen {
    

    public AppelloGen(){}

    /*scrivere un metodo che ritorna true se e solo se esiste un nodo foglia di a il cui valore è non minore dei valori
     * contenuti nei nodi antenati
     */

     public static boolean verificaMaxAntenati(AlberoBin<Integer> a){
        if(a==null)
            return false;
        return cercaFoglia(a.sin(), a.val()) || cercaFoglia(a.des(),a.val());
     }

     private static boolean cercaFoglia(AlberoBin<Integer> a, int x){
        if(a==null)
            return false;
        if(a.sin()==null && a.des()==null)
            if(a.val()>x){ //verifico se la foglia è maggiore del maggiore
                System.out.println(a.val()+ " e x: "+ x);
                return true;
            }
        if(a.val()>x)
            return cercaFoglia(a.sin(), a.val()) || cercaFoglia(a.des(), a.val());
        return cercaFoglia(a.sin(), x) || cercaFoglia(a.des(), x);
     }

    /*
     * CTP è quando devo cercare in tutto l'albero quindi ho theta(n)
     * CTM è quando il figlio sinistro o destro è foglia ed è minore della radice quindi si ha theta(1)
     * CSM è quando mi trovo in CTM ed ho chiamate costanti quindi theta(1)
     * CSP è quando devo cercare in un albero degenere ed ho chiamate proporzionali ad n quindi theta(n) 
     * 
    */

     public static void main(String[] args) {
        
        AlberoBinLF<Integer> al=new AlberoBinLF<Integer>(5);
        AlberoBinLF<Integer> al1=new AlberoBinLF<Integer>(7);
        AlberoBinLF<Integer> al2=new AlberoBinLF<Integer>(5);
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
        System.out.println(verificaMaxAntenati(al));
     }


}
