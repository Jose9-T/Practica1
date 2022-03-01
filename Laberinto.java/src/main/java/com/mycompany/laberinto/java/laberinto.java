
package com.mycompany.laberinto.java;
import java.util.Scanner;

public class laberinto {
static Scanner scanner = new Scanner(System.in);
// mover
static String MOVER;
static final String ARRIBA = "N";
static final String ABAJO = "S";
static final String DERECHA = "E";
static final String IZQUIERDA = "O";
static String POSICION;

static int opcionOro;
static int LEVANTARORO = 1;
static int SEGUIR = 2;
static String temp;


//modo de juego 
    static int modoDeJuego;
   
    static String nombreJugador;
    //Casillas para el tablero
    static String ubicacionJugador = "J";
    static String ubicacionBot = "B";
    static String casillaVacia = "O";
    static String oro = "G";
    static String salirLaberinto = "S";
    static String pared = "#";
    
    
// tablero1 peincipiante    
static String tablero1[][] = new String[10][10];
static boolean [][]aux=  new boolean[10][10];

// juego predeterminado modo Intermedio:
static String tablero2[][] = new String[12][12];

// juego avanzado
static String [][] tablero3 = new String[30][30];

// creador de mapas
static String nombreMapa;
        // numero de oro, pared, casillasvacias, jugador, bot, salidas y caracter de respresentacion de cada uno
static int oroo = 0;
static String repOro;//representar oro
static int paredd = 0;
static String repPared; //representar pared
static int vacias = 0;
static String repVacias;//representar casillas vacias
static int salidas = 0;
static String repSalidas;//representar Salidas

static String repJugador;// representar al jugador
static String repBot;//representar al bot
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //menu principal
       
        int opcionJugar;
        
        do{
        System.out.println("\t BIENVENIDO AL LABERINTO");
        System.out.println("Elige una opción");
        System.out.println("1. Jugar");
        System.out.println("2. Crear mapa");
        System.out.println("3. Reportes");
        System.out.println("4. Salir");
        opcionJugar = scanner.nextInt();
        
        if (opcionJugar==1){
        System.out.println("Elige el modo de juego");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Avanzado");
        modoDeJuego = scanner.nextInt();
            if (modoDeJuego==1){
                principiante ();
                moverse ();
            } if (modoDeJuego==2){
                intermedio ();
                movInter();
            } if (modoDeJuego==3){
                avanzado ();
                movAva();
            } 
        } if (opcionJugar == 2){
            crearM();
        }
        } while(opcionJugar != 4);
        
