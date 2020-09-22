package modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.Vista;

public class Modelo {
    private Vista view;
    
    public String Encriptar(String c){
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
    
    public String Desencriptar(String c){
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
            f = new File("src/mvc/"+txtFile);
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
        
    public void Leer(Vista view, String txtFile) throws IOException {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         archivo = new File ("src/mvc/"+txtFile);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      Escribir(view,txtFile);
    }
    
    public void Escribir(Vista view,String txtFile){
      this.view = view;
      File archivo = null;
      String linea = null;

      archivo = new File("src/mvc/"+txtFile);
        try { 
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            linea = leer.readLine();
            while(linea != null){
                view.text.setText(linea+"\n");
                linea = leer.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
