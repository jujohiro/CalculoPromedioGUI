package vista.gui;

import controlador.Coordinador;
import modelo.operaciones.Procesos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class VentanaOperaciones extends JFrame implements ActionListener {

    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JButton btnCalcular;
    private JLabel lblResPromedio, lblResultado;
    private JButton btnImprimirTotal;
    private JButton btnConsultarestudiante;
    private JTextField txtDocumento;
    private JButton btnConsultarLista;

    private Procesos misProcesos;
    private Coordinador miCoordinador;
    private JLabel etiquetaEstadoFinal; 

    public void setCoordinador(Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }

    public void setProcesos(Procesos procesos) {
        this.misProcesos = procesos;
    }

    public VentanaOperaciones() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(486, 531);
        setTitle("CALCULO DE PROMEDIO");
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelPrincipal);
        panelPrincipal.setLayout(null);

        JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
        lblTitulo.setBackground(Color.black);
        lblTitulo.setForeground(Color.white);
        lblTitulo.setOpaque(true);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblTitulo.setBounds(0, 0, 477, 50);
        panelPrincipal.add(lblTitulo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(31, 86, 100, 23);
        panelPrincipal.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(95, 80, 200, 39);
        panelPrincipal.add(txtNombre);
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtNombre.setColumns(10);

        JLabel lblNota1 = new JLabel("Nota1:");
        lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNota1.setBounds(31, 135, 100, 23);
        panelPrincipal.add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setColumns(10);
        txtNota1.setBounds(95, 129, 63, 39);
        txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelPrincipal.add(txtNota1);

        JLabel lblNota2 = new JLabel("Nota2:");
        lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNota2.setBounds(168, 135, 100, 23);
        panelPrincipal.add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setColumns(10);
        txtNota2.setBounds(232, 129, 63, 39);
        txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelPrincipal.add(txtNota2);

        JLabel lblNota3 = new JLabel("Nota3:");
        lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNota3.setBounds(300, 135, 100, 23);
        panelPrincipal.add(lblNota3);

        txtNota3 = new JTextField();
        txtNota3.setColumns(10);
        txtNota3.setBounds(364, 129, 63, 39);
        txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panelPrincipal.add(txtNota3);

        JLabel lblPromedio = new JLabel("Promedio:");
        lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblPromedio.setBounds(31, 245, 127, 31);
        panelPrincipal.add(lblPromedio);

        lblResPromedio = new JLabel("");
        lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblResPromedio.setBounds(156, 245, 271, 31);
        panelPrincipal.add(lblResPromedio);

        lblResultado = new JLabel("Resultado:");
        lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblResultado.setBounds(31, 286, 396, 31);
        panelPrincipal.add(lblResultado);

        btnCalcular = new JButton();
        btnCalcular.setText("Calcular");
        btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCalcular.setBounds(310, 190, 117, 31);
        btnCalcular.addActionListener(this);
        panelPrincipal.add(btnCalcular);

        btnImprimirTotal = new JButton();
        btnImprimirTotal.setText("Imprimir total");
        btnImprimirTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnImprimirTotal.setBounds(28, 365, 136, 31);
        btnImprimirTotal.addActionListener(this);
        panelPrincipal.add(btnImprimirTotal);

        btnConsultarestudiante = new JButton();
        btnConsultarestudiante.setText("Consultar");
        btnConsultarestudiante.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultarestudiante.setBounds(327, 365, 100, 31);
        btnConsultarestudiante.addActionListener(this);
        panelPrincipal.add(btnConsultarestudiante);

        txtDocumento = new JTextField();
        txtDocumento.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtDocumento.setColumns(10);
        txtDocumento.setBounds(364, 78, 63, 39);
        panelPrincipal.add(txtDocumento);

        JLabel lblDoc = new JLabel("CC: ");
        lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDoc.setBounds(312, 86, 42, 23);
        panelPrincipal.add(lblDoc);

        btnConsultarLista = new JButton();
        btnConsultarLista.setText("Consulta Total");
        btnConsultarLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnConsultarLista.setBounds(181, 365, 136, 31);
        btnConsultarLista.addActionListener(this);
        panelPrincipal.add(btnConsultarLista);

        
        etiquetaEstadoFinal = new JLabel();
        etiquetaEstadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 25));
        etiquetaEstadoFinal.setBounds(31, 320, 396, 31);
        panelPrincipal.add(etiquetaEstadoFinal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            calcularPromedio();
        } else if (e.getSource() == btnImprimirTotal) {
            imprimirTotal();
        } else if (e.getSource() == btnConsultarestudiante) {
            consultarEstudiante();
        } else if (e.getSource() == btnConsultarLista) {
            consultarLista();
        }
    }

    private void consultarLista() {
         if (miCoordinador == null) {
        mostrarError("El objeto Coordinador no ha sido inicializado.");
        return;
    }
        miCoordinador.mostrarVentanaConsultaPersonas();
    }

    private void imprimirTotal() {
        miCoordinador.mostrarVentanaConsultaGeneral();
    }

    private void consultarEstudiante() {
        miCoordinador.mostrarVentanaConsulta();
    }

    private void calcularPromedio() {
         if (misProcesos == null) {
        mostrarError("El objeto Procesos no ha sido inicializado.");
        return;
    }
        try {
            double nota1 = obtenerNota(txtNota1);
            double nota2 = obtenerNota(txtNota2);
            double nota3 = obtenerNota(txtNota3);

            double promedio = misProcesos.calcularPromedio(nota1, nota2, nota3);

            actualizarResultadoPromedio(promedio);

            guardarDatosEnBD(nota1, nota2, nota3, promedio);

        } catch (IllegalArgumentException e) {
            mostrarErrorNotasFueraDeRango(e.getMessage());
        } catch (Exception e) {
            mostrarErrorNotasInvalidas();
        }
    }

    private double obtenerNota(JTextField campoNota) throws NumberFormatException, IllegalArgumentException {
    String textoNota = campoNota.getText();
    if (textoNota.isEmpty()) {
        throw new IllegalArgumentException("El campo de la nota no puede estar vacío");
    }
    double nota = Double.parseDouble(textoNota);
    if (nota < 0 || nota > 5) {
        throw new IllegalArgumentException("La nota debe estar entre 0 y 5");
    }
    return nota;
}
    private void actualizarResultadoPromedio(double promedio) {
        lblResPromedio.setText(Double.toString(promedio));
        String resultado = promedio >= 3.5 ? "APROBÓ" : "REPROBÓ";
        Color color = promedio >= 3.5 ? Color.green : Color.red;

        actualizarEstadoFinal(resultado, color);
    }

    private void actualizarEstadoFinal(String estado, Color color) {
        etiquetaEstadoFinal.setText("Resultado: El estudiante " + estado);
        etiquetaEstadoFinal.setForeground(color);
    }

    private void guardarDatosEnBD(double nota1, double nota2, double nota3, double promedio) {
        misProcesos.registrarEnBD(txtNombre.getText(), txtDocumento.getText(), nota1, nota2, nota3, promedio);
    }

    private void mostrarErrorNotasFueraDeRango(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Datos inválidos", 
                JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarErrorNotasInvalidas() {
        JOptionPane.showMessageDialog(null, "Las notas ingresadas no son válidas", 
                "Datos inválidos", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarError(String mensaje) {
    JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}