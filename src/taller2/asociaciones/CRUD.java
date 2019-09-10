/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.asociaciones;

/**
 *
 * @author Sebastian
 */
public class CRUD 
{
    
    public void agregar(Libro libro,Biblioteca biblioteca)
    {
        biblioteca.agregarLibro(libro);
    }
    
    public Libro buscarTitulo(String titulo,Biblioteca biblioteca){
        int cantidadLibros;
        int recorrerListaLibros =0;
        Libro libro;
        cantidadLibros = biblioteca.cantidadLibrosRegistrados();
        
        while((!biblioteca.getListaLibros().get(recorrerListaLibros).getTitulo().equals(titulo))&&(recorrerListaLibros < cantidadLibros)){
            recorrerListaLibros+=1;
        }
        
        if(biblioteca.getListaLibros().get(recorrerListaLibros).getTitulo().equals(titulo)){
            libro = biblioteca.getListaLibros().get(cantidadLibros);
            return libro;
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
            System.out.println("Cantidad de libros: "+biblioteca.getListaLibros().get(recorrer).getCantidadEjemplares());
        }
    }
}
