package controller; 

public class Employee {
    private int id;
    private String name;
    private String position;

    // Constructor
    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Method to display employee details
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Position: " + position;
    }
}
