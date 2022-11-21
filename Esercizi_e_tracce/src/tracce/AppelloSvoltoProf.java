package tracce;
import alberi.*;
public class AppelloSvoltoProf {
    
    /*scrivere un metodo che ritorna la somma di tutti i valori più grandi di x che appaiono nelle foglie dell'albero A */

    public static int SGT(AlberoBin<Integer> a, int x){
        if(a==null)
            return 0;
        if(a.sin()==null && a.des()==null)
            if(a.val()>x)
                return a.val()+SGT(a.sin(), x) + SGT(a.des(), x);
        return SGT(a.sin(), x) + SGT(a.des(), x);
    }

    /*
     * CTP = CTM è theta(n) in quanto devo restituire la somma di tutte le foglie maggiori di x
     * CSM mi trovo in un albero bilanciato quindi avrò chiamate al massimo pari a log n quindi theta(log n)
     * CSP mi trovo in un albero che degenera a lista quindi theta(n)
    */
    public static void main(String[] args){
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
         System.out.println(SGT(al,5));
    }


}
