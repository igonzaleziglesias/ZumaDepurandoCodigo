package Codigo;

import Excepciones.FueraDeRango;
import Excepciones.ListaVacia;
import java.util.ArrayList;

public class Ristra implements IRistra {

    int control = 0;
    private int puntuacion;
    private ArrayList<Bola> ristraBolas = new ArrayList<Bola>();

    public int getPuntuacion() {
        return puntuacion;
    }

    public void nuevaBola(Bola bola) {
        ristraBolas.add(bola);
    }

    public int longitud() {
        return ristraBolas.size();
    }

    public void mostrarAñadiendoDerecha() {
        System.out.println("");
        for (Bola ele : ristraBolas) {
            System.out.print(ele.toString());
        }
    }

    public ArrayList<Bola> invertir() {
        ArrayList<Bola> reverse;

        if (ristraBolas != null) {
            reverse = new ArrayList<>();
            for (int i = ristraBolas.size() - 1; i >= 0; i--) {
                reverse.add(ristraBolas.get(i));
            }
        } else {
            reverse = null;
        }
        return reverse;
    }

    public void mostrarConFormato(ArrayList<Bola> bola) {
        System.out.println("");
        System.out.println("Ristra: ");
        System.out.println("");
        System.out.print("  ");
        for (int i = longitud(); i >= 1; i--) {
            System.out.printf("%4d", i);
        }
        System.out.println("");
//        int i;
//        for (i = FIN - longitud() + 1; i > 1; i--) {
//            System.out.printf("%4s", "");
//        }
        System.out.print("\033[30m==");
        for (Bola ele : bola) {
            System.out.printf("%3s", "");
            System.out.print(ele.toString());
        }
        System.out.println("");
        System.out.println("\nPuntuacion: " + puntuacion);
    }

    public void explotar(int posicion, int acumulador, int acumulador2) throws ListaVacia {
        if (ristraBolas.isEmpty()) {
            throw new ListaVacia("Lista Vacia");
        }
        ristraBolas.remove(posicion);//elimina la bola insertada
        acumulador = acumulador - 1;//quitamos la posicion en la que introducimos que ya la eliminamos
        acumulador2 = acumulador2 - 1;//quitamos la posicion en la que introducimos 

        while (acumulador != 0) {//borra las bolas iguales a la de la posicion que estaban situdas detras de la que disparamos
            if (ristraBolas.isEmpty()) {
                throw new ListaVacia("Lista Vacia");
            }
            ristraBolas.remove(posicion);
            acumulador--;
        }
        int i = 1;
        while (acumulador2 != 0) {//borra las bolas iguales a la de la posicion que estaban situadas por delante de la que disparamos
            if (ristraBolas.isEmpty()) {
                throw new ListaVacia("Lista Vacia");
            }
            ristraBolas.remove(posicion - i);
            i++;
            acumulador2--;
        }

    }

    public int puntuacion(int bolasJuntas) {
        int puntos = 1;
        if (bolasJuntas > 3) {
            for (int i = 4; i <= bolasJuntas; i++) {
                puntos++;
                puntos++;
            }
        }

        return puntos;
    }

