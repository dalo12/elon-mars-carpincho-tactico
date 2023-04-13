import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String[] args) {
        List<List<Integer>> resultado = new ArrayList<List<Integer>>();
        int[] entrada;
        Scanner s = new Scanner(System.in);
        int casos_t = 0;
        int cant_n = 0;
        long peso_w = 0;

        casos_t = s.nextInt();

        for (int i = 0; i < casos_t; i++) {
            cant_n = s.nextInt();
            peso_w = s.nextLong();
            entrada = new int[cant_n];
            
            for (int j = 0; j < cant_n; j++) {
                entrada[j] = s.nextInt();
            }

            resultado.add(resolver(entrada, peso_w));
        }

        for (List<Integer> l : resultado) {
            imprimirResultado(l);
        }
    }

    protected static List<Integer> resolver(int[] entrada, long peso_w){
        List<Integer> resultado = new ArrayList<Integer>();
        long peso_c = 0;
        int i = 0;
        double mitad = Math.ceil(peso_w / 2.);
        boolean ideal = false;

        while(peso_w != peso_c && i < entrada.length && !ideal){
            if(entrada[i] <= peso_w - peso_c){
                resultado.add(i+1);
                peso_c += entrada[i];
            }
            if(mitad <= entrada[i] && entrada[i] <= peso_w){
                resultado = new ArrayList<Integer>();
                resultado.add(i+1);
                peso_c = entrada[i];
                ideal = true;
            }

            i++;
        }
        
        if(peso_c < mitad){
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