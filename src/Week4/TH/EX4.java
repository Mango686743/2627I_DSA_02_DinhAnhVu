import java.util.*;

class Student {
    int id;
    String name;
    double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
}

public class EX4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            studentList.add(new Student(id, name, cgpa));
        }

        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int cgpaCompare = Double.compare(s2.cgpa, s1.cgpa);
                if (cgpaCompare != 0) {
                    return cgpaCompare;
                }

                int nameCompare = s1.name.compareTo(s2.name);
                if (nameCompare != 0) {
                    return nameCompare;
                }

                return Integer.compare(s1.id, s2.id);
            }
        });

        for (Student st : studentList) {
            System.out.println(st.name);
        }

        sc.close();
    }
}