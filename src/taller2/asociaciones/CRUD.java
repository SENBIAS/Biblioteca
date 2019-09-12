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
public class CRUD 
{
    public Libro buscarTitulo(String titulo,Biblioteca biblioteca){
        int cantidadLibros;
        int recorrerListaLibros =0;
        cantidadLibros = biblioteca.cantidadLibrosRegistrados();
        
        while((!biblioteca.getListaLibros().get(recorrerListaLibros).getTitulo().equals(titulo))&&(recorrerListaLibros < cantidadLibros)){
            recorrerListaLibros+=1;
        }
        
        if(biblioteca.getListaLibros().get(recorrerListaLibros).getTitulo().equals(titulo)){
            return biblioteca.getListaLibros().get(cantidadLibros);
        }else{
            return null;
        }
    }
    
    public void listarLibros(Biblioteca biblioteca){
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
    
    private void actualizarTitulo(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el titulo nuevo: "); 
        String nuevoTitulo = tecladoString.nextLine();
        libroActualizable.setTitulo(nuevoTitulo);
        System.out.println("Titulo actualizado.");
    }
    
    private void actualizarAutor(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el autor nuevo: "); 
        String nuevoAutor = tecladoString.nextLine();
        libroActualizable.setAutor(nuevoAutor);
        System.out.println("Autor actualizado.");
    }
    
    private void actualizarISBN(Libro libroActualizable){
        Scanner tecladoInt = new Scanner(System.in); 
        System.out.print("Ingrese el ISBN nuevo: "); 
        int nuevoISBN = tecladoInt.nextInt();
        libroActualizable.setIsbn(nuevoISBN);
        System.out.println("ISBN actualizado.");
    }
    
    private void actualizarPaginas(Libro libroActualizable){
        Scanner tecladoInt = new Scanner(System.in);  
        System.out.print("Ingrese el numero nuevo de paginas: "); 
        int nuevoPaginas = tecladoInt.nextInt();
        libroActualizable.setPages(nuevoPaginas);
        System.out.println("Paginas actualizadas.");
    }
    
    private void actualizarFecha(Libro libroActualizable){
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese la nueva fecha: "); 
        String nuevaFecha = tecladoString.nextLine();
        libroActualizable.setFecha(nuevaFecha);
        System.out.println("Fecha actualizada.");
    }
    
    private void menu(){
        System.out.println("Elija el dato a actualizar.");
        System.out.println("1.Actualizar titulo.");
        System.out.println("2.Actualizar autor.");
        System.out.println("3.Actualizar ISBN.");
        System.out.println("4.Actualizar paginas.");
        System.out.println("5.Actualizar fecha.");
        System.out.println("6.Terminar.");
    }
    
    public void actualizar(String titulo ,Biblioteca biblioteca){
        Libro libroActualizable;
        libroActualizable = buscarTitulo(titulo, biblioteca);
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
                case 7:
                    break;
            }  
            }while(option < 6);
        }
    }
    
    public void agregar(Libro libro,Biblioteca biblioteca,int ISBN){
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
    
    public void elminar(Biblioteca biblioteca){
        String titulo;
        Scanner tecladoString = new Scanner(System.in);
        System.out.print("Ingrese el titulo del libro a eliminar: ");
        titulo = tecladoString.nextLine();
        Libro libroEliminar = buscarTitulo(titulo, biblioteca);
        
        if(libroEliminar != null){
            biblioteca.getListaLibros().remove(libroEliminar);
        }else{
            System.out.println("Libro no encontrado");
        }
    }
    
}
