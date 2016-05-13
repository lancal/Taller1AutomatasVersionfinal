/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1automatasversionfinal;

import java.io.*;


/**
 *
 * @author alanpierrecalderonsantibanez
 */
public class Taller1AutomatasVersionfinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader lectura = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese Nombre del Archivo NFA a Convertir: ");
        String nombre = lectura.readLine();
        Automata automata = new Automata();
        automata.leerNFA(nombre);
        convertNFAtoDFA conversion = new convertNFAtoDFA (automata);
        //asdfasfd

        
    }
    
}
