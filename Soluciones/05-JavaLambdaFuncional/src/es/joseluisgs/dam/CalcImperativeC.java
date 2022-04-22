package es.joseluisgs.dam;

public class CalcImperativeC implements ICalcImperativeC {
    @Override
    public void suma(int a, int b) {
        System.out.println("Suma:");
        System.out.println("\tResultado: " + (a + b));
    }

    @Override
    public void resta(int a, int b) {
        System.out.println("Resta:");
        System.out.println("\tResultado: " + (a - b));
    }

    @Override
    public void multiplicacion(int a, int b) {
        System.out.println("Multiplicacion:");
        System.out.println("\tResultado: " + (a * b));
    }

    @Override
    public void division(int a, int b) {
        System.out.println("Division:");
        if (b != 0) {
            System.out.println("\tResultado: " + (a / b));
        } else {
            System.err.println("\tError!");
        }
    }
}
