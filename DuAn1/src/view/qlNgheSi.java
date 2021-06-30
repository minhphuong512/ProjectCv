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
import dao.NgheSiDAO;
import java.awt.Color;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import static java.lang.Thread.sleep;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mapper.NgheSiMapper;
import model.NgheSi;
import untility.accout;

/**
 *
 * @author Admin
 */
public class qlNgheSi extends javax.swing.JInternalFrame {

    NgheSiDAO nsdao = new NgheSiDAO();
    int index = 0;
    String TenNS = "";
    String TenTaiKhoan = accout.acc.getTenND();

    /**
     * Creates new form qlbaihat
     */
    public qlNgheSi() {
        initComponents();
        tabs.setSelectedIndex(0);
    }

    void FillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbns.getModel();
        model.setRowCount(0);
        try {
            List<NgheSi> list = nsdao.findAll("select * from NGHESI");
            for (NgheSi x : list) {
                Object[] row = {
                    x.getTenNS(),
                    x.getNgayTao(),
                    x.getNguoiTao(),
                    x.getMota()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clean() {
        txttenns.setBackground(Color.white);
        txtngaytao.setBackground(Color.white);
        txtnguoitao.setBackground(Color.white);
        txtmota.setBackground(Color.white);
        txttenns.setText("");
        txtngaytao.setText("");
        txtnguoitao.setText("");
        txtmota.setText("");
    }

    void editTable() {
        clean();
        try {
            TenNS = (String) tbns.getValueAt(this.index, 0);
            NgheSi model = nsdao.findOne("select * from NGHESI where ten = ?", TenNS);
            txttenns.setText(model.getTenNS());
            txtngaytao.setText(String.valueOf(model.getNgayTao()));
            txtnguoitao.setText(model.getNguoiTao());
            txtmota.setText(model.getMota());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addNS() {
        NgheSi model = getModel();
        try {
            abstractDAO.update("insert into NGHESI(ten,NgayTao,NguoiTao,Mota)VALUES(?,GETDATE(),?,?)",
                    txttenns.getText(), TenTaiKhoan, txtmota.getText());
            this.FillToTable();
            this.clean();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e) {
            System.out.println("Exception in addNS");
        }
    }

    void updateNS() {
        try {
            abstractDAO.update("update NGHESI set ten = ?,NgayTao = GETDATE() ,NguoiTao = ?,Mota = ? where ten = ?",
                    txttenns.getText(), TenTaiKhoan, txtmota.getText(), TenNS);
            this.FillToTable();
            JOptionPane.showMessageDialog(this, "sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteNS() {
        try {
            int mans = DAO.abstractDAO.query("select * from NGHESI where ten = ?", new NgheSiMapper(), txttenns.getText()).get(0).getMaNS();
            abstractDAO.update("delete USER_NGHESI where MaNS = ?", mans);
            abstractDAO.update("delete BAIHAT_NGHESI where MaNS = ?", mans);
            abstractDAO.update("delete NGHESI where MaNS = ?", mans);
            this.FillToTable();
            this.clean();
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            tabs.setSelectedIndex(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Lỗi dữ liệu");
        }

    }

    void setModel(NgheSi model) {
        txttenns.setText(model.getTenNS());
        txtngaytao.setText(String.valueOf(model.getNgayTao()));
        txtmota.setText(model.getMota());
        txtnguoitao.setText(model.getNguoiTao());

    }

    NgheSi getModel() {
        NgheSi ns = new NgheSi();
        ns.setTenNS(txttenns.getText());
        ns.setMota(txtmota.getText());
        ns.setNguoiTao(txtnguoitao.getText());
        return ns;
    }

    public boolean checkTrung(JTextField txt) {
        txt.setBackground(white);
        if (nsdao.findAll("select * from NGHESI where ten like N'?'", txttenns.getText()) == null) {
            return true;
        } else {
            txt.setBackground(pink);
            JOptionPane.showMessageDialog(this, txt.getText() + " đã bị tồn tại.");
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

        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbns = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttenns = new javax.swing.JTextField();
        txtnguoitao = new javax.swing.JTextField();
        txtngaytao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtmota = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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

        tbns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "TÊN NGHỆ SĨ", "NGÀY TẠO", "NGƯỜI TẠO", "MÔ TẢ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbns);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        tabs.addTab("Danh Sách", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_search_property_35px.png")), jPanel1); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên Nghệ Sĩ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Tạo");

        txtnguoitao.setEditable(false);

        txtngaytao.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Người Tạo");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/icons8_joyent_30px.png"))); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mô tả");

        txtmota.setColumns(20);
        txtmota.setRows(5);
        jScrollPane2.setViewportView(txtmota);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/broom_30px.png"))); // NOI18N
        jButton6.setText("Mới");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttenns, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtnguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jButton3)
                        .addGap(35, 35, 35)
                        .addComponent(jButton4)
                        .addGap(34, 34, 34)
                        .addComponent(jButton5)
                        .addGap(35, 35, 35)
                        .addComponent(jButton6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(354, 354, 354)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnguoitao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttenns, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton3)
                    .addComponent(jButton6)))
        );

        tabs.addTab("Cập nhật", new javax.swing.ImageIcon(getClass().getResource("/data/icons8_edit_35px_1.png")), jPanel2); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nghệ Sĩ");
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
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (untility.utilityCheck.checkNullText(txttenns)
                && untility.utilityCheck.checkNullText(txtmota)
                && checkTrung(txttenns)) {
            addNS();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnsMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.index = tbns.rowAtPoint(evt.getPoint()); //lấy vị trí dòng được chọn
            if (this.index >= 0) {
                this.editTable();
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tbnsMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (untility.utilityCheck.checkNullText(txttenns)
                && untility.utilityCheck.checkNullText(txtmota)
                && checkTrung(txttenns)) {
            updateNS();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        deleteNS();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        FillToTable();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        clean();
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbns;
    private javax.swing.JTextArea txtmota;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtnguoitao;
    private javax.swing.JTextField txttenns;
    // End of variables declaration//GEN-END:variables
}
