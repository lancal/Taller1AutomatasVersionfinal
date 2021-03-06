package taller1automatasversionfinal;

import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author alanpierrecalderonsantibanez
 */
public class Automata {
    
     /* Defino listas de estados, transiciones y estados finales */
    ArrayList<String> listaEstados;
    ArrayList<String> listaTransiciones;
    ArrayList<String> listaEstadosFinales;
    ArrayList<String> alfabeto;
    
    public Automata (){
        
    listaEstados = new ArrayList();
    listaTransiciones = new ArrayList();
    listaEstadosFinales = new ArrayList();
    alfabeto = new ArrayList();
    
    }
    
    public void leerNFA(String nombreArchivo){
        
        try{
            
                File fileDir = new File(System.getProperty("user.dir")+"//"+nombreArchivo+".txt");
                
                try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"))){
                
                    String linea;
                String lenguaje;
                int cantEstados = 0;
                /* Leo la primera linea del archivo hasta encontrar la palabra "epsilon" */
                linea = in.readLine();
                int indice = linea.indexOf("epsilon");
                lenguaje = linea.substring(0, indice);
                //System.out.println(lenguaje);
                String[]caracter = lenguaje.split(" ");
                //contruccion alfabeto
                for(String cha:caracter){
                    //System.out.println(caracter[i]);
                    alfabeto.add(cha);
                }
                
                System.out.println("El Lenguaje aceptado para el automata es: "+lenguaje+(char)949);
                
                while ((linea = in.readLine()) != null) {
                    System.out.println(linea);
                    cantEstados++;
                    /* Por cada linea leida se cuenta un estado */
                    listaEstados.add("q"+cantEstados);
                    /* Guardo cada transicion separada por comas en el arreglo transiciones */
                    String[] transiciones = linea.substring(4,linea.length()).split(", ");
                    for (String trans: transiciones) {
                        /* Si es que mi transicion leida tiene un *, quiere decir que es un estado final y no una transicion */
                        if (trans.contains("*")) {
                            listaEstadosFinales.add("q"+cantEstados);
                        } else {
                            /* Caso contrario, guardo mi transicion en la lista transiciones */
                            listaTransiciones.add("q"+cantEstados+": "+trans);
                        }
                    }
                }
                
                
                /**
                 * Imprimir cantidad de estados
                 * Imprimir cantidad de transiciones
                 * Imprimir los estados leidos en el archivo
                 * Imprimir los estados finales
                 * Imprimir las transiciones
                 */
                System.out.println("Cantidad de Estados: "+cantEstados);
                System.out.println("Cantidad de Transiciones: "+listaTransiciones.size());
                System.out.println("Estados:");
                listaEstados.stream().forEach((estados) -> {
                    System.out.println(estados);
                });
                System.out.println("Estados Finales:");
                listaEstadosFinales.stream().forEach((estados) -> {
                    System.out.println(estados);
                });
                System.out.println("Transiciones:");
                listaTransiciones.stream().forEach((transiciones) -> {
                    System.out.println(transiciones);
                });
                alfabeto.stream().forEach((car)->{
                    System.out.println(car);
                });
            }
                
                    
                    
                

        
        } 
        catch (UnsupportedEncodingException e) 
	    {
			System.out.println(e.getMessage());
	    } 
	    catch (IOException e) 
	    {
			System.out.println(e.getMessage());
	    }
	    catch (Exception e)
	    {
			System.out.println(e.getMessage());
	    }
        
    }
    
    
    
}
