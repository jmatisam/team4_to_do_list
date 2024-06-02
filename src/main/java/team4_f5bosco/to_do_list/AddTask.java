package team4_f5bosco.to_do_list;

public class AddTask {
    private String name;
    private String time;
    private String person;
    private boolean isCompleted;

    public AddTask(String name, String time, String person, boolean isCompleted) {
        this.name = name;
        this.time = time;
        this.person = person;
        this.isCompleted = isCompleted;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
