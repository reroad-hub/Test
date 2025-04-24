import java.util.HashMap;

public class Student {
    private final String id;
    private final String name;
    private final HashMap<String, Integer> grade = new HashMap<>();

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addGrade(String subject, Integer score) {
        grade.put(subject, score);
    }

    public HashMap<String, Integer> getGrades() {
        return grade;
    }
}
