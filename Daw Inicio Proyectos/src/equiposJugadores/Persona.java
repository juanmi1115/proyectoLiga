package equiposJugadores;

import java.util.Random;

/**
 * Clase Descripción.
 * En ella se va a guardar los datos básicos de los entrenadores y jugadores.
 * @author juanmi
 */
public class Persona {
    private String nombre; //nombre del jugador o entrenador.
    private String apellido; //Apellido del jugador o entrenador.
    private static final String [] nombres = {"Juan","Paco","Pepe","Mateo","Miguel","Fabi�n","Antonio","Lolo","Andr�s","Ram�n","Cristiano","Leo","Karim","Pedro",
                             "Salvio","Eden","Lucas","Bart�lo","Eustaquio","Agustin","Aleix","Michel","Joaqu�n","Isco","Luka","Paul","Ra�l",
                             "Fernando","Ter","Luis","Malcolm","Javier","Arturo","Daniel","Eusebio","Alfredo","Jes�s","Keylor","Sergio",
                             "Rafael","�lvaro","Jaime","Xavier","Timo","Thibaut","Vinicius","David","Manolo","Teo","Mario"};
    
    private static final String [] apellidos = {"De Luiz","Ramos","Su�rez","Messi","Ronaldo","Kroos","Courtois","Navas","Gonz�lez","Moura","Varane","De Gea",
                               "Torres","Hern�ndez","Coutinho","Demb�l�","Hazard","S�nchez","Ontiveros","Pogba","Di Stefano","Iniesta","Salgado",
                               "Gait�n","T�llez","Vidal","Junior","Morata","Modric","Aureola","Benzema","Alarc�n","Pacheco","Caballero",
                               "P�rez","Mart�n","Fern�ndez","Bravo","Vargas","Stegen","Jim�nez","Valderrama","Cort�s","Mart�nez","Rabiot",
                               "L�pez","Verrati","Casillas","Reina","Puskas"};
    
    public Persona(){
        //Aquí introduzco el paquete Random, para seleccionar objetos aleatoriamente.
        Random aleatorio = new Random();
       
        //En este String guardo el valor de un nombre aleatorio.
       this.setNombre(nombres[aleatorio.nextInt(50)]);
       
       
        //En este String guardo el valor de un apellido aleatorio.
       this.setApellido(apellidos[aleatorio.nextInt(50)]);
    }
    
    //Constructor de la clase Persona.
    public Persona(String nombre, String apellido ) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    //Aqui se implementan los getters y setters de la clase Persona.
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
        
}