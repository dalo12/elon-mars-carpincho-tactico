import java.util.ArrayList;
import java.lang.Math.ceil;
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


/*
    Pseudocódigo:
 
    para i = 0 hasta n{
        si w[i] <= W - C{
            solucion.add(i)
            C = C + w[i]
        }
    }

    si C >= W / 2 {
        imprimir(solución)
    }sino{
        imprimir(-1)
    }
 */

public class Resolucion{
    public static void main(String[] args){
        List<Integer> resultado;
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner s = new Scanner(System.in);
        int casos_t = 0;
        int cant_n = 0;
        int peso_w = 0;

        for(int i = 0; i<casos_t; i++){
            cant_n = s.nextInt();
            peso_w = s.nextInt();

            for(int j = 0; j<cant_n; j++){
                entrada.add(s.nextInt());
            }
        }

        resultado = resolver(entrada, peso_w);

        System.out.println();
        for(Integer p : resultado){
            System.out.print(p + " ");
        }
        System.out.println();
    }

    protected List<Integer> resolver(List<Integer> entrada, int peso_w){
        List<Integer> resultado = new ArrayList<Integer>();
        int peso_c = 0;

        for(Integer p : entrada){
            if(p <= peso_w - peso_c){
                resultado.add(entrada.indexOf(p));
                peso_c += p;
            }
        }

        if(peso_c >= Math.ceil(peso_w / 2)){
            resultado.clear();
            resultado.add(-1);
        }

        return resultado;   
    }
}