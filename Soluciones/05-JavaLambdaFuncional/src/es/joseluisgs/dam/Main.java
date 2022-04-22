package es.joseluisgs.dam;

public class Main {

    public static void main(String[] args) {
        // Podemos usar funciones definidas...
        hola();

        // podemos usar funciones anonimas o lambda, según las necesitemos
        Runnable r = () -> System.out.println("Hola");
        r.run();

        // Es anonima, no tiene nombre, solo la implementación.
        // De esta manera no hace falta declararla si solo la vamos a usar una vez

        // Pueden aceptar parámetros
        // Runnable r2 = (String s) -> System.out.println(s);

        /**
         * Concepto de caja negra (entrada salida sin muchas preocupaciones).
         * El código se vuelve más declarativo (programación declarativa)
         * y menos no imperativo (programación imperativa).
         * El código se vuelve más compacto, más simple, más fácil de leer y también más elegante.
         * Aportan una sintaxis básica.
         * Singularidad (SOLID o Responsabilidad única).
         *
         * (Lista de argumentos) -> { Cuerpo de la expresión lambda }
         * Si solo tiene un argumento, puede escribirse sin paréntesis
         * Si solo tiene una instruccion, puede escribirse sin llaves
         * a -> System.out.println(a)
         * () -> System.out.println("Hola")
         * () -> { System.out.println("Hola") }
         */

        // Y si tenemos disitntas implementaciones de una misma interfaz??
        CalcImperativeA calcA = new CalcImperativeA();
        System.out.println("Suma: " + calcA.suma(1, 2));
        CalcImperativeB calcB = new CalcImperativeB();
        calcB.suma(1, 2);

        // Hecho con Lambda, no necesitamos la implementación, se la indicamos sobre
        // La marcha
        ICalcImperativeA calcLambdaA = (a, b) -> a + b;
        System.out.println("Suma: " + calcLambdaA.suma(1, 2));
        ICalcImperativeB calcLambdaB = (a, b) -> {
            System.out.println("Suma: " + a + b);
        };
        calcLambdaB.suma(1, 2);
        ICalcImperativeA calcLambdaA2 = (a, b) -> 2 * a + 5 + b;
        System.out.println("Suma: " + calcLambdaA2.suma(1, 2));

        /**
         * Si utilizamos interfaces, las lambdas están desarrolladas para solamente
         * trabajar con un único método en su interior.
         * Si tenemos varios métodos, los requisitos a cumplir son:
         * Todos los métodos deben de tener la misma cantidad de parámetros.
         * Se deben declarar métodos a utilizar como default o static.
         * El resto de métodos quedaran inutilizados.
         * En definitiva: una función lambda es como una con un único método público.
         * El cual implementas su comportamiento sobre la marcha.
         */

        CalcImperativeC calcC = new CalcImperativeC();
        calcC.suma(1, 3);
        calcC.resta(1, 3);
        calcC.division(1, 3);
        calcC.multiplicacion(1, 3);

        ICalcFunctional calcLambdaC = (a, b) -> a * b; // Este es la multiplicación
        System.out.println("Total suma: " + calcLambdaC.suma(2, 3));
        System.out.println("Total resta: " + calcLambdaC.resta(2, 3));
        System.out.println("Total multiplicacion: " + calcLambdaC.multiplicacion(2, 3));

        ICalcFunctional calcLambdaC2 = (a, b) -> 2 * a * 2 * b;
        System.out.println("Total multiplicacion: " + calcLambdaC2.multiplicacion(2, 3));
    }


    private static void hola() {
        System.out.println("Hola");
    }
}
