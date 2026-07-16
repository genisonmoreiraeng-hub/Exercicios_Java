Observaão: os desavios não rodam, esta aqui somente para historico de tarefas
Desafio
Em um futuro próximo, o Banco Digital ByteBank revolucionou o gerenciamento de contas bancárias ao permitir que clientes controlem suas finanças de forma totalmente digital. Para garantir a segurança e organização dos dados, o ByteBank exige que todas as operações sejam realizadas por meio de métodos encapsulados, protegendo as informações sensíveis dos usuários. Você foi contratado para implementar uma parte fundamental desse sistema: a classe Conta, responsável por armazenar o saldo de um cliente e permitir operações básicas de depósito e saque, sempre respeitando as regras de encapsulamento.

Implemente uma classe chamada Conta que possua um saldo inicial definido no momento da criação. A classe deve disponibilizar métodos para depositar e sacar valores, garantindo que o saldo nunca fique negativo. Se uma tentativa de saque exceder o saldo disponível, a operação deve ser ignorada. Após uma sequência de operações, o programa deve exibir o saldo final da conta. Utilize encapsulamento para proteger o atributo saldo, permitindo acesso apenas por meio dos métodos definidos.

Entrada
A primeira linha contém um inteiro representando o saldo inicial da conta. As linhas seguintes contêm comandos no formato "depositar X" ou "sacar X", onde X é um inteiro positivo. O processamento termina ao receber o comando "fim".

Saída
Imprima uma única linha contendo o saldo final da conta após todas as operações.

Exemplos
A tabela abaixo apresenta exemplos de entrada e saída:

Entrada	Saída
100
depositar 50
sacar 30
fim	120
200
sacar 250
depositar 100
fim	300
50
sacar 20
sacar 40
fim	30
0
depositar 10
sacar 5
fim	5
