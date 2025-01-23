package shadowfox_intern_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInformationSystemSwing {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Information System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Table to display student records
        String[] columnNames = {"Name", "Age", "Course"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel courseLabel = new JLabel("Course:");
        JTextField courseField = new JTextField();

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete Selected");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageField);
        inputPanel.add(courseLabel);
        inputPanel.add(courseField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Add student event
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String ageText = ageField.getText();
                String course = courseField.getText();

                try {
                    int age = Integer.parseInt(ageText);

                    if (name.isEmpty() || course.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Name and Course cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        tableModel.addRow(new Object[]{name, age, course});
                        nameField.setText("");
                        ageField.setText("");
                        courseField.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Delete selected student event
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a student to delete.", "Delete Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add components to frame
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        // Set frame visibility
        frame.setVisible(true);
    }
}
