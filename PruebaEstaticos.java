/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estatico;

public class PruebaEstaticos {

    public static void main(String[] args) {
        System.out.println(Estatico.mensaje());
        Estatico e = new Estatico();
        System.out.println(e.mensajeNS());
        if (80 > Estatico.MIN_CALIF) {
            System.out.println("Hay una calificacion mayor a 0");
        }
        int calif = Math.max(Estatico.MIN_CALIF, Estatico.MAX_CALIF);
        calif = (int) (Math.random() * 100);
        System.out.println("La calificacion es:" + calif);

        if (calif < Estatico.MIN_APROB) {
            System.out.println("Hay una calificacion aprobatoria");
        }
        System.out.println(Estatico.MENOR_QUE);
        System.out.println(Estatico.MAYOR_QUE);
        System.out.println(Estatico.palabrasReservadas[0]);
        System.out.println(Estatico.palabrasReservadas[1]);
        System.out.println(Estatico.palabrasReservadas[2]);
        System.out.println(Estatico.palabrasReservadas[3]);
        if (Estatico.palabrasReservadas[0].equals("CONST")) {
            System.out.println("Son iguales");
        } //TERMINA IF EQUALS
        Estatico.llenaPalRes();

        if (Estatico.palabrasRes.contains("Do")) {
            System.out.println("Si lo contiene");
        } //TERMINA CONTAINS
        Lexema l1 = new  Lexema("Computadora", "Portatil"); 
        System.out.println(l1); 
    }
}
