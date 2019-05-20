package equiposJugadores;

import java.util.Random;

import equiposJugadores.Persona;

/**
 * Clase Jugador.
 * Esta clase extiende de la clase Descripción y aquí añadimos las características 
 * que tendrá un jugador.
 * @author juanmi
 */
public class Jugador extends Persona{
    private float fuerza; //Aquí guardamos la fuerza de cada jugador.
    private float resistencia; //Aquí guardamos la resistencia de cada jugador.
    private float velocidad; //Aquí guardamos la velocidad de cada jugador.
    private float precision; //Aquí guardamos la precisión de cada jugador.
    private float tecnica; //Aquí guardamos la técnica de cada jugador.
   
    
    public Jugador(){
        super();
        
        //Aquí introduzco el paquete Random, para seleccionar objetos aleatoriamente.
        Random aleatorio = new Random();
        
       this.fuerza = aleatorio.nextInt(100);
       
       this.resistencia = aleatorio.nextInt(100);
       
       this.velocidad = aleatorio.nextInt(100);
       
       this.precision = aleatorio.nextInt(100);
       
       this.tecnica = aleatorio.nextInt(100);
    }

    
    //Constructor de la clase Jugador.
    public Jugador(float fuerza, float resistencia, float velocidad, float precision, float tecnica, String nombre, String apellido) {
        super(nombre, apellido);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
        this.velocidad = velocidad;
        this.precision = precision;
        this.tecnica = tecnica;
    }

    
    //Aqui se implementa los getters y setters de la clase Jugador.

    public float getFuerza() {
        return fuerza;
    }

    public float getResistencia() {
        return resistencia;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public float getPrecision() {
        return precision;
    }

    public float getTecnica() {
        return tecnica;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public void setResistencia(float resistencia) {
        this.resistencia = resistencia;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public void setPrecision(float precision) {
        this.precision = precision;
    }

    public void setTecnica(float tecnica) {
        this.tecnica = tecnica;
    }

    @Override
    public String toString() {
        return  "\n"+
                this.getNombre()+" "+this.getApellido()+"\n"
                +"Fuerza del jugador: "+this.getFuerza()+"\n"
                +"Resistencia del jugador: "+this.getResistencia()+"\n"
                +"Velocidad del jugador: "+this.getVelocidad()+"\n"
                +"Precisión del jugador: "+this.getPrecision()+"\n"
                +"Técnica del jugador: "+this.getTecnica()+"\n";
    }
        
    
}