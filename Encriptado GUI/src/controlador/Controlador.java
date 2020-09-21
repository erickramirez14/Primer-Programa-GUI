package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener{
    private Vista view;
    private Modelo model;
    String variable;
    
    public Controlador(Vista view, Modelo model){
        this.view = view;
        this.model = model;
        this.view.encryptJButton.addActionListener(this);
        this.view.decryptJButton.addActionListener(this);
        this.view.saveJButton.addActionListener(this);
        this.view.txtFile.addActionListener(this);
        view.encryptJButton.setActionCommand ("Accion_Encriptar");
        view.decryptJButton.setActionCommand ("Accion_Desencriptar");
        view.saveJButton.setActionCommand ("Accion_Guardar");
        view.txtFile.setActionCommand ("Accion_Buscar");
    }

    public void iniciar() {
        view.setTitle("Programa Encriptado");
        view.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = view.text.getText();
        String file = view.txtFile.getText();
        String action = e.getActionCommand();
        
        switch(action){
            case "Accion_Encriptar":
                String textoEncriptado = model.Encriptar(texto);
                view.text.setText(textoEncriptado);
                break;
            case "Accion_Desencriptar":
                String textoDesencriptado = model.Desencriptar(texto);
                view.text.setText(textoDesencriptado);
                break;
            case "Accion_Guardar":
                model.Guardar(texto, file);
                break;
            case "Accion_Buscar":
            try {
                model.Leer(view,file);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
        }
    }
    
}
