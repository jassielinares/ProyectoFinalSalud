
package vista;

import pojos.Estudiante;
import java.util.ArrayList;

//librerias de conexion
import java.sql.Connection;//conexion a BD
import java.sql.DriverManager;//driver de conexion
import java.sql.ResultSet;//resultado final de datos
import java.sql.ResultSetMetaData;//resultado de metadatos
import java.sql.SQLException;//Tratamiento de Errros de BD SQL
import java.sql.Statement;//Generador de sentencias SQL
import java.text.SimpleDateFormat;//Formatear datos
import java.util.Date;//fecha de sistema
import javax.swing.ImageIcon;//Tratamiento de imagenes
import javax.swing.JOptionPane;//ventanas emergentes
import javax.swing.table.DefaultTableModel;//tabla de datos

/**
 *
 * @author Usuario
 */
public class ImcInterfaz extends javax.swing.JFrame 
{
    private Estudiante imc;
    private Tabla tabla;
    private ArrayList<String> datos;
     //clases de conexion y sus objetos
    public Connection cn;
    public Statement stmt;
    public ResultSet rs;
    
    Estudiante objetoEstudiante = new Estudiante();//objeto libro generado
    
    public ImcInterfaz() {
        this.datos = new ArrayList<>();
        this.imc = null;
        this.tabla = null;
        initComponents();
        
        this.setLocationRelativeTo(null);
        //ponerle el tamaño a la imagen de acuerdo al tamaño de lbl
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImagenEstudiantes,"src/imagen/estudiantes.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(lblImagenDoctor,"src/imagen/doctor.jpg");
        rsscalelabel.RSScaleLabel.setScaleLabel(lblfondo,"src/imagen/fondoIMC.jpg");
        
    }
    
