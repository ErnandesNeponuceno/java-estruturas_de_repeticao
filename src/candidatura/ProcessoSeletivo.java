package src.candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("Processo seletivo iniciado: \n");
   
        selecaoCandidatos ();
    }

    static  void entrandoEmContato (String [] candidatos){
        System.out.println("\nIniciado o processo de contato com os candidatos selecionados:\n");
        for (String candidato: candidatos){
            if (candidato != null) {
                int tentativasRealizadas = 0;
                boolean continuarTentando = true;
                boolean atendeu = false;

                do {
                    atendeu = atender();
                    continuarTentando = !atendeu;
                    if(continuarTentando){
                        tentativasRealizadas++;
                    } else {
                        System.out.println("Contato realizado com sucesso: ");
                    }
                } while (continuarTentando && tentativasRealizadas < 3);
        
                if(atendeu){
                    System.out.println("Conseguimos contato com o candidato " + candidato + " na tentativa " + (tentativasRealizadas + 1));
                } else {
                    System.out.println("Não conseguimos contato com o candidato " + candidato + "." + " Número máximo de tentativas " + (tentativasRealizadas));
                }
        
            }
        };
        
    }
    static boolean atender (){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados( String [] candidatos){
        System.out.println("\nImprimindo a lista de canditados selacionados: ");
        for(int indice=0; indice < candidatos.length; indice++){
            if (candidatos[indice] != null) {
                System.out.println("O candidato de número " + (indice + 1) + " é o(a): " + candidatos[indice]);
            }
        }
        entrandoEmContato(candidatos);
        
    }

    static void selecaoCandidatos (){
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Maria", "Joao", "Cleo", "Ana", "Marcela", "Igor", "Mateus"};
        String[] candidatosSelecionados = new String[5];
        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatoSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.printf("O candidato " + candidato + " solicitou esse valor de salario: %.2f\n", salarioPretendido);
            if (salarioBase > salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados[candidatoSelecionados] = candidato;
                System.out.println("Ligar para candidato");
                candidatoSelecionados++;
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Ligar para candidato com contra proposta");
            } else {
                System.out.println("Aguardar demais candidatos");
            }
            candidatoAtual++;
        }

        imprimirSelecionados(candidatosSelecionados);
        
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


}
