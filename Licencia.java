import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * 
 * Esta clase es para validar los terminos y condiciones
 * 
 * @author Marco Vinicio
 * @version 1.0
 * 
 */

public class Licencia extends JFrame implements ChangeListener{
    
    private JLabel titulo;
    private JCheckBox check1;
    private JButton okBtn, noBtn;
    private JScrollPane scrollPane;
    private JTextArea terminos;
    private String name = "";
    

    /**
     * Constructor principal de la clase
     * 
     * @param name Guarda el nombre del usuario
     */
    public Licencia(String name){
        setSize(new Dimension(610,370));
        setLocationRelativeTo(null);
        setResizable(false);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("images/Logo.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Bienvenida bienv = new Bienvenida();
        this.name = name;

        titulo = new JLabel("TÉRMINOS Y CONDICIONES");
        titulo.setBounds(215,5,200,30);
        titulo.setFont(new Font("Andale Mono",1,14));
        titulo.setForeground(new Color(0,0,0));
        add(titulo);
        
        terminos = new JTextArea();
        terminos.setEditable(false);
        terminos.setFont(new Font("Andale Mono",0,9));
        terminos.setText("\n\n          TÉRMINOS Y CONDICIONES" +
                    "\n\n            A.  PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE CODE TECHNOLOGY." +
                    "\n            B.  PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS." +
                    "\n            C.  CODE TEC NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE." +
                    "\n\n          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" +
                    "\n          (CODE TEC Y EL AUTOR MARCO), NO SE RESPONSABILIZAN DEL USO QUE USTED" + 
                    "\n          HAGA CON ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO)" +
                    "\n          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE." + 
                    "\n\n          PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE" + 
                    "\n          http://www.codetec.com.mx/");
        scrollPane = new JScrollPane(terminos);
        scrollPane.setBounds(10,40,575,200);
        add(scrollPane);

        check1 = new JCheckBox("Yo " + name + " Acepto");
        check1.setBounds(10,250,300,30);
        check1.addChangeListener(this);
        add(check1);

        okBtn = new JButton("Continuar");
        okBtn.setBounds(10,290,100,30);
        okBtn.addActionListener(e -> {
            Principal prin = new Principal(name);
            prin.setVisible(true);
            this.dispose();
        });
        okBtn.setEnabled(false);
        add(okBtn);

        noBtn = new JButton("No Acepto");
        noBtn.setBounds(120,290,100,30);
        noBtn.addActionListener(e -> {
            this.dispose();
            bienv.setVisible(true);
        });
        noBtn.setEnabled(true);
        add(noBtn);


    }

    //Metodo para verificar si el CheckBox fue marcado
    public void stateChanged(ChangeEvent e){
        if(check1.isSelected()){
            okBtn.setEnabled(true);
            noBtn.setEnabled(false);
        }else{
            okBtn.setEnabled(false);
            noBtn.setEnabled(true);
        }
        
    }

    
}
