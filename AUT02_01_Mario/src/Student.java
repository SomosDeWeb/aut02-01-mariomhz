public class Student {
    private String name;
    private int age;
    private double score;
    private boolean enrolled;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    };

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    public boolean isEnrolled() {
        return enrolled;
    }

    @Override
    public String toString() {
        return name + " (" + age + ") " + "- Average score: " + score + " Enrolled: " + enrolled;
    }
}
