package equiposJugadores;

import java.util.ArrayList;

/**
 *  Clase Equipo.
 *  En ella vamos a crear cada equipo de la Liga.
 * @author juanmi
 */
public class Equipo {
    private String nombre; //Aqui guarda el nombre del equipo.
    private Caracteristicas caracPrincipal; //Aqui guardamos la caracteristica principal del equipo. 
    private Estadio estadio; //Aqui guardamos el estadio del equipo.
    private Entrenador entrenador; //Aqui guardamos el entrenador del equipo.
    private ArrayList<Jugador> jugadores; //En este array se guardan los jugadores del equipo.

    public Equipo(String nombre, Caracteristicas caracPrincipal, Estadio estadio, Entrenador entrenador, ArrayList<Jugador> jugadores) {
        this.nombre = nombre;
        this.caracPrincipal = caracPrincipal;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
    }
    
     public Equipo(String nombre, Caracteristicas caracPrincipal, Estadio estadio) {
        this.nombre = nombre;
        this.caracPrincipal = caracPrincipal;
        this.estadio = estadio;
        this.entrenador = new Entrenador();
        this.jugadores=new ArrayList<Jugador>();
         for (int i = 0; i < 5; i++) {
             this.jugadores.add(new Jugador());
         }
    }

    public String getNombre() {
        return nombre;
    }

    public Caracteristicas getCaracPrincipal() {
        return caracPrincipal;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCaracPrincipal(Caracteristicas caracPrincipal) {
        this.caracPrincipal = caracPrincipal;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void setEntrenador(Entrenador Entrenador) {
        this.entrenador = entrenador;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

  

    @Override
    public String toString() {
        return "\n"+
               "Equipo: " + this.nombre +"\n"
               +"Caracteristica Principal: " + this.caracPrincipal +"\n"
               +"Estadio: " + this.getEstadio() +"\n"
               +"Entrenador: " + this.entrenador +"\n"
               +"jugadores: " + this.jugadores+"\n"
               +"/--------------------------------------------/";
    }
    

}
