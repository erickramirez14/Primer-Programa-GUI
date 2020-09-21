
package mvc;
import modelo.Modelo;
import vista.Vista;
import controlador.Controlador;

public class mvc {

    public static void main(String[] args) {
        Modelo mod = new Modelo();
        Vista view = new Vista();
        Controlador ctrl = new Controlador(view, mod);
        ctrl.iniciar();
        view.setVisible(true);
    }
    
}
