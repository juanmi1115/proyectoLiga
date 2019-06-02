package equiposJugadores;


import java.util.Random;

/**
 * Clase Entrenador.
 * Esta clase extiende de la clase DescripciÛn y adem·s asignaremos a cada 
 * entrenador un potenciador.
 * @author juanmi
 */
public class Entrenador extends Persona{
    
    private float potFuerza; //Aqui guardamos el potenciador de fuerza del entrenador.
    private float potResistencia; //Aqui guardamos el potenciador de resistencia del entrenador.
    private float potVelocidad; //Aqui guardamos el potenciador de velocidad del entrenador.
    private float potPrecision; //Aqui guardamos el potenciador de precisi√≥n del entrenador.
    private float potTecnica; //Aqui guardamos el potenciador de t√©cnica del entrenador.

    //Aqui asignamos de manera aleatoria lal caracteristicas del entrenador
    public Entrenador(){
        super();
        Random aleatorio = new Random();
        
       this.potFuerza = aleatorio.nextInt(100);
       
       this.potResistencia = aleatorio.nextInt(100);
       
       this.potVelocidad = aleatorio.nextInt(100);
       
       this.potPrecision = aleatorio.nextInt(100);
       
       this.potTecnica = aleatorio.nextInt(100);
    
    }
    //Constructor de la clase Entrenador.
    public Entrenador(float potFuerza, float potResistencia, float potVelocidad, float potPrecision, float potTecnica, String nombre, String apellido) {
        super(nombre, apellido);
        this.potFuerza = potFuerza;
        this.potResistencia = potResistencia;
        this.potVelocidad = potVelocidad;
        this.potPrecision = potPrecision;
        this.potTecnica = potTecnica;
    }

    
    //Aqui se implementa los getters y setters de la clase Entrenador.
    public float getPotFuerza() {
        return potFuerza;
    }

    public float getPotResistencia() {
        return potResistencia;
    }

    public float getPotVelocidad() {
        return potVelocidad;
    }

    public float getPotPrecision() {
        return potPrecision;
    }

    public float getPotTecnica() {
        return potTecnica;
    }

    public void setPotFuerza(float potFuerza) {
        this.potFuerza = potFuerza;
    }

    public void setPotResistencia(float potResistencia) {
        this.potResistencia = potResistencia;
    }

    public void setPotVelocidad(float potVelocidad) {
        this.potVelocidad = potVelocidad;
    }

    public void setPotPrecision(float potPrecision) {
        this.potPrecision = potPrecision;
    }

    public void setPotTecnica(float potTecnica) {
        this.potTecnica = potTecnica;
    }
    
    //FunciÛn toString para leer Entrenador
    @Override
    public String toString() {
        return  "\n"+
                this.getNombre()+" "+this.getApellido()+"\n"
                +"Potenciador de fuerza: "+this.getPotFuerza()+"\n"
                +"Potenciador de resistencia: "+this.getPotResistencia()+"\n"
                +"Potenciador de velocidad: "+this.getPotVelocidad()+"\n"
                +"Potenciador de precisi√≥n: "+this.getPotPrecision()+"\n"
                +"Potenciador de t√©cnica: "+this.getPotTecnica()+"\n";
    }
    
    
    
}
