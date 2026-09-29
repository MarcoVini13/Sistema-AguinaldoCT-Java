import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.dgc.VMID;


/**
 * 
 * Clase principal de la aplicacion
 * 
 * @author Marco
 * @version 1.0
 * 
 */
public class Principal extends JFrame implements ActionListener{

    private int x=650;
    private int y=500;
    private String name;
    private JMenuBar mb;
    private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuPerzonalizar;
    private JMenuItem miCalculo, miBlanco,miNegro,miElCreador,miSalir,miNuevo,miVacaciones;
    private JLabel logoL, bienvL, nomL,antL, resL, footerL,apL,amL,depL,titleL;
    private JTextField txtName, txtAP,txtAM;
    private JComboBox<String> comboDep, comboAnti;
    private JTextArea textRes;
    private ImageIcon img = new ImageIcon("images/LogoW.jpg");
    private Color negro = new Color(0,0,0);
    private Color blanco = new Color(255,255,255);
    

    public Principal(String name){

        setSize(new Dimension(x,y));
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Pantalla principal");
        setIconImage(new ImageIcon(getClass().getResource("images/Logo.png")).getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255,255,255));

       
        this.name = name;
        
        //Menu Bar
        mb = new JMenuBar();
        setJMenuBar(mb);

        menuOpciones = new JMenu("Opciones");
        menuOpciones.setFont(new Font("Andale Mono",1,14));
        mb.add(menuOpciones);

        menuCalcular = new JMenu("Calcular");
        menuCalcular.setFont(new Font("Andale Mono",1,14));
        mb.add(menuCalcular);

        menuAcercaDe = new JMenu("Acerca de");
        menuAcercaDe.setFont(new Font("Andale Mono",1,14));
        mb.add(menuAcercaDe);

        menuPerzonalizar = new JMenu("Color de fondo");
        menuPerzonalizar.setFont(new Font("Andale Mono",1,14));
        menuOpciones.add(menuPerzonalizar);


        miCalculo = new JMenuItem("Aguinaldo");
        miCalculo.setFont(new Font("Andale Mono",1,14));
        menuCalcular.add(miCalculo);
        miCalculo.addActionListener(this);

        miBlanco = new JMenuItem("Blanco");
        miBlanco.setFont(new Font("Andale Mono",1,14));
        menuPerzonalizar.add(miBlanco);
        miBlanco.addActionListener(this);

        miNegro = new JMenuItem("Negro");
        miNegro.setFont(new Font("Andale Mono",1,14));
        menuPerzonalizar.add(miNegro);
        miNegro.addActionListener(this);

