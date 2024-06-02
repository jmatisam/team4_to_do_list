package team4_f5bosco.to_do_list;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.springframework.web.servlet.tags.form.FormTag;

public class ToDoListApplication extends JFrame {
    private static ArrayList<AddTask> tasks = new ArrayList<>();
    private static JFrame mainFrame;
    private static JFrame addTaskFrame;
    private static JFrame listTaskFrame;
    private static JFrame deleteTaskFrame;
    private static JFrame markCompletedFrame;
    private static final String FILE_PATH = "tasks.json";

	public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Task Manager");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 400);
        mainFrame.setLayout(null);
		mainFrame.setLocationRelativeTo(null);


		JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(100, 50, 170, 70);
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddTaskWindow("a");
            }
        });
		
	    // Botón para listar tareas
        JButton listTaskButton = new JButton("List Tasks");
        listTaskButton.setBounds(350, 50, 170, 70);
        listTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openListTaskWindow();
            }
        });

        // Botón para borrar tareas
        JButton deleteTaskButton = new JButton("Erased Tasks");
        deleteTaskButton.setBounds(250, 150, 170, 70);
        deleteTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteTaskWindow();
            }
        });
        
        // Botón para marcar tareas como completadas
        JButton markCompletedButton = new JButton("Finished Tasks");
        markCompletedButton.setBounds(500, 150, 170, 70);
        markCompletedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMarkCompletedWindow();
            }
        });
       
		
        mainFrame.add(addTaskButton);
		mainFrame.add(deleteTaskButton);
		mainFrame.add(listTaskButton);
		mainFrame.add(markCompletedButton);

		ImageIcon imagen = new ImageIcon("src\\main\\resources\\static\\images\\background.jpg");
        JLabel background = new JLabel();
        background.setBounds(0, 0, mainFrame.getWidth(), mainFrame.getHeight());
        background.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
        mainFrame.add(background);

        
        mainFrame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                
                int newWidth = mainFrame.getWidth();
                int newHeight = mainFrame.getHeight();
                background.setBounds(0, 0, newWidth, newHeight);
                background.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH)));
            }
        });
		mainFrame.setVisible(true);

	}
	private static void openAddTaskWindow(String string) {
        addTaskFrame = new JFrame("Add Task");
        addTaskFrame.setSize(340, 340);
        addTaskFrame.setLayout(null);
		addTaskFrame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Task:");
        nameLabel.setBounds(10, 16, 100, 25);
        addTaskFrame.add(nameLabel);

        JTextField nameField = new JTextField(20);
        nameField.setBounds(100, 10, 175, 30);
        addTaskFrame.add(nameField);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(10, 52, 80, 30);
        addTaskFrame.add(timeLabel);

        JTextField timeField = new JTextField(20);
        timeField.setBounds(100, 55, 175, 30);
        addTaskFrame.add(timeField);

        JLabel personLabel = new JLabel("Person:");
        personLabel.setBounds(10, 92, 100, 40);
        addTaskFrame.add(personLabel);

        JTextField personField = new JTextField(20);
        personField.setBounds(100, 100, 175, 30);
        addTaskFrame.add(personField);

        JCheckBox isCompletedCheckBox = new JCheckBox("Completed");
        isCompletedCheckBox.setBounds(100, 150, 200, 50);
        isCompletedCheckBox.setEnabled(false);
        addTaskFrame.add(isCompletedCheckBox);

        JButton acceptButton = new JButton("Accept");
        acceptButton.setBounds(100, 200, 120, 40);
		acceptButton.setBackground(new Color(100, 255, 51));
		acceptButton.setFont(new Font("arial", Font.BOLD,16));
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddTask newTask = new AddTask(
                        nameField.getText(),
                        timeField.getText(),
                        personField.getText(),
                        isCompletedCheckBox.isSelected()
                );
                tasks.add(newTask);
                //saveTasks();
                addTaskFrame.dispose();
            }
        });
        addTaskFrame.add(acceptButton);

        addTaskFrame.setVisible(true);
    }

	
}

