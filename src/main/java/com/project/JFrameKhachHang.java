/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project;

import com.project.dao.*;
import com.project.models.KhachHang;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johntoan98gmail.com
 */
public class JFrameKhachHang extends javax.swing.JFrame {

    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    private DonHangDAO donHangDao = new DonHangDAO();
    private VeMayBayDAO veMayBayDAO = new VeMayBayDAO();

    /**
     * Creates new form KhachHang
     */
    public JFrameKhachHang() {
        initComponents();
        loadKhachHangTable();
    }

    private void loadKhachHangTable() {
        try {
            List<com.project.models.KhachHang> khachHangList = khachHangDAO.findAll();
            DefaultTableModel model = (DefaultTableModel) jtb_Khach_Hang.getModel();
            model.setRowCount(0);  // Xóa các dòng cũ
            for (com.project.models.KhachHang kh : khachHangList) {
                model.addRow(new Object[]{kh.getKhachHangID(), kh.getHoTen(), kh.getEmail(), kh.getSoDienThoai(), kh.getNgaySinh(), kh.getDiaChi()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi tải danh sách khách hàng: " + e.getMessage());
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

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Khach_Hang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtf_Ten = new javax.swing.JTextField();
        jtf_Email = new javax.swing.JTextField();
        jtf_sdt = new javax.swing.JTextField();
        jtf_Dia_Chi = new javax.swing.JTextField();
        jtf_Ngay_Sinh = new javax.swing.JTextField();
        jbtn_Create = new javax.swing.JButton();
        jbtn_Edit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jtf_Id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Danh Khách Hàng");

        jtb_Khach_Hang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Họ Tên", "Email", "Sdt", "Ngày Sinh", "Địa Chỉ"
            }
        ));
        jtb_Khach_Hang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtb_Khach_HangFocusGained(evt);
            }
        });
        jtb_Khach_Hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_Khach_HangMouseClicked(evt);
            }
        });
        jtb_Khach_Hang.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jtb_Khach_HangCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jtb_Khach_Hang);

        jLabel1.setText("Họ tên:");

        jLabel2.setText("Email:");

        jLabel3.setText("Số điện thoại:");

        jLabel4.setText("Ngày sinh:");

        jLabel6.setText("Địa chỉ:");

        jbtn_Create.setText("Thêm");
        jbtn_Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_CreateActionPerformed(evt);
            }
        });

        jbtn_Edit.setText("Sửa");
        jbtn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_EditActionPerformed(evt);
            }
        });

        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hủy");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtn_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtn_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(127, 127, 127)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)))
                                .addComponent(jLabel7))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtf_Dia_Chi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtf_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtf_Ngay_Sinh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtf_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtf_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtf_Dia_Chi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtf_Ngay_Sinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_Create)
                    .addComponent(jbtn_Edit)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_Khach_HangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtb_Khach_HangFocusGained

    }//GEN-LAST:event_jtb_Khach_HangFocusGained

    private void jtb_Khach_HangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_Khach_HangMouseClicked
        int selectedRow = jtb_Khach_Hang.getSelectedRow();
        if (selectedRow != -1) {  // Kiểm tra xem có hàng nào được chọn
            String id = jtb_Khach_Hang.getValueAt(selectedRow, 0).toString();
            String email = jtb_Khach_Hang.getValueAt(selectedRow, 2).toString();
            String ten = jtb_Khach_Hang.getValueAt(selectedRow, 1).toString();
            String sdt = jtb_Khach_Hang.getValueAt(selectedRow, 3).toString();
            String diachi = jtb_Khach_Hang.getValueAt(selectedRow, 5).toString();
            String ngaysinh = jtb_Khach_Hang.getValueAt(selectedRow, 4).toString();
            jtf_Dia_Chi.setText(diachi);
            jtf_Id.setText(id);
            jtf_Email.setText(email);
            jtf_Ngay_Sinh.setText(ngaysinh);
            jtf_Ten.setText(ten);
            jtf_sdt.setText(sdt);
        }
    }//GEN-LAST:event_jtb_Khach_HangMouseClicked

    private void jtb_Khach_HangCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtb_Khach_HangCaretPositionChanged

    }//GEN-LAST:event_jtb_Khach_HangCaretPositionChanged

    private void jbtn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_EditActionPerformed
         try {
        // Kiểm tra các trường không được để trống
        if (jtf_Id.getText().isEmpty() || jtf_Ten.getText().isEmpty() || jtf_Email.getText().isEmpty()
                || jtf_sdt.getText().isEmpty() || jtf_Dia_Chi.getText().isEmpty() || jtf_Ngay_Sinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }

        // Lấy dữ liệu từ các trường nhập
        int id = Integer.parseInt(jtf_Id.getText());
        String hoTen = jtf_Ten.getText();
        String email = jtf_Email.getText();
        String sdt = jtf_sdt.getText();
        String diaChi = jtf_Dia_Chi.getText();
        LocalDate ngaySinh = LocalDate.parse(jtf_Ngay_Sinh.getText());

        // Kiểm tra ID tồn tại
        if (khachHangDAO.findById(id) == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng với ID đã nhập!");
            return;
        }

        // Cập nhật thông tin khách hàng
        KhachHang khachHang = new KhachHang(id, hoTen, sdt, email, diaChi, ngaySinh);
        khachHangDAO.update(khachHang);

        JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
        // Refresh lại bảng hoặc cập nhật danh sách nếu cần thiết
        loadKhachHangTable();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật khách hàng.");
    }
    }//GEN-LAST:event_jbtn_EditActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        JFrameDatVe jFrameDatVe = new JFrameDatVe();
         jFrameDatVe.setLocationRelativeTo(null);
        jFrameDatVe.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
        int selectedRow = jtb_Khach_Hang.getSelectedRow();
        if (selectedRow != -1) {  // Kiểm tra xem có hàng nào được chọn
            int id = Integer.parseInt(jtb_Khach_Hang.getValueAt(selectedRow, 0).toString());

            // Hiển thị hộp thoại xác nhận
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc chắn muốn xóa khách hàng này?",
                    "Xác nhận xóa",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                // Thực hiện thao tác xóa nếu người dùng chọn "Yes"
                donHangDao.deleteDonHangByKhachHangID(id);
                veMayBayDAO.deleteVeByKhach(id);
                khachHangDAO.deleteById(id);
                JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công ");
                loadKhachHangTable();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một khách hàng để xóa.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi xóa khách hàng.");
    }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtn_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_CreateActionPerformed
         try {
        // Kiểm tra các trường không được để trống
        if (jtf_Id.getText().isEmpty() || jtf_Ten.getText().isEmpty() || jtf_Email.getText().isEmpty()
                || jtf_sdt.getText().isEmpty() || jtf_Dia_Chi.getText().isEmpty() || jtf_Ngay_Sinh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        
        // Lấy dữ liệu từ các trường nhập
        int id = Integer.parseInt(jtf_Id.getText());
        String hoTen = jtf_Ten.getText();
        String email = jtf_Email.getText();
        String sdt = jtf_sdt.getText();
        String diaChi = jtf_Dia_Chi.getText();
        LocalDate ngaySinh = LocalDate.parse(jtf_Ngay_Sinh.getText());  // Đảm bảo đúng định dạng

        // Kiểm tra trùng ID
        if (khachHangDAO.findById(id) != null) {
            JOptionPane.showMessageDialog(this, "ID khách hàng đã tồn tại!");
            return;
        }

        // Tạo đối tượng khách hàng mới
        KhachHang khachHang = new KhachHang(id, hoTen, sdt, email, diaChi, ngaySinh);

        // Thêm khách hàng vào cơ sở dữ liệu
        khachHangDAO.save(khachHang);

        JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
        // Refresh lại bảng hoặc cập nhật danh sách nếu cần thiết
        loadKhachHangTable();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi thêm khách hàng.");
    }
    }//GEN-LAST:event_jbtn_CreateActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_Create;
    private javax.swing.JButton jbtn_Edit;
    private javax.swing.JTable jtb_Khach_Hang;
    private javax.swing.JTextField jtf_Dia_Chi;
    private javax.swing.JTextField jtf_Email;
    private javax.swing.JTextField jtf_Id;
    private javax.swing.JTextField jtf_Ngay_Sinh;
    private javax.swing.JTextField jtf_Ten;
    private javax.swing.JTextField jtf_sdt;
    // End of variables declaration//GEN-END:variables
}
