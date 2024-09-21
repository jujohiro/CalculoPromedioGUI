package controlador;

import vista.gui.*;
import modelo.vo.ModeloDatos;

public class Coordinador {
    private VentanaConsulta miVentanaConsulta;
    private VentanaConsultaGeneral miVentanaConsultaGeneral;
    private VentanaConsultaPersonas miVentanaConsultaPersonas;
    private VentanaOperaciones miVentanaPrincipal;
    private ModeloDatos miModeloDatos;
    
    public Coordinador () {}
    
    public void mostrarVentanaConsulta () {
        miVentanaConsulta.setVisible(true);
    }
    
    public void mostrarVentanaConsultaGeneral () {
        miVentanaConsultaGeneral.llenarAreaTexto();
        miVentanaConsultaGeneral.setVisible(true);
    }
    
    public void mostrarVentanaConsultaPersonas () {
        miVentanaConsultaPersonas.llenarTabla();
        miVentanaConsultaPersonas.setVisible(true);
    }
    
    public void mostarVentanaPrincipal () {
        miVentanaPrincipal.setVisible(true);
    }
    
    public void setModeloDados (ModeloDatos modeloDatos) {
        this.miModeloDatos = modeloDatos;
    }

    public VentanaConsulta getVentanaConsulta() {
        return miVentanaConsulta;
    }

    public void setVentanaConsulta(VentanaConsulta miVentanaConsulta) {
        this.miVentanaConsulta = miVentanaConsulta;
    }

    public VentanaConsultaGeneral getVentanaConsultaGeneral() {
        return miVentanaConsultaGeneral;
    }

    public void setVentanaConsultaGeneral(VentanaConsultaGeneral miVentanaConsultaGeneral) {
        this.miVentanaConsultaGeneral = miVentanaConsultaGeneral;
    }

    public VentanaConsultaPersonas getVentanaConsultaPersonas() {
        return miVentanaConsultaPersonas;
    }

    public void setVentanaConsultaPersonas(VentanaConsultaPersonas miVentanaConsultaPersonas) {
        this.miVentanaConsultaPersonas = miVentanaConsultaPersonas;
    }

    public VentanaOperaciones getVentanaPrincipal() {
        return miVentanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaOperaciones miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    public ModeloDatos getModeloDatos() {
        return miModeloDatos;
    }

    public void setModeloDatos(ModeloDatos miModeloDatos) {
        this.miModeloDatos = miModeloDatos;
    }
}