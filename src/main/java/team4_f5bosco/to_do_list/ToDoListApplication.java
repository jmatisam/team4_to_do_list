package team4_f5bosco.to_do_list;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoListApplication {
    private static ArrayList<AddTask> tasks = new ArrayList<>();
    private static JFrame mainFrame;
    private static JFrame addTaskFrame;
    private static JFrame listTaskFrame;
    private static JFrame deleteTaskFrame;

    public static void main(String[] args) {
        // Crear la ventana principal
        mainFrame = new JFrame("Task Manager");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(null);

        // Fondo e icono
        // Aquí deberías agregar tu imagen de fondo e icono

        // Botón para añadir tareas
        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setBounds(50, 50, 120, 30);
        addTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddTaskWindow();
            }
        });
        mainFrame.add(addTaskButton);

        // Botón para listar tareas
        JButton listTaskButton = new JButton("List Tasks");
        listTaskButton.setBounds(200, 50, 120, 30);
        listTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openListTaskWindow();
            }
        });
        mainFrame.add(listTaskButton);

        // Botón para borrar tareas
        JButton deleteTaskButton = new JButton("Erased Tasks");
        deleteTaskButton.setBounds(50, 150, 120, 30);
        deleteTaskButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDeleteTaskWindow();
            }
        });
        mainFrame.add(deleteTaskButton);

        // Botón para marcar tareas como completadas
        JButton markCompletedButton = new JButton("Finished Tasks");
        markCompletedButton.setBounds(200, 150, 120, 30);
        markCompletedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openMarkCompletedWindow();
            }
        });
        mainFrame.add(markCompletedButton);

        // Mostrar la ventana principal
        mainFrame.setVisible(true);
		
    }

    private static void openAddTaskWindow() {
		// Crear la ventana para añadir tarea
		addTaskFrame = new JFrame("Añadir Tarea");
		addTaskFrame.setSize(300, 200);
		addTaskFrame.setLayout(null);
	
		// Campo para el nombre de la tarea
		JLabel nameLabel = new JLabel("Nombre:");
		nameLabel.setBounds(10, 10, 80, 25);
		addTaskFrame.add(nameLabel);
	
		JTextField nameField = new JTextField(20);
		nameField.setBounds(100, 10, 165, 25);
		addTaskFrame.add(nameField);
	
		// Campo para el tiempo
		JLabel timeLabel = new JLabel("Tiempo:");
		timeLabel.setBounds(10, 40, 80, 25);
		addTaskFrame.add(timeLabel);
	
		JTextField timeField = new JTextField(20);
		timeField.setBounds(100, 40, 165, 25);
		addTaskFrame.add(timeField);
	
		// Campo para la persona asignada
		JLabel personLabel = new JLabel("Persona:");
		personLabel.setBounds(10, 70, 80, 25);
		addTaskFrame.add(personLabel);
	
		JTextField personField = new JTextField(20);
		personField.setBounds(100, 70, 165, 25);
		addTaskFrame.add(personField);
	
		// Checkbox para la tarea completada (no seleccionable inicialmente)
		JCheckBox isCompletedCheckBox = new JCheckBox("Completada");
		isCompletedCheckBox.setBounds(100, 100, 150, 25);
		isCompletedCheckBox.setEnabled(false);
		addTaskFrame.add(isCompletedCheckBox);
	
		// Botón para aceptar y añadir la tarea
		JButton acceptButton = new JButton("Aceptar");
		acceptButton.setBounds(100, 130, 80, 25);
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crear una nueva tarea con los datos ingresados
				AddTask newTask = new AddTask(
					nameField.getText(),
					timeField.getText(),
					personField.getText(),
					isCompletedCheckBox.isSelected()
				);
				// Añadir la nueva tarea a la lista
				tasks.add(newTask);
				
				// Cerrar la ventana de añadir tarea
				addTaskFrame.dispose();
			}
		});
		addTaskFrame.add(acceptButton);
	
		// Mostrar la ventana para añadir tarea
		addTaskFrame.setVisible(true);

	}
	
    private static void openListTaskWindow() {
        // Lógica para abrir la ventana de listar tareas
    }

    private static void openDeleteTaskWindow() {
        // Lógica para abrir la ventana de borrar tareas
    }

    private static void openMarkCompletedWindow() {
        // Lógica para abrir la ventana de marcar tareas como completadas
    }
	
}
