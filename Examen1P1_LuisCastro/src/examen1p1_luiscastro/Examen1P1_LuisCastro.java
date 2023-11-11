/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_luiscastro;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lfern
 */
public class Examen1P1_LuisCastro {
static Scanner leer = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("*****Menu*****");
        System.out.println("1. Fight or Flight.");
        System.out.println("2. Tri Fuerza.");
        System.out.println("3+. Salir del programa.");
        System.out.println("Ingrese su opcion: ");
        int opcion = leer.nextInt();
        
        while(opcion>=1 && opcion <=2){
            switch(opcion){
                case 1:
                    System.out.println("Fight or Flight.");
                    int opcion2;
                    char respuesta = 's';
                    int vida_zombie = 25;
                    int balas = 25;
                    double prob_danno = 65;
                    System.out.println("Ingrese maestria: ");
                    System.out.println("1. Principiante (0% de hit extra + extra damage. ");
                    System.out.println("2. Intermedio (5% de hit extra + extra damage. ");
                    System.out.println("3. Experto (15% de hit extra + extra damage. ");
                    opcion2 = leer.nextInt();
                    
                    if(opcion2 == 1){
                        prob_danno = 65 + 0;
                    }else if(opcion2 == 2){
                        prob_danno = 65 + 5;
                    }else if (opcion2 == 3){
                        prob_danno = 65 + 15;
                    }
                    
                    int distancia =  new Random().nextInt((30 - 15) + 1) + 15;
                    System.out.println("El zombie esta a "+distancia + "metros.");
                    System.out.println("El jugador cuenta con "+balas+" balas!");
                    
                    while(vida_zombie !=0 && distancia !=0 && balas !=0 && (respuesta == 's'|| respuesta == 'S')){
                        while (respuesta=='s'||respuesta=='S'){
                            int probabilidad = new Random().nextInt((100-1)+1)+1;
                        
                            if(probabilidad < prob_danno){
                                int danno_causado = new Random().nextInt((7-1)+1)+1;
                                vida_zombie = vida_zombie - danno_causado;
                                System.out.println("Hit! El tiro ha reducido el HP del zombie un total de:"+danno_causado);
                                    if(vida_zombie <=0){
                                        vida_zombie = 0;
                                    }
                                System.out.println("Vida restante del zombie:"+vida_zombie);
                                }
                            if(probabilidad > prob_danno){
                                int distancia_movida = new Random().nextInt((5-3)+1)+3;
                                distancia = distancia - distancia_movida;
                                    if(distancia <=0){
                                        distancia = 0;
                                    }
                                System.out.println("Ha fallado! El zombie se encuentra a "+distancia+ " metros.");
                            }
                            
                            
                            balas = balas-1;
                            System.out.println("El jugador cuenta con "+balas+" balas!");
                            if(balas==0){
                            System.out.println("GAME OVER, las balas se redujeron a 0.");
                            break;
                            }
                            if(distancia == 0){
                                System.out.println("GAME OVER, la distancia se redujo a 0.");
                                break;
                            }
                            if(vida_zombie<=0){
                                System.out.println("Vida restante del zombie: 0.");
                                System.out.println("YOU WIN! La vida del zombie se ha reducido a 0.");
                                break;
                            }
                        System.out.println("Listo para la siguiente ronda? [S/N]");
                        respuesta = leer.next().charAt(0);
                            if(respuesta != 's' && respuesta != 'S'){
                            break;
                            }
                        }//fin while ronda
                    }//fin while externo
                    break;
                case 2:
                    TriFuerza();
                    break;
            }//fin del switch
            System.out.println("*****Menu*****");
            System.out.println("1. Fight or Flight.");
            System.out.println("2. Tri Fuerza.");
            System.out.println("3+. Salir del programa.");
            System.out.println("Ingrese su opcion: ");
            opcion = leer.nextInt();
        }//fin while
    }//fin main
    
    public static void TriFuerza(){
        System.out.println("TriFuerza.");
        System.out.println("El numero tiene que ser par y mayor a 20.");
        System.out.println("Ingrese un tamaño.");
        int tam = leer.nextInt();
        
        while(tam%2 != 0 || tam < 20||tam%4==0){
            System.out.println("Numero Invalido! Tiene que ser par y mayor a 20!");
            System.out.println("La division del numero entre 2 tiene que dar impar.");
            System.out.println("Ingrese de nuevo: ");
            tam = leer.nextInt();
        }
        int num = tam;
        for(int i = 0; i < (tam/2); i++){
            for(int j = 0; j < tam+1; j++){
                if (j-1 == i|| i+num ==j){
                    System.out.print(" ");
                }
                if(j >=(tam/2)- i - 1  && j <= (tam/2) + i + 1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            num -=2;
            System.out.println("");
        }
        
    }//fin metodo trifuerza
}//fin de la clase
