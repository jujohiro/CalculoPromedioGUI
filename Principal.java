

import controlador.Coordinador;

import vista.gui.*;
import modelo.vo.*;
import modelo.operaciones.*;
import controlador.*;
import controlador.Coordinador;
import controlador.Coordinador;

public class Principal {
    private VentanaConsulta miVentanaConsulta;
    private VentanaConsultaGeneral miVentanaConsultaGeneral;
    private VentanaConsultaPersonas miVentanaConsultaPersonas;
    private VentanaOperaciones miVentanaPrincipal;
    private ModeloDatos miModeloDatos;
    private Coordinador miCoordinador;
    private Procesos misProcesos;
    
    public static void main(String[] args) {
        Principal miPrincipal=new Principal();
        miPrincipal.iniciar();
    }
    
    public void iniciar() {
        miVentanaConsulta = new VentanaConsulta();
        miVentanaConsultaGeneral = new VentanaConsultaGeneral();
        miVentanaConsultaPersonas = new VentanaConsultaPersonas();
        miVentanaPrincipal = new VentanaOperaciones();
        miModeloDatos = new ModeloDatos();
        miCoordinador = new Coordinador();
        misProcesos = new Procesos();
        
        miVentanaConsulta.setProcesos(misProcesos);
        miVentanaConsultaGeneral.setProcesos(misProcesos);
        miVentanaConsultaPersonas.setProcesos(misProcesos);
        miVentanaPrincipal.setProcesos(misProcesos);
        
        miVentanaConsulta.setCoordinador(miCoordinador);
        miVentanaConsultaGeneral.setCoordinador(miCoordinador);
        miVentanaConsultaPersonas.setCoordinador(miCoordinador);
        miVentanaPrincipal.setCoordinador(miCoordinador);
        
        misProcesos.setModeloDatos(miModeloDatos);
        
        miCoordinador.setModeloDados(miModeloDatos);
        miCoordinador.setVentanaConsulta(miVentanaConsulta);
        miCoordinador.setVentanaConsultaGeneral(miVentanaConsultaGeneral);
        miCoordinador.setVentanaConsultaPersonas(miVentanaConsultaPersonas);
        miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
        
        miCoordinador.mostarVentanaPrincipal();
    }
}