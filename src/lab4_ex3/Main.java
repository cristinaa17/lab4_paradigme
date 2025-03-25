package lab4_ex3;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<Student, Integer> students = readInputFile(fileName);

        for (Map.Entry<Student, Integer> entry : students.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " | Apariții: " + entry.getValue());
        }
    }

    static Map<Student, Integer> readInputFile(String name) {
        Map<Student, Integer> students = new HashMap<>();
        BufferedReader buffReader = null;

        try {
            File file = new File(name);
            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return students;
            }

            buffReader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = buffReader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 4) continue;

                String nume = parts[0];
                String prenume = parts[1];
                String grupa = parts[2];

                List<Integer> note = new ArrayList<>();
                for (int i = 3; i < parts.length; i++) {
                    note.add(Integer.parseInt(parts[i]));
                }

                Student student = new Student(nume, prenume, grupa, note);

                students.put(student, students.getOrDefault(student, 0) + 1);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return students;
    }
}
