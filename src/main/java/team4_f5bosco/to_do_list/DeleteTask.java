package team4_f5bosco.to_do_list;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteTask {
    

        public static void main(String[] args) {
            
            ArrayList<String> tasks = new ArrayList<>();


            
            tasks.add("buy fruits");
            tasks.add("buy meat");
            tasks.add("buy fish");
            tasks.add("buy vegetables");


            System.out.println("Tasks list: " + tasks);


            Scanner input = new Scanner(System.in);

            System.out.println("Do you want to delete a task?");
            System.out.print("Write the number: ");

            int removeTask=input.nextInt();
            

            String tasksRemoved = tasks.remove(removeTask-1);

            System.out.println("Delete task: " + tasksRemoved);
            System.out.println("Tasks list: "  + tasks);
            


            input.close();


        
        }




}
