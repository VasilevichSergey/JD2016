package by.it.luksha.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void task1(){
        StringBuilder text = new StringBuilder(Data.lykomorie);

        System.out.println("1. В каждом слове текста буквы No 5-ю и 7-ю заменить символом #. Для слов короче 5 корректировку не выполнять.");

        Pattern patternFive = Pattern.compile("[а-яА-ЯЁё]{5,}");
        Matcher matcherText = patternFive.matcher(text);

        while(matcherText.find())
        {
            int length = matcherText.group().length();
            int start = matcherText.start();
            text.setCharAt(start + 4, '#');
            if (length > 6)
            {
                text.setCharAt(start + 6, '#');
            }
        }
        System.out.println(text);
    }

    public static void task2(){
        String[] text = Data.lykomorie.split("[^а-яА-ЯЕё]+");

        System.out.println("2. Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.");


        for (int i = 0; i < text.length; i++) {
            if (text[i].length() > 0) {
                int count = 1;
                for (int j = i + 1; j < text.length; j++) {
                    if (text[i].equals(text[j])) {
                        count++;
                        text[j] = "";
                    }
                }
                System.out.printf("Слово \"%s\" имеет %d повторений.", text[i], count);
                System.out.println();
            }
        }
    }

    public static void task3() {
        System.out.println("3. В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.");

        StringBuilder text = new StringBuilder(Data.lykomorie);

        Pattern pattern = Pattern.compile("^[Ё|У|Е|Ы|А|О|Э|Я|И|Ю|ё|у|е|ы|а|о|э|я|и|ю]+[а-яё]+[ё|у|е|ы|а|о|э|я|и|ю]+");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find())
        {
            count++;
        }

        System.out.println(count);
    }
}
