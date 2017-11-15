package elahorcado;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Pantalla implements WindowListener, ActionListener {

    private Frame f, fv;
    private final int Intentos = 6;
    private Version vg;
    private Set registro = new HashSet();
    private Set aciertos = new HashSet();
    private Set errores = new HashSet();
    private Set alfabeto = new HashSet();
    private String visible = "", muestra = "";

    private Panel p1, p2;
    private MenuBar barraMenu;
    private Button boton[];
    private char letra;
    private Label letter;
    private Label palabraAdivinar;
    private Label verificar;
    private Palabra adivina;
    private String palabra = "";
    private Menu menu1, menu2, menu3;
    private MenuItem menu1Op1;
    private MenuItem menu1Op2;
    private Menu menu2Op1;
    private MenuItem menu3Op1;
    private MenuItem niv1, niv2, niv3;

    public Pantalla(String titulo) {

        menu3 = new Menu("Creditos");
        menu3Op1 = new MenuItem("Autores");
        menu3Op1.addActionListener(this);

        menu2 = new Menu("Iniciar");
        menu2Op1 = new Menu("Dificultad");

        niv1 = new MenuItem("Palabras");
        niv2 = new MenuItem("Frases");
        niv3 = new MenuItem("Parrafos");
        niv1.addActionListener(this);
        niv2.addActionListener(this);
        niv3.addActionListener(this);

        menu1 = new Menu("Opciones");
        menu1Op2 = new MenuItem("Reiniciar");
        menu1Op2.setEnabled(false);
        menu1Op2.addActionListener(this);
        menu1Op1 = new MenuItem("Abandonar juego");
        menu1Op1.addActionListener(this);

        adivina = new Palabra();
        f = new Frame(titulo);
        f.addWindowListener(this);
        barraMenu = new MenuBar();
        barraMenu.add(menu1);
        barraMenu.add(menu2);
        barraMenu.add(menu3);
        menu1.add(menu1Op1);
        menu1.add(menu1Op2);

        menu2Op1.add(niv1);
        menu2Op1.add(niv2);
        menu2Op1.add(niv3);

        menu2.add(menu2Op1);
        menu3.add(menu3Op1);
        f.setMenuBar(barraMenu);
        p1 = new Panel();
        p2 = new Panel();
        letter = new Label("Aqui apareceran sus letras escogidas");
        palabraAdivinar = new Label("Aciertos:");
        verificar = new Label("");
        boton = new Button[27];
        letra = 'A';
        for (int i = 0; i < 14; i++) {
            alfabeto.add(letra);
            boton[i] = new Button("" + letra);
            boton[i].setEnabled(false);
            letra++;
        }

        boton[14] = new Button("\u00d1");
        boton[14].setEnabled(false);
        alfabeto.add("\u00d1".charAt(0));
        for (int i = 15; i < 27; i++) {
            alfabeto.add(letra);
            boton[i] = new Button("" + letra);
            boton[i].setEnabled(false);
            letra++;
        }

    }

    public void EntornoGrafico() {
        f.setSize(1200, 900);

        f.setLayout(new GridLayout(2, 1));

        p1.setLayout(new GridLayout(3, 9, 5, 5));
        p1.setSize(400, 100);
        p2.setLayout(new GridLayout(2, 2));
        p1.setBackground(Color.blue);
        p2.setSize(400, 100);

        p2.setBackground(Color.LIGHT_GRAY);
        for (int i = 0; i < 27; i++) {
            boton[i].addActionListener(this);
            p1.add(boton[i]);
        }
        p2.add(letter);
        p2.add(verificar);
        p2.add(palabraAdivinar);
        f.add(p2);
        f.add(p1);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        Pantalla pantallajuego = new Pantalla("Ahorcado Version Halloween");
        pantallajuego.EntornoGrafico();
    }

    public void windowOpened(WindowEvent e) {

    }

    public void windowClosing(WindowEvent e) {
        System.exit(0);
        throw new UnsupportedOperationException("Not supported yet.");

    }

    public void windowClosed(WindowEvent e) {

    }

    public void windowIconified(WindowEvent e) {

    }

    public void windowDeiconified(WindowEvent e) {

    }

    public void windowActivated(WindowEvent e) {

    }

    public void windowDeactivated(WindowEvent e) {

    }

    public void actionPerformed(ActionEvent e) {
        char letra = e.getActionCommand().trim().charAt(0);
        int numero = letra;

        if (e.getActionCommand() == "Autores") {
            fv = new Frame();
            vg = new Version(fv, "Estudiantes Universidad Nacional");
            vg.setVisible(true);

        }

        if (e.getActionCommand() == "Abandonar juego") {
            System.exit(0);
        }

        if (e.getActionCommand() == "Reiniciar") {
            palabraAdivinar.setText("Aciertos:");
            verificar.setText("");
            letter.setText("Aqui apareceran sus letras escogidas");
            for (int i = 0; i < boton.length; i++) {
                boton[i].setEnabled(false);
            }
            visible = "";
            muestra = "";
            registro.clear();
            aciertos.clear();
            errores.clear();
            menu2Op1.setEnabled(true);
        } else {

            if (e.getActionCommand() == "Palabras") {
                palabra = adivina.generarPalabra(0);
                registro = adivina.letrasEnPalabra(palabra);
                for (int i = 0; i < palabra.length(); i++) {
                    visible = visible + "_";
                    muestra = muestra + "_ ";
                }
                palabraAdivinar.setText(muestra);
                System.out.println(registro);
                for (int i = 0; i < boton.length; i++) {
                    boton[i].setEnabled(true);
                }
                menu2Op1.setEnabled(false);
                menu1Op2.setEnabled(true);
            }
            if (e.getActionCommand() == "Frases") {
                palabra = adivina.generarPalabra(1);
                registro = adivina.letrasEnPalabra(palabra);
                for (int i = 0; i < palabra.length(); i++) {
                    visible = visible + "_";
                    muestra += "_ ";
                }
                palabraAdivinar.setText(muestra);
                System.out.println(registro);
                for (int i = 0; i < boton.length; i++) {
                    boton[i].setEnabled(true);
                }
                menu2Op1.setEnabled(false);
                menu1Op2.setEnabled(true);
            }

            if (e.getActionCommand() == "Parrafos") {
                palabra = adivina.generarPalabra(2);
                registro = adivina.letrasEnPalabra(palabra);
                for (int i = 0; i < palabra.length(); i++) {
                    visible = visible + "_";
                    muestra = muestra + "_ ";
                }
                palabraAdivinar.setText(muestra);
                System.out.println(registro);
                for (int i = 0; i < boton.length; i++) {
                    boton[i].setEnabled(true);
                }
                menu2Op1.setEnabled(false);
                menu1Op2.setEnabled(true);
            } else {

                if (adivina.verificarLetra(e.getActionCommand().charAt(0), palabra)) {
                    verificar.setText("¡Correcto!");
                } else {
                    verificar.setText("Sigue intentando");
                }

                letter.setText("" + e.getActionCommand().charAt(0));
            }

            if ((65 <= numero) && (numero <= 90)) {
                if (adivina.verificarLetra(letra, palabra)) {
                    aciertos.add(letra);
                } else {
                    errores.add(letra);
                }
                if (numero < 79) {
                    boton[numero - 65].setEnabled(false);
                } else {
                    boton[numero - 64].setEnabled(false);
                }

                visible = adivina.actualizaVisible(aciertos, palabra, visible);
                muestra = "";
                for (int i = 0; i < visible.length(); i++) {
                    muestra = muestra + visible.charAt(i);
                }
                palabraAdivinar.setText(muestra);

                if (adivina.verificarVictoria(registro, aciertos)) {
                    letter.setText("¡Felicitaciones lo conseguiste!");
                    for (int i = 0; i < boton.length; i++) {
                        boton[i].setEnabled(false);
                    }
                } else {
                    if (adivina.VerificarDerrota(errores, Intentos)) {
                        letter.setText("¡Lo sentimos, perdiste!");
                        for (int i = 0; i < boton.length; i++) {
                            boton[i].setEnabled(false);
                        }
                    } else {

                    }
                }

                System.out.println(registro);
                System.out.println(aciertos);
                System.out.println(errores);
            }
            if (letra == "\u00d1".charAt(0)) {
                letra = "\u00d1".charAt(0);
                if (adivina.verificarLetra(letra, palabra)) {
                    aciertos.add(letra);
                } else {
                    errores.add(letra);
                }
                boton[14].setEnabled(false);

                visible = adivina.actualizaVisible(aciertos, palabra, visible);
                muestra = "";
                for (int i = 0; i < visible.length(); i++) {
                    muestra = muestra + visible.charAt(i);
                }
                palabraAdivinar.setText(muestra);

                if (adivina.verificarVictoria(registro, aciertos)) {
                    letter.setText("¡Felicitaciones, lo conseguiste!");
                    for (int i = 0; i < boton.length; i++) {
                        boton[i].setEnabled(false);
                    }
                } else {
                    if (adivina.VerificarDerrota(errores, Intentos)) {
                        letter.setText("¡Lo sentimos, perdiste!");
                        for (int i = 0; i < boton.length; i++) {
                            boton[i].setEnabled(false);
                        }
                    } else {

                    }
                }

                System.out.println(aciertos);
                System.out.println(errores);
            }
        }
    }
}
