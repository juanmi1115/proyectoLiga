package equiposJugadores;

import java.util.Random;

/**
 * Clase DescripciÃ³n.
 * En ella se va a guardar los datos bÃ¡sicos de los entrenadores y jugadores.
 * @author juanmi
 */
public class Persona {
    private String nombre; //nombre del jugador o entrenador.
    private String apellido; //Apellido del jugador o entrenador.
    private static final String [] nombres = {"Juan","Paco","Pepe","Mateo","Miguel","Fabián","Antonio","Lolo","Andrés","Ramón","Cristiano","Leo","Karim","Pedro",
                             "Salvio","Eden","Lucas","Bartólo","Eustaquio","Agustin","Aleix","Michel","Joaquín","Isco","Luka","Paul","Raúl",
                             "Fernando","Ter","Luis","Malcolm","Javier","Arturo","Daniel","Eusebio","Alfredo","Jesús","Keylor","Sergio",
                             "Rafael","Álvaro","Jaime","Xavier","Timo","Thibaut","Vinicius","David","Manolo","Teo","Mario"};
    
    private static final String [] apellidos = {"De Luiz","Ramos","Suárez","Messi","Ronaldo","Kroos","Courtois","Navas","González","Moura","Varane","De Gea",
                               "Torres","Hernández","Coutinho","Dembélé","Hazard","Sánchez","Ontiveros","Pogba","Di Stefano","Iniesta","Salgado",
                               "Gaitán","Téllez","Vidal","Junior","Morata","Modric","Aureola","Benzema","Alarcón","Pacheco","Caballero",
                               "Pérez","Martín","Fernández","Bravo","Vargas","Stegen","Jiménez","Valderrama","Cortés","Martínez","Rabiot",
                               "López","Verrati","Casillas","Reina","Puskas"};
    
    public Persona(){
        //AquÃ­ introduzco el paquete Random, para seleccionar objetos aleatoriamente.
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