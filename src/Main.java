import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) {
        List<List<Integer>> resultado = new ArrayList<List<Integer>>();
        Entry<Integer,Integer>[] entrada;
        Entry<Integer, Integer> paquete;
        Scanner s = new Scanner(System.in);
        int casos_t = 0;
        int cant_n = 0;
        long peso_w = 0;
        int peso_paquete = 0;

        casos_t = s.nextInt();

        for (int i = 0; i < casos_t; i++) {
            cant_n = s.nextInt();
            peso_w = s.nextLong();
            entrada = new Entry[cant_n];
            
            for (int j = 0; j < cant_n; j++) {
                peso_paquete = s.nextInt();
                paquete = new SimpleEntry<Integer,Integer>(j + 1, peso_paquete);
                entrada[j] = paquete;
            }

            resultado.add(resolver(entrada, peso_w));
        }

        for (List<Integer> l : resultado) {
            imprimirResultado(l);
        }
    }

    protected static List<Integer> resolver(Entry<Integer,Integer>[] entrada, long peso_w){
        List<Integer> resultado = new ArrayList<Integer>();
        long peso_c = 0;
        int i = entrada.length - 1;

        Arrays.sort(entrada, new Comparator<Entry<Integer,Integer>>(){

            @Override
            public int compare(Entry<Integer, Integer> arg0, Entry<Integer, Integer> arg1) {
                return arg0.getValue() - arg1.getValue();
            }
            
        });

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