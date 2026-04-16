/*

 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estatico;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prueba2 {

    public static void main(String[] args) {
        String regex = "([A-Za-z]\\w*)|"  
                + 
                "(0|[1-9]\\d*)|"
                + 
                "(==|!=|<=|>=|<|>|=\\+|-|\\*|/)|"
                +
                "(\\.|,|;|\\(|\\))|"
                +
                "(\\s)|"
                +
                "(.)";

        String texto = """
                       const x=100,y=10.21;var a___2,b_c_2_t,059
                       a__2<<===!==xy-yx==>=>>100000000066
                       if-while+for*then/do%to|downto
                       (x_nueva(y_vieja))(b_c_2_t.
                       fin_2)"""; 

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        ArrayList<Lexema> lexemas = new ArrayList<>();
        while (matcher.find()) {
            String hallazgo = matcher.group();
            if (matcher.group(1) != null) {

                //AGREGAR A IDENTIFICADORES
                lexemas.add(new Lexema(hallazgo,"ID"));
                continue;
            }
            if (matcher.group(2) !=null) {
                lexemas.add(new Lexema(hallazgo,"NUM")); 
                continue; 
            }
            
            if (matcher.group(6)!=null) {
                 lexemas.add(new Lexema(hallazgo,"ERROR")); 
            } 
        }
        for (Lexema e : lexemas) { 
            System.out.println(e);
        }
    }
}