        miNuevo = new JMenuItem("Nuevo");
        miNuevo.setFont(new Font("Andale Mono",1,14));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);
        
        miSalir = new JMenuItem("Salir");
        miSalir.setFont(new Font("Andale Mono",1,14));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);

        miElCreador = new JMenuItem("El creador");
        miElCreador.setFont(new Font("Andale Mono",1,14));
        menuAcercaDe.add(miElCreador);
        miElCreador.addActionListener(this);


        //Label del logo
        logoL = new JLabel();
        setImageLabel(logoL, img, new Dimension(200,200));
        logoL.setBounds(5,5,200,200);
        add(logoL);

    
            bienvL = new JLabel("Bienvenido " + name);
            bienvL.setBounds(220,30,300,50);
            bienvL.setFont(new Font("Andale Mono",1,32));
            add(bienvL);
        

        
        
        titleL = new JLabel("Datos del trabajador para el calculo");
        titleL.setBounds(220,120,350,50);
        titleL.setFont(new Font("Andale Mono",1,20));
        add(titleL);

        //Registro del campo NOMBRE
        nomL = new JLabel("Nombre completo:");
        nomL.setBounds(220,170,150,25);
        nomL.setFont(new Font("Andale Mono",1,12));
        add(nomL);

        txtName = new JTextField();
        txtName.setBounds(220,190,150,25);
        add(txtName);

        //Registro del campo APELLIDO PATERNO
        apL = new JLabel("Apellido paterno:");
        apL.setBounds(220,215,150,25);
        apL.setFont(new Font("Andale Mono",1,12));
        add(apL);

        txtAP = new JTextField();
        txtAP.setBounds(220,240,150,25);
        add(txtAP);

        //Registro del campo APELLIDO MATERNO
        amL = new JLabel("Apellido materno:");
        amL.setBounds(220,265,150,25);
        amL.setFont(new Font("Andale Mono",1,12));
        add(amL);

        txtAM = new JTextField();
        txtAM.setBounds(220,290,150,25);
        add(txtAM);

        //Registro del campo ANTIGUEDAD
        antL = new JLabel("Selecciona la antiguedad:");
        antL.setBounds(400,170,150,25);
        antL.setFont(new Font("Andale Mono",1,12));
        add(antL);

        comboAnti = new JComboBox<>();
        comboAnti.setBounds(400,190,220,25);
        comboAnti.setFont(new Font("Andale Mono",1,14));
        add(comboAnti);
        comboAnti.addItem("");
        comboAnti.addItem("Menos de 1 año de servicio");
        comboAnti.addItem("1 año de servicio");
        comboAnti.addItem("De 3 a 6 años de servicio");
        comboAnti.addItem("Más de 7 años de servicio");

        //Registro del campo DEPARTAMENTO
        depL = new JLabel("Selecciona el Departamento:");
        depL.setBounds(400,215,170,25);
        depL.setFont(new Font("Andale Mono",1,12));
        add(depL);

        comboDep = new JComboBox<>();
        comboDep.setBounds(400,240,220,25);
        comboDep.setFont(new Font("Andale Mono",1,14));
        add(comboDep);
        comboDep.addItem("");
        comboDep.addItem("Programacion");
        comboDep.addItem("Diseño");
        comboDep.addItem("Cientifico matematico");
        comboDep.addItem("Atencion a cliente");
        comboDep.addItem("Recursos humanos");
        comboDep.addItem("Gerencia");
        add(comboDep);

        //Muestra del RESULTADO
        resL = new JLabel("Resultado:");
        resL.setBounds(400,265,100,25);
        resL.setFont(new Font("Andale Mono",1,12));
        add(resL);

        textRes = new JTextArea();
        textRes.setFont(new Font("Andale Mono",1,12));
        textRes.setBackground(new Color(201,206,214));
        textRes.setEditable(false);
        JScrollPane textScroll = new JScrollPane(textRes);
        textScroll.setBounds(400, 290, 220, 100);
        add(textScroll);

        //Pie de pagina
        footerL = new JLabel("©2026 Code Tec - Company | Todos los derechos reservados");
        footerL.setBounds(135,400,500,30);
        footerL.setFont(new Font("Andale Mono",1,12));
        add(footerL);

    }

    //Metodos para verificar lo seleccionado por el usuario
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == miCalculo){
            
            String nombre = txtName.getText();
            String apellidoP = txtAP.getText(); 
            String apellidoM = txtAM.getText();
            String antiguedad = comboAnti.getSelectedItem().toString();
            String departamento = comboDep.getSelectedItem().toString();

            Calculos cal = new Calculos();
            String res = cal.calcularAguinaldo(nombre, apellidoP, apellidoM, antiguedad, departamento);
            
            textRes.setText(res);

        }

        if(e.getSource() == miNuevo){
            txtName.setText("");
            txtAP.setText("");
            txtAM.setText("");
            comboAnti.setSelectedIndex(0);
            comboDep.setSelectedIndex(0);
            textRes.setText("");
        }
        if(e.getSource() == miSalir){
            this.dispose();
            Bienvenida bienv = new Bienvenida();
            bienv.setVisible(true);
        }
        if(e.getSource() == miBlanco){
            getContentPane().setBackground(blanco);
            bienvL.setForeground(negro);
            titleL.setForeground(negro);
            nomL.setForeground(negro);
            apL.setForeground(negro);
            amL.setForeground(negro);
            antL.setForeground(negro);
            depL.setForeground(negro);
            resL.setForeground(negro);
            img = new ImageIcon("images/LogoW.jpg");
            logoL.setIcon(img);
            setImageLabel(logoL, img, new Dimension(200,200));
            footerL.setForeground(negro);
        }
        if(e.getSource() == miNegro){
            getContentPane().setBackground(negro);
            bienvL.setForeground(blanco);
            titleL.setForeground(blanco);
            nomL.setForeground(blanco);
            apL.setForeground(blanco);
            amL.setForeground(blanco);
            antL.setForeground(blanco);
            depL.setForeground(blanco);
            resL.setForeground(blanco);
            img = new ImageIcon("images/Logotipo.png");
            logoL.setIcon(img);
            setImageLabel(logoL, img, new Dimension(200,200));
            footerL.setForeground(blanco);
            
        }

        if(e.getSource() == miElCreador){
            JOptionPane.showMessageDialog(null, "Creado por Marco Almendarez");
        }
        
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
}
