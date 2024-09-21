package vista.gui;

import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.operaciones.Procesos;
import modelo.vo.EstudianteVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaConsulta extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtDoc;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblResultado;
	private JLabel lblResPromedio;
	private JLabel lblResActualizacion;

  private Procesos misProcesos;
    private Coordinador miCoordinador;

    public void setCoordinador (Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }
    
    public void setProcesos (Procesos procesos) {
        this.misProcesos = procesos;
    }
        
    public VentanaConsulta() {
            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(491, 426);
            getContentPane().setLayout(null);
            setLocationRelativeTo(null);
            iniciarComponentes();
    }

    public void iniciarComponentes() {
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            JPanel panelPrincipal = new JPanel();
            panelPrincipal.setLayout(null);
            panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
            panelPrincipal.setBounds(0, 0, 477, 379);
            getContentPane().add(panelPrincipal);

            JLabel lblConsultar = new JLabel("CONSULTAR");
            lblConsultar.setOpaque(true);
            lblConsultar.setHorizontalAlignment(SwingConstants.CENTER);
            lblConsultar.setForeground(Color.WHITE);
            lblConsultar.setFont(new Font("Tahoma", Font.PLAIN, 25));
            lblConsultar.setBackground(Color.BLACK);
            lblConsultar.setBounds(0, 0, 477, 50);
            panelPrincipal.add(lblConsultar);

            JLabel lblNombre = new JLabel("Nombre:");
            lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNombre.setBounds(31, 104, 100, 23);
            panelPrincipal.add(lblNombre);

            txtNombre = new JTextField();
            txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
            txtNombre.setColumns(10);
            txtNombre.setBounds(95, 98, 332, 39);
            panelPrincipal.add(txtNombre);

            JLabel lblNota1 = new JLabel("Nota1:");
            lblNota1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNota1.setBounds(31, 153, 100, 23);
            panelPrincipal.add(lblNota1);

            txtNota1 = new JTextField();
            txtNota1.setFont(new Font("Tahoma", Font.PLAIN, 15));
            txtNota1.setColumns(10);
            txtNota1.setBounds(95, 147, 63, 39);
            panelPrincipal.add(txtNota1);

            JLabel lblNota2 = new JLabel("Nota2:");
            lblNota2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNota2.setBounds(168, 153, 100, 23);
            panelPrincipal.add(lblNota2);

            txtNota2 = new JTextField();
            txtNota2.setFont(new Font("Tahoma", Font.PLAIN, 15));
            txtNota2.setColumns(10);
            txtNota2.setBounds(232, 147, 63, 39);
            panelPrincipal.add(txtNota2);

            JLabel lblNota3 = new JLabel("Nota3:");
            lblNota3.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblNota3.setBounds(300, 153, 100, 23);
            panelPrincipal.add(lblNota3);

            txtNota3 = new JTextField();
            txtNota3.setFont(new Font("Tahoma", Font.PLAIN, 15));
            txtNota3.setColumns(10);
            txtNota3.setBounds(364, 147, 63, 39);
            panelPrincipal.add(txtNota3);

            JLabel lblPromedio = new JLabel("Promedio:");
            lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
            lblPromedio.setBounds(31, 196, 127, 31);
            panelPrincipal.add(lblPromedio);

            lblResPromedio = new JLabel("");
            lblResPromedio.setFont(new Font("Tahoma", Font.PLAIN, 25));
            lblResPromedio.setBounds(156, 196, 271, 31);
            panelPrincipal.add(lblResPromedio);

            lblResultado = new JLabel("Resultado:");
            lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 25));
            lblResultado.setBounds(31, 237, 396, 31);
            panelPrincipal.add(lblResultado);

            btnConsultar = new JButton();
            btnConsultar.setText("...");
            btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnConsultar.setBounds(364, 60, 63, 31);
            btnConsultar.addActionListener(this);
            panelPrincipal.add(btnConsultar);

            JLabel lblDoc = new JLabel("Documento");
            lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 14));
            lblDoc.setBounds(195, 65, 100, 23);
            panelPrincipal.add(lblDoc);

            txtDoc = new JTextField();
            txtDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
            txtDoc.setColumns(10);
            txtDoc.setBounds(300, 60, 63, 31);
            panelPrincipal.add(txtDoc);

            btnActualizar = new JButton();
            btnActualizar.setText("Actualizar");
            btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnActualizar.setBounds(31, 278, 184, 31);
            btnActualizar.addActionListener(this);
            panelPrincipal.add(btnActualizar);

            btnEliminar = new JButton();
            btnEliminar.setText("Eliminar");
            btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btnEliminar.setBounds(243, 278, 184, 31);
            btnEliminar.addActionListener(this);
            panelPrincipal.add(btnEliminar);

            lblResActualizacion = new JLabel("");
            lblResActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 25));
            lblResActualizacion.setBounds(31, 325, 396, 31);
            panelPrincipal.add(lblResActualizacion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnConsultar) {
            if (this.misProcesos.obtenerEstudiante(txtDoc.getText()) != null) {
                EstudianteVO estudiante = this.misProcesos.obtenerEstudiante(txtDoc.getText());
                txtNombre.setText(estudiante.getNombre());
                txtNota1.setText(Double.toString(estudiante.getNota1()));
                txtNota2.setText(Double.toString(estudiante.getNota2()));
                txtNota3.setText(Double.toString(estudiante.getNota3()));
                txtDoc.setText(estudiante.getDocumento());
                lblResPromedio.setText(Double.toString(estudiante.getPromedio()));
                if (estudiante.getPromedio() >= 3.5) {
                    lblResultado.setText("Resultado: Aprobó");
                    lblResultado.setForeground(Color.green);
                } else {
                    lblResultado.setText("Resultado: Reprobó");
                    lblResultado.setForeground(Color.red);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El estudiante no está registrado", 
                        "Datos invalidos", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
       else if (e.getSource() == btnActualizar) {
    if (misProcesos.obtenerEstudiante(txtDoc.getText()) != null) {
        try {
            
            double nota1 = Double.parseDouble(txtNota1.getText());
            double nota2 = Double.parseDouble(txtNota2.getText());
            double nota3 = Double.parseDouble(txtNota3.getText());
            
          
            double promedio = misProcesos.calcularPromedio(nota1, nota2, nota3);

            misProcesos.actualizarEstudiante(txtNombre.getText(), txtDoc.getText(), nota1, nota2, nota3, promedio);

            lblResPromedio.setText(Double.toString(promedio));
            if (promedio >= 3.5) {
                lblResultado.setText("Resultado: Aprobó");
                lblResultado.setForeground(Color.green);
            } else {
                lblResultado.setText("Resultado: Reprobó");
                lblResultado.setForeground(Color.red);
            }

           
            lblResActualizacion.setText("Estudiante actualizado con éxito");
            lblResActualizacion.setForeground(Color.blue);

         
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese notas válidas.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "El estudiante no está registrado",
                "Datos invalidos", JOptionPane.ERROR_MESSAGE);
    }
}
        else if (e.getSource() == btnEliminar) {
    if (misProcesos.obtenerEstudiante(txtDoc.getText()) != null) {
 
        int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que deseas eliminar este estudiante?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            misProcesos.eliminarEstudiante(txtDoc.getText());
            JOptionPane.showMessageDialog(null, "Estudiante eliminado con éxito", 
                    "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        }
    } else {
        JOptionPane.showMessageDialog(null, "El estudiante no está registrado", 
                "Datos invalidos", JOptionPane.ERROR_MESSAGE);
    }
}
    }
    public void limpiarCampos() {
    txtNombre.setText("");
    txtNota1.setText("");
    txtNota2.setText("");
    txtNota3.setText("");
    txtDoc.setText("");
    lblResPromedio.setText("");
    lblResultado.setText("");
    lblResActualizacion.setText("");
}
    }
