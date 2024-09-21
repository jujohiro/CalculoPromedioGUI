package modelo.operaciones;

import java.util.HashMap;
import javax.swing.JOptionPane;

import modelo.vo.EstudianteVO;
import modelo.vo.ModeloDatos;

public class Procesos {
    private ModeloDatos miModeloDatos;
    
    public void setModeloDatos (ModeloDatos modeloDatos) {
        this.miModeloDatos = new ModeloDatos();
    }
    
    public double calcularPromedio(double n1,double n2,double n3) {
	return (n1 + n2 + n3) / 3;
    }

    public String calculoFinal(double promedio) {
        return "El promedio total de estudiantes es de "+promedio;
    }
    
    public void eliminarEstudiante(String doc) {
        miModeloDatos.eliminarEstudiante(doc);
    }

    public double calcularPromedio(EstudianteVO est) {
        return (est.getNota1() + est.getNota2() + est.getNota3()) / 3;
    }
    
    public void actualizarEstudiante(String nombre, String documento, double nota1, double nota2, double nota3, double promedio) {
        
        miModeloDatos.actualizarEstudiante(nombre, documento, nota1, nota2, nota3, promedio);
    }

    public void registrarEnBD(String nombre, String documento, double nota1, double nota2, double nota3, double promedio) {
        if (obtenerEstudiante(documento) == null) {                        
            EstudianteVO estudiante = new EstudianteVO();
            estudiante.setDocumento(documento);
            estudiante.setNombre(nombre);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            estudiante.setPromedio(promedio);
            if (verificarValido(nombre, documento, nota1, nota2, nota3))
                miModeloDatos.registrarEstudiante(estudiante);
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante ya está registrado", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean verificarValido(String nombre, String documento, double nota1, double nota2, double nota3) {
        if (documento.length() < 1) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el documento", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (nombre.length() < 1) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!(nota1 >= 0 && nota1 <= 5)) {
            JOptionPane.showMessageDialog(null, "La nota 1 debe estar en el rango de 0 a 5", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!(nota2 >= 0 && nota2 <= 5)) {
            JOptionPane.showMessageDialog(null, "La nota 2 debe estar en el rango de 0 a 5", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!(nota3 >= 0 && nota3 <= 5)) {
            JOptionPane.showMessageDialog(null, "La nota 3 debe estar en el rango de 0 a 5",
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
	
    public HashMap<String, EstudianteVO> getListaPersonas(){
        return this.miModeloDatos.getListaEstudiantes();
    }

    public EstudianteVO obtenerEstudiante(String doc) {
        EstudianteVO p=null;
        p = this.miModeloDatos.consultarEstudiante(doc);
        return p;
    }
}