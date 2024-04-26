package EnumeracoesComposicao;

import java.util.Date; // Importa a classe Date para lidar com datas e horas.

import entities.enums.OrderStatus; // Importa a enumeração OrderStatus corretamente.
import entities.enumeracoes.Order; // Importa a classe Order corretamente.

public class Enumeracoes {

    public static void main(String[] args) {

        // Criando um novo pedido com ID 1080, data atual e status PENDING_PAYMENT.
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
        
        // Imprimindo os detalhes do pedido.
        System.out.println(order);
        
        // Atribuindo o status DELIVERED à variável os1.
        OrderStatus os1 = OrderStatus.DELIVERED;
        
        // Obtendo o status DELIVERED através do método valueOf da enumeração OrderStatus e atribuindo à variável os2.
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
        
        // Imprimindo os valores de os1 e os2.
        System.out.println(os1);
        System.out.println(os2);
    }
}