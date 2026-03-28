interface Operacion{
    int calcular(int n1, int n2);

    default void mensaje(){
        System.out.println("mensaje generico");
        mensajePrivado();
    }

    private void mensajePrivado(){
        System.out.println("mensaje privado");
    }

    static void mensajeStatic(){
        System.out.println("mensaje estatico");
    }
}

