
package vista;

//librerias de conexion
import pojos.TextPrompt;
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

public class Acceso extends javax.swing.JFrame {

     //clases de conexion y sus objetos
    public Connection cn;
    public Statement stmt;
    public ResultSet rs;
    
    public Acceso() {
        initComponents();
        this.setTitle("Bienvenida a Sistema de salud");//pone titulo 
        this.setLocationRelativeTo(null);//centra la ventada 
        //ponerle el tamaño a la imagen de acuerdo al tamaño de lbl
        rsscalelabel.RSScaleLabel.setScaleLabel(lblFondo,"src/imagen/FondoLogin.jpg");
        
        //Linea de codigo para ponerle nombre a un JTextfields invisible 
        TextPrompt usuario = new TextPrompt("Nombre de usuario", txtUsuario);
        TextPrompt contraseña = new TextPrompt("Contraseña", txtPPassword);
      
    }

   public void conectarBase(){
    try{ //inicia try
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/bdsalud1","root","hola123");
            stmt=cn.createStatement();//genera sentencias sobre objetos de base de datos
    }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error de base de datos 1: \n"+ ex);
    }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error de base de datos 2:"+ e);
    }
   }//termina metodo conectar
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtPPassword = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, 40));

        txtPPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtPPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(txtPPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 260, 40));

        btnIniciarSesion.setBackground(new java.awt.Color(0, 51, 204));
        btnIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar Sesion ");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 170, 40));

        lblFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPPasswordActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
              try {
            String usuarioAcceso=this.txtUsuario.getText();
            String passAcceso=this.txtPPassword.getText();
            boolean error=true;
            
            conectarBase();
            
           //busqueda de usuario 
           rs=stmt.executeQuery("SELECT * FROM tusuarios");
            
            while (rs.next()==true) {//inicia while
                if (usuarioAcceso.equals(rs.getString("usuario"))&&passAcceso.equals(rs.getString("password"))) {//inicia if 
                    error=false; 
                    JOptionPane.showMessageDialog(null,"Bienvenido a sistema usuario\n\n"+usuarioAcceso);
                    ImcInterfaz ventanaIMC= new ImcInterfaz();//llamada a la ventana o iGU
                    ventanaIMC.setVisible(true);//muestra ventana 
                    this.hide();//oculta ventana anterior
                }//termina if 
                
            }//termina while
            
            if(error==true){
               JOptionPane.showMessageDialog(null,"Error usuario no existe en sistema\nVerifica"+usuarioAcceso);
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error de BD validacion\n\n"+ex);
        }
        
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JPasswordField txtPPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
