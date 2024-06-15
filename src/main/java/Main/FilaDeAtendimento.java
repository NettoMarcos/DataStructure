package Main;
import dataStructure.Queue;

import java.util.Random;

public class FilaDeAtendimento {
    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101);
        Queue queue = new Queue(cliente);

        System.out.println("Chegou o cliente: " + cliente);
        for(int i = 2; i <= n; i++){
            cliente = random.nextInt(101);
            System.out.println("Chegou o cliente: " + cliente);
            queue.enqueue(cliente);
        }
        // Atendimento dos clientes

        System.out.println("######################");
        System.out.println("ATENDIMENTO");
        System.out.println("######################");
        var node = queue.degueue();
        while (node != null){
            System.out.println("Atendido o cliente: " + node.getValue());
            node = queue.degueue();
        }

    }
}
