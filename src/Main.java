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
        List<List<Long>> resultado = new ArrayList<List<Long>>();
        Entry<Long,Long>[] entrada;
        Entry<Long, Long> paquete;
        Scanner s = new Scanner(System.in);
        long casos_t = 0;
        int cant_n = 0;
        long peso_w = 0;
        long peso_paquete = 0;

        casos_t = s.nextLong();

        for (int i = 0; i < casos_t; i++) {
            cant_n = s.nextInt();
            peso_w = s.nextLong();
            entrada = (Entry<Long,Long>[]) new Entry[cant_n];
            
            for (int j = 0; j < cant_n; j++) {
                peso_paquete = s.nextInt();
                paquete = new SimpleEntry<Long,Long>((long) j + 1, peso_paquete);
                entrada[j] = paquete;
            }

            resultado.add(resolver(entrada, peso_w));
        }

        for (List<Long> l : resultado) {
            imprimirResultado(l);
        }
    }

    protected static List<Long> resolver(Entry<Long,Long>[] entrada, long peso_w){
        List<Long> resultado = new ArrayList<Long>();
        long peso_c = 0;
        int i = entrada.length - 1;

        Arrays.sort(entrada, new Comparator<Entry<Long,Long>>(){

            @Override
            public int compare(Entry<Long, Long> arg0, Entry<Long, Long> arg1) {
                return arg0.getValue().compareTo(arg1.getValue());
            }
            
        });

        while(peso_w != peso_c && i >= 0){
            if(entrada[i].getValue() <= peso_w - peso_c){
                resultado.add(entrada[i].getKey());
                peso_c += entrada[i].getValue();
            }
            i--;
        }
        
        if(peso_c < Math.ceil(peso_w / 2.0f)){
            resultado = new ArrayList<Long>();
        }

        return resultado;
    }

    protected static void imprimirResultado(List<Long> resultado){
        if(resultado.size() == 0){
            System.out.println(-1);
        }else{
            System.out.println(resultado.size());
            for(Long e : resultado){
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