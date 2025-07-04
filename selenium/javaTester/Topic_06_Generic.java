package javaTester;

import java.util.ArrayList;

public class Topic_06_Generic {
    public static void main(String[] args) {
        // Non-Generic
        ArrayList studentName = new ArrayList();
        studentName.add("Nguyen Van Linh");
        studentName.add("Dang Thuy Tram");
        studentName.add(18);
        studentName.add(true);
        studentName.add(25.6);
        // Generic <Type>
        ArrayList<String> students = new ArrayList<String>();
        students.add("Nguyen Van Linh");
        students.add("Dang Thuy Tram");
    }
}
