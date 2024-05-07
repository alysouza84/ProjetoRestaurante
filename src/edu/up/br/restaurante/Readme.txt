Projeto de Gerenciamento de Restaurante.
        O projeto consiste em um sistema de gerenciamento de um restaurante,
        onde é possível cadastrar clientes, funcionários, cardápio, pedidos.
        (a mesa e a conta sao relacionadas ao pedido e nao precisam de cadastro, apenas de gerenciamento);

        Cadastro (Adicionar/Remover/Pesquisar/Listar/Listar Todos de maneira ordenada) de:

        - Cliente:cpf, nome, telefone, endereço, e-mail.
            (Irá criar arquivo com os dados do cliente, nome do arquivo clientes.txt);

        - Funcionário: nome, telefone, endereço, e-mail, cargo, salário.
            (Irá criar arquivo com os dados do funcionário, nome do arquivo funcionarios.txt);

        - Cardápio: nome, descrição, tipo, preço.
            (Irá criar arquivo com os dados do cardápio, nome do arquivo cardapio.txt);

        - Mesa: numero da mesa, status, pedido vinculado, quantidade de pessoas e reserva;
        (nao precisa de gerenciamento como cadastro, sera um valor fixo de mesas, ex 10;

        - Pedido: funcionario, mesa, comida e quantidade, bebida e quantidade.
            (Não terá arquivo, apenas será exibido na tela);

        - Conta: cliente, total parcial, fechar conta.
            (Não terá arquivo, apenas será exibido na tela);

        - gerenciamento: classe que auxilia a main na chamada das outras classes,
         a main chama o gerenciamento para realizar as tarefas;


        O sistema deve permitir:
        - Pedidos (fechar conta, adicionar pedido. (mostra as mesas disponiveis, modificar pedido, excluir pedido);
        - Cadastrar  novo(clientes, funcionários, cardápio) ou
          Atualizar clientes, funcionários, cardápio.
          Excluir clientes, funcionários, cardápio.

        - Listagem ordenada ou nao (clientes, funcionários, cardápio, pedidos, mesas).
        - Pesquisar clientes, funcionários, cardápio, pedidos.

        -=-=-=-=-=-=-=-=-=-=-=-=-=-
        Ordenar o que for feito no arquivo TXT;
        Tem que ter métodos estáticos;
        -=-=-=-=-=-=-=-=-=-=-=-=-=-