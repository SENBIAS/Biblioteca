/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller2.asociaciones;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class Biblioteca {
    private String nombre;
    private String direccion;
    private ArrayList<Libro> listaLibros;

    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.direccion = null;
        this.nombre=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
    
    public int cantidadLibrosRegistrados(){
        return listaLibros.size();
    }
    
    public void agregarLibro(Libro libro){
        listaLibros.add(libro);
    }
    
}
