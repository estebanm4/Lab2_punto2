package elahorcado;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Version extends Dialog implements ActionListener {
  String mensaje = "Juego del Ahorcado, versión Halloween " + "\n" +
          "Autores: " + "\n" +
          "Aldo J Marquez" + "\n" +
          "Mateo Pacheco" + "\n" +
          "Luis Suarez" + "\n" +
          "Juan Esteban Muñoz" + "\n" 
          ;
  private TextArea ta;
  
  private Button b = new Button("Salir");

  public Version(Frame parent, String message) {
    super(parent, true);
    ta = new TextArea();
    ta.append(mensaje);
    this.add(BorderLayout.CENTER, new Label(message));
    Panel p = new Panel();
    p.setLayout(new FlowLayout());
    ta.setEditable(false);
    p.add(ta);
    b.addActionListener(this);
    p.add(b);
    this.add(BorderLayout.SOUTH, p);
    this.setSize(300,100);
    this.setResizable(false);
    this.setLocation(100, 200);
    this.pack();
  
  }  
  
  public void actionPerformed(ActionEvent evt) {
    this.hide();
    this.dispose();
  }
  
  public static void main(String arg[]){
      Frame f = new Frame();
     Version vg = new Version(f, "V 1.0");
     vg.setVisible(true);
  
  }
  
}


