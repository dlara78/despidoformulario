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
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IncapacidadTemporal extends javax.swing.JFrame {

int numDiasIT;
float baseDiaria;
int diasTramo1 = 0;
int diasTramo2 = 0;
int diasTramo3 = 0;
int diasTramo4 = 0;

float eurosTramo1 = 0;
float eurosTramo2 = 0;
float eurosTramo3 = 0;
float eurosTramo4 = 0;

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
        jComboBox1 = new javax.swing.JComboBox();
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

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TRAMOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Fecha de baja IT");

        jLabel2.setText("Fecha de alta IT");

        dateFechaBajaIT.setDateFormatString("dd/MM/yyyy");

        dateFechaAltaIT.setDateFormatString("dd/MM/yyyy");

        btnCalcularIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconsets/icon_calcular.png"))); // NOI18N
        btnCalcularIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularITActionPerformed(evt);
            }
        });

        jLabel3.setText("Base diaria");

        jLabel4.setText("Convenio");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estatuto de los trabajadores", "Pte 2", "Pte 3", "Pte 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTramoDos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTramoUno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTramoTres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTramoCuatro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(272, 272, 272))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDiasTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEurosTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelComplTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateFechaAltaIT, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(dateFechaBajaIT, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(textBaseDiaria)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCalcularIT, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(btnSalirIT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(textBaseDiaria)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCalcularIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalirIT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirITActionPerformed
        this.dispose();
        Principal mostrar = new Principal();
        mostrar.setVisible(true);      
    }//GEN-LAST:event_btnSalirITActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnCalcularITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularITActionPerformed

        this.numDiasIT = 0;
        this.baseDiaria = 0;
        this.diasTramo1 = 0;
        this.diasTramo2 = 0;
        this.diasTramo3 = 0;
        this.diasTramo4 = 0;
        
        this.eurosTramo1 = 0;
        this.eurosTramo2 = 0;
        this.eurosTramo3 = 0;
        this.eurosTramo4 = 0;
        
        GregorianCalendar fBajaMedica;
        GregorianCalendar fAltaMedica;
        fBajaMedica = new GregorianCalendar();
        fBajaMedica.setTime(dateFechaBajaIT.getDate());
        
        this.baseDiaria = Float.parseFloat(this.textBaseDiaria.getText());


        fAltaMedica = new GregorianCalendar();
        fAltaMedica.set(
                dateFechaAltaIT.getCalendar().get(Calendar.YEAR),
                dateFechaAltaIT.getCalendar().get(Calendar.MONTH),
                dateFechaAltaIT.getCalendar().get(Calendar.DAY_OF_MONTH), 23, 59, 59);

        // int valorRedondeado = Math.round(valorFloat);
        this.numDiasIT = Math.round(MetodosComunes.MetodosFechas.diferenciaDosGregorian(fBajaMedica, fAltaMedica));
        
        if (this.numDiasIT <= 3){
            this.diasTramo1 = this.numDiasIT;
        } else if (this.numDiasIT > 3 && this.numDiasIT <= 15) {
            this.diasTramo1 = 3;
            this.diasTramo2 = this.numDiasIT - this.diasTramo1;
        
        } else if (this.numDiasIT > 15 && this.numDiasIT <= 20){
            this.diasTramo1 = 3;
            this.diasTramo2 = 12;
            this.diasTramo3 = this.numDiasIT - this.diasTramo1 - this.diasTramo2;
            
        } else {
            this.diasTramo1 = 3;
            this.diasTramo2 = 12;
            this.diasTramo3 = 5;
            this.diasTramo4 = this.numDiasIT - this.diasTramo1 - this.diasTramo2 - this.diasTramo3 - this.diasTramo4;
        }
        
        this.labelDiasTramo1.setText(String.valueOf(this.diasTramo1));
        this.labelDiasTramo2.setText(String.valueOf(this.diasTramo2));
        this.labelDiasTramo3.setText(String.valueOf(this.diasTramo3));
        this.labelDiasTramo4.setText(String.valueOf(this.diasTramo4));
        
        this.eurosTramo1 = this.diasTramo1 * this.baseDiaria;
        this.eurosTramo2 = this.diasTramo2 * this.baseDiaria;
        this.eurosTramo3 = this.diasTramo3 * this.baseDiaria;
        this.eurosTramo4 = this.diasTramo4 * this.baseDiaria;
                        
        this.labelEurosTramo1.setText(String.valueOf(this.eurosTramo1));
        this.labelEurosTramo2.setText(String.valueOf(this.eurosTramo2));
        this.labelEurosTramo3.setText(String.valueOf(this.eurosTramo3));
        this.labelEurosTramo4.setText(String.valueOf(this.eurosTramo4));
        
        this.labelDiasTotal.setText(String.valueOf(this.numDiasIT));
        this.labelEurosTotal.setText(String.valueOf(this.eurosTramo1 + this.eurosTramo2 + this.eurosTramo3 + this.eurosTramo4));
        
        
        
    }//GEN-LAST:event_btnCalcularITActionPerformed

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
    private javax.swing.JComboBox jComboBox1;
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
    // End of variables declaration//GEN-END:variables
}
