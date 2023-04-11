import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import java.lang.Comparable;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        List<List<Integer>> resultado = new ArrayList<List<Integer>>();
        Paquete<Integer,Integer>[] entrada;
        Scanner s = new Scanner(System.in);
        Paquete<Integer, Integer> paquete;
        int casos_t = 0;
        int cant_n = 0;
        int peso_w = 0;
        int peso_paquete = 0;

        casos_t = s.nextInt();

        for (int i = 0; i < casos_t; i++) {
            cant_n = s.nextInt();
            peso_w = s.nextInt();
            entrada = (Paquete<Integer,Integer>[]) new Paquete[cant_n];
            
            for (int j = 0; j < cant_n; j++) {
                peso_paquete = s.nextInt();
                paquete = new Paquete<Integer,Integer>(j + 1, peso_paquete);
                entrada[j] = paquete;
            }

            resultado.add(resolver(entrada, peso_w));
        }

        for (List<Integer> l : resultado) {
            imprimirResultado(l);
        }
    }

    protected static List<Integer> resolver(Paquete<Integer,Integer>[] entrada, int peso_w){
        List<Integer> resultado = new ArrayList<Integer>();
        int peso_c = 0;
        int i = entrada.length - 1;

        Arrays.sort(entrada);

        while(peso_w != peso_c && i >= 0){
            if(entrada[i].getValue() <= peso_w - peso_c){
                resultado.add(entrada[i].getKey());
                peso_c += entrada[i].getValue();
            }
            i--;
        }
        
        if(peso_c < Math.ceil(peso_w / 2)){
            resultado = new ArrayList<Integer>();
        }

        return resultado;
    }

    protected static void imprimirResultado(List<Integer> resultado){
        if(resultado.size() == 0){
            System.out.println(-1);
        }else{
            System.out.println(resultado.size());
            for(Integer e : resultado){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

}

class Paquete<K,V> implements Comparable<Paquete>{
    protected K key;
    protected V value;

    public Paquete(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(Paquete o) {
        return (int) value - (int) o.getValue();
    }

}
/*
 * Elon quiere viajar a Marte, pero necesita tu ayuda.
 * Elon tiene un cohete con una capacidad de W
 * Además, tiene n paquetes, donde el i-ésimo paquete pesa wi
 * Quiere llevar algunos de estos paquetes en el cohete, de forma tal que el cohete no vaya ni muy vacío ni muy cargado. En particular, el peso total C
 * de los paquetes debe satisfacer ⌈W/2⌉≤C≤W
 * Para ayudar a Elon, te pidió que imprimas una lista de paquetes que cumpla estas condiciones, o le avises que es imposible.
 *
 * Made by David Latouquette & David López
 */