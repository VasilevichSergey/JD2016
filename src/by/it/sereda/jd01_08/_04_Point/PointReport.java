package by.it.sereda.jd01_08._04_Point;

public class PointReport {
    public void printReport(Point1D p) {
        System.out.printf("length=%.2f %s%n", p.length(), p);
        // вызовы out.print(p.toString())
        // и out.print(p) для объекта идентичны !
    }
}