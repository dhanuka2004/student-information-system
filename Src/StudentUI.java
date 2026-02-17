StudentManager manager = new StudentManager();
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUI {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Student Information System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        // Create buttons
        JButton addButton = new JButton("Add Student")
        addButton.addActionListener(e -> {
            JTextField idField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField ageField = new JTextField();
            JTextField courseField = new JTextField();

            Object[] formFields = {
                    "ID:", idField,
                    "Name:", nameField,
                    "Age:", ageField,
                    "Course:", courseField
            };

            int result = JOptionPane.showConfirmDialog(frame, formFields,
                    "Add Student", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String id = idField.getText();
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String course = courseField.getText();

                // Add to StudentManager
                manager.addStudent(new Student(id, name, age, course));

                JOptionPane.showMessageDialog(frame, "Student added successfully!");
            }
        });
        ;
        JButton viewButton = new JButton("View Students");
        JButton updateButton = new JButton("Update Student");
        JButton deleteButton = new JButton("Delete Student");
        JButton exitButton = new JButton("Exit");

        // Add buttons to panel
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(exitButton);

        // Add panel to frame
        frame.add(panel);

        // Button actions (for now, just show messages)
        addButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Add Student clicked"));
        viewButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "View Students clicked"));
        updateButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Update Student clicked"));
        deleteButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Delete Student clicked"));
        exitButton.addActionListener(e -> System.exit(0));

        // Show the window
        frame.setVisible(true);
    }
}
