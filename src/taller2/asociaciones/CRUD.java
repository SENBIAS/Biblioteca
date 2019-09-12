/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.asociaciones;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class CRUD 
{
    public static Libro buscarTitulo(String titulo,ArrayList<Libro> listaLibros){
        int cantidadLibros;
        int recorrerListaLibros =0;
        cantidadLibros = listaLibros.size();
        Libro libro;
        
        if(cantidadLibros!=0){
            while((recorrerListaLibros < cantidadLibros-1)&&(!listaLibros.get(recorrerListaLibros).getAutor().equals(titulo))){
                recorrerListaLibros+=1;
            }
            
            if(listaLibros.get(recorrerListaLibros).getAutor().equals(titulo)){
                libro = listaLibros.get(recorrerListaLibros);
                return libro;
            }else{
                libro = null;
             return libro;
            }
        }else{
            libro = null;
            return libro;
        }
    }
    
    public static void imprimirLibro(Libro libro){
        if(libro != null){
            System.out.println("Titulo: "+libro.getTitulo());
            System.out.println("Autor: "+libro.getAutor());
            System.out.println("ISBN: "+libro.getIsbn());
            System.out.println("Paginas: "+libro.getPages());
            System.out.println("Fecha: "+libro.getFecha());
        }else{
            System.out.println("El libro no esta en la lista.");
        }
    }
    
    public static void listarLibros(Biblioteca biblioteca){
        int cantidadLibros = biblioteca.cantidadLibrosRegistrados();
        
        for(int recorrer = 0;recorrer < cantidadLibros;recorrer++){
            System.out.println("Libro #"+(recorrer+1));
            System.out.println("Titulo: "+biblioteca.getListaLibros().get(recorrer).getTitulo());
            System.out.println("Autor: "+biblioteca.getListaLibros().get(recorrer).getAutor());
            System.out.println("ISBN: "+biblioteca.getListaLibros().get(recorrer).getIsbn());
            System.out.println("Paginas: "+biblioteca.getListaLibros().get(recorrer).getPages());
            System.out.println("Fecha: "+biblioteca.getListaLibros().get(recorrer).getFecha());
        }
    }
    
    private static void actualizarTitulo(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el titulo nuevo: "); 
        String nuevoTitulo = tecladoString.nextLine();
        libroActualizable.setTitulo(nuevoTitulo);
        System.out.println("Titulo actualizado.");
    }
    
    private static void actualizarAutor(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el autor nuevo: "); 
        String nuevoAutor = tecladoString.nextLine();
        libroActualizable.setAutor(nuevoAutor);
        System.out.println("Autor actualizado.");
    }
    
    private static void actualizarISBN(Libro libroActualizable){
        Scanner tecladoInt = new Scanner(System.in); 
        System.out.print("Ingrese el ISBN nuevo: "); 
        int nuevoISBN = tecladoInt.nextInt();
        libroActualizable.setIsbn(nuevoISBN);
        System.out.println("ISBN actualizado.");
    }
    
    private static void actualizarPaginas(Libro libroActualizable){
        Scanner tecladoInt = new Scanner(System.in);  
        System.out.print("Ingrese el numero nuevo de paginas: "); 
        int nuevoPaginas = tecladoInt.nextInt();
        libroActualizable.setPages(nuevoPaginas);
        System.out.println("Paginas actualizadas.");
    }
    
    private static void actualizarFecha(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese la nueva fecha: "); 
        String nuevaFecha = tecladoString.nextLine();
        libroActualizable.setFecha(nuevaFecha);
        System.out.println("Fecha actualizada.");
    }
    
    private static void menu(){
        System.out.println("Elija el dato a actualizar.");
        System.out.println("1.Actualizar titulo.");
        System.out.println("2.Actualizar autor.");
        System.out.println("3.Actualizar ISBN.");
        System.out.println("4.Actualizar paginas.");
        System.out.println("5.Actualizar fecha.");
        System.out.println("6.Terminar.");
    }
    
    /**
     *
     * @param titulo
     * @param listaLibros
     */
    public static void actualizar(String titulo ,ArrayList<Libro> listaLibros){
        Libro libroActualizable;
        libroActualizable = buscarTitulo(titulo, listaLibros);
        Scanner tecladoInt = new Scanner(System.in);      
        if(libroActualizable != null){
            int option;
            do{
                menu();
                option = tecladoInt.nextInt();
                switch(option){
                case 1:
                    actualizarTitulo(libroActualizable);
                    break;
                case 2:
                    actualizarAutor(libroActualizable);
                    break;
                case 3:
                    actualizarISBN(libroActualizable);
                    break;
                case 4:
                    actualizarPaginas(libroActualizable);
                    break;
                case 5:
                    actualizarFecha(libroActualizable);
                    break;
                case 6:
                    break;
            }  
            }while(option < 6);
        }
    }
    
    /**
     *
     * @param libro
     * @param biblioteca
     * @param ISBN
     */
    public static void agregar(Libro libro,Biblioteca biblioteca,int ISBN){
        String titulo;
        String autor;
        int pages;
        String fecha;
       
        Scanner tecladoInt = new Scanner(System.in);
        Scanner tecladoString = new Scanner(System.in);
        
        System.out.print("Ingrese el titulo: ");
        titulo = tecladoString.nextLine();
        System.out.print("Ingrese el autor: ");
        autor = tecladoString.nextLine();
        System.out.print("Ingrese el numeor de paginas: ");
        pages = tecladoInt.nextInt();
        System.out.print("Ingrese la fecha: ");
        fecha = tecladoString.nextLine();
        
        libro.setAutor(autor);
        libro.setTitulo(titulo);
        libro.setPages(pages);
        libro.setIsbn(ISBN);
        libro.setFecha(fecha);
        
        biblioteca.agregarLibro(libro);
    }
    
    public static void elminar(Biblioteca biblioteca){
        String titulo;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el titulo del libro a eliminar: ");
        titulo = tecladoString.nextLine();
        Libro libroEliminar = buscarTitulo(titulo, biblioteca.getListaLibros());
        
        if(libroEliminar != null){
            biblioteca.getListaLibros().remove(libroEliminar);
        }else{
            System.out.println("Libro no encontrado");
        }
    }
    
}
