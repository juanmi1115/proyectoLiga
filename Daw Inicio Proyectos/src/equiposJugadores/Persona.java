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
    private static final String [] nombres = {"Juan","Paco","Pepe","Mateo","Miguel","Fabian","Antonio","Lolo","Andres","Ramon","Cristiano","Leo","Karim","Pedro",
                             "Salvio","Eden","Lucas","Bartolo","Eustaquio","Agustin","Aleix","Michel","Joaquin","Isco","Luka","Paul","Raul",
                             "Fernando","Ter","Luis","Malcolm","Javier","Arturo","Daniel","Eusebio","Alfredo","Jesús","Keylor","Sergio",
                             "Rafael","Alvaro","Jaime","Xavier","Timo","Thibaut","Vinicius","David","Manolo","Teo","Mario"};
    
    private static final String [] apellidos = {"De Luiz","Ramos","Suarez","Messi","Ronaldo","Kroos","Courtois","Navas","Gonzalez","Moura","Varane","De Gea",
                               "Torres","Hernández","Coutinho","Dembele","Hazard","Sanchez","Ontiveros","Pogba","Di Stefano","Iniesta","Salgado",
                               "Gaitan","Tellez","Vidal","Junior","Morata","Modric","Aureola","Benzema","Alarcon","Pacheco","Caballero",
                               "Perez","Martin","Fernandez","Bravo","Vargas","Stegen","Jiménez","Valderrama","Cortes","Martinez","Rabiot",
                               "Lopez","Verrati","Casillas","Reina","Puskas"};
    
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