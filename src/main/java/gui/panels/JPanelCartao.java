/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.panels;

import controle.BancoControle;
import controle.CartaoControle;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import gui.jdialog.JDialogBancoAlterar;
import gui.jdialog.JDialogCartao;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;
import jiconfont.icons.font_awesome.FontAwesome;
import modelos.entidades.Banco;
import modelos.entidades.Cartao;
import util.TelaUtils;

/**
 *
 * @author galdi
 */
public class JPanelCartao extends javax.swing.JPanel {
    
    private CartaoControle cartaoControle;
    private DefaultTableModel model;
    private JFrame parent;
    
    public JPanelCartao(JFrame parent) throws Exception {
        cartaoControle = new CartaoControle();
        this.parent = parent;
        initComponents();
        model = (DefaultTableModel) jTable.getModel();
        TableColumnModel tcm = (DefaultTableColumnModel) jTable.getColumnModel();
        tcm.removeColumn(tcm.getColumn(8));
        mostrarListagem();
    }

    private void mostrarListagem() {
        try {
            ArrayList<Cartao> cartoes = cartaoControle.listagem();
            model = (DefaultTableModel) jTable.getModel();
            model.setNumRows(0);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            for (int i = 0; i < cartoes.size(); i++) {
                String[] saida = new String[9];
                Cartao aux = cartoes.get(i);
                saida[0] = Integer.toString(aux.getNumero());
                saida[1] = aux.getBandeira();
                saida[2] = sdf.format(aux.getValidade());
                saida[3] = Float.toString(aux.getLimite());
                saida[4] = Integer.toString(aux.getMulta());
                saida[5] = sdf.format(aux.getVencimento());
                saida[6] = aux.getNome();
                saida[7] = sdf.format(aux.getFechamento());
                saida[8] = Integer.toString(aux.getId());
                model.addRow(saida);
            } 
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonNovoBanco = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jMenuItemEditar.setText("Editar Banco");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemEditar);

        jMenuItemExcluir.setText("Excluir Banco");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItemExcluir);

        jScrollPane2.setViewportView(jEditorPane1);

        setPreferredSize(new java.awt.Dimension(1041, 719));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><center>Cart�o<center></html>");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N�mero", "Bandeira", "Validade", "Limite", "Multa", "Fatura Vencimento", "Nome", "Fatura Fechamento", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.setRowHeight(35);
        jTable.setShowHorizontalLines(true);
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButtonNovoBanco.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButtonNovoBanco.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.PLUS, 16)
        );
        jButtonNovoBanco.setText("Cadastrar Cart�o");
        jButtonNovoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoBancoActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setText("Pesquisar Cart�o");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setIcon(TelaUtils.getIconFontAwesome(FontAwesome.SEARCH, 16));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(48, 26));
        jButton1.setMinimumSize(new java.awt.Dimension(48, 26));
        jButton1.setPreferredSize(new java.awt.Dimension(48, 26));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGap(348, 348, 348))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonNovoBanco))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jButtonNovoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoBancoActionPerformed
        try {
            JDialogCartao addCard = new JDialogCartao(parent, true);
            addCard.setVisible(true);
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonNovoBancoActionPerformed

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
          try {
            cartaoControle.apagarPorId(Integer.parseInt(model.getValueAt(jTable.getSelectedRow(), 8).toString()));
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    private void jTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseReleased
        if (evt.isPopupTrigger() && jTable.isFocusOwner()) {
            jPopupMenu2.show(jTable,evt.getX(),evt.getY());
        }

    }//GEN-LAST:event_jTableMouseReleased

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        try {
            JDialogBancoAlterar addBanco = new JDialogBancoAlterar(parent, true, jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            addBanco.setVisible(true);
            mostrarListagem();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int id = Integer.parseInt(jTextField1.getText());
            BancoControle aux = new BancoControle();
            Banco auxBanco = aux.consultarPorID(id);
            
            if (auxBanco == null) {
                throw new Exception("Banco n�o existe!");
            }
            
            JOptionPane.showMessageDialog(this, "ID: " + auxBanco.getId() + " = " + auxBanco.getDescricao(), "Banco Encontrado!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonNovoBanco;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
