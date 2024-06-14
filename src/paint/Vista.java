package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista extends javax.swing.JFrame {

    public Controlador controlador;
    public Modelo modelo;
    public static boolean primerClick;
    int lados;
    Color color;

    public Vista(Modelo modelo) {
        this.modelo = modelo;
        initComponents();
        jTextField1.setText(String.valueOf(jSlider1.getValue()));
        jLabel1.setVisible(false);
        jTextField1.setVisible(false);
        jSlider1.setVisible(false);
        jCheckBox1.setVisible(false);
        lados = 3;
        color = Color.black;
        modelo.eliminarDibujoEstandar();
        modelo.crearDibujo();
        List<String> nombres = modelo.obtenerNombresDibujos();     
        jComboBox2.removeAllItems();
        for (String name : nombres) {
            jComboBox2.addItem(name);
        } 
        
       
    }
    
    public void actualizarListaNombres(){
        List<String> nombres = modelo.obtenerNombresDibujos();     
        jComboBox2.removeAllItems();
        for (String name : nombres) {
            jComboBox2.addItem(name);
        } 
         modelo.eliminarDibujoEstandar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Punto", "Recta", "Circulo", "Poligono Regular", "Poligono Irregular" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(20);
        jSlider1.setMinimum(3);
        jSlider1.setValue(3);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel1.setText("Lados:");

        jTextField1.setText(" ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Relleno");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Color");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Pintar");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Goma");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jButton1.setText("Guardar Dibujo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccionar Dibujo:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setToolTipText("");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("Cargar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Exportar SVG");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jCheckBox3)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton5))
                                .addComponent(jCheckBox1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton1)
                                .addComponent(jLabel2)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox3)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox1)
                        .addGap(57, 57, 57)
                        .addComponent(jButton1)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(65, 65, 65)
                        .addComponent(jButton6)
                        .addGap(0, 58, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedItem().toString().equals("Poligono Regular") || jComboBox1.getSelectedItem().toString().equals("Poligono Irregular")) {
            jLabel1.setVisible(true);
            jTextField1.setVisible(true);
            jSlider1.setVisible(true);
            jCheckBox1.setVisible(true);
        } else {
            jLabel1.setVisible(false);
            jTextField1.setVisible(false);
            jSlider1.setVisible(false);
            jCheckBox1.setVisible(false);
        }
        i = 1;

    }//GEN-LAST:event_jComboBox1ActionPerformed

    //Coordenadas
    int x1, y1, x2, y2;
    int primerX;
    int primerY;
    //Contador de clicks
    int i = 1;

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        String figura = jComboBox1.getSelectedItem().toString();

        switch (figura) {
            case "Punto":
                x1 = evt.getX();
                y1 = evt.getY();
                controlador.dibujarPunto(x1, y1, color);
                // modelo.crearFigura("Punto", x + "," + y);
                break;
            case "Recta":
                if (i == 2) {
                    x2 = evt.getX();
                    y2 = evt.getY();
                    controlador.dibujarRecta(x1, y1, x2, y2, color);
                    i = 1;
                    // modelo.crearFigura("Recta", "50,50,150,150");
                } else {
                    x1 = evt.getX();
                    y1 = evt.getY();
                    i++;
                }
                break;
            case "Circulo":
                if (i == 2) {
                    x2 = evt.getX();
                    y2 = evt.getY();
                    controlador.dibujarCirculo(x1, y1, x2, y2, color);
                    i = 1;
                    // modelo.crearFigura("Circunferencia", x + "," + y + ",100");
                } else {
                    x1 = evt.getX();
                    y1 = evt.getY();
                    i++;
                }

                break;
            case "Poligono Regular":
                if (i == 2) {
                    x2 = evt.getX();
                    y2 = evt.getY();
                    if (jCheckBox1.isSelected()) {
                        controlador.dibujarPoligonoRegularRelleno(x1, y1, x2, y2, lados, color);
                    } else {
                        controlador.dibujarPoligonoRegular(x1, y1, x2, y2, lados, color);
                    }
                    i = 1;
                    // modelo.crearFigura("Poligono Regular", x + "," + y + ",100");
                } else {
                    x1 = evt.getX();
                    y1 = evt.getY();
                    i++;
                }
                break;
            case "Poligono Irregular":

                if (i == (lados + 1)) {
                    if (lados % 2 == 0) {
                        controlador.dibujarRecta(x2, y2, primerX, primerY, color);//recta final, une ultimo con primer punto
                        i = 1;
                    } else {
                        controlador.dibujarRecta(x1, y1, primerX, primerY, color);//recta final, une ultimo con primer punto
                        i = 1;
                    }
                } else {
                    if (i == 1) {
                        primerX = evt.getX();
                        primerY = evt.getY();
                        x1 = evt.getX();
                        y1 = evt.getY();
                        i++;
                    } else {
                        if (i % 2 == 0) {
                            x2 = evt.getX();
                            y2 = evt.getY();
                            controlador.dibujarRecta(x1, y1, x2, y2, color);
                            i++;
                        } else {
                            x1 = evt.getX();
                            y1 = evt.getY();
                            controlador.dibujarRecta(x1, y1, x2, y2, color);
                            i++;
                        }
                    }
                }

                break;
        }


    }//GEN-LAST:event_jPanel1MouseClicked


    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            x1 = evt.getX();
            y1 = evt.getY();
            controlador.dibujarPunto(x1, y1, color);
        }
        if (jCheckBox3.isSelected()) {
            x1 = evt.getX();
            y1 = evt.getY();
            controlador.dibujarPunto(x1, y1, Color.white);
        }

    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jPanel1.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:        
        jTextField1.setText(String.valueOf(jSlider1.getValue()));
        lados = jSlider1.getValue();

    }//GEN-LAST:event_jSlider1StateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        color = JColorChooser.showDialog(null, "Elige un color", color);
        if (color == null) {
            color = Color.BLACK; // Color por defecto si se cancela
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            jCheckBox2.setSelected(false);
        }
        if (jCheckBox2.isSelected() || jCheckBox3.isSelected()) {
            jComboBox1.setEnabled(false);
        } else {
            jComboBox1.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected()) {
            jCheckBox3.setSelected(false);
        }
        if (jCheckBox2.isSelected() || jCheckBox3.isSelected()) {
            jComboBox1.setEnabled(false);
        } else {
            jComboBox1.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        // Crear y mostrar un JDialog
        JDialog dialog = new JDialog(this, "Introducir Nombre", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new BorderLayout());

        // Crear un panel para contener los componentes
        JPanel panel = new JPanel(new GridLayout(4, 4));

        JLabel label = new JLabel("Nombre del dibujo:");
        panel.add(label);

        JTextField textField = new JTextField();
        panel.add(textField);

        dialog.add(panel, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = textField.getText();
                // Aquí puedes manejar el texto ingresado, por ejemplo, pasarlo al modelo
                modelo.modificarNombre(nombre);
                jPanel1.repaint();
                modelo.crearDibujo();
                dialog.dispose();
            }
        });
        dialog.add(okButton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this); // Centrar el diálogo sobre la ventana principal
        dialog.setVisible(true);
          
        actualizarListaNombres();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        modelo.eliminarDibujo(jComboBox2.getSelectedItem().toString());
        actualizarListaNombres();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:        
        
        String nombreDibujo=jComboBox2.getSelectedItem().toString();
        modelo.obtenerIDDibujoBD(jComboBox2.getSelectedItem().toString());        
        controlador.dibujarFigurasBD(nombreDibujo);
        
        actualizarListaNombres();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String nombreDibujo = jComboBox2.getSelectedItem().toString();
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath()+".svg";
            modelo.guardarFigurasEnSVG(nombreDibujo, filePath);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
