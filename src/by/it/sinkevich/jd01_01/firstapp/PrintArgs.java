package by.it.sinkevich.jd01_01.firstapp;

public class PrintArgs {

    public void showArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.printf("Аргумент №%d ==> %s%n", i + 1, args[i]);
        }
    }
}
