package by.it.vasilevich.jd01_02;

public class TaskA {
    static String getMax(int arrayList[]) {
        Integer max=Integer.MIN_VALUE;
        for (Integer i : arrayList){
            if(max<i){
                max=i;
            }
        }
        return "Max="+max.toString()+" Length="+max.toString().length();
    }

    static String getMin(int arrayList[]){
        Integer min=Integer.MAX_VALUE;
        for (Integer i : arrayList){
            if(min>i){
                min=i;
            }
        }
        return "Min="+min.toString()+" Length="+min.toString().length();
    }

    static double mean (int array[]) {
        double res=0;
        for (int i : array) res+=i;
        res/=array.length;
        return res;
    }

    static boolean uniqueDigits(Integer value) {
        char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++){
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    return false;
                    }
                }
            }
        return true;
    }
}