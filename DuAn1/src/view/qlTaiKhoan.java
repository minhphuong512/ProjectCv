/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.abstractDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.TaiKhoan;
import DAO.userDAO;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import mapper.userMapper;

/**
 *
 * @author Admin
 */
public class qlTaiKhoan extends javax.swing.JInternalFrame {

    userDAO dao = new userDAO();
    int index = 0;
    String TaiKhoan = "";

    /**
     * Creates new form qlbaihat
     */
    public qlTaiKhoan() {
        initComponents();
        tabs.setSelectedIndex(0);
    }

    void FillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbbh.getModel();
        model.setRowCount(0);
        try {
            List<TaiKhoan> list = dao.findAll("select * from USERS");
            for (TaiKhoan x : list) {
                Object[] row = {
                    x.getTaiKhoan(),
                    x.getMatKhau(),
                    x.getTenND(),
                    x.isGioiTinh() ? "nam" : "nữ",
                    x.getEmail(),
                    x.isVaiTro() ?   "ADMIN" : "USER"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clean() {
        txttaikhoan.setBackground(Color.white);
        txtmatkhau.setBackground(Color.white);
        txtten.setBackground(Color.white);
        txtemail.setBackground(Color.white);
        txttaikhoan.setText("");
        txtmatkhau.setText("");
        txtten.setText("");
        txtemail.setText("");
        rdbnam.setSelected(false);
        rdbnu.setSelected(false);
        rdbuser.setSelected(false);
        rdbadmin.setSelected(false);
    }

    void editTable() {
        clean();
        try {
            TaiKhoan = (String) tbbh.getValueAt(this.index, 0);
            TaiKhoan model = dao.findOne("select * from USERS where TaiKhoan = ?", TaiKhoan);
            txttaikhoan.setText(model.getTaiKhoan());
            txtmatkhau.setText(model.getMatKhau());
            txtten.setText(model.getTenND());
            txtemail.setText(model.getEmail());
            if ((model.isGioiTinh() ? "nam" : "nữ").equalsIgnoreCase("nam")) {
                rdbnam.setSelected(true);
            } else {
                rdbnu.setSelected(true);
            }
            if (model.isVaiTro()) {
                rdbuser.setSelected(true);
            } else {
                rdbadmin.setSelected(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateBH() {
        String gt = "", vt = "";
        if (rdbnam.isSelected() == true) {
            gt = "0";
        } else {
            gt = "1";
        }
        if (rdbuser.isSelected() == true) {
            vt = "0";
        } else {
            vt = "1";
        }
        try {
            abstractDAO.update("update USERS set TaiKhoan = ? , MatKhau = ? , Ten = ? ,gioitinh = ?,email = ?,vaitro = ? where TaiKhoan = ?",
                    txttaikhoan.getText(), txtmatkhau.getText(), txtten.getText(), gt, txtemail.getText(), vt, TaiKhoan);
            this.FillToTable();
            JOptionPane.showMessageDialog(this, "sửa thành công");
            tabs.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Không có dữ liệu này");
        }
    }

    void deleteBH() {
        TaiKhoan = txttaikhoan.getText();
        try {
            int mbhx = DAO.abstractDAO.query("select * from USERS where taiKhoan = ?", new userMapper(), TaiKhoan).get(0).getMaND();

            abstractDAO.update("delete USER_ALBUM where MaND = ?", mbhx);
            abstractDAO.update("delete USER_NGHESI where MaND = ?", mbhx);
            abstractDAO.update("delete USER_BAIHAT where MaND = ?", mbhx);
            abstractDAO.update("delete USER_THELOAI where MaND = ?", mbhx);

            abstractDAO.update("delete USERS where MaND = ?", mbhx);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            this.FillToTable();
            this.clean();
            tabs.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Lỗi dữ liệu");
        }

    }

    boolean checkGioiTinh() {
        if (rdbnam.isSelected()== true || rdbnu.isSelected() == true) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Phải chọn giới tính");
            return false;
        }
    }

    boolean checkVaiTro() {
        if (rdbuser.isSelected() == true || rdbadmin.isSelected() == true) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Phải chọn vai trò");
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttaikhoan = new javax.swing.JTextField();
        txtmatkhau = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        rdbnam = new javax.swing.JRadioButton();
        rdbnu = new javax.swing.JRadioButton();
        rdbuser = new javax.swing.JRadioButton();
        rdbadmin = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setEnabled(false);
        setVisible(false);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tabs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbbh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TÀI KHOẢN", "MẬT KHẨU", "TÊN", "GIỚI TÍNH", "EMAIL", "VAI TRÒ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbbh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbh);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );

        tabs.addTab("Danh Sách", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_search_property_35px.png")), jPanel1); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tài Khoản");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mật Khẩu");

        txttaikhoan.setEditable(false);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons8_update_30px.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons8_trash_can_30px.png"))); // NOI18N
        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Giới tính:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Tên");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Vai trò:");

        buttonGroup1.add(rdbnam);
        rdbnam.setText("Nam");

        buttonGroup1.add(rdbnu);
        rdbnu.setText("Nữ");

        buttonGroup2.add(rdbuser);
        rdbuser.setText("USER");

        buttonGroup2.add(rdbadmin);
        rdbadmin.setText("ADMIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdbnam)
                                .addGap(29, 29, 29)
                                .addComponent(rdbnu))
                            .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(18, 18, 18)
                            .addComponent(rdbuser)
                            .addGap(40, 40, 40)
                            .addComponent(rdbadmin)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jButton4)
                .addGap(95, 95, 95)
                .addComponent(jButton5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttaikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(rdbnam)
                    .addComponent(rdbnu)
                    .addComponent(rdbuser)
                    .addComponent(rdbadmin))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4))
                .addGap(79, 79, 79))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_edit_35px_1.png")), jPanel2); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Bài Hát");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbbhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbhMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tbbh.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.editTable();
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tbbhMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        FillToTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        deleteBH();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (untility.utilityCheck.checkNullText(txtten)
                && untility.utilityCheck.checkNullText(txtmatkhau)
                && untility.utilityCheck.checkNullText(txtemail)
                && checkGioiTinh() && checkVaiTro()
                && untility.utilityCheck.checkEmail(txtemail)) {
            updateBH();
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbadmin;
    private javax.swing.JRadioButton rdbnam;
    private javax.swing.JRadioButton rdbnu;
    private javax.swing.JRadioButton rdbuser;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbbh;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmatkhau;
    private javax.swing.JTextField txttaikhoan;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
