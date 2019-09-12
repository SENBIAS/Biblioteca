/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.asociaciones;

import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Taller2Asociaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro;
        int ISBN = 100001;
        String titulo;
        Scanner tecladoInt = new Scanner(System.in); 
        int option;
            do{
                menu();
                option = tecladoInt.nextInt();
                switch(option){
                case 1:
                    libro = new Libro();
                    CRUD.agregar(libro, biblioteca, ISBN);
                    ISBN+=1;
                    System.out.println("");
                    break;
                case 2:
                    titulo = capturarTitulo();
                    libro = CRUD.buscarTitulo(titulo, biblioteca.getListaLibros());
                    CRUD.imprimirLibro(libro);
                    System.out.println("");
                    break;
                case 3:
                    CRUD.listarLibros(biblioteca);
                    System.out.println("");
                    break;
                case 4:
                    titulo = capturarTitulo();
                    CRUD.actualizar(titulo, biblioteca.getListaLibros());
                    System.out.println("");
                    break;
                case 5:
                    break;
            }  
            }while(option < 5);
    }
    
    private static void menu(){
        System.out.println("1.Ingresar un libro.");
        System.out.println("2.Buscar libro");
        System.out.println("3.Imprimir libros");
        System.out.println("4.Actualizar libros");
        System.out.println("5.Salir");
    }
    
    private static String capturarTitulo(){
        String titulo;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el titulo del libro: ");
        titulo = tecladoString.nextLine();
        return titulo;
    }
    
}