    public void conectarBase(){
        try{ //inicia try
                Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost/bdsalud1","root","hola123");
                JOptionPane.showMessageDialog(null, "Conexion a BD OK\n\nLINARES");
                stmt=cn.createStatement();//genera sentencias sobre objetos de base de datos
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error de base de datos 1: \n"+ ex);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error de base de datos 2:"+ e);
        }
    }//termina metodo conectar
    
    public void mostrarDatos()
    {
        boolean bandera = true;
        String altura = txtAltura.getText();
        String peso = txtPeso.getText();
        float alt = 0;
        float pes = 0;
        
        try 
        {
            alt = Float.parseFloat(altura);
            pes = Float.parseFloat(peso);
        } catch (NumberFormatException e) 
        {
            bandera = false;
            JOptionPane.showMessageDialog(this, "No has ingresado ningun dato del estudiante");
        }
        
        if(bandera)
        {
            this.imc = new Estudiante(alt, pes);
            this.datos = this.imc.calcularImc();
        }        
        
    }
        public void recomendacion(){
            
        double TMB=0,calorias = 0,carbohidratos=0,proteinas=0,grasas=0, alturaCM=0;
        
        String actividad= cbActividad.getSelectedItem().toString();
        String  genero = cbGenero.getSelectedItem().toString();
        double  peso=Double.parseDouble(txtPeso.getText());
        double altura= Double.parseDouble(txtAltura.getText());
        double edad=Double.parseDouble(txtEdad.getText());
        
        alturaCM=  altura*(100/1.0);
        
        if(genero == "Hombre"){
            TMB= (10*peso)+ (6.25* alturaCM)-(5*edad)+ 5;
        }else{
            TMB= (10*peso)+ (6.25* alturaCM)-(5*edad)+ 161;
        }
        
        if( actividad == "1. Poco o ningun ejercicio") {
	 calorias= TMB * 1.2;
	} else if(actividad=="2. Ejercicio ligero(1-3 dias por semana)"){
         calorias= TMB * 1.375;
        }else if(actividad=="3. Ejercicio moderado(3-5 dias por semana)"){
         calorias= TMB * 1.55;
        }else if(actividad=="4. Ejercicio fuerte (6 dias por semana)"){
         calorias= TMB * 1.725;
        }else if(actividad=="5. Ejercicio profesional o extremo"){
         calorias= TMB * 1.9;
        } 

      carbohidratos = calorias*0.40;
      proteinas = calorias*0.30;
      grasas = calorias*0.30;
        
         txtReco.setText("De acuerdo con las características del paciente "+txtNombre.getText()+" debe consumir "+String.valueOf(calorias)+" calorias por día de las cuales "+String.valueOf(carbohidratos)+" corresponden a carbohidratos, "+String.valueOf(proteinas)+" corresponden a proteínas y "+String.valueOf(grasas)+" corresponde a grasas");

  }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSistemaSalud = new javax.swing.JLabel();
        lblAltura = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        botonCalcular = new javax.swing.JButton();
        lblIMC = new javax.swing.JLabel();
        lblEstadoSalud = new javax.swing.JLabel();
        txtTiene = new javax.swing.JTextField();
        txtImc = new javax.swing.JTextField();
        btnTabla = new javax.swing.JButton();
        lblMetro = new javax.swing.JLabel();
        lblKilogramos = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        lblEdad = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblAltura1 = new javax.swing.JLabel();
        lblAltura2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtIdEstudiante = new javax.swing.JTextField();
        btnMostrarLista = new javax.swing.JButton();
        lblImagenEstudiantes = new javax.swing.JLabel();
        btnDarBaja = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAgregarEstudiante = new javax.swing.JButton();
        lblImagenDoctor = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        lblActividadRealizada = new javax.swing.JLabel();
        cbActividad = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReco = new javax.swing.JTextPane();
        lblfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSistemaSalud.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblSistemaSalud.setForeground(new java.awt.Color(255, 51, 51));
        lblSistemaSalud.setText("SISTEMA DE ESTADO DE SALUD");
        getContentPane().add(lblSistemaSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 624, 28));

        lblAltura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAltura.setText("Altura Actual:");
        getContentPane().add(lblAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        lblPeso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPeso.setText("Peso Actual:");
        getContentPane().add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));

        txtAltura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtAltura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 135, -1));

        txtPeso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 135, -1));

        botonCalcular.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonCalcular.setText("Calcular IMC");
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        getContentPane().add(botonCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, -1, -1));

        lblIMC.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblIMC.setText("IMC:");
        getContentPane().add(lblIMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        lblEstadoSalud.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEstadoSalud.setText("Estado de salud: ");
        getContentPane().add(lblEstadoSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        txtTiene.setEditable(false);
        txtTiene.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtTiene, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 175, -1));

        txtImc.setEditable(false);
        txtImc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtImc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImcActionPerformed(evt);
            }
        });
        getContentPane().add(txtImc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 175, -1));

        btnTabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTabla.setText("Ver Tabla");
        btnTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTablaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 120, -1));

        lblMetro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMetro.setText("m");
        getContentPane().add(lblMetro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        lblKilogramos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblKilogramos.setText("Kg");
        getContentPane().add(lblKilogramos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 530, 99, 34));

        lblEdad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblEdad.setText("Edad:");
        getContentPane().add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        lblSexo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSexo.setText("Sexo:");
        getContentPane().add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        lblAltura1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAltura1.setText("Nombre:");
        getContentPane().add(lblAltura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, 20));

        lblAltura2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAltura2.setText("Id:");
        getContentPane().add(lblAltura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        txtEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 135, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 135, -1));

        txtIdEstudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtIdEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 135, -1));

        btnMostrarLista.setBackground(new java.awt.Color(102, 102, 255));
        btnMostrarLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMostrarLista.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarLista.setText("MOSTRAR LISTA  ");
        btnMostrarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrarLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 90, 171, -1));

        lblImagenEstudiantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblImagenEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 58, 340, 240));

        btnDarBaja.setBackground(new java.awt.Color(102, 102, 255));
        btnDarBaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDarBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnDarBaja.setText("DAR DE BAJA");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDarBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 171, -1));

        btnModificar.setBackground(new java.awt.Color(102, 102, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("MODIFICAR DATOS");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, -1, -1));

        btnAgregarEstudiante.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAgregarEstudiante.setForeground(new java.awt.Color(0, 51, 255));
        btnAgregarEstudiante.setText("Agregar estudiante ");
        btnAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEstudianteActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, -1, -1));

        lblImagenDoctor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblImagenDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 253, 186));

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoge tu opcion", "Hombre ", "Mujer " }));
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(cbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 135, -1));

        lblActividadRealizada.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblActividadRealizada.setText("Actividad realizada:");
        getContentPane().add(lblActividadRealizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        cbActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoge tu opcion ", "1. Poco o ningun ejercicio", "2. Ejercicio ligero(1-3 dias por semana)", "3. Ejercicio moderado(3-5 dias por semana)", "4. Ejercicio fuerte (6 dias por semana)", "5. Ejercicio profesional o extremo" }));
        getContentPane().add(cbActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 280, 30));

        txtReco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtReco);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 290, 160));

        lblfondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGeneroActionPerformed

    private void btnAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEstudianteActionPerformed

        //llamada o invocacion a metodo conectar
        conectarBase();
        String altaEstudiante="";//variable para lamacenar los valores capturados y enviarlos a la base
        
        //para almacenar los varlores desde formulario
        objetoEstudiante.setIdEstudiante(Integer.parseInt(txtIdEstudiante.getText()));
        objetoEstudiante.setNombre(txtNombre.getText());
        objetoEstudiante.setSexo(cbGenero.getSelectedItem().toString());
        objetoEstudiante.setEdad(Double.parseDouble(txtEdad.getText()));
        objetoEstudiante.setAltura(Double.parseDouble(txtAltura.getText()));
        objetoEstudiante.setPeso(Double.parseDouble(txtPeso.getText()));
        objetoEstudiante.setImc(Double.parseDouble(txtImc.getText()));
        objetoEstudiante.setTiene(txtTiene.getText());
        objetoEstudiante.setActividad(cbActividad.getSelectedItem().toString());
        objetoEstudiante.setRecomendacion(txtReco.getText());
        
        altaEstudiante="INSERT INTO testudiante (`idEstudiante`,`nombre`,`sexo`,`edad`,`altura`,`peso`,`imc`,`tiene`,`actividad`,`recomendacion`) VALUES ('"+objetoEstudiante.getIdEstudiante()+"','"+objetoEstudiante.getNombre()+"','"+objetoEstudiante.getSexo()+"','"+objetoEstudiante.getEdad()+"','"+objetoEstudiante.getAltura()+"','"+objetoEstudiante.getPeso()+"','"+objetoEstudiante.getImc()+"','"+objetoEstudiante.getTiene()+"','"+objetoEstudiante.getActividad()+"','"+objetoEstudiante.getRecomendacion()+"')";
        try {
            stmt.executeUpdate(altaEstudiante);
            JOptionPane.showMessageDialog(null,"Se registro producto de forma exitosa!!!\n"+objetoEstudiante.getNombre());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de BD al genera Alta\nVerifica:"+ ex);
        }

    }//GEN-LAST:event_btnAgregarEstudianteActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        ModificarEstudiante ventanaModificar= new ModificarEstudiante();//llamada a la ventana o iGU
        ventanaModificar.setVisible(true);//muestra ventana
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed

        BajaEstudiante ventanaBaja= new BajaEstudiante();//llamada a la ventana o iGU
        ventanaBaja.setVisible(true);//muestra ventana
    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void btnMostrarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarListaActionPerformed

        ListasEstudiantes ventanaLista= new ListasEstudiantes();//llamada a la ventana o iGU
        ventanaLista.setVisible(true);//muestra ventana
    }//GEN-LAST:event_btnMostrarListaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int confirmaSalida=JOptionPane.showConfirmDialog(null,"¿Quieres salir?","Mensaje importante",JOptionPane.YES_NO_OPTION);
        if (confirmaSalida==0) {
            System.exit(0);//cierra ventana
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTablaActionPerformed
        this.tabla = new Tabla(this, false);
        this.tabla.setVisible(true);
    }//GEN-LAST:event_btnTablaActionPerformed

    private void txtImcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImcActionPerformed

    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        this.mostrarDatos();
        this.txtImc.setText(this.datos.get(0));
        this.txtTiene.setText(this.datos.get(1));
        recomendacion();
    }//GEN-LAST:event_botonCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImcInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImcInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImcInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImcInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImcInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton btnAgregarEstudiante;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarLista;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTabla;
    private javax.swing.JComboBox<String> cbActividad;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblActividadRealizada;
    private javax.swing.JLabel lblAltura;
    private javax.swing.JLabel lblAltura1;
    private javax.swing.JLabel lblAltura2;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEstadoSalud;
    private javax.swing.JLabel lblIMC;
    private javax.swing.JLabel lblImagenDoctor;
    private javax.swing.JLabel lblImagenEstudiantes;
    private javax.swing.JLabel lblKilogramos;
    private javax.swing.JLabel lblMetro;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSistemaSalud;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdEstudiante;
    private javax.swing.JTextField txtImc;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextPane txtReco;
    private javax.swing.JTextField txtTiene;
    // End of variables declaration//GEN-END:variables
}
