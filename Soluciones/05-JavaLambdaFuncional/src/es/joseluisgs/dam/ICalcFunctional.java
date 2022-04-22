package es.joseluisgs.dam;

public interface ICalcFunctional {
    default int suma(int a, int b) {
        return a + b;
    }

    int multiplicacion(int a, int b);

    default int resta(int a, int b) {
        return a - b;
    }

}