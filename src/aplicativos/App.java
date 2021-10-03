package aplicativos;

import java.io.IOException;
import java.util.Scanner;
import aplicativos.Modelo.Piloto;

public class App{
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

        opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }
                    if(qtdCadastrados < MAX_ELEMENTOS){

                        Pessoa piloto = new Pessoa();
    
                        System.out.println("Informe o nome do piloto :");
                        piloto.setNome(in.next());
    
                        System.out.println("Informe o cpf do piloto :");
                        piloto.setCpf(in.next());
    
                        pilotos[qtdCadastrados] = piloto;
                        qtdCadastrados++;
                    }

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
                
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }
                if(pilotos != null){
                    for(int i = 0; i < pilotos.length; i++){
                        System.out.println(" O nome do piloto cadastrado é : " + pilotos[i].getNome());
                        System.out.println(" O cpf do piloto cadastrado é : " + pilotos[i].getCpf());
                        System.out.println("--------------------------------------");
                        System.out.println();
                    }
                }

                voltarMenu(in);

            } else if (opcao == 3) {
            System.out.println("Informe o cpf do pilotos que procura : ");
            String nextLine = in.nextLine();
                for (int i = 0; i < MAX_ELEMENTOS; i++) {
                    String cpf = pilotos[i].getCpf();
                    if (cpf.equals(nextLine)) {
                        System.out.println("O nome do piloto listado pelo cpf é : " + pilotos[i].getNome());
                    }
                }
                voltarMenu(in);
            
            }else if (opcao == 4) {
           
            System.out.println("Em quanto você quer aumentar o vetor");
            int aumento = in.nextInt();
            Piloto[] novospilotos = new Piloto[qtdCadastrados + aumento];
            
            for(int i = 0; i < aumento; i++){
                Piloto p1 = new Piloto();
                System.out.println("informe nome do piloto :");
                p1.setNome(in.next());
                System.out.println("informe cpf do piloto :");
                p1.setCpf(in.next());
                System.out.println("--------------------------------------");
                novospilotos[i] = p1;
            }

            if(pilotos != null){
                for(int i = 0; i < qtdCadastrados + aumento; i++){
                    System.out.println(" O nome do piloto cadastrado é : " + pilotos[i].getNome());
                    System.out.println(" O cpf do piloto cadastrado é : " + pilotos[i].getCpf());
                    System.out.println();
                    System.out.println("--------------------------------------");
                    System.out.println(" O nome do piloto cadastrado é : " + novospilotos[i].getNome());
                    System.out.println(" O cpf do piloto cadastrado é : " + novospilotos[i].getCpf());
                    System.out.println();
                    System.out.println("---------------------------------------");
                    System.out.println();
                }
            }
        }    
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}