    public int puntuacionConcatenacion() {
        return 5;
    }

//    
//    public void concatenarExplosiones(Bola bola, int control) throws FueraDeRango, ListaVacia {
////       puntua=0    public void concatenarExplosiones(Bola bola, int control) throws FueraDeRango, ListaVacia {
//;
//        if (!ristraBolas.isEmpty()) {
////        System.out.println(longitud());
////tratar con una excepcion que introduzca un int
//            int posicion = control;//indicar la posicion a la que disparar
//
//            if (posicion < 0) {
//                throw new FueraDeRango("Disparo fallido");
//            }
//            if (posicion > longitud()) {//comprueba que el disparo sea a la ristra de bolas y si no lanza una excepcion fuera de rango
//                throw new FueraDeRango("Disparo fallido");
//            }
//            int acumulador = 1;
//            int acumulador2 = 1;
//            MetodosAuxiliares ayuda = new MetodosAuxiliares();
//            int controlador = 0;
//            int bolasJuntas = 0;
//
//
//                ristraBolas.add(posicion, bola);
//                int longitud = longitud();
//                if (longitud() > 0) {//comprueba si la ristra tiene elementos
//
//                    acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
//                    acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
//                    controlador = acumulador2 - 1;System.out.println("controlador: " + posicion + "-" + controlador);
//                    bolasJuntas = (acumulador + acumulador2 - 1);System.out.println("acumuladorBolasJuntas2 " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido
//                    System.out.println("izq: "+(acumulador-1)+" der: "+(acumulador2-1));
//                    
//                    if ((bolasJuntas >= 3)&&(acumulador-1>=0)&&(acumulador2-1!=0)) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
//                        explotar(posicion, acumulador, acumulador2);System.out.println("explotando3");
//                        this.puntuacion=this.puntuacion+puntuacion(bolasJuntas)+puntuacionConcatenacion();
//                        Bola bolaComodin = ristraBolas.get(posicion - controlador);
//                        ristraBolas.remove(posicion - controlador);
//                        concatenarExplosiones(bolaComodin, posicion - controlador);
//
//                    }
//                }
////            }
//
//        }else ristraBolas.add(bola);
//        System.out.println("puntos3: ");
//
//    }
    //
//    public ArrayList<Bola> disparar(Bola bola) throws FueraDeRango, ListaVacia {
//
////        System.out.println(longitud());
////tratar con una excepcion que introduzca un int
//        MetodosAuxiliares ayuda = new MetodosAuxiliares();
//        int posicion = 0;
//        boolean numero = true;
//        int controlador = 0;
////        int puntos = 0;
//
//        posicion = ayuda.pedirPosicion(longitud());
//
//        int acumulador = 1;
//        int acumulador2 = 1;
//        int bolasJuntas=0;
//        if (posicion == longitud()) {//dispara al final del array y cuenta las bolas del mismo color que hay a su lado
//            ristraBolas.add(bola);
//
//            acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);
//            controlador = acumulador2;
//            bolasJuntas=acumulador2;System.out.println("acumuladorBolasExplotan: " + bolasJuntas);
//        if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
//                explotar(posicion, acumulador, acumulador2);System.out.println("explotando0");
//                this.puntuacion=this.puntuacion+puntuacion(bolasJuntas);
//
//            try {
//                Bola bolaComodin = ristraBolas.get(posicion - controlador);
//                ristraBolas.remove(posicion - controlador);System.out.println("Eliminando Elemento1");
//                concatenarExplosiones(bolaComodin, posicion - controlador);System.out.println("puntuacion.this: " + this.puntuacion + " puntos a sumar: ");
//
//            } catch (Exception ex) {
//                System.out.println("Siguiente Posicion nula");
//            }
//        }
//        } else {
//
//            ristraBolas.add(posicion, bola);
//            int longitud = longitud();
//            if (longitud() > 1) {//comprueba si la ristra tiene elementos
//
//                acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas que hay despues del disparo iguales a la bola disparada(cuenta la bola disparada)
//                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas que hay antes del disparo iguales a la bola disparada(cuenta la bola disparada)
//                controlador = acumulador2 - 1;
////                System.out.println("controlador: "+controlador);
//
//                bolasJuntas = (acumulador + acumulador2 - 1);System.out.println("acumuladorBolasExplotan: " + bolasJuntas);//restamos 1 para no contar dos veces la posicion del elemento introducido
//
//                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
//                    explotar(posicion, acumulador, acumulador2);System.out.println("explotando1");
//                    this.puntuacion=this.puntuacion+puntuacion(bolasJuntas);
//
//                    try {
//                        Bola bolaComodin = ristraBolas.get(posicion - controlador);
//                        ristraBolas.remove(posicion - controlador);System.out.println("Eliminando Elemento2");
//                        concatenarExplosiones(bolaComodin, posicion - controlador);System.out.println("puntuacion.this: " + this.puntuacion + " puntos a sumar: ");
//                    } catch (Exception ex) {
////                        System.out.println("puntos: "+puntos+" puntua: "+puntua);
////                        if(puntua==0){this.puntuacion=this.puntuacion+puntos;
////                        return ristraBolas;}
////                        this.puntuacion=this.puntuacion+puntua;
//                        System.out.println("Siguiente Posicion nula2");
//                    }
//                }
//            }
//        }
//        this.puntuacion = this.puntuacion;
//        return ristraBolas;
//    }
    public ArrayList<Bola> disparar(Bola bola, int posicionConcatena) throws FueraDeRango, ListaVacia {
        MetodosAuxiliares ayuda = new MetodosAuxiliares();
        int puntos = 0;
        int posicion = 0;
        if (control == 0) {
            posicion = ayuda.pedirPosicion(longitud());
        } else {
            posicion = posicionConcatena;
        }

        int acumulador = 1, acumulador2 = 1, controlador = 0/*necesario?*/, bolasJuntas = 0, longitud = longitud();

        if (posicion == longitud()) {//comprueba si la posicion a insertar es igual a la longitud de la ristra
            ristraBolas.add(bola);//dispara al final del array
            acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas iguales a la disparada que hay antes despues de disparar(cuenta la bola disparada,inicializada en 1)
            controlador = acumulador2;
            bolasJuntas = acumulador2;
            System.out.println("Bolas a explotar1: " + bolasJuntas);
            
            if (control == 0) {//añadir si control = 1
                if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                    explotar(posicion, acumulador, acumulador2);
                    System.out.println("explotando1");
                    if (control == 0) {
                        puntos = puntos + puntuacion(bolasJuntas);
                    }
                    if (control == 1) {
                        puntos = puntos + puntuacion(bolasJuntas) + puntuacionConcatenacion();
                    }

                    try {
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);//Extrae la siguiente bola de la ristra despues de la eliminacion
                        ristraBolas.remove(posicion - controlador);
                        System.out.println("Eliminando Bola siguiente1");
                        control = 1;
                        disparar(bolaComodin, posicion - controlador);
                        System.out.println("puntuacion a sumar1: " + puntos + " puntos a sumar: ");

                    } catch (Exception ex) {
                        System.out.println("Siguiente Posicion nula");
                    }
                }
            } else if ((bolasJuntas >= 3)&&(acumulador-1>=0)&&(acumulador2-1!=0)) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                       explotar(posicion, acumulador, acumulador2);System.out.println("explotando3");
                    try {
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);//Extrae la siguiente bola de la ristra despues de la eliminacion
                        ristraBolas.remove(posicion - controlador);
                        System.out.println("Eliminando Bola siguiente3");
                        control = 1;
                        disparar(bolaComodin, posicion - controlador);
                        puntos = puntos + puntuacion(bolasJuntas) + puntuacionConcatenacion();
                        System.out.println("puntuacion a sumar3: " + puntos + " puntos a sumar: ");

                    } catch (Exception ex) {
                        System.out.println("Siguiente Posicion nula");
                    }
            }
        } else {
            ristraBolas.add(posicion, bola);
            if (longitud() > 1) {//comprueba si la ristra tiene elementos
                acumulador = ayuda.contarBolasDetras(posicion, ristraBolas, acumulador, longitud);//cuenta las bolas iguales a la disparada que hay despues despues de disparar(cuenta la bola disparada, inicializada en 1)
                acumulador2 = ayuda.contarBolasPorDelante(posicion, ristraBolas, acumulador2);//cuenta las bolas iguales a la disparada que hay antes despues de disparar(cuenta la bola disparada,inicializada en 1)
                controlador = acumulador2 - 1;

                bolasJuntas = (acumulador + acumulador2 - 1);
                System.out.println("Bolas a explotar2: " + bolasJuntas);//restamos 1 para no contar dos veces la posicion de la bola introducida
                if (control == 0) {
                    if (bolasJuntas >= 3) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                        explotar(posicion, acumulador, acumulador2);
                        System.out.println("explotando2");
                        if (control == 0) {
                            puntos = puntos + puntuacion(bolasJuntas);
                        }
                        if (control == 1) {
                            puntos = puntos + puntuacion(bolasJuntas) + puntuacionConcatenacion();
                        }

                        try {
                            Bola bolaComodin = ristraBolas.get(posicion - controlador);
                            ristraBolas.remove(posicion - controlador);
                            System.out.println("Eliminando Bola Siguiente2");

                            control = 1;
                            disparar(bolaComodin, posicion - controlador);
                            System.out.println("puntuacion a sumar2: " + puntos + " puntos a sumar: ");
                        } catch (Exception ex) {

                            System.out.println("Siguiente Posicion nula2");
                        }

                    }
                }else if ((bolasJuntas >= 3)&&(acumulador-1>=0)&&(acumulador2-1!=0)) {//hace explotar el conjunto de bolas si al disparar hay 3 o mas bolas iguales juntas
                        explotar(posicion, acumulador, acumulador2);System.out.println("explotando4");
                        try {
                        Bola bolaComodin = ristraBolas.get(posicion - controlador);//Extrae la siguiente bola de la ristra despues de la eliminacion
                        ristraBolas.remove(posicion - controlador);
                        System.out.println("Eliminando Bola siguiente4");
                        control = 1;
                        disparar(bolaComodin, posicion - controlador);
                        puntos = puntos + puntuacion(bolasJuntas) + puntuacionConcatenacion();
                        System.out.println("puntuacion a sumar4: " + puntos + " puntos a sumar: ");

                    } catch (Exception ex) {
                        System.out.println("Siguiente Posicion nula");
                    }
                }
            }
        }
        System.out.println("puntuacion a sumar total: " + puntos + " puntos a sumar: ");
        control = 0;
        this.puntuacion = this.puntuacion + puntos;
        return ristraBolas;
    }

}
