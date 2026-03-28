public class Calculadora2 {
    public static void main(String[] args) {
        Operacion suma = (n1, n2)->n1+n2;
        Operacion resta = (n1,n2)->n1-n2;
        int x = 5;
        int y = 2;
        System.out.println("resta: " + resta.calcular(x, y));
        suma.mensaje();
        Operacion.mensajeStatic();
    }
}