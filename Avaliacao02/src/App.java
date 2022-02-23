
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import loja.Produtos;
import loja.Vendas; 

public class App
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
int opcao;
Scanner in = new Scanner(System.in);
ArrayList <Produtos> produto = new ArrayList<>();        
ArrayList <Vendas> venda = new ArrayList<>();        

do 
        {

            System.out.println("               MENU               ");
            System.out.println("----------------------------------");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período - Detalhado");
            System.out.println("5 - Realizar venda");
            System.out.println("0 - Sair");
            System.out.print("\nOpção: ");

            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) 
            {
                case 1:

                System.out.print("INCLUA O NOME DO PRODUTO: ");
                String nome = in.nextLine();

                System.out.print("INCLUA O CÓDIGO DO PRODUTO: ");
                String codigo = in.nextLine();

                System.out.print("VALOR FINAL DO PRODUTO: ");
                double valor = in.nextDouble();
                in.nextLine();

                System.out.print("QUANTIDADE DO PRODUTO: ");
                int estoque = in.nextInt();
                in.nextLine();

                Produtos pro1 = new Produtos(codigo, nome, valor, estoque);

                produto.add(pro1);

                voltarMenu(in);

                break;

                case 2:
                System.out.println(" CONSULTA DE PRODUTOS ");

                System.out.println("Digite o Código do produto: ");
                String codigo1 = in.nextLine();

               for(int i = 0; i < produto.size(); i++){
                    
                    Produtos pro2 = new Produtos();
                    pro2 = produto.get(i);

                    if(codigo1.equals(pro2.getCodigo()));{
                        System.out.println(pro2.getNome());
                        System.out.println(pro2.getCodigo());
                        System.out.println(pro2.getValor());
                        System.out.println(pro2.getEstoque());

                    }
                }
                
                voltarMenu(in);
                  
                break;

                case 3:

                System.out.println("-------PRODUTOS CADASTRADOS-------");

                double valor1 = 0;

                for(int i = 0; i < produto.size(); i++){
                    
                    Produtos pro3 = new Produtos();
                    pro3 = produto.get(i);
                    valor1 = valor1 + produto.get(i).getValor();

                    System.out.printf("\n Produto:  %s ", pro3.toString());

                }

                double media = valor1 / produto.size();

                System.out.println(media);
                
                voltarMenu(in);
                
                break;

                case 4:

                    break;

                case 5:
                System.out.println("----------------------------------------");
                System.out.println("              REALIZAR VENDA            ");
                System.out.println("----------------------------------------");

                System.out.print("Código do produto a vender: ");
                String codVend = in.nextLine();

                if (produto.size() < 1)
                {
                   
                    System.out.println("----------------------------------------");
                    System.out.println("      NÃO HÁ PRODUTOS CADASTRADOS       ");
                    System.out.println("----------------------------------------");
                    voltarMenu(in);
                    break;
                }

                int i = -1;
                for (Produtos p2 : produto)
                {
                    if (p2.getCodigo().equals(codVend))
                    {
                        i = produto.indexOf(p2);
                    }
                    if (i == -1)
                    {
                        
                        System.out.println("----------------------------------------");
                        System.out.println("         PRODUTO NÃO ENCONTRADO         ");
                        System.out.println("----------------------------------------"); 
                        break;
                    }
System.out.printf("\n(QUANTIDADE DISPONÍVEL: %s un.)\n", produto.get(i)
                    .getEstoque());
                    System.out.printf("\nQuantidade de %s a vender: ", produto.get(i).getNome());
                    int itens = in.nextInt();
                    in.nextLine();

                    Produtos p3 = new Produtos();
                    p3 = produto.get(i);

                    if (itens > p3.getEstoque())
                    {
                       
                        System.out.println("----------------------------------------");
                        System.out.println("          ESTOQUE INSUFICIENTE          ");
                        System.out.println("----------------------------------------");
                        break;
                    }

                   
                    System.out.printf("%s %s(s) vendido(a) com sucesso! \n", itens, produto.get(i).getNome());

                    produto.get(i).subtrairestoque(itens);

                    Vendas v = new Vendas(itens, produto.get(i));
                    venda.add(v);

                }
                break;
            }

        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException 
    {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
        System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}
