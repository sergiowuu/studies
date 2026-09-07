package exceptionHandling;

import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        String[] produtos = new String[5];
        int[] quantidades = new int[5];
        double[] precos = new double[5];

        Scanner scan = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("=== MENU ===");
            System.out.println("1. Listar todos os produtos");
            System.out.println("2. Adicionar produto");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Ver valor total do estoque");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scan.nextLine();

            // Aplicando refatoração para tratar entrada inválida

            // Antes
            // if (entrada == null || entrada.isEmpty()) {
            // entrada = "0";
            // } else {
            // for (int l = 0; l < entrada.length(); l++) {
            // if (entrada.charAt(l) < '0' || entrada.charAt(l) > '9') {
            // entrada = "0";
            // break;
            // }
            // }
            // }

            // opcao = Integer.parseInt(entrada);

            // Depois
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = 0; // Define uma opção inválida para continuar o loop
            }

            switch (opcao) {
                case 1:
                    System.out.println("=== Lista de produtos ===");
                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null) {
                            System.out.println("Produto: " + produtos[i] + ", Quantidade: " + quantidades[i]
                                    + ", Preço: " + precos[i]);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scan.nextLine();
                    
                    boolean quantidadeValida = false;
                    int quantidade = 0;
                    while(!quantidadeValida) {
                        System.out.print("Digite a quantidade: ");
                        try {
                            quantidade = Integer.parseInt(scan.nextLine());
                            quantidadeValida = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Quantidade inválida! Por favor, digite um número inteiro.");
                        }
                    }

                    boolean precoValido = false;
                    double preco = 0;
                    while(!precoValido) {
                        System.out.print("Digite o preço: ");
                        try {
                            preco = Double.parseDouble(scan.nextLine());
                            precoValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Preço inválido! Por favor, digite um número válido.");
                        }
                    }

                    boolean adicionado = false;
                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] == null) {
                            produtos[i] = nomeProduto;
                            quantidades[i] = quantidade;
                            precos[i] = preco;
                            adicionado = true;
                            System.out.println("Produto adicionado com sucesso!");
                            break;
                        }
                    }
                    if (!adicionado) {
                        System.out.println("Estoque cheio! Não é possível adicionar mais produtos.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do produto para buscar: ");
                    String buscaProduto = scan.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null && produtos[i].equalsIgnoreCase(buscaProduto)) {
                            System.out.println("Produto encontrado: " + produtos[i] + ", Quantidade: " + quantidades[i]
                                    + ", Preço: " + precos[i]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 4:
                    double valorTotal = 0;
                    for (int i = 0; i < produtos.length; i++) {
                        if (produtos[i] != null) {
                            valorTotal += quantidades[i] * precos[i];
                        }
                    }
                    System.out.println("Valor total do estoque: " + valorTotal);
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scan.close();
    }
}
