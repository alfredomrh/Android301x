package es.uam.eps.android.conecta4_semana3_incompleto;

import java.util.Random;

public class Game {
    static final int NFILAS = 6;
    static final int NCOLUMNAS = 7;
    static final int VACIO = 0;
    static final int MAQUINA = 1;
    static final int JUGADOR = 2;

    private int tablero[][]; //difinicion de la matriz tablero

    public Game() { //constructor que declara el tablero y lo inicializa todo a vacio

        tablero = new int[NFILAS][NCOLUMNAS];  //constructor que instancia el tablero y lo inicializa a vacio

        for (int i = 0; i < NFILAS; i++)
            for (int j = 0; j < NCOLUMNAS; j++)
                tablero[i][j] = VACIO;
    }

    /*************************************************************************
     Completa este metodo.
     Parametros: indices i y j del tablero.
     Retorno: cierto si la posicion tablero[i][j] esta vacia (su valor
     es VACIO) y falso en caso contrario
     *************************************************************************/
    public boolean estaVacio(int i, int j) { //si la posicion está vacia devuelve true

    	if(tablero[i][j] == VACIO)

                return true;

        return false;
    }

    /*************************************************************************
     Completa este metodo.
     Parametros: indices i y j del tablero.
     Retorno: cierto si la posicion tablero[i][j] esta ocupada por el
     jugador (su valor es JUGADOR) y falso en caso contrario
     *************************************************************************/
    public boolean estaJugador(int i, int j) {  //si la posicion contiene el jugador devuelve true

        if(tablero[i][j] == JUGADOR)

            return true;

        return false;

    }

    public void ponerJugador(int i, int j) { //asigna el jugador a la posicion pasada como argumento
        tablero[i][j] = JUGADOR;
    }

    public boolean tableroLleno() { //si alguna posicion está vacia devuelve false

        for (int i=0; i<NFILAS; i++)
            for (int j=0; j<NCOLUMNAS; j++)
                if (tablero[i][j] == VACIO)
                    return false;

        return true;
    }

    /*************************************************************************
     Completa este metodo.
     Parametros: indices i y j del tablero.
     Retorno: cierto si se puede colocar ficha en la posicion (i,j) del
     tablero. Debes comprobar que esa posicion del tablero esta vacia
     (su valor es VACIO) y que es la posicion vacia mas baja del tablero.
     En caso contrario, la funcion debe devolver false.
     *************************************************************************/
    public boolean sePuedeColocarFicha(int i, int j) {

        if(estaVacio(i,j)) {//primero comprueba que la posicion esta vacia

            for (int pf = 0; pf < i; pf++) //recorre desde la fila cero de esa columna viendo si las fichas estan ocupadas hasta la posicion deseada

                if (tablero[pf][j] == VACIO) return false;

        }

        else return false;

        return true;
    }

    public void juegaMaquina() { //realiza el movimiento de la maquina
        int i;
        int fila = -1, columna;
        Random r = new Random();

        do {
            columna = r.nextInt(NCOLUMNAS); //elige una columna al azar

            for (i = 0; i < NFILAS; i++) //recorre las filas de esa columna
                if (tablero[i][columna] == VACIO) { //buscando una posicion vacia
                    fila = i; //le asigna la fila
                    break; //sale del bucle
                }
        } while (fila < 0);

        tablero[fila][columna] = MAQUINA; //la pone como ocupada
    }

    public boolean comprobarFilas(int turno){

       int count = 0;

        for (int j=0; j<NCOLUMNAS; j++) {

            for (int i = 0; i < NFILAS; i++) {

                if (tablero[i][j] == turno) count++;

            }
            if (count == 4) return true;
            else count = 0;
        }

        return false;
    }

    public boolean comprobarColumnas(int turno){

        int count = 0;

        for (int i=0; i<NFILAS; i++) {

            for (int j = 0; j < NCOLUMNAS; j++) {

                if (tablero[i][j] == turno) count++;

            }
            if (count == 4) return true;
            else count = 0;
        }

        return false;
    }

    public boolean comprobarDiagonales(int turno){

        int count = 0;

        for (int i = 0; i < NFILAS; i++) {

            for (int j=0; j < NCOLUMNAS; j++) {

                if (tablero[i][j] == turno) count++;

            }
            if (count == 4) return true;
            else count = 0;
        }

        return false;
    }

    public boolean comprobarCuatro(int turno){

        if (comprobarFilas(turno)) return true;
        else if (comprobarColumnas(turno)) return true;
        else if (comprobarDiagonales(turno)) return true;
        else return false;

    }

}