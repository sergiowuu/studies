# Contexto

Sistema de uma locadora de veículos que possui **uma frota de veículos**, essa locadora **atende cliente** e o sistem deve **registrar aluguéis** (retirada até a devolução).

## Sobre a frota de veículos
- Há várias categorias de veículos, sejam carros sedans, SUV, 2 portas, motos, etc, e cada categoria tem uma forma diferente de calcular o valor diário
- Nenhum **veículo genérico deve existir** no sistema, todo veículo deve ser **obrigatóriamente de uma categoria**
- Cada veículo tem uma placa **única**, um status que só pode assumir um **estado fixo e conhecido** (disponível, alugado, em manutenção)
- Veículos alugados ou em manutenção não podem ser alugados, somente disponíveis
- Todo veículo deve estar com o tanque cheio para que possa estar como disponível

## Sobre os clientes
- Um cliente tem dados básicos e **um dado que após cadastrado, não deve mudar** (como se fosse o seu identificador único)
- Clientes podem ter **categorias diferentes** que concedem diferentes descontos no valor final do aluguel (cliente comum, cliente fidelidade, cliente premium, etc.)

## Sobre o aluguel
- Um aluguel **associa um cliente a um veículo por um período** (data início até data fim)
- O valor final do aluguel deve considerar: **a diária do veículo (varia conforme o veículo), a quantidade de dias, o desconto do cliente (se houver) e a taxa caso o carro seja devolvido sem estar com o tanque cheio**.
- Ao criar um aluguel, o veículo correspondente **ser marcado como "alugado" imediatamente de forma automática**
- Deve ser possível consultar quantos carros estão **disponíveis**, quantos estão **alugados** e quantos estão **em manutenção**