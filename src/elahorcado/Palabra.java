package elahorcado;

import java.util.*;

public class Palabra {

    String dificultad[] = {"Palabras", "Frases", "Parrafos"};

    String palabras[] = {"HALLOWEEN", "ARAÑA", "CALABAZA", "CALAVERA",
        "ESQUELETO", "BRUJAS", "ZOMBIE", "CEMENTERIO"};
    String frases[] = {"PEDIR DULCES", "DULCE O TRUCO",
        "TRADICION CULTURAL", "DISFRUTAR EN FAMILIA"};
    String parrafos[] = {"ES UNA CELEBRACION MUY POPULAR LOS NIÑOS DISFRUTAN DE ELLA"};

    public String generarPalabra(int dificultad) {
        int n = 0;
        n = (int) (Math.random() * 4);
        if (dificultad == 0) {
            return palabras[n];
        } else if (dificultad == 1) {
            return frases[n];
        } else {
            return parrafos[n];
        }

    }

    public boolean verificarLetra(char letra, String palabra) {
        boolean mensaje = false;
        for (int i = 0; i < palabra.length(); i++) {
            if (letra == palabra.charAt(i)) {
                mensaje = true;
                break;
            } else {
                mensaje = false;
            }
        }
        return mensaje;
    }

    public Set letrasEnPalabra(String palabra) {
        Set letras = new HashSet();
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != ' ') {
                letras.add(palabra.charAt(i));
            }
        }
        return letras;
    }

    public boolean verificarVictoria(Set conjunto, Set correctas) {
        if (conjunto.size() == correctas.size()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean VerificarDerrota(Set incorrectas, int intentos) {
        if (incorrectas.size() == intentos) {
            return true;
        } else {
            return false;
        }
    }

    public String actualizaVisible(Set correctas, String palabra, String visible) {
        visible = "";
        boolean bandera = false;
        Iterator it = correctas.iterator();
        for (int i = 0; i < palabra.length(); i++) {
            while (it.hasNext()) {
                char a = it.next().toString().charAt(0);
                System.out.println(" " + a + "  " + palabra.trim().charAt(i));
                if (a == palabra.trim().charAt(i)) {
                    visible += a;
                    bandera = true;
                    break;
                }
            }
            if (bandera == false) {
                visible += "_";
            }
            bandera = false;
            it = correctas.iterator();
        }
        return visible;
    }
}
