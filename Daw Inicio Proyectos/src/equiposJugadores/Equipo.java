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
    private int puntos;
    private int V;
    private int E;
    private int D;
    private int GF;
    private int GC;
    private int PJ;

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
    

    public int getPuntos() {
		return puntos;
	}

	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public int getD() {
		return D;
	}

	public int getGF() {
		return GF;
	}

	public int getGC() {
		return GC;
	}
	
	public void sumarVictoria() {
		puntos += 3;
		V++;
	}

	public void sumarEmpate() {
		puntos++;
		E++;
	}
	
	public void sumarDerrota() {
		this.D++;
	}

	public void sumarGolAFavor() {
		this.GF++;
	}

	public void sumarGolEnContra() {
		this.GC++;
	}
	public void sumarPartidosJugados() {
		this.PJ++;
		
	}
	public int getPartidosJugados() {
		return PJ;
	}
	
	

	

	/**
	 * @return the difGoles
	 */
	//public int getDifGoles() {
	//	return this.getGolesAFavor()-this.golesEnContra;
	//}


	@Override
    public String toString() {
       /* return "\n"+
               "Equipo: " + this.nombre +"\n"
               +"Caracteristica Principal: " + this.caracPrincipal +"\n"
               +"Estadio: " + this.getEstadio() +"\n"
               +"Entrenador: " + this.entrenador +"\n"
               +"jugadores: " + this.jugadores+"\n"
               +"/--------------------------------------------/";*/
		return this.nombre+this.puntos;
    }
    

}
