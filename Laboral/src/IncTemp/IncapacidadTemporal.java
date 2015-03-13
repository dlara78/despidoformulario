/*
 * Copyright (C) 2015 david
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package IncTemp;

import MetodosComunes.Principal;

public class IncapacidadTemporal extends javax.swing.JFrame {

    public IncapacidadTemporal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateFechaBajaIT = new com.toedter.calendar.JDateChooser();
        dateFechaAltaIT = new com.toedter.calendar.JDateChooser();
        btnCalcularIT = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textBaseDiaria = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcmbConvenio = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        labelTramoUno = new javax.swing.JLabel();
        labelTramoDos = new javax.swing.JLabel();
        labelTramoTres = new javax.swing.JLabel();
        labelTramoCuatro = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelDiasTramo1 = new javax.swing.JLabel();
        labelEurosTramo1 = new javax.swing.JLabel();
        labelComplTramo1 = new javax.swing.JLabel();
        labelDiasTramo2 = new javax.swing.JLabel();
        labelEurosTramo2 = new javax.swing.JLabel();
        labelComplTramo2 = new javax.swing.JLabel();
        labelDiasTramo3 = new javax.swing.JLabel();
        labelEurosTramo3 = new javax.swing.JLabel();
        labelComplTramo3 = new javax.swing.JLabel();
        labelDiasTramo4 = new javax.swing.JLabel();
        labelEurosTramo4 = new javax.swing.JLabel();
        labelComplTramo4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelDiasTotal = new javax.swing.JLabel();
        labelEurosTotal = new javax.swing.JLabel();
        labelComplTotal = new javax.swing.JLabel();
        btnSalirIT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtControl = new javax.swing.JTextField();

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TRAMOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Fecha de baja IT");

        jLabel2.setText("Fecha de alta IT");

        dateFechaBajaIT.setDateFormatString("dd/MM/yyyy");

        dateFechaAltaIT.setDateFormatString("dd/MM/yyyy");

        btnCalcularIT.setText("CALCULAR");
        btnCalcularIT.setBorder(null);
        btnCalcularIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularITActionPerformed(evt);
            }
        });

        jLabel3.setText("Base diaria");

        textBaseDiaria.setText("30");
        textBaseDiaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBaseDiariaActionPerformed(evt);
            }
        });

        jLabel4.setText("Convenio");

        jcmbConvenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estatuto de los trabajadores", "Complemento al 100%", "Pte 3", "Pte 4" }));
        jcmbConvenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbConvenioActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTramoUno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTramoUno.setText("1er tramo (1 a 3)");
        labelTramoUno.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTramoDos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTramoDos.setText("2o tramo (4 a 15)");
        labelTramoDos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTramoTres.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTramoTres.setText("3er tramo (16 a 20)");
        labelTramoTres.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTramoCuatro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTramoCuatro.setText("4o tramo (21 a ...)");
        labelTramoCuatro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TRAMOS");

        labelDiasTramo1.setBackground(new java.awt.Color(255, 255, 255));
        labelDiasTramo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDiasTramo1.setText("0");
        labelDiasTramo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEurosTramo1.setBackground(new java.awt.Color(255, 255, 255));
        labelEurosTramo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEurosTramo1.setText("0");
        labelEurosTramo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelComplTramo1.setBackground(new java.awt.Color(255, 255, 255));
        labelComplTramo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplTramo1.setText("0");
        labelComplTramo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelDiasTramo2.setBackground(new java.awt.Color(255, 255, 255));
        labelDiasTramo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDiasTramo2.setText("0");
        labelDiasTramo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEurosTramo2.setBackground(new java.awt.Color(255, 255, 255));
        labelEurosTramo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEurosTramo2.setText("0");
        labelEurosTramo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelComplTramo2.setBackground(new java.awt.Color(255, 255, 255));
        labelComplTramo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplTramo2.setText("0");
        labelComplTramo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelDiasTramo3.setBackground(new java.awt.Color(255, 255, 255));
        labelDiasTramo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDiasTramo3.setText("0");
        labelDiasTramo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEurosTramo3.setBackground(new java.awt.Color(255, 255, 255));
        labelEurosTramo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEurosTramo3.setText("0");
        labelEurosTramo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelComplTramo3.setBackground(new java.awt.Color(255, 255, 255));
        labelComplTramo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplTramo3.setText("0");
        labelComplTramo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelDiasTramo4.setBackground(new java.awt.Color(255, 255, 255));
        labelDiasTramo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDiasTramo4.setText("0");
        labelDiasTramo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEurosTramo4.setBackground(new java.awt.Color(255, 255, 255));
        labelEurosTramo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEurosTramo4.setText("0");
        labelEurosTramo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelComplTramo4.setBackground(new java.awt.Color(255, 255, 255));
        labelComplTramo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplTramo4.setText("0");
        labelComplTramo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DIAS");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("EUROS");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("COMPL.");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TOTAL");

        labelDiasTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDiasTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelEurosTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEurosTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelComplTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComplTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelTramoDos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTramoUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTramoTres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTramoCuatro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelDiasTramo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelEurosTramo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelComplTramo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelDiasTramo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelEurosTramo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelComplTramo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelDiasTramo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelEurosTramo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelComplTramo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelDiasTramo4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelEurosTramo4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelDiasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelEurosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelComplTramo4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelComplTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTramoUno)
                    .addComponent(labelDiasTramo1)
                    .addComponent(labelEurosTramo1)
                    .addComponent(labelComplTramo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTramoDos)
                    .addComponent(labelDiasTramo2)
                    .addComponent(labelEurosTramo2)
                    .addComponent(labelComplTramo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTramoTres, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTramoCuatro)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDiasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelEurosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelComplTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelEurosTramo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDiasTramo3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelComplTramo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDiasTramo4)
                            .addComponent(labelEurosTramo4)
                            .addComponent(labelComplTramo4))))
                .addGap(39, 39, 39))
        );

        btnSalirIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsets/icon_salir.png"))); // NOI18N
        btnSalirIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirITActionPerformed(evt);
            }
        });

        jButton1.setText("LIMPIAR");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtControl.setText("jTextField1");
        txtControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtControlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jcmbConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textBaseDiaria, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateFechaAltaIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(dateFechaBajaIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtControl, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCalcularIT, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalirIT)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCalcularIT, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalirIT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dateFechaBajaIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(dateFechaAltaIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textBaseDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcmbConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(txtControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirITActionPerformed
        this.dispose();
        Principal mostrar = new Principal();
        mostrar.setVisible(true);      
    }//GEN-LAST:event_btnSalirITActionPerformed

    private void jcmbConvenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbConvenioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcmbConvenioActionPerformed

    private void btnCalcularITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularITActionPerformed

   MetodosIT proceso1 = new MetodosIT();
   proceso1.calculaIncTmp(this.dateFechaBajaIT, this.dateFechaAltaIT, this.textBaseDiaria, this.jcmbConvenio);
   
   this.txtControl.setText(proceso1.normaAplicable);
   
   this.labelDiasTramo1.setText(String.valueOf(proceso1.diasTramo1));
   this.labelDiasTramo2.setText(String.valueOf(proceso1.diasTramo2));
   this.labelDiasTramo3.setText(String.valueOf(proceso1.diasTramo3));
   this.labelDiasTramo4.setText(String.valueOf(proceso1.diasTramo4));
   
   this.labelEurosTramo1.setText(MetodosComunes.MetodosFormatos.darFormatoMoneda(proceso1.eurosTramo1));
   this.labelEurosTramo2.setText(MetodosComunes.MetodosFormatos.darFormatoMoneda(proceso1.eurosTramo2));
   this.labelEurosTramo3.setText(MetodosComunes.MetodosFormatos.darFormatoMoneda(proceso1.eurosTramo3));
   this.labelEurosTramo4.setText(MetodosComunes.MetodosFormatos.darFormatoMoneda(proceso1.eurosTramo4));
    
   //this.labelEurosTramo4.setText(String.valueOf(proceso1.eurosTramo4));
   
   this.labelDiasTotal.setText(String.valueOf(proceso1.numDiasIT));
   this.labelEurosTotal.setText(String.valueOf(proceso1.eurosTramo1 + proceso1.eurosTramo2 + proceso1.eurosTramo3 + proceso1.eurosTramo4));
      
    }//GEN-LAST:event_btnCalcularITActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textBaseDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBaseDiariaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBaseDiariaActionPerformed

    private void txtControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtControlActionPerformed

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
            java.util.logging.Logger.getLogger(IncapacidadTemporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IncapacidadTemporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IncapacidadTemporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IncapacidadTemporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IncapacidadTemporal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularIT;
    private javax.swing.JButton btnSalirIT;
    private com.toedter.calendar.JDateChooser dateFechaAltaIT;
    private com.toedter.calendar.JDateChooser dateFechaBajaIT;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox jcmbConvenio;
    private javax.swing.JLabel labelComplTotal;
    private javax.swing.JLabel labelComplTramo1;
    private javax.swing.JLabel labelComplTramo2;
    private javax.swing.JLabel labelComplTramo3;
    private javax.swing.JLabel labelComplTramo4;
    private javax.swing.JLabel labelDiasTotal;
    private javax.swing.JLabel labelDiasTramo1;
    private javax.swing.JLabel labelDiasTramo2;
    private javax.swing.JLabel labelDiasTramo3;
    private javax.swing.JLabel labelDiasTramo4;
    private javax.swing.JLabel labelEurosTotal;
    private javax.swing.JLabel labelEurosTramo1;
    private javax.swing.JLabel labelEurosTramo2;
    private javax.swing.JLabel labelEurosTramo3;
    private javax.swing.JLabel labelEurosTramo4;
    private javax.swing.JLabel labelTramoCuatro;
    private javax.swing.JLabel labelTramoDos;
    private javax.swing.JLabel labelTramoTres;
    private javax.swing.JLabel labelTramoUno;
    private javax.swing.JTextField textBaseDiaria;
    private javax.swing.JTextField txtControl;
    // End of variables declaration//GEN-END:variables
}
