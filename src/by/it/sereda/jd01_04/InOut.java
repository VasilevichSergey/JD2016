package by.it.sereda.jd01_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InOut {
    /**
     * Процедура чтения одной строки с консоли
     * @return Вщзвращает строку с консоли
     * @throws java.io.IOException
     */
    public static String consoleReadLine() throws IOException {
        InputStreamReader iStreamReader=new InputStreamReader(System.in);
        BufferedReader line=new BufferedReader(iStreamReader);
        String out=line.readLine();
        //line.close();
        return out;
    }

    /**
     * @param line Строка чисел (целых) разделенных пробелом
     * @return на выходе массив таких числе
     */
    public static double[] stringLineToArray(String line) {
        line = line.trim();                         //удаляем пробелы в начале и в конце
        String[] elemString = line.split(" ");      //преобразование строки в массив
        int count = elemString.length;              //найдем длину массива
        double[] mas = new double[count];                 //создали массив для чисел
        for (int i = 0; i< count; i++) {            //заполнили его
            mas[i] = Double.parseDouble(elemString[i]);
        }
        return mas;
    } //end stringLineToArray

    public static double[][] consoleReadLine2d() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк массива: ");
        int linein = in.nextInt();
        System.out.print("Введите количество столбцов массива: ");
        int colin = in.nextInt();
        in.close();
        double[][] arr = new double[linein][colin];
        for (int i = 0; i < linein; i++) {
            System.out.print("Введите элементы [" + i + "]-й строки:");
            InputStreamReader iStreamReader = new InputStreamReader(System.in);
            BufferedReader line2 = new BufferedReader(iStreamReader);
            String lineout = line2.readLine();
            lineout = lineout.trim();
            String[] elemString2 = lineout.split(" ");      //преобразование строки в массив
            int count2 = elemString2.length;              //найдем длину массива
            for (int z = 0; z < count2; z++) {            //заполнили его
                arr[i][z] = Double.parseDouble(elemString2[z]);
            }

        }
        return arr;
    }




    /**
     * @param mas   входной массив
     * @param name  имя на экране
     * @param cols  число столбцов для выводв
     */

    public static void arrayPrint (double[] mas, String name, int cols) {
        int col=0;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(name);                             //печатаем имя массива
            System.out.printf("[% -3d]=%-9.4f ", i, mas[i]);     //печатаем значения
            col++;
            if ((0==col%cols)                                   //если конец колонки
                    || (mas.length-1==i))                              //или конец массива
            {
                System.out.println();               //тогда печатаем перевод строки
            }
        }
    }



    public static void arrayPrint2D(double[][] m) {
        for (int i = 0; i < m.length; i++) {        //перебираем строки массива
            for (int j = 0; j < m[0].length; j++)   //перебираем столбцы массива
                System.out.printf("%6.2f ",m[i][j]);//печатаем один элемент
            System.out.println();                   //в конце столбуа
        }
        System.out.println();           //в конце массива выводится пустая строка
    }

    /**
     * @param m Печать двумерного массива с заданным именем и индексами
     */
    public static void arrayPrint2D(double[][] m, String name) {
        for (int i = 0; i < m.length; i++) {        //перебираем строки массива
            for (int j = 0; j < m[0].length; j++)   //перебираем столбцы массива
                System.out.printf(name+"[%1d,%1d]=%-6.1f ", i, j, m[i][j]);
            System.out.println();
        }
        System.out.println();           //в конце массива выводится пустая строка
    }
}
