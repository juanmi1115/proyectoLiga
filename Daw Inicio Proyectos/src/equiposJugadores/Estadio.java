package equiposJugadores;

public class Estadio {
    private String nombre; //Aqui se guarda el nombre del estadio.
    private String [][] matrizCampo; //Aqui se guarda la matriz del campo.

    
    
    
    public Estadio(String nombre, String[][] matrizCampo) {
        this.nombre = nombre;
        this.matrizCampo = matrizCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public String [][] getMatrizCampo() {
        return matrizCampo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatrizCampo(String[][] matrizCampo) {
        this.matrizCampo = matrizCampo;
    }

    @Override
    public String toString() {
        return nombre + " Campo=" + leerMatriz(matrizCampo);
    }
    
    public String leerMatriz(String [][] matrizCampo){
        String s = "";
        for (int i = 0; i < matrizCampo.length; i++) {
            for (int j = 0; j < matrizCampo[i].length; j++) {
               s+=matrizCampo[i][j];
            }
        }
            return s;
    }
         
}
