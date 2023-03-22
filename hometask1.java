
package java_projects.java_seminar_5;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class hometask1 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> tel = new HashMap<String, ArrayList<String>>();
        Scanner scanner = new Scanner(System.in, "cp866");
        String tempSurname;
        String tempPhone;
        Boolean f = false;
        while (f == false) {
            System.out.println("Введите '1', '2' или 'stop': ");
            String sw = scanner.next();
            switch (sw) {
                case "1":
                    System.out.println("Введите фамилию: ");
                    tempSurname = scanner.next();
                    if (tel.containsKey(tempSurname)) {
                        System.out.println("Добавьте еще один телефон для пользователя " + tempSurname + ": ");
                        tempPhone = scanner.next();
                        tel.get(tempSurname).add(tempPhone);
                    } else {
                        System.out.println("Такой фамилии в MAP пока нет! Добавьте новую фамилию: ");
                        tempSurname = scanner.next();
                        System.out.println("Добавьте телефон для новой фамилии: ");
                        tempPhone = scanner.next();
                        tel.put(tempSurname, new ArrayList<String>());
                        tel.get(tempSurname).add(tempPhone);
                    }
                    break;
                case "2":
                    System.out.println();
                    tel.entrySet().forEach(System.out::println);
                    System.out.println();
                    break;
                case "stop":
                    f = true;
                    break;
            }
        }
        scanner.close();
    }
}