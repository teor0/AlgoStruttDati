package tracce;
import alberi.*;
public class AppelloLuglio {
    
    public AppelloLuglio(){
    }

    /*scrivere un metodo che ritorna true se e solo se esiste almeno un nodo al livello l in A 
    * e la somma dei valori dei nodi che si trovano al livello l in A sia maggiore di una soglia */

    public static boolean livelloSomma(AlberoBin<Integer> a, int l, int soglia){
        if(a==null)
            return false;
        int x=sommaLivello(a, l);
        System.out.println(x);
        return x>soglia; 
    }

    private static int sommaLivello(AlberoBin<Integer> a, int l){
        if(a==null)
            return 0;
        if(l<0)
            return 0;
        if(l==0)
            return a.val();
        return sommaLivello(a.sin(), l-1) + sommaLivello(a.des(), l-1);
       

    }

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
        System.out.println(livelloSomma(al, 1, 20));
     }


}
