package es.joseluisgs.dam;

public class CalcImperativeB implements ICalcImperativeB {

    @Override
    public void suma(int a, int b) {
        System.out.println("Suma: " + (a + b));
    }
}
