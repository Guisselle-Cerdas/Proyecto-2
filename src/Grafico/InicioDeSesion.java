/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Controladores.ControladorExpedientes;
import Controladores.ControladorUsuarios;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author johan
 */
public class InicioDeSesion extends javax.swing.JInternalFrame {

    private ControladorExpedientes exp;
    private ControladorUsuarios cUsuario;
    public JDateChooser getjDateChooser1() {
        return jDateChooser1;
    }

    public void setjDateChooser1(JDateChooser jDateChooser1) {
        this.jDateChooser1 = jDateChooser1;
    }

    public JPasswordField getContraseña() {
        return contraseña;
    }

    public void setContraseña(JPasswordField contraseña) {
        this.contraseña = contraseña;
    }

   

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    /**
     * Creates new form InicioDeSesion
     */
    public InicioDeSesion() {
         initComponents();
        exp = new ControladorExpedientes();
        cUsuario = new ControladorUsuarios();
        this.getContentPane().setBackground(new Color(85, 151, 248));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnInicioSesion = new javax.swing.JButton();
        contraseña = new javax.swing.JPasswordField();

        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        jDateChooser1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de atencion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });

        contraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtUsuario)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btnInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contraseña))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed
       if (cUsuario.iniciarSesion(this) == true) {
            JOptionPane.showMessageDialog(null, "Se inicio sesión");
            ExpedienteSencillo expendie = new ExpedienteSencillo();
            FrmPrincipal.escritorio.add(expendie);
            expendie.show();
            exp.cargarMedico(this, expendie);
            exp.buscarFecha(this, expendie);
            Date fecha = new Date(this.jDateChooser1.getDate().getTime());
            SimpleDateFormat fechas = new SimpleDateFormat("dd/MM/yyyy");
            expendie.setTxtFechaAtencion(String.valueOf(fechas.format(fecha)));
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se puede iniciar sesión");
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicioSesion;
    private javax.swing.JPasswordField contraseña;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