        System.out.println("Saliendo del juego, regresa pronto!!");
        
    
    }
    public static String [][] principiante (){
    //Juego predeterminado
         
         //Juego predeterminado llenado de la tabla
   for (int fila = 0; fila < 10;fila++){
        for (int col = 0; col< 10; col ++) {
        // pared fila
        if (fila == 0 || fila == 9) {
        tablero1[fila][col] = pared;
        } if ((fila == 2) && (col==1||col==2||col==3 ||col==5 || col== 6)) {
             tablero1[fila][col] = pared;    
             } if ((fila == 5 || fila == 7)&& (col== 2 || col == 3 || col == 4 || col == 5)) {
                tablero1[fila][col]= pared;
                }if ((fila == 6) && (col== 0 || col==9 )){
                tablero1[fila][col]= pared;
                }// pared columna
                    if (col == 9){
                    tablero1[fila][col] = pared;
                    } if ((fila == 1 ||fila == 2 ||fila == 3 ||fila == 4 ||fila == 5 ||fila==7 ||fila ==8) && (col==7 )){
                        tablero1[fila][col] = pared;
                        } if ((fila == 3 || fila == 4) && ( col ==5)){
                            tablero1[fila][col] = pared;
                            } if((fila== 8)&& (col== 2)) {
                            tablero1[fila][col] = pared;
                            }if ((fila == 2 ||fila == 3 ||fila == 4 ||fila == 5 ||fila==6 || fila ==7 ) && (col == 0)){
                            tablero1[fila][col] = pared;
                            } // casillas vacia
                                        if ((fila==1)&& (col==1 || col == 2 || col == 3 || col == 4|| col == 5)) {
                                        tablero1[fila][col]= casillaVacia; 
                                        } if ((fila==2)&& (col ==4|| col==8)){
                                            tablero1[fila][col]= casillaVacia; 
                                            } if ((fila==3)&&(col == 2 || col == 3 || col == 4||col == 8)){
                                                tablero1[fila][col]= casillaVacia;
                                                }if ((fila == 4)&&(col==1 || col == 2 || col == 3 ||col == 6||col == 8)){
                                                    tablero1[fila][col]= casillaVacia;
                                                    } if ((fila==5|| fila==7 ) && (col==1 ||col == 6||col == 8)){
                                                        tablero1[fila][col]= casillaVacia;
                                                        } if ((fila==6)&& (col== 1 || col == 2 || col == 3 ||col == 4||col == 5|| col==6|| col==7|| col==8)) {
                                                        tablero1[fila][col]= casillaVacia;
                                                        } if ((fila ==8) && (col==4||col==5)){
                                                        tablero1[fila][col]= casillaVacia;
                                                        }
                                // distribucion de oro
                                  if ((fila ==1 || fila==8) && (col == 6 || col == 8)) {
                                        tablero1[fila][col]= oro;
                                       } if ((fila==3 || fila==8) && (col == 1)){
                                           tablero1[fila][col]= oro;
                                           } if ((fila == 8) && (col == 3)){
                                               tablero1[fila][col]= oro;
                                            // Salidas
                                           } if ((fila == 1 || fila == 8) && (col == 0)){
                                        tablero1[fila][col]= salirLaberinto;
                                        }

                                        //jugador
                                        if ((fila == 3) && (col == 6)){
                                        tablero1[fila][col]= ubicacionJugador;
                                        }

                                         // posicion de bot
                                        if ((fila == 4) && (col == 4)){
                                         tablero1[fila][col]= ubicacionBot;
                                        }
                                        

       
    }
        
    }
        System.out.println("\t Bienvenido al Laberinto");
            System.out.println("Antes de iniciar introduce tu nombre:");
            nombreJugador = scanner.next();
            System.out.println("Bienveido al laberinto, aventurero "+nombreJugador);
            System.out.println("Para ganar debes recoger al menos 5 de Oro");
        		
            for (int fila = 0; fila < 10; fila++){
                        for (int col = 0; col < 10; col ++) {
			System.out.print(tablero1[fila][col]+ " ");
			}
			System.out.println(" ");
                        }
return tablero1;
}
    // movimientos para jugar mapa principiante
 public static String [][] moverse(){
    
int oroEncontrado= 0;
int oroSalir = 5;
boolean modificado = false;

System.out.println("Para moverte debes usar");
System.out.println("Arriba = N, "+"Abajo = S, "+ "Derecha = E, "+"Izquierda = O.");
MOVER = scanner.next();
 
for (int i=0; i<tablero1.length; i++){
    for (int j=0; j<tablero1.length; j++){
    
    if (MOVER.equals(ABAJO)){
    modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero1[i++][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero1[i++][j]);
            } else 
            
            if (tablero1[i++][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } 
            
                if(tablero1[i++][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero1[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero1[i][j]);
                    }                
        } else
            if (MOVER.equals(ARRIBA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero1[i--][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero1[i--][j]);
            } else 
                if (tablero1[i--][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } 
            
                if(tablero1[i--][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero1[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero1[i][j]);
                    }
            }else
            if (MOVER.equals(DERECHA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                if(tablero1[i][j++].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero1[i][j++]);
            } else 
                if (tablero1[i][j++].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                if(tablero1[i][j++].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero1[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero1[i][j]);
                    }
            } else
            if (MOVER.equals(IZQUIERDA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                if(tablero1[i][j--].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero1[i][j--]);
            } else 
                if (tablero1[i][j--].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                if(tablero1[i][j--].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero1[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero1[i][j]);
                    }
            }
    }
} 
return tablero1;
}
 
 public static String [][] intermedio (){
                
        for (int fila = 0; fila < 12; fila++) {
            for (int col = 0; col < 12; col++) {
                // pared fila
                if ((fila == 0) && (col == 2 || col == 3 || col == 4 || col == 5 || col == 6 || col == 7 || col == 8 || col == 9 || col == 10 || col == 11)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 2) && (col == 2 || col == 3 || col == 4 || col == 8 || col == 9)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 4) && (col == 4 || col == 5 || col == 6 || col == 7)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 5) && (col == 4 || col == 7 || col == 8 || col == 9)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 6) && (col == 1 || col == 2 || col == 4 || col == 5)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 7) && (col == 2 || col == 7 || col == 8)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 9) && (col == 2 || col == 3 || col == 4 || col == 5 || col == 8 || col == 9)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 11) && (col == 1 || col == 2 || col == 3 || col == 4 || col == 5 || col == 6 || col == 7 || col == 8 || col == 9)) {
                    tablero2[fila][col] = pared;
                }
                
                // pared columnas
                if ((fila == 0 || fila == 1 || fila == 2 || fila == 3 || fila == 4 || fila == 5 || fila == 6 || fila == 7 || fila == 8 || fila == 9 || fila == 10 || fila == 11) && (col == 0)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 2 || fila == 3 || fila == 4 || fila == 5) && (col == 2)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 7 || fila == 8) && (col == 5)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 1 || fila == 2) && (col == 6)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 1 || fila == 10) && (col == 8)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 3 || fila == 4 || fila == 8) && (col == 9)) {
                    tablero2[fila][col] = pared;
                }
                if ((fila == 1 || fila == 2 || fila == 3 || fila == 4 || fila == 5 || fila == 6 || fila == 7 || fila == 8 || fila == 9 || fila == 10 || fila == 11) && (col == 11)) {
                    tablero2[fila][col] = pared;
                }
                
                // casillas vacias
                if ((fila == 1 || fila == 2 || fila == 3 || fila == 4|| fila == 8 || fila == 9 || fila == 10)&&(col==1)) {
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==1|| fila==8 |fila==10)&& (col==2)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==1||fila == 3 || fila == 4 || fila == 5 || fila == 6 || fila == 7 || fila == 8||fila==10)&&(col==3)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==1||fila==3||fila==7||fila==10)&&(col==4)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==1||fila==2||fila==3||fila==10) && (col==5)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==3||fila==6||fila==7||fila==8||fila==9||fila==10)&&(col==6)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==2||fila==3||fila==6||fila==8||fila==9)&&(col==7)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==3|| fila==6)&&(col==8)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila==6)&&(col==9)){
                tablero2[fila][col] = casillaVacia;
                }
                if ((fila == 1 || fila == 2 || fila == 3 || fila == 4||fila == 5 || fila == 6 || fila == 7 || fila == 8 || fila == 9 || fila == 10)&& (col==10)){
                tablero2[fila][col] = casillaVacia;
                }
                
                // Distriucion de oro
                if ((fila == 1) && (col == 7 || col == 9)) {
                    tablero2[fila][col] = oro;
                }
                if ((fila == 5) && (col == 1 || col == 6)) {
                    tablero2[fila][col] = oro;
                }
                if ((fila == 7) && (col == 1 || col == 9)) {
                    tablero2[fila][col] = oro;
                }
                if ((fila == 8) && (col == 4 || col == 8)) {
                    tablero2[fila][col] = oro;
                }
                if ((fila == 10) && (col == 7 || col == 9)) {
                    tablero2[fila][col] = oro;
                }
                
                //salidas
                if ((fila==0)&& (col==1)){
                    tablero2[fila][col] = salirLaberinto;
                }
                if ((fila==11)&& (col==10)){
                    tablero2[fila][col] = salirLaberinto;
                }
                
                //Ubicacion de jugador
                if ((fila==5)&& (col==5)){
                tablero2[fila][col] = ubicacionJugador;
                }
                
                //ubicacion Bot
                if ((fila==4)&& (col==8)){
                tablero2[fila][col] = ubicacionBot;
                }
                
            }
        }
        System.out.println("\t Bienvenido al Laberinto");
            System.out.println("Antes de iniciar introduce tu nombre:");
            nombreJugador = scanner.next();
            System.out.println("Bienvenido al laberinto"+" "+nombreJugador);
            System.out.println("Para ganar debes recoger al menos 8 de Oro");
        		for (int fila = 0; fila < 12; fila++){
                            for (int col = 0; col < 12; col ++) {
                            System.out.print(tablero2[fila][col]+ " ");
                            }
			System.out.println(" ");
                        }
