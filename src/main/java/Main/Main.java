package Main;

import dataStructure.Stack;

public class Main {
    public static void main(String[] args) {

        int [] numeros = {5,4,3,2,1};

        inverter(numeros);

    }

    private static void inverter(final int[] numeros){
        Stack stack = new Stack(numeros[0]);

        for(int i = 1; i < numeros.length; i++){
            stack.push(numeros[i]);
        }


        var node = stack.pop();
        while (node !=  null){
            System.out.println(node.getValue());
            node = stack.pop();
        }
    }
}

//codigo alternativo criando um vetor invertido.

/*

public class Main {
    public static void main(String[] args) {

        int [] numeros = {5,4,3,2,1};
        int [] invertido = inverter(numeros);
        for (int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
        for (int i = 0; i < invertido.length; i++){
            System.out.println(invertido[i]);
        }


    }

    private static int[] inverter(final int[] numeros){
        Stack stack = new Stack(numeros[0]);
        int[] invertido = new int[numeros.length];

        for(int i = 1; i < numeros.length; i++){
            stack.push(numeros[i]);
        }


        var node = stack.pop();
        int index = 0;
        while (node !=  null){
            invertido[index] = node.getValue();
            node = stack.pop();
            index ++;
        }
        return invertido;
    }
}

*/
