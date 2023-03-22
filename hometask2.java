// Пусть дан список сотрудников: 
// Иван Иванов
// Светлана Петрова
// ...
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности Имени.

package java_projects.java_seminar_5;

import java.util.HashMap;
import java.util.ArrayList;

public class hometask2 {
    public static void main(String[] args) {
        HashMap<Integer, String> fio = new HashMap<>();
        fio.put(1, "Иван Иванов");
        fio.put(2, "Светлана Петрова");
        fio.put(3, "Кристина Белова");
        fio.put(4, "Анна Мусина");
        fio.put(5, "Анна Крутова");
        fio.put(6, "Иван Юрин");
        fio.put(7, "Петр Лыков");
        fio.put(8, "Павел Чернов");
        fio.put(9, "Петр Чернышов");
        fio.put(10, "Мария Федорова");
        fio.put(11, "Марина Светлова");
        fio.put(12, "Мария Савина");
        fio.put(13, "Мария Рыкова");
        fio.put(14, "Марина Лугова");
        fio.put(15, "Анна Владимирова");
        fio.put(16, "Иван Мечников");
        fio.put(17, "Петр Петин");
        fio.put(18, "Иван Ежов");
        StringBuffer sb = new StringBuffer(10000);
        sb.append(fio.values());
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        String[] array = new String[fio.size()];
        array = str.split("[|]| |,|, | ,");
        ArrayList<String> al = new ArrayList<String>();
        int ind = 0;
        while (ind < array.length) {
            al.add(array[ind]);
            ind = ind + 3;
        }
        System.out.println(al);
        HashMap<String, Integer> namesCount = new HashMap<String, Integer>();
        for (int i = 0; i < al.size(); i++) {
            String tempStr = al.get(i);
            if (!namesCount.containsKey(tempStr)) {
                namesCount.put(tempStr, 1);
            } else {
                namesCount.put(tempStr, namesCount.get(tempStr) + 1);
            }
        }

        namesCount.entrySet().stream()
                .sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}