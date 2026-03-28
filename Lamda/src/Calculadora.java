public class Calculadora {

    public void sumar(int num1, int num2){
        System.out.println(num1+num2);
    }
    public double restar(int num1, int num2){
        return num1-num2;
    }
    public static double multiplicacion(int num1, int num2){
        return num1*num2;
    }
    public double division(int num1, int num2){
        return num1/num2;
    }

     /*
     public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.sumar(2, 1);
        System.out.println(c.restar(5, 2));
        System.out.println(multiplicacion(2, 2));
    }
     */
}