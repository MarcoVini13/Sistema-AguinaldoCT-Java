import javax.swing.JOptionPane;


/**
 * Clase para completar los calculos
 * 
 * @author Marco Almendarez
 * @version 
 */
public class Calculos {

    public String nombre;
    public String apellidoP;
    public String apellidoM;
    public String antiguedad;
    public String departamento;
    public String resultado = "";
    private int monto;

    // Constructor vacío
    public Calculos() {
    }

    public String calcularAguinaldo(String nombre, String apellidoP, String apellidoM, String antiguedad, String departamento) {
        
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.antiguedad = antiguedad;
        this.departamento = departamento;

        if (nombre.equals("") || apellidoP.equals("") || apellidoM.equals("") || antiguedad.equals("") || departamento.equals("")) {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");  
            return "";
        }

        monto = 0;

       
        if (antiguedad.equals("Menos de 1 año de servicio")) {
            monto = 1000;
        } else if (antiguedad.equals("1 año de servicio")) {
            monto = 2000;
        } else if (antiguedad.equals("De 3 a 6 años de servicio")) {
            monto = 3000;
        } else if (antiguedad.equals("Más de 7 años de servicio")) {
            monto = 4000;
        }

        // Validación de departamentos válidos
        if (departamento.equals("Programacion") || departamento.equals("Diseño") || 
            departamento.equals("Cientifico matematico") || departamento.equals("Atencion a cliente") || 
            departamento.equals("Recursos humanos") || departamento.equals("Gerencia")) {
            
            resultado = "\n El trabajador " + this.nombre + " " + this.apellidoP + " " + this.apellidoM +
                        "\n del departamento de: " + this.departamento + "\n con " + this.antiguedad +
                        "\n recibe $" + monto + " de Aguinaldo. ";
        }

        return resultado;
    }
}