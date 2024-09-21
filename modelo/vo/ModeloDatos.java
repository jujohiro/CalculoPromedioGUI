package modelo.vo;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class ModeloDatos {
    private HashMap<String, EstudianteVO> listaEstudiantes;
    
    public ModeloDatos () {
        this.listaEstudiantes = new HashMap<String, EstudianteVO>();
    }
    
    public void registrarEstudiante(EstudianteVO estudiante) {
        listaEstudiantes.put(estudiante.getDocumento(), estudiante);
    }
    
    public EstudianteVO consultarEstudiante(String documento) {
        if (listaEstudiantes.containsKey(documento)) {
            return listaEstudiantes.get(documento);
        } else {
            return null;
        }
    }
    
    public void eliminarEstudiante(String documento) {
        if (listaEstudiantes.containsKey(documento)) {
            listaEstudiantes.remove(documento);
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante no existe",
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarEstudiante(String nombre, String documento, double nota1, double nota2, double nota3, double promedio) {
        if (listaEstudiantes.containsKey(documento)) {
            EstudianteVO estudiante = consultarEstudiante(documento);
            estudiante.setNombre(nombre);
            estudiante.setDocumento(documento);
            estudiante.setNota1(nota1);
            estudiante.setNota2(nota2);
            estudiante.setNota3(nota3);
            estudiante.setPromedio(promedio);
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante no esta en la base de datos", 
                    "Datos invalidos", JOptionPane.ERROR_MESSAGE);
        }
    }
    public HashMap<String, EstudianteVO> getListaEstudiantes () {
        return listaEstudiantes;
    }
}
