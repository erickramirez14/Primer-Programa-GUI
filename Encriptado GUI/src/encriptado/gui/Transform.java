package encriptado.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Transform {
        
    String Encriptar(String c){
        String codigo = c;
        char[] convertir = new char[20];
        char[] acomodar = new char[20];
        
        String cadena = codigo.trim();
        float ncadena = cadena.length();
        StringBuffer cadena2 = new StringBuffer();
        
        for (int i = 0; i < ncadena; i++) {
            char caracter = cadena.charAt(i);
            int ascii = (int)caracter+3;
            char codi = (char)ascii;
            convertir[i] = codi;
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)-.1); i++) {
            int num = (int)(ncadena)-i;
            acomodar[i] = convertir[num];
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)); i++) {
            int auxChar = Math.round((ncadena/2)) - i;
            
            char caracter = convertir[auxChar];
            int ascii = (int)caracter-1;
            char codi = (char)ascii;
            int aux = (int) Math.round((ncadena/2)-.1)+i;
            acomodar[aux] = codi;
        }
        
        for (int i = 0; i <= ncadena; i++) {
            cadena2 = cadena2.append(acomodar[i]);
    }
        
        String cadena3 = cadena2.toString();
        return cadena3;
        }
    
    String Desencriptar(String c){
        String codigo = c;
        char[] convertir = new char[20];
        char[] acomodar = new char[20];
        int auxF = 0;
        
        String cadena = codigo.trim();
        float ncadena = cadena.length();
        StringBuffer cadena2 = new StringBuffer();
        
        for (int i = 0; i < ncadena; i++) {
            char caracter = cadena.charAt(i);
            int ascii = (int)caracter-3;
            char codi = (char)ascii;
            convertir[i] = codi;
        }
        
        for (int i = 1; i <= Math.round((ncadena/2)); i++) {
            int num = (int)(ncadena)-i;
            char caracter = convertir[num];
            int ascii = (int)caracter+1;
            char codi = (char)ascii;
            acomodar[auxF] = codi;
            auxF++;
        }
        
        auxF = 0;
        for (int i = 1; i <= Math.round((ncadena/2)-.1); i++) {
            int auxChar = (int)Math.round((ncadena/2)-.1) - i;
            int aux = (int) Math.round((ncadena/2))+auxF;
            acomodar[aux] = convertir[auxChar];
            auxF++;
        }
        
        for (int i = 0; i <= ncadena; i++) {
            cadena2 = cadena2.append(acomodar[i]);
        }
        
        String cadena3 = cadena2.toString();
            return cadena3;
        }

        public void Guardar(String codigo,String txtFile){
            File f = null;
            FileWriter w;
            BufferedWriter bw;
            PrintWriter wr;
            try{
            f = new File("src/encriptado/gui/guardar.txt");
            w= new FileWriter(f);
            bw= new BufferedWriter (w);
            wr= new PrintWriter(bw);

            wr.write(codigo);

            wr.close();
            bw.close();

            }catch (IOException event){
            JOptionPane.showMessageDialog(null, event);
            }
        }
}

