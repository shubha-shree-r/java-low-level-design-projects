import java.util.ArrayList;
import java.util.List;

public class Accociation {

    public static void main(String[] args) {
        Course course = new Course("Mathematics");

        Student student1 = new Student("Shubha", 12);
        Student student2 = new Student("jeevan", 14);

        course.enrollStudent(student1);
        course.enrollStudent(student2);

        System.out.println("Enrolled student details are:");
        for(Student students: course.getEnrollment()){
            System.out.println("Name : " +students.getName()+ ", "+ "Age : " + students.getAge());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String name;
    private List<Student> enrollment;

    public Course(String name) {
        this.name = name;
        this.enrollment = new ArrayList<>();


    }

    public void enrollStudent(Student student) {
        enrollment.add(student);
    }

    public List<Student> getEnrollment() {
        return enrollment;
    }


}
