/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competiciones;

import competiciones.Jornada;
import equiposJugadores.Entrenador;
import equiposJugadores.Equipo;
import equiposJugadores.Jugador;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Partido.
 * En ella se asigna el valor de los partidos de la jornada.
 * @author juanmi
 */
public class Partido {
    private Equipo equipoLocal; //Aqui se asigna al equipo local que juega este partido.
    private Equipo equipoVisitante; //Aqui se asigna el equipo visitante que juega este partido.
    private byte golesLocal;
    private byte golesVisitante;
    private boolean jugado;

    public Partido( Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado=false;
    }
    
    @Override
    public String toString(){
        if(jugado){
            return this.equipoLocal.getNombre()+"          "+golesLocal+" - "+golesVisitante+"          "+this.equipoVisitante.getNombre()+"\n";
        }
        //Si no se ha jugado
            return this.equipoLocal.getNombre()+" - "+this.equipoVisitante.getNombre()+ " (por jugar) "+"\n";
    }
    
    
    
    public void simular(){
        Random aleatorio = new Random();
        ArrayList<Jugador> jugadoresLocal=equipoLocal.getJugadores();
        float sumaCaracLocal=0;
        float sumaCaracVisi = 0;
                    
            int multFuerza=1;
            int multResistencia=1;
            int multVelocidad = 1;
            int multPrecision = 1;
            int multTecnica = 1;
    
       
        for(int i=0;i<jugadoresLocal.size();i++){
            
            switch(equipoLocal.getCaracPrincipal()){
                
                case FUERZA:
                    multFuerza=2;
                    break;
                    
                case RESISTENCIA:
                    multResistencia = 2;
                    break;
                    
                case VELOCIDAD:
                    multVelocidad = 2;
                    break;
                    
                case PRECISION:
                    multPrecision = 2;
                    break;
                    
                case TECNICA:
                    multTecnica = 2;
                    break;
            }
            sumaCaracLocal = (multFuerza * jugadoresLocal.get(i).getFuerza() * equipoLocal.getEntrenador().getPotFuerza() 
                       + multResistencia * jugadoresLocal.get(i).getResistencia() * equipoLocal.getEntrenador().getPotResistencia()
                       + multVelocidad * jugadoresLocal.get(i).getVelocidad() * equipoLocal.getEntrenador().getPotVelocidad()
                       + multPrecision * jugadoresLocal.get(i).getPrecision() * equipoLocal.getEntrenador().getPotPrecision() 
                       + multTecnica * jugadoresLocal.get(i).getTecnica() * equipoLocal.getEntrenador().getPotTecnica());
            }

        ArrayList<Jugador> jugadoresVisitante = equipoVisitante.getJugadores();        
        for (int i = 0; i < jugadoresVisitante.size(); i++) {
            switch(equipoVisitante.getCaracPrincipal()){
                
                case FUERZA:
                    multFuerza=2;
                    break;
                    
                case RESISTENCIA:
                    multResistencia = 2;
                    break;
                    
                case VELOCIDAD:
                    multVelocidad = 2;
                    break;
                    
                case PRECISION:
                    multPrecision = 2;
                    break;
                    
                case TECNICA:
                    multTecnica = 2;
                    break;
            }
            sumaCaracVisi = ( multFuerza * jugadoresVisitante.get(i).getFuerza() * equipoVisitante.getEntrenador().getPotFuerza()
                        + multResistencia * jugadoresVisitante.get(i).getResistencia() * equipoVisitante.getEntrenador().getPotResistencia()
                        + multVelocidad * jugadoresVisitante.get(i).getVelocidad()* equipoVisitante.getEntrenador().getPotVelocidad()
                        + multPrecision * jugadoresVisitante.get(i).getPrecision() * equipoVisitante.getEntrenador().getPotPrecision()
                        + multTecnica * jugadoresVisitante.get(i).getTecnica() * equipoVisitante.getEntrenador().getPotTecnica());
        }
        
        
        for (int i = 0; i < 5; i++) {
            
            float puntLocal = aleatorio.nextInt((int)sumaCaracLocal) / 2 + sumaCaracLocal / 2;
            float puntVisitante = aleatorio.nextInt((int)sumaCaracVisi) / 2 + sumaCaracVisi / 2;
            
                int valorAleatorio;
                
                if (puntLocal > puntVisitante){
                    valorAleatorio = aleatorio.nextInt(3);
                        if(valorAleatorio >= 2){
                            this.golesLocal ++;
                        }
                }
                
                else if(puntVisitante > puntLocal){
                    valorAleatorio = aleatorio.nextInt(3);
                        if(valorAleatorio >= 2){
                            this.golesVisitante ++;
                        }
                }
        }
        
        this.jugado=true;
    }
    

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }  

    public byte getGolesLocal() {
        return golesLocal;
    }

    public byte getGolesVisitante() {
        return golesVisitante;
    }

    
    
    
    
}
