// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску.

package java_projects.java_seminar_5;

import java.util.Random;

public class hometask3 {
    public static void main(String[] args) {
        System.out.println();
        Random random = new Random();
        // Вводим символ, обозначающий клетки, на которые нельзя ставить ферзя
        Character t = '.';
        // Инициируем нашу шахматную доску
        Character[][] ferz = new Character[8][8];
        // Переменные для строк и столбцов
        int i2;
        int j2;
        // Переменные для подсчета количества попыток и итераций в каждой из попыток
        int count = 0;
        int pop = 0;
        // Переменная y будет проверять, остались ли клетки 'O' на доске
        Boolean y = false;
        // Делаем цикл, в котором условие - 8 ферзей стоят на доске
        while (count != 8) {
            System.out.println("--------------------------------------------------------");
            pop = pop + 1;
            System.out.println("ПОПЫТКА НОМЕР " + pop);
            System.out.println();
            // Заполняем нашу доску пустыми клетками
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ferz[i][j] = 'O';
                }
            }
            count = 0;
            // Расставляем наших ферзей по очереди
            for (int z = 1; z <= 8; z++) {

                // Проверяем, остались ли вообще валидные клетки
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ferz[i][j] == 'O') {
                            y = true;
                            break;
                        }
                    }
                }
                // Если остались, то делаем следующий ход
                if (y == true) {
                    while (true) {
                        i2 = random.nextInt(0, 8);
                        j2 = random.nextInt(0, 8);
                        if (ferz[i2][j2] == 'O') {
                            ferz[i2][j2] = 'X';
                            count++;
                            break;
                        }
                    }
                    System.out.println("Ферзь № " + count);
                    // Рисуем на доске траектории, на которые нельзя ставить следующего ферзя
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if ((i == i2) | (j == j2) && (ferz[i][j] != 'X')) {
                                ferz[i][j] = t;
                                // Рисуем точки влево вверх от X
                                for (int k = 0; k <= i2; k++) {
                                    for (int l = 0; l <= j2; l++) {
                                        if (((i2 - k) >= 0) && ((j2 - k) >= 0)) {
                                            if (ferz[i2 - k][j2 - k] != 'X') {
                                                ferz[i2 - k][j2 - k] = t;
                                            }
                                        }
                                    }

                                }
                                // Рисуем точки вправо вниз от Х
                                for (int k = 0; k < (8 - i2); k++) {
                                    for (int l = 0; l < (8 - j2); l++) {
                                        if (((i2 + k) < 8) && ((j2 + k) < 8)) {
                                            if (ferz[i2 + k][j2 + k] != 'X') {
                                                ferz[i2 + k][j2 + k] = t;
                                            }
                                        }
                                    }
                                }
                                // Рисуем точки вправо вверх от Х
                                for (int k = 0; k <= i2; k++) {
                                    for (int l = 0; l < (8 - j2); l++) {
                                        if (((i2 - k) >= 0) && ((j2 + k) < 8)) {
                                            if (ferz[i2 - k][j2 + k] != 'X') {
                                                ferz[i2 - k][j2 + k] = t;
                                            }
                                        }
                                    }
                                }
                                // Рисуем точки влево вниз от Х
                                for (int k = 0; k < (8 - i2); k++) {
                                    for (int l = 0; l <= j2; l++) {
                                        if (((i2 + k) < 8) && ((j2 - k) >= 0)) {
                                            if (ferz[i2 + k][j2 - k] != 'X') {
                                                ferz[i2 + k][j2 - k] = t;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    // Выводим всю доску на экран
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            System.out.print("  " + ferz[i][j]);
                        }
                        System.out.println();
                    }
                }
                System.out.println();
                y = false;
            }
        }
    }
}