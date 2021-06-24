package src.ente;

import src.ente.Ente;

public class Heroe extends Ente{

    
    public Heroe(int vida, int resistenciaArmadura, String nombre) {
        super(vida, resistenciaArmadura, nombre);
    }

    public Heroe(String nombre){
        super(nombre);
    }

    public void muerto(){

    }
}
