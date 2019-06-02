/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competiciones;

import competiciones.Jornada;
import equiposJugadores.Equipo;
import interfaces.Ventana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import static equiposJugadores.Caracteristicas.FUERZA;
import static equiposJugadores.Caracteristicas.PRECISION;
import static equiposJugadores.Caracteristicas.RESISTENCIA;
import static equiposJugadores.Caracteristicas.TECNICA;
import static equiposJugadores.Caracteristicas.VELOCIDAD;

/**
 * Clase Liga. En esta clase se asigna los valores de la liga.
 * 
 * @author juanmi
 */
public class Liga {
	private String nombre; // Aqui guardamos el nombre de la liga.
	private HashMap<String, Equipo> equipos; // En este array se guarda los equipos que juegan en la liga.
	private Jornada[] jornada; // En este array guardamos las jornadas de la liga.
	private Ventana ventana; // variable para usar la clase Ventana
	private int proximaJornada; //variable para inicializar un contador

	//Constructor de Liga
	public Liga(String nombre, HashMap<String, Equipo> equipos, Jornada[] jornada) {
		this.nombre = nombre;
		this.equipos = equipos;
		this.jornada = jornada;
		this.proximaJornada = 0;


	}
	//Función para imprimir la jornada actual
	public String proximaJornada() {
		return jornada[proximaJornada].toString();
	}
	//Función para simular la jornada actual
	public void simularSiguienteJornada() {
		jornada[proximaJornada].simular();
		proximaJornada++;
	}
	//Función para mostrar los resultados de la jornada actual
	public String resultadosUltimaJornada() {
		return jornada[proximaJornada - 1].toString();
	}
	//Getter de nombre 
	public String getNombre() {
		return nombre;
	}
	//Getter del el hashMap de equipo
	public HashMap<String, Equipo> getEquipo() {
		return equipos;
	}
	//Getter del array de jornadas
	public Jornada[] getJornada() {
		return jornada;
	}
	//Setter del nombre de la liga
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//Setter del hashMap de equipo
	public void setEquipo(HashMap<String, Equipo> equipo) {

		this.equipos = equipo;
	}
	//Setter del array que contiene las jornadas
	public void setJornada(Jornada[] jornada) {
		this.jornada = jornada;
	}
	
	//Función toString para leer la jornadas y los equipos
	@Override
	public String toString() {
		return nombre + leerArray(equipos) + "\n " + leerArray2(jornada);
	}
	//Función para leer el hashMap de equipos
	public String leerArray(HashMap<String, Equipo> array) {
		Iterator it = array.entrySet().iterator();
		String ret = "";
		while (it.hasNext()) {
			Equipo actual = ((Equipo) ((Entry) it.next()).getValue());
			ret += actual.getNombre() + "\n";
		}
		return ret;
	}
	//Función para leer el array de Jornadas
	public String leerArray2(Jornada[] array) {
		String s = "";
		for (int i = 0; i < array.length; i++) {
			s += array[i].toString();
		}
		return s;
	}
}
