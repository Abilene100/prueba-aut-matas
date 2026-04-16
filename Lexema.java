/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estatico;

/**
 *
 * @author abile
 */
public class Lexema {

    private String dato;
    private String tipo;
    private int token;
    
    //Contructor
    public Lexema(String dato, String tipo) {
        this.tipo = tipo;
        this.dato = dato;
        if (tipo.equals("ID")){ 
            this.token = Estatico.esReservada(dato); 
            this.tipo = (token==100)? tipo:"PR";
            
        } else {
            this.token=0;
        }
        
    }
    
    
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "{" + dato + "\t" + tipo + "\t" + token +"}"; 
    }
}
