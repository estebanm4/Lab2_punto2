/*
 * Versión corta del ahorcado con AWT
 * GSL-UAT 2008   Versión 1.0
 */

package elahorcado;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Version extends Dialog implements ActionListener {
  String mensaje = "EL AHORCADO \n VERSION 1.0 \n GSL-UAT 2008"+
          "\n http://gsl.uat.edu.mx";
  private TextArea ta;
  //private Button yes = new Button("Yes");
  private Button b = new Button("salir");

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
     Version vg = new Version(f, "VERSION 1.0");
     vg.setVisible(true);
  
  }
  
}


