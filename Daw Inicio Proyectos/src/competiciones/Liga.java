/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competiciones;

import competiciones.Jornada;
import equiposJugadores.Equipo;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Liga.
 * En esta clase se asigna los valores de la liga.
 * @author juanmi
 */
public class Liga {
    private String nombre; //Aqui guardamos el nombre de la liga.
    private Equipo [] equipo; //En este array se guarda los equipos que juegan en la liga.
    private Jornada [] jornada; //En este array las jornadas de la liga.

    public Liga(String nombre, Equipo[] equipo, Jornada [] jornada) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.jornada = jornada;
        
    }

    public String getNombre() {
        return nombre;
    }

    public Equipo[] getEquipo() {
        return equipo;
    }

    public Jornada[] getJornada() {
        return jornada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEquipo(Equipo[] equipo) {
        this.equipo = equipo;
    }

    public void setJornada(Jornada[] jornada) {
        this.jornada = jornada;
    }

    @Override
    public String toString() {
        return nombre + leerArray(equipo) + "\n " + leerArray2(jornada);
    }
    
    public String leerArray(Equipo [] array){
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += array[i];
        }
            return s;
    }

    public String leerArray2(Jornada [] array){
        String s = "";
        for (int i = 0; i < array.length; i++) {
            s += array[i].toString();
        }
            return s;
    }     
}
