package src.ente;

public class Elfo extends Heroe{
    public Elfo(int vida, int armadura, String nombre){
        super(vida, armadura, nombre);
    }

    @Override
    public int modificadorAtaque(Ente enemigo){
        int res = 0;
        if(enemigo instanceof Trasgo){
            res =  20;
            System.out.println(this.toString()+ " le tuvo furia al trasgo");
        }
        return res;
    }
}
