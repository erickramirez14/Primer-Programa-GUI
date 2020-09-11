package Tap_primero;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class PruebaTransform extends JFrame
{
	private final JTextField txtFile; // displays file
	private final JTextArea text; // displays file
	private final JButton encryptJButton;
        private final JButton decryptJButton;
        private final JButton saveJButton;

	PruebaTransform(){
    	super("Testing cipher");
        setBounds(700, 300, 500, 300);
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        JPanel fileJPanel = new JPanel();
    	fileJPanel.setLayout(new FlowLayout());
        JLabel lblFile = new JLabel( "Archivo de texto/cifrado:" );
        fileJPanel.add(lblFile);
        txtFile = new JTextField(".txt",20);
        fileJPanel.add(txtFile);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10,15);
    	add(text, BorderLayout.CENTER);
        
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new BorderLayout());
        
        encryptJButton = new JButton("Encriptar");
    	buttonJPanel.add(encryptJButton, BorderLayout.NORTH);
        
    	decryptJButton = new JButton("Desencriptar");
    	buttonJPanel.add(decryptJButton, BorderLayout.CENTER);
        
    	saveJButton = new JButton("Guardar");
    	buttonJPanel.add(saveJButton, BorderLayout.SOUTH);
        add(buttonJPanel, BorderLayout.EAST);
        
        AccionEncriptado event = new AccionEncriptado();
        AccionDesencriptado event2 = new AccionDesencriptado();
        AccionGuardar event3 = new AccionGuardar();
        encryptJButton.addActionListener(event);
        decryptJButton.addActionListener(event2);
        saveJButton.addActionListener(event3);
        txtFile.addActionListener(new txtAccion());
    }
    
    class txtAccion implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
                String codigo= text.getText();
                String File= txtFile.getText();
                Transform t = new Transform();
                t.Leer(File);
          }
    }
    
    class AccionEncriptado implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
                String codigo= text.getText();
                Transform t = new Transform();
                String textoEncriptado = t.Encriptar(codigo);
                text.setText(textoEncriptado);
          }
    }
    
    class AccionDesencriptado implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
                String codigo= text.getText();
                Transform t = new Transform();
                String textoDesencriptado = t.Desencriptar(codigo);
                text.setText(textoDesencriptado);
          }
    }
    
    class AccionGuardar implements ActionListener{
    	@Override
          public void actionPerformed(ActionEvent event)
          {
                String codigo= text.getText();
                String file= txtFile.getText();
                Transform t = new Transform();
                t.Guardar(codigo,file);
          }
    }//
    
    public void Escribir(String txtFile){
      File archivo = null;

      archivo = new File("src/encriptado/gui/"+txtFile);
        try { 
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            while(linea != null){
                text.append(linea+"\n");
                linea = leer.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Transform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Transform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public static void main(String[] args)
   { 
      PruebaTransform ventana = new PruebaTransform(); 
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 300); 
      ventana.setVisible(true); 
   } 
}