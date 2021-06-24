package src.ente;

public class Hobbit extends Heroe{
    

    public Hobbit(int vida, int resistenciaArmadura, String nombre) {
        super(vida, resistenciaArmadura, nombre);
    }

    @Override
    public int modificadorDefensa(Ente enemigo){
        int res = 0;
        if(enemigo instanceof Trasgo){
            res = - 20;
            System.out.println(this.toString()+ " le tuvo miedo al trasgo");
        }
        return res;
    }
}
