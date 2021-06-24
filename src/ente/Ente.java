package src.ente;

public class Ente {

    // Sobrecarga de metodos
    public Ente(int limiteSuperior, String nombre, int vida, int resistenciaArmadura, int cantidadDados) {
        this.limiteSuperior = limiteSuperior;
        this.nombre = nombre;
        this.vida = vida;
        this.resistenciaArmadura = resistenciaArmadura;
        this.cantidadDados = cantidadDados;
    }

    public Ente(int vida, int resistenciaArmadura, String nombre) {
        this.vida = vida;
        this.nombre = nombre;
        this.resistenciaArmadura = resistenciaArmadura;
    }

    public Ente(String nombre) {
        this.nombre = nombre;
    }

    public int getAleatorio(){
        return (int)(Math.random()*100);
    }

    public void atacarEnte(Ente enemigo){
        int ataque = getAleatorio()+modificadorAtaque(enemigo);
        enemigo.recibirAtaque(this, ataque);
    }

    public int modificadorAtaque(Ente enemigo){
        int res = 0;
        if(enemigo instanceof Trasgo){
            res = 20;
        }
        return res;
    }

    public int modificadorDefensa(Ente enemigo){
        return 0;
    }
    public void recibirAtaque(Ente enemigo, int danioAtaque){
        int ataqueRecibido = danioAtaque + modificadorDefensa(enemigo);
        if(this.getResistenciaArmadura()<ataqueRecibido){
            this.setVida(this.vida - ataqueRecibido); 
        } else {
            System.out.println(enemigo.toString()+" no logró atacar a "+ this.toString());
        }
    }
    // Getters y setters

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if(vida<=0){
            this.vida = 0;
            System.out.println("Ha muerto: "+this.toString());
        } else {
           this.vida = vida;
        }
       
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getResistenciaArmadura() {
        return resistenciaArmadura;
    }

    public void setResistenciaArmadura(int resistenciaArmadura) {
        this.resistenciaArmadura = resistenciaArmadura;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(int limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public int getCantidadDados() {
        return cantidadDados;
    }

    public void setCantidadDados(int cantidadDados) {
        this.cantidadDados = cantidadDados;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + cantidadDados;
        result = prime * result + limiteSuperior;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + resistenciaArmadura;
        result = prime * result + vida;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ente other = (Ente) obj;
        if (cantidadDados != other.cantidadDados)
            return false;
        if (limiteSuperior != other.limiteSuperior)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (resistenciaArmadura != other.resistenciaArmadura)
            return false;
        if (vida != other.vida)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ente [cantidadDados=" + cantidadDados + ", limiteSuperior=" + limiteSuperior + ", nombre=" + nombre
                + ", resistenciaArmadura=" + resistenciaArmadura + ", vida=" + vida + "]";
    }

    // Variables ocultas
    private int vida;
    private String nombre;
    private int resistenciaArmadura;
    private int limiteSuperior;
    private int cantidadDados;
}
