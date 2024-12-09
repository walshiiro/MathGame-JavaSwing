package view;

import controller.Controller;
import model.User;
import model.UserList;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.awt.Color.WHITE;

public class LeaderBoardPage extends javax.swing.JPanel {

    private List<User> userList;
    private Image backgroundImage;
    public Controller controller;

    public LeaderBoardPage(Controller controller,List<User> userList) {

        this.userList = userList;
        this.controller = controller;
        initComponents();
        populateTable(); // Thêm dữ liệu vào bảng
        try {
            backgroundImage = ImageIO.read(new File("image/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        // Tạo model cho bảng
        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(
                new Object[][] {}, // Khởi tạo dữ liệu trống
                new String[] { "Name", "Points" } // Tiêu đề các cột
        );
        jTable1.setModel(tableModel); // Gán model cho bảng
        jTable1.setOpaque(false); // Bảng trở nên trong suốt
        jTable1.setBackground(WHITE); // Đặt nền trong suốt
        jTable1.setShowGrid(false); // Ẩn đường kẻ ô
        jTable1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 18)); // Đặt font chữ lớn hơn
        jTable1.setRowHeight(30); // Tăng chiều cao hàng để phù hợp với font
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setOpaque(false); // Làm cho JScrollPane trong suốt
        jScrollPane1.getViewport().setOpaque(false); // Làm cho Viewport trong suốt
        jButton1.setText("Thoát");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.showMenuPage();
            }
        });

        JButton jButtonUpdate = new JButton();
        jButtonUpdate.setText("Cập nhật");
        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức updatePopulateTable với danh sách mới
                List<User> updatedUserList = controller.userList.scoreTable(); // Lấy danh sách mới từ Controller
                updatePopulateTable(updatedUserList); // Cập nhật bảng
            }
        });

        JButton jButtonClear = new JButton();
        jButtonClear.setText("Xoá hết");
        jButtonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTableData(); // Gọi phương thức xoá dữ liệu
            }
        });




        // Thiết lập bố cục
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(124, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(97, 97, 97))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40))))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(41, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))
        );


    }

    /**
     * Phương thức để điền dữ liệu từ UserList vào bảng
     */
    private void populateTable() {
        // Lấy danh sách người dùng



        // Lấy model của bảng
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) jTable1.getModel();

        // Xóa toàn bộ dữ liệu cũ (nếu có)
        tableModel.setRowCount(0);
        // Thêm dữ liệu từ danh sách người dùng
        for (User user : userList) {
            tableModel.addRow(new Object[] { user.getName(), user.getPoints() });
        }
    }
    public void updatePopulateTable(List<User> newUserList) {
        this.userList = newUserList; // Cập nhật danh sách người dùng mới

        // Lấy model của bảng
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) jTable1.getModel();

        // Xóa toàn bộ dữ liệu cũ (nếu có)
        tableModel.setRowCount(0);

        // Thêm dữ liệu mới từ danh sách người dùng
        for (User user : userList) {
            tableModel.addRow(new Object[]{user.getName(), user.getPoints()});
        }

        // Thông báo log (nếu cần)
        System.out.println("Bảng đã được cập nhật với danh sách người dùng mới.");
    }
    private void clearTableData() {
        // Dùng Iterator để tránh ConcurrentModificationException
        java.util.Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equalsIgnoreCase(controller.username)) {
                user.setPoints(0); // Đặt điểm về 0 cho username hiện tại
            } else {
                iterator.remove(); // Xóa các user khác
            }
        }

        // Ghi lại danh sách đã cập nhật vào file để đảm bảo đồng bộ

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("userdata.txt")); // 'true' to append data
                for (User user : userList) {
                    bw.write(user.getName() + "," + user.getPoints());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("Error writing to file: " + e.getMessage());
            }


        // Cập nhật lại bảng hiển thị
        updatePopulateTable(controller.userList.scoreTable());

        // Thông báo cho người dùng
        JOptionPane.showMessageDialog(this, "Dữ liệu đã được làm mới! Điểm của bạn đã được đặt lại về 0.");
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