return tablero2;
}
 
    // movimientos para jugar mapa Intermedio
 public static String [][] movInter(){
    
int oroEncontrado= 0;
int oroSalir = 8;
boolean modificado = false;

System.out.println("Para moverte debes usar");
System.out.println("Arriba = N, "+"Abajo = S, "+ "Derecha = E, "+"Izquierda = O.");
MOVER = scanner.next();
 
for (int i=0; i<tablero2.length; i++){
    for (int j=0; j<tablero2.length; j++){
    
    if (MOVER.equals(ABAJO)){
    modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero2[i++][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero2[i++][j]);
            } else 
            
            if (tablero2[i++][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } 
            
                if(tablero2[i++][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero2[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero2[i][j]);
                    }                
        } else
            if (MOVER.equals(ARRIBA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero2[i--][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero2[i--][j]);
            } else 
                if (tablero2[i--][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } 
            
                if(tablero2[i--][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero2[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero2[i][j]);
                    }
            }else
            if (MOVER.equals(DERECHA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                    if(tablero2[i][j++].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero2[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero2[i][j]);
                    }
                if(tablero2[i][j++].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero2[i][j++]);
            } else 
                if (tablero2[i][j++].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                
            } else
            if (MOVER.equals(IZQUIERDA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                if(tablero2[i][j--].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero2[i][j--]);
            } else 
                if (tablero2[i][j--].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                if(tablero2[i][j--].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero2[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero2[i][j]);
                    }
            }
    }
} 
return tablero2;
}

 public static String [][]avanzado(){
        
        //String [][] posicion;
        //String vista[][] =new String[5][5];
        //String guardar;
        //String name;
        
        for (int fila=0; fila<tablero3.length; fila++){
            for (int col=0; col<tablero3.length; col++){
            // Pared
            if ((fila==0)&& (col==0 ||col== 1||col==2||col==3||col==4||col==5||col==6||col==7||col==9||col==10||col==11||col==12||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==25||col==26||col==27||col==28||col==29)){
                tablero3[fila][col]= pared;
            } if ((fila==1)&& (col==7||col==17||col==26)){
                tablero3[fila][col]= pared;
            } if ((fila==2)&&(col==0||col==1||col==2||col==3||col==4||col==5||col==8||col==9||col==10||col==12||col==13||col==14||col==16||col==19||col==20||col==21||col==22||col==23||col==24||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==3)&&(col==0||col==5||col==7||col==10||col==12||col==14||col==16||col==18||col==20||col==24||col==25||col==29)){
                tablero3[fila][col]= pared;
            } if ((fila==4)&& (col==0||col==2||col==3||col==5||col==10||col==12||col==14||col==16||col==17||col==20||col==22||col==25||col==27||col==29)){
                tablero3[fila][col] = pared;
            } if ((fila==5)&&(col==0||col==2||col==5||col==7||col==8||col==9||col==10||col==11||col==12||col==14||col==18||col==20||col==22||col==23||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]= pared;
            } if((fila==6)&& (col==0||col==2||col==3||col==10||col==12||col==22||col==27||col==28||col==29)){
                tablero3[fila][col]= pared;
            } if ((fila==7)&&(col==0||col==1||col==5||col==7||col==9||col==12||col==13||col==15||col==16||col==18||col==19||col==20||col==21||col==22||col==24||col==26||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==8)&& (col==0||col==3||col==5||col==9||col==11||col==13||col==16||col==18||col==24||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==9)&&(col==0||col==2||col==3||col==5||col==6||col==7||col==9||col==11||col==13||col==14||col==16||col==18||col==19||col==20||col==22||col==23||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if((fila==10)&&(col==0||col==5||col==7||col==9||col==11||col==13||col==16||col==18||col==19||col==20||col==22||col==23||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==11)&& (col==0||col==1||col==2||col==4||col==9||col==11||col==13||col==14||col==16||col==17||col==18||col==19||col==20||col==22||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==12)&&(col==0||col==3||col==6||col==7||col==8||col==11||col==13||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==13)&&(col==0||col==1||col==3||col==4||col==6||col==9||col==11||col==15||col==17||col==18||col==20||col==23||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==14)&&(col==0||col==3||col==6||col==8||col==9||col==11||col==13||col==15||col==16||col==19||col==22||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==15)&&(col==0||col==1||col==3||col==4||col==9||col==11||col==12||col==13||col==15||col==21||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==16)&&(col==0||col==3||col==6||col==8||col==9||col==12||col==15||col==17||col==18||col==19||col==20||col==21||col==23||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==17)&&(col==0||col==1||col==5||col==6||col==7||col==9||col==13||col==17||col==26||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==18)&&(col==0||col==2||col==4||col==9||col==12||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==19)&&(col==0||col==2||col==6||col==7||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==20)&&(col==0||col==2||col==3||col==4||col==5||col==6||col==9||col==10||col==11||col==12||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==25||col==27||col==28||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==21)&&(col==0||col==2||col==6||col==8||col==23||col==25)){
                tablero3[fila][col]=pared;
            } if ((fila==22)&&(col==0||col==4||col==6||col==9||col==11||col==12||col==13||col==14||col==15||col==16||col==18||col==19||col==20||col==25||col==27||col==28||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==23)&&(col==0||col==2||col==3||col==4||col==6||col==8||col==11||col==16||col==20||col==22||col==23||col==24||col==25||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==24)&&(col==0||col==2||col==6||col==9||col==11||col==12||col==13||col==14||col==16||col==17||col==18||col==20||col==25||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==25)&&(col==0||col==2||col==3||col==4||col==6||col==7||col==8||col==9||col==11||col==16||col==18||col==20||col==21||col==22||col==24||col==26||col==27||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==26)&&(col==0||col==2||col==13||col==16||col==18||col==24||col==26||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==27)&&(col==0||col==2||col==3||col==4||col==5||col==6||col==7||col==8||col==9||col==10||col==12||col==14||col==15||col==16||col==18||col==20||col==21||col==22||col==23||col==24||col==28||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==28)&&(col==0||col==7||col==12||col==26||col==29)){
                tablero3[fila][col]=pared;
            } if ((fila==29)&& (col==0||col==1||col==2||col==3||col==4||col==5||col==6||col==7||col==8||col==9||col==10||col==11||col==12||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==25||col==26||col==27||col==28||col==29)){
                tablero3[fila][col]=pared;
            }
            //casillas Vacias
            if ((fila==28)&&(col==1||col==2||col==3||col==4||col==5||col==5||col==8||col==9||col==10||col==11||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==25||col==27)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==27)&&(col==1||col==11||col==13||col==17||col==19||col==25||col==26||col==27)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==26)&&(col==1||col==3||col==4||col==5||col==6||col==7||col==8||col==9||col==10||col==11||col==12||col==14||col==15||col==17||col==19||col==20||col==21||col==22||col==23||col==25||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==25)&&(col==1||col==5||col==10||col==12||col==13||col==14||col==15||col==19||col==23||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==24)&&(col==1||col==4||col==5||col==7||col==10||col==15||col==19||col==21||col==22||col==23||col==24||col==26||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==23)&&(col==1||col==5||col==7||col==9||col==10||col==13||col==14||col==15||col==17||col==18||col==19||col==21||col==26)){
                tablero3[fila][col]= casillaVacia;
            } if ((fila==22)&&(col==1||col==2||col==3||col==5||col==7||col==8||col==10||col==17||col==21||col==22||col==23||col==24||col==26)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==21)&&(col==1||col==3||col==4||col==5||col==7||col==9||col==10||col==11||col==12||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==24||col==26||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==20)&&(col==1||col==7||col==8||col==23||col==24||col==26)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==19)&&(col==3||col==4||col==5||col==8||col==9||col==10||col==11||col==12||col==14||col==15||col==16||col==18||col==19||col==20||col==22||col==23||col==26)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==18)&&(col==3||col==5||col==6||col==7||col==8||col==10||col==11||col==25||col==26||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==17)&&(col==2||col==3||col==4||col==8||col==10||col==11||col==12||col==14||col==15||col==19||col==20||col==21||col==22||col==23||col==24||col==25||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==16)&&(col==1||col==2||col==4||col==5||col==7||col==10||col==11||col==13||col==14||col==16||col==22||col==24||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==15)&&(col==2||col==5||col==6||col==7||col==10||col==14||col==16||col==17||col==18||col==19||col==20||col==22||col==23||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==14)&&(col==1||col==2||col==4||col==5||col==7||col==10||col==14||col==17||col==18||col==19||col==20||col==21||col==23||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==13)&&(col==2||col==5||col==7||col==8||col==10||col==12||col==13||col==14||col==19||col==21||col==22||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==12)&&(col==1||col==2||col==4||col==5||col==9||col==10||col==12||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==11)&&(col==5||col==6||col==7||col==8||col==10||col==12||col==15||col==21||col==23||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==10)&&(col==1||col==2||col==3||col==4||col==6||col==8||col==10||col==12||col==14||col==15||col==17||col==18||col==21||col==22||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==9)&&(col==1||col==4||col==8||col==10||col==12||col==15||col==17||col==21||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==9)&&(col==1||col==4||col==8||col==10||col==12||col==15||col==17||col==21||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==8)&&(col==1||col==2||col==4||col==6||col==7||col==8||col==10||col==12||col==13||col==14||col==15||col==17||col==19||col==20||col==21||col==22||col==23||col==25||col==26)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==7)&&(col==2||col==3||col==4||col==6||col==8||col==10||col==11||col==14||col==17||col==23||col==25)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==6)&&(col==1||col==4||col==5||col==6||col==7||col==8||col==9||col==11||col==13||col==14||col==15||col==16||col==17||col==18||col==19||col==20||col==21||col==23||col==24||col==25||col==26)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==5)&&(col==3||col==4||col==6||col==13||col==15||col==16||col==17||col==19||col==21||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==4)&&(col==1||col==4||col==6||col==7||col==8||col==9||col==13||col==15||col==18||col==19||col==21||col==23||col==24||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==3)&&(col==1||col==2||col==4||col==6||col==11||col==13||col==15||col==19||col==21||col==22||col==23||col==26||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==2)&&(col==6||col==7||col==11||col==15||col==17||col==18||col==25||col==26||col==28)){
                tablero3[fila][col]=casillaVacia;
            } if ((fila==1)&&(col==1||col==2||col==3||col==4||col==5||col==6||col==8||col==9||col==10||col==11||col==12||col==13||col==14||col==15||col==16||col==18||col==19||col==20||col==21||col==22||col==23||col==24||col==25||col==27||col==28)){
                tablero3[fila][col]=casillaVacia;
            }
            //Salidas
            if((fila==0)&&(col==8)){
            tablero3[fila][col]=salirLaberinto;
            } if ((fila==1)&&(col==0||col==29)){
            tablero3[fila][col]=salirLaberinto;
            } if ((fila==21)&&(col==29)){
            tablero3[fila][col]=salirLaberinto;
            } if ((fila==29)&&(col==13)){
            tablero3[fila][col]=salirLaberinto;
            }
            //Oro
            if ((fila==3)&&(col==3||col==8||col==9||col==17)){
            tablero3[fila][col]=oro;
            } if ((fila==4)&&(col==11)){
            tablero3[fila][col]=oro;
            } if ((fila==5)&&(col==1)){
            tablero3[fila][col]=oro;
            } if ((fila==7|| fila==8)&&(col==28)){
            tablero3[fila][col]=oro;
            } if ((fila==9||fila==16)&&(col==26)){
            tablero3[fila][col]=oro;
            } if ((fila==10)&&(col==19)){
            tablero3[fila][col]=oro;
            } if((fila==11)&&(col==3)){
            tablero3[fila][col]=oro;
            } if ((fila==14)&&(col==12)) {
            tablero3[fila][col]=oro;
            } if ((fila==15)&&(col==8)){
            tablero3[fila][col]=oro;
            }if ((fila==17)&&(col==18)){
            tablero3[fila][col]=oro;
            } if((fila==18)&&(col==1)){
            tablero3[fila][col]=oro;
            }if ((fila==19)&&(col==1||col==13||col==17||col==21||col==28)){
            tablero3[fila][col]=oro;
            } if((fila==23)&&(col==12||col==28)){
            tablero3[fila][col]=oro;
            } if ((fila==24)&&(col==3||col==8)){
            tablero3[fila][col]=oro;
            } if ((fila==25)&&(col==17||col==25)){
            tablero3[fila][col]=oro;
            } if ((fila==28)&&(col==6||col==28)){
            tablero3[fila][col]=oro;
            }
            //Ubicacion Bot
            if ((fila==17)&&(col==16)){
            tablero3[fila][col]=ubicacionBot;
            }
            //Ubicacion del jugador
            if((fila==13)&&(col==16)){
            tablero3[fila][col]=ubicacionJugador;
            }
            }
        }
        
        System.out.println("\t Bienvenido al laberinto");
        System.out.println("Antes de iniciar ingresa tu nombre:");
        nombreJugador = scanner.next();
        System.out.println(nombreJugador+" para ganar debes recoger al menos 25 de oro");
        System.out.println("\t Que comience el juego");
        for (int fila=0; fila<30; fila++){
            for (int col=0; col<30; col++){
                System.out.print(tablero3[fila][col]+" ");
            }
            System.out.println(" "); 
        }
      return tablero3;    
    }
  
  public static String [][] movAva(){
    
int oroEncontrado= 0;
int oroSalir = 25;
boolean modificado = false;

System.out.println("Para moverte debes usar");
System.out.println("Arriba = N, "+"Abajo = S, "+ "Derecha = E, "+"Izquierda = O.");
MOVER = scanner.next();
 
for (int i=0; i<tablero3.length; i++){
    for (int j=0; j<tablero3.length; j++){
    
    if (MOVER.equals(ABAJO)){
    modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero3[i++][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero3[i++][j]);
            } else 
            
            if (tablero3[i++][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } else
            
                if(tablero3[i++][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero3[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero3[i][j]);
                    }                
        } else
            if (MOVER.equals(ARRIBA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
            if(tablero3[i--][j].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero3[i--][j]);
            } else 
                if (tablero3[i--][j].equals(pared)){
                System.out.println("Movimiento no valido");
            } 
            
                if(tablero3[i--][j].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero3[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero3[i][j]);
                    }
            }else
            if (MOVER.equals(DERECHA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                if(tablero3[i][j++].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero3[i][j++]);
            } else 
                if (tablero3[i][j++].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                if(tablero3[i][j++].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero3[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero3[i][j]);
                    }
            } else
            if (MOVER.equals(IZQUIERDA)){
                modificado = true; 
    //ubicacionJugador = tablero1[i++][j];
                if(tablero3[i][j--].equals(casillaVacia)){
                ubicacionJugador = POSICION;
                casillaVacia = temp;
                ubicacionJugador = temp;
                casillaVacia = POSICION;
                //casillaVacia = temp;
                System.out.println("Movimiento realizado con exito");
                modificado = true;
                System.out.println(tablero3[i][j--]);
            } else 
                if (tablero3[i][j--].equals(pared)){
                System.out.println("Movimiento no valido");
            }             
                if(tablero3[i][j--].equals(oro)){                
                    System.out.println("Genial encontraste oro");
                    System.out.println("¿Qué deseas hacer?");
                    System.out.println("1. Levantar oro");
                    System.out.println("2. Seguir");
                    opcionOro = scanner.nextInt();
                } if (opcionOro == LEVANTARORO ){                    
                        oroEncontrado = 0 + 1;
                        ubicacionJugador = POSICION;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                    
                        System.out.println("Movimiento realizado con exito");
                        System.out.println("Tienes "+ oroEncontrado+" de oro");
                        System.out.println("Aún debes consegir " + (oroSalir-1) + " para ganar");
                        System.out.println(tablero3[i][j]);
                }else 
                    if (opcionOro==SEGUIR){                        
                        ubicacionJugador = POSICION;
                        oro = temp;
                        oro = POSICION;
                        ubicacionJugador = casillaVacia;                        
                        System.out.println(tablero3[i][j]);
                    }
            }
    }
} 
return tablero3;
}
  
  public static char[][] crearM() {
        int fila;
        int col;
              
        System.out.println("Bienvenido al creador de mapas del laberinto");
        System.out.println("Para iniciar ingresa los siguientes datos");
        System.out.println("¿Comó se llamará tu mapa?");
        nombreMapa = scanner.next();
        
       
        System.out.println("¿De cuántas filas lo quieres?");
        fila = scanner.nextInt();
        System.out.println("¿De cuántas columnas lo quieres?");
        col = scanner.nextInt();
        
        char [][]nuevoMapa = new char[fila][col];
        
        for (int i=0; i<nuevoMapa.length; i++){
            for (int j=0; j<nuevoMapa[i].length; j++){
                System.out.print(nuevoMapa[i][j]+ " ");
            }
            System.out.println(" ");
        }
        
        System.out.println("Continuemos con el laberinto ...");
        
        for (int i=0; i<nuevoMapa.length; ){
        for (int j=0; j<nuevoMapa.length; j++){
            System.out.println("¿Cuanto de oro necesitas?");
            oroo = scanner.nextInt();
            System.out.println("Con que caracter, deseas representar el oro?");
            repOro = scanner.next();
            
            System.out.println("¿Cuántas paredes necesita?");
            paredd = scanner.nextInt();
            System.out.println("¿Cómo desdea representar las paredes?");
            repPared = scanner.next();
            
        }
    }
        for ( int i=0; i<nuevoMapa.length; i++){
            for (int j=0; j<nuevoMapa[i].length; j++){
                System.out.println(nuevoMapa[i][j]);
            }
        }
      return nuevoMapa;    
    }    
}
