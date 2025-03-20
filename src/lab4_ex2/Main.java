package lab4_ex2;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Student> studenti = new ArrayList<>();

        studenti.add(new Student("Cristina Radulescu", "TI 22/1"));
        studenti.add(new Student("Vlad Stoia", "TI 22/1"));
        studenti.add(new Student("Iasmina Dobrota", "TI 22/1"));
        studenti.add(new Student("Catalin Barbu", "TI 22/1"));
        studenti.add(new Student("Andrei Vulcu", "ISM 21/1"));

        for (Student s : studenti) {
            for (int i = 0; i < 5; i++) {
                s.adaugaNota(rand.nextInt(7) + 4); // Interval [4,10]
            }
        }

        studenti.sort(new ByGroupComparator());
        System.out.println("Ordonare alfabetică pe grupe:");
        studenti.forEach(System.out::println);

        List<Student> integralisti = new ArrayList<>();
        List<Student> restantieri = new ArrayList<>();

        for (Student s : studenti) {
            if (s.esteIntegralist()) {
                integralisti.add(s);
            } else {
                restantieri.add(s);
            }
        }

        integralisti.sort(new ByGradesComparator());
        System.out.println("\nIntegralisti ordonați descrescător după medie:");
        integralisti.forEach(System.out::println);

        restantieri.sort(new ByRestanteComparator());
        System.out.println("\nRestanțieri ordonați crescător după numărul de restanțe:");
        restantieri.forEach(System.out::println);
    }
}
