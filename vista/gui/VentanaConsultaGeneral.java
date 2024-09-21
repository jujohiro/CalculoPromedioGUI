package vista.gui;

import controlador.Coordinador;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VentanaConsultaGeneral extends JFrame {

    private JPanel panelPrincipal;
    private JTextArea areaInformacion;

    private Procesos misProcesos;
    private Coordinador miCoordinador;

    public void setCoordinador (Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }
    
    public void setProcesos (Procesos procesos) {
        this.misProcesos = procesos;
    }
	
    public VentanaConsultaGeneral() {
        setSize(527, 337);
        setTitle("CALCULO DE PROMEDIO");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();	
    }

    private void iniciarComponentes(){
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);

        JLabel lblTitulo = new JLabel("IMPRIMIR INFORMACION");
        lblTitulo.setBackground(Color.black);
        lblTitulo.setForeground(Color.white);
        lblTitulo.setOpaque(true);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTitulo.setBounds(0, 0, 499, 50);
        panelPrincipal.add(lblTitulo);

        JScrollPane scroll = new JScrollPane();
        scroll.setBounds(10, 60, 489, 230);
        panelPrincipal.add(scroll);

        areaInformacion = new JTextArea();
        areaInformacion.setWrapStyleWord(true);
        areaInformacion.setLineWrap(true);
        areaInformacion.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 16));
        scroll.setViewportView(areaInformacion);

    }

    public void llenarAreaTexto() {
        if (misProcesos.getListaPersonas().size() > 0) {
            String res = "";
            double suma = 0;
            for (EstudianteVO estudiante : misProcesos.getListaPersonas().values()) {
                res += estudiante+"\n";
                suma += estudiante.getPromedio();
            }
            res+="\n "+misProcesos.calculoFinal(suma / misProcesos.getListaPersonas().size());
            areaInformacion.setText(res);
        } else {
            areaInformacion.setText("No hay estudiantes registrados.");
        }
    }
}