/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import pojos.Estudiante;

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

public class ListasEstudiantes extends javax.swing.JFrame {

     //clases de conexion y sus objetos
    public Connection cn;
    public Statement stmt;
    public ResultSet rs;
    
    Estudiante objetoEstudiante = new Estudiante();//objeto libro generado
    
    public ListasEstudiantes() {
        initComponents();
        
         //ponerle el tamaño a la imagen de acuerdo al tamaño de lbl
        rsscalelabel.RSScaleLabel.setScaleLabel(lblFondo,"src/imagen/fondoRegistro.jpg");
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
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultaEstudiantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnConsultarEstudiantes = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtConsultaEstudiantes.setForeground(new java.awt.Color(255, 0, 0));
        jtConsultaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estudiante", "Nombre", "Sexo", "Edad", "Altura", "Peso", "IMC", "Estado de salud ", "Actividad Fisica", "Recomendacion "
            }
        ));
        jScrollPane1.setViewportView(jtConsultaEstudiantes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, 1200, 280));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Estudiantes Registrados ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, -1));

        btnConsultarEstudiantes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultarEstudiantes.setForeground(new java.awt.Color(255, 51, 51));
        btnConsultarEstudiantes.setText("Actualizar lista de estudiantes ");
        btnConsultarEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarEstudiantesActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 440, -1, -1));

        lblFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnConsultarEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEstudiantesActionPerformed
   try {
            conectarBase();//llamada a metodo conectar 
            //almacenamiento logico de datos modelo de datos
            DefaultTableModel modeloDatos = new DefaultTableModel();
            jtConsultaEstudiantes.setModel(modeloDatos);
            rs=stmt.executeQuery("select * from testudiante");
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas =rsmd.getColumnCount();
            modeloDatos.addColumn("ID Estudiante");
            modeloDatos.addColumn("Nombre");
            modeloDatos.addColumn("Sexo");
            modeloDatos.addColumn("Edad");
            modeloDatos.addColumn("Altura");
            modeloDatos.addColumn("Peso");
            modeloDatos.addColumn("IMC");
            modeloDatos.addColumn("Estado de salud ");
            modeloDatos.addColumn("Actividad Fisica");
            modeloDatos.addColumn("Recomendacion");
            
            //imprimir registros 
            while(rs.next()){
              Object fila [] = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }//termina for 
                modeloDatos.addRow(fila);
            }//termina while
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Error de BD consulta"+ ex);
        }
    }//GEN-LAST:event_btnConsultarEstudiantesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(ListasEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListasEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListasEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListasEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListasEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarEstudiantes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtConsultaEstudiantes;
    private javax.swing.JLabel lblFondo;
    // End of variables declaration//GEN-END:variables
}
