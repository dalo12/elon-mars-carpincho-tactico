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
public static void main(String[] args){
    int[] entrada;
    int[] resultado;
    int casos = 0;

}