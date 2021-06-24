package src.main;

import java.util.Scanner;

import src.ente.*;

public class LOTR {
    public LOTR(){
        h1 = new Elfo(250, 40, "Legolas");
        heroes[0] = h1; 
        b1 = new Orco(250, 40, "Orco");
        bestias[0] = b1;
        h2 = new Trasgo(250, 40, "Trasgo");
        heroes[1] = h2;
        b2 = new Hobbit(250, 40, "Frodo");
        bestias[1] = b2;
    }

    public void iniciarComponentes() {

        menu();
    }

    private void menu() {
        int opcion;

        System.out.println("Bienvenido al juego del señor de los anillos.");

        do {
            System.out.println("\n  ---------- Menu ----------  " 
                             + "\n1. Jugar"
                             + "\n2. Mostrar ejercito bueno"
                             + "\n3. Mostrar ejercito malo"
                             + "\n4. Salir"
                             + "\nDigite una opción: ");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    batalla();
                    break;
                case 2:
                    System.out.println("Lista de heroes");
                    mostrarHeroes();
                    break;
                case 3:
                    System.out.println("Lista de bestias");
                    mostrarBestias();
                    break;
                case 4:
                    System.out.println("¡Saliendo del programa!");
                    break;
                default:
                System.out.println("¡Opción inválida!");
            }
        } while (opcion != 4);
    }

    public void batalla(){
        int i;
        boolean seguir = true;
        while(seguir){
            i=0;
            //Los entes se atacan
            while(ejercito>i){
                if(heroes[i].getVida()>0 && bestias[i].getVida()>0){
                    heroes[i].atacarEnte(bestias[i]);
                    bestias[i].atacarEnte(heroes[i]);
                    System.out.println("\n\n");
                }
                i++;
            }
            
            //Encontrar la cantidad de vida que tienen
            for(int j=0; j<ejercito; j++){
                if(heroes[j].getVida()>0 && bestias[j].getVida()>0){
                    seguir = true;
                    break;
                } else {
                    seguir = false;
                }
            }
        }
        
        System.out.println("Todos los elementos de un ejercito se murió.");
        
    }

    private void mostrarHeroes(){
        int i=0;
        while(ejercito>i){
            System.out.println((i+1)+ ". "+heroes[i].toString());
            i++;
        }
    }

    private void mostrarBestias(){
        int i=0;
        while(ejercito>i){
            System.out.println((i+1)+ ". "+bestias[i].toString());
            i++;
        }
    }

    private int ejercito = 2;
    private Ente h1;
    private Ente b1;
    private Ente h2;
    private Ente b2;
    private Ente[] heroes = new Ente[10];
    private Ente[] bestias = new Ente[10];
    private Scanner entrada = new Scanner(System.in);
}