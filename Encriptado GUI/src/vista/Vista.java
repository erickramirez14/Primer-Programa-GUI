package vista;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Vista extends JFrame {
    public final JTextField txtFile; // displays file
	public final JTextArea text; // displays file
	public final JButton encryptJButton;
        public final JButton decryptJButton;
        public final JButton saveJButton;
    
        public Vista(){
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
    }
}
