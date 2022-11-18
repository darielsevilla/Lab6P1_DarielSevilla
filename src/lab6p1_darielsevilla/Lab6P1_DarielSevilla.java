/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_darielsevilla;

import java.util.Scanner;
import java.security.SecureRandom;

public class Lab6P1_DarielSevilla {
    static Scanner lea = new Scanner(System.in);
    static SecureRandom random = new SecureRandom();
    //metodo apuntador 
    public static String apuntador(String pointer, int[] aleatorio){
        int size = 0;
        for(int i = 0; i < pointer.length(); i++){
            if(pointer.charAt(i) == 'x'){
                size++;
            }
        }
        String resp = "";
        
        
        int point = 0;
        int respPoint = 0;
        for(int i = 0; i < pointer.length(); i++){
            if(pointer.charAt(i) == 'r'){
                point++;
            } else if(pointer.charAt(i) == 'l'){
                point--;
            } else if(pointer.charAt(i) == 'x'){
                resp += aleatorio[point];
                respPoint++;
            }
            
        }
        
        return resp;
    }
    //metodo imprimir array
    public static void imprimir(int[] imp){
        //impresion de arrays
        for(int i = 0; i < imp.length; i++){
            System.out.printf("[%d]",imp[i]);
            
            if(i == imp.length - 1){
                System.out.println("");
            }
        }
    }
    //metodo creacion de nuevo arreglo
    public static int[] arrayNum(int par){
        
        int[] resp = new int[4];
        int[] resp2 = new int[4];
        
        for(int i = 0; i < 4; i++){
            resp[i] = par % 10;
            par /= 10;
        }
        
        for(int i = 0; i < resp.length; i++){
            resp2[i] = resp[resp.length - (i+1)];
        }
        
        return resp2;        
    }
    //metodo ordenacion de arreglo
    public static int[] ascendente(int[] par){
        //crea arreglo del tamaño del parametro
        int[] resp = new int[par.length];
        
        for(int i = 0; i < par.length; i++){
            resp[i] = par[i];
        }
        //primer for pasa por todos los caracteres
        for(int i = 0; i < resp.length; i++){
            /*segundo por pasa por todos los caracteres. Esto se hace una vez por cada caracter. El objetivo es determinar que caracter va en cada
            posicion i, por ende, cuando se determine, ese caracter i en especifico no se necesitara en el siguente ciclo. por eso int j empieza en i y no en 0*/
            for(int j = i; j < resp.length; j++){
                /*se compara el caracter en i con cada caracter en j. si el caracter en j es menor que i, cambian de jugar, usando temp para que el valor en i
                no se pierda al redeclararlo con el valor en posicion j. Asi hasta q j pase por todos los caracteres. Si esto se hiso cada vez que i fue major que un
                caracter, al final i deberia ya ser el mas bajo, por lo que ya no se alterara esta posicion y el siguiente ciclo j empezara en la posicion del siguiente i
                */
                if(resp[i] > resp[j]){
                    int temp = resp[i];
                    resp[i] = resp[j];
                    resp[j] = temp;
                
                }
            }
        }
        
        return resp;
    }
    //metodo descendiente
    public static int[] descendiente(int[] par){
        int[] resp = new int[par.length];
        
        for(int i = 0; i < par.length; i++){
            resp[i] = par[i];
        }
        for(int i = 0; i < resp.length; i++){
            for(int j = i; j < resp.length; j++){
                if(resp[i] < resp[j]){
                    int temp = resp[i];
                    resp[i] = resp[j];
                    resp[j] = temp;
                
                }
            }
        }
        return resp;
    }
    //metodo ordenacion descendiente
    public static int conversion(int [] par){
        int resp = 0;
        for(int i = 0; i < par.length; i++){
            resp += par[par.length-(i+1)] * Math.pow(10, i);
        }
        return resp;
    }
    //metodo kaprekar
    public static void keprekar(int num1){
        int tempo = num1;
        for(int i = 0; i < 7; i++){
            int[] arr = arrayNum(tempo);
            int numero1 = conversion(ascendente(arr));
            int numero2 = conversion(descendiente(arr));
            int respuesta = numero2 - numero1;
            System.out.println(numero2 + " - " + numero1 + " = " + respuesta);
            tempo = respuesta;
            if(respuesta == 6174){
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        int menu;
        do{
            //entrada
            System.out.println("\n\n--Menu opciones--\n");
            System.out.println("1-Turing");
            System.out.println("2-Kaprekar");
            System.out.println("3-Salida");
            System.out.print("Elija opcion:");
            menu = lea.nextInt();
            
            //menu switch
            switch(menu){
                case 1:
                    System.out.print("Ingrese tamaño de cadena:");
                    int tam = lea.nextInt();
                    int[] temp = new int[tam];
                    
                    for(int i = 0; i < tam; i++){
                        temp[i] = random.nextInt(10);    

                    }
                    //impresion y entrada de apuntador
                    System.out.print("Arreglo aleatorio: ");
                    imprimir(temp);
                    String pointer;
                    boolean test = true;
                    do{
                        test = true;
                        System.out.print("Ingrese comandos de apuntador (r,l,x):");
                        pointer = lea.next().toLowerCase();
                        int cont = 0;
                        //alidacion de que no se sobrepasen del liite 
                        for(int i = 0; i < pointer.length(); i++){
                            if(pointer.charAt(i) == 'r'){
                                cont++;
                            } else if (pointer.charAt(i) == 'l'){
                                cont--;
                            }
                            
                            if(cont < 0 || cont >= tam){
                                System.out.println("*Sus comandos sobrepasan en limite del arreglo*");
                                test = false;
                                break;
                            }
                            
                        }
                    }while(test == false);
                    
                    
                    String newArray = apuntador(pointer, temp);
                    System.out.println("Respuesta: ");
                    System.out.print(newArray);
                    
                    break;
                case 2:
                    int num1 = 0;
                    boolean check = true;
                    do{
                        System.out.print("Ingrse un numero de 4 digitos (que no sean todos iguales): ");
                        num1 = lea.nextInt();
                        int tempo = num1;
                    
                        int cont = 0;
                        
                        while(tempo != 0){
                            tempo /= 10;
                            cont++;
                            
                        }
                        
                        tempo = num1;
                        int igual = 0;
                        int digito = num1 % 10;
                        
                        for(int i = 1; i <= 4; i++){
                            if(tempo % 10 != digito){
                                
                                igual++;
                            }
                            tempo /= 10;
                        }
                        
                        if(cont != 4 || igual == 0){
                            check = false;
                        } else {
                            check = true;
                        }
                        
                   
                    }while(check == false);
                    
                    keprekar(num1);
                    break;
                
            }
        }while(menu != 3);
    }
}
