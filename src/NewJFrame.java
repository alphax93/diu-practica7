
import java.awt.Point;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewJFrame extends javax.swing.JFrame {
    private int sumven=0;
    
    public NewJFrame() {
        initComponents();
        escritorio.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        umbralizarItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        openItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openItem.setText("Abrir");
        openItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openItemActionPerformed(evt);
            }
        });
        jMenu1.add(openItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Salir");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        jMenu1.add(exitItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });

        umbralizarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        umbralizarItem.setText("Umbralizar");
        umbralizarItem.setEnabled(false);
        umbralizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralizarItemActionPerformed(evt);
            }
        });
        jMenu2.add(umbralizarItem);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        int res =JOptionPane.showConfirmDialog(rootPane, "¿Seguro que quieres?", "Salir", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_exitItemActionPerformed

    private void umbralizarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralizarItemActionPerformed
        // TODO add your handling code here:
        InternalFrame ventanaU = new InternalFrame();
        while(true){
            try{
                String v =(String) JOptionPane.showInputDialog(rootPane, "Umbral:",
                    "Meter tamaño de umbral",JOptionPane.PLAIN_MESSAGE ,null, null, "0");
                if(v!=null){
                    int i = Integer.parseInt(v);
                    
                    escritorio.add(ventanaU);
                    sumven++;
                    ventanaU.setLocation(new Point(sumven*20,sumven*20));
                    ventanaU.setVisible(true);
                    ventanaU.setImagen(ventana.getPanelImagen1().umbralizar(ventana.getPanelImagen1().getI(), i));
                    ventanaU.setTitle(name + " - Umbral: " + v);
                } 
                break;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(rootPane, "Introduzca un número mayor que cero.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_umbralizarItemActionPerformed

    private void openItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openItemActionPerformed
        // TODO add your handling code here:
        ventana = new InternalFrame();
        
        JFileChooser fc= new JFileChooser(".");
        FileFilter f = new FileNameExtensionFilter("JPG: .jpg,.jpeg,.jpe", "jpg","jpeg","jpe","JPG","JPEG","JPE");
        fc.addChoosableFileFilter(f);
        f = new FileNameExtensionFilter("PNG: .png", "png","PNG");
        fc.addChoosableFileFilter(f);
        f = new FileNameExtensionFilter("BMP: .bmp", "bmp", "BMP");
        fc.addChoosableFileFilter(f);
        fc.setAcceptAllFileFilterUsed(false);
        int res =fc.showOpenDialog(null);
        
        
        JInternalFrame[] ventanaabierta = escritorio.getAllFrames();
        if(ventanaabierta != null){
            for (JInternalFrame jInternalFrame : ventanaabierta) {
            jInternalFrame.dispose();
            }
        }
        if (res == JFileChooser.APPROVE_OPTION) {
            try{
                name=fc.getSelectedFile().getName();
                escritorio.add(ventana);
                ventana.setVisible(true);
                ventana.setTitle(name);
                ventana.setImagen(ImageIO.read(fc.getSelectedFile()));
            }catch(IOException e){
            }
            umbralizarItem.setEnabled(true);
        }
    }//GEN-LAST:event_openItemActionPerformed

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        // TODO add your handling code here:
        if(ventana == null || !ventana.isVisible()  ){
            umbralizarItem.setEnabled(false);
        }
    }//GEN-LAST:event_jMenu2MenuSelected

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
    private InternalFrame ventana;
    private String name;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem openItem;
    private javax.swing.JMenuItem umbralizarItem;
    // End of variables declaration//GEN-END:variables
}
