import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

/**
 * 
 * Ventana principal de bienvenida
 * 
 * 
 * @author Marco Almendarez
 * @version 1.0
 * 
 * 
 */


public class Bienvenida extends JFrame {

    private JTextField user;
    private JLabel logoL, tituloL,textField,companyL;
    private JButton logBtn;
    private int x = 350;
    private int y = 450;

    public Bienvenida(){
        setSize(new Dimension(x,y));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setTitle("Bienvenido");
        getContentPane().setBackground(new Color(0,0,0));
        setIconImage(new ImageIcon(getClass().getResource("images/Logo.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon logo = new ImageIcon("images/Logotipo.png"); //Imagen

        logoL = new JLabel(logo);
       
        setImageLabel(logoL, logo, new Dimension(300,300));
        logoL.setBounds(65,15,200,150);
        add(logoL);

        tituloL = new JLabel("Sistema de Aguinaldo");
        tituloL.setBounds(75,180,250,30);
        tituloL.setFont(new Font("Andale Mono", 3, 18));
        tituloL.setForeground(new Color(255,255,255));
        add(tituloL);

        textField = new JLabel("Ingrese su nombre");
        textField.setBounds(45,212,200,30);
        textField.setFont(new Font("Andale Mono",1,12));
        textField.setForeground(new Color(255,255,255));
        add(textField);

        companyL = new JLabel("©2026 Code Tec - Company");
        companyL.setBounds(85,375,300,30);
        companyL.setFont(new Font("Andale Mono",1,12));
        companyL.setForeground(new Color(255,255,255));
        add(companyL);

        user = new JTextField();
        user.setBounds(45,240,255,25);
        user.setBackground(new Color(224,224,224));
        add(user);

        logBtn = new JButton("Ingresar");
        logBtn.setBounds(((x-100)/2),280,100,30);
        logBtn.setBackground(new Color(255,255,255));
        logBtn.setFont(new Font("Andale Mono",1,14));
        //logBtn.setForeground(new Color(0,255,68));
        logBtn.addActionListener(e -> {
            
            String userName = user.getText().trim();

            if(userName.equals("")){
                JOptionPane.showMessageDialog(null, "Debes ingresar tu nommbre");
            } else{
                Preferences prefs = Preferences.userNodeForPackage(Licencia.class);
                boolean aceptada = prefs.getBoolean("licencia_aceptada", false);

                if(aceptada) {
                    // Si ya la aceptó antes, se salta la licencia y va directo a Principal
                    Principal principal = new Principal(userName);
                    principal.setVisible(true);
                    this.dispose();
                } else {
                    // Si es la primera vez, muestra la licencia normal pasándole el nombre
                    Licencia licencia = new Licencia(userName);
                    licencia.setVisible(true);
                    this.dispose();
                }
            }

                    
        });
        add(logBtn);

    }

    /**
     * Metodo para cambiar el tamaño de las imagenes
     * 
     * @param JLabel Etiqueta donde va la imagen
     * @param i Imagen seleccionada
     * @param d Dimensiones de la imagen
     * 
     */
    public void setImageLabel(JLabel label, ImageIcon i, Dimension d){
        Image tempImage = i.getImage();
        Image resizedImage = tempImage.getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
        label.setIcon(new ImageIcon(resizedImage));
    }

    public static void main(String[] args) {
        Bienvenida venBienv = new Bienvenida();
        venBienv.setVisible(true);
    }


}