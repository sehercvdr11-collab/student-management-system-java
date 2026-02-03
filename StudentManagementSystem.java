
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double grade;

    Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Öğrenci Yönetim Sistemi ---");
            System.out.println("1. Öğrenci Ekle");
            System.out.println("2. Öğrencileri Listele");
            System.out.println("3. Ortalama Hesapla");
            System.out.println("4. Öğrenci Sil");
            System.out.println("5. ID ile Öğrenci Ara");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    listStudents();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.out.println("Programdan çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (choice != 6);
    }

    static void addStudent() {
        System.out.print("Öğrenci ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Öğrenci Adı: ");
        String name = scanner.nextLine();

        System.out.print("Notu: ");
        double grade = scanner.nextDouble();

        students.add(new Student(id, name, grade));
        System.out.println("Öğrenci eklendi.");
    }

    static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("Kayıtlı öğrenci yok.");
            return;
        }

        for (Student s : students) {
            System.out.println("ID: " + s.id + " | Ad: " + s.name + " | Not: " + s.grade);
        }
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("Öğrenci yok.");
            return;
        }

        double total = 0;
        for (Student s : students) {
            total += s.grade;
        }

        System.out.println("Ortalama Not: " + (total / students.size()));
    }

    static void deleteStudent() {
        System.out.print("Silinecek öğrenci ID: ");
        int id = scanner.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Öğrenci silindi.");
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");
    }

    static void searchStudent() {
        System.out.print("Aranan öğrenci ID: ");
        int id = scanner.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID: " + s.id + " | Ad: " + s.name + " | Not: " + s.grade);
                return;
            }
        }
        System.out.println("Öğrenci bulunamadı.");
    }
}

