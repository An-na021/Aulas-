/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Annam
 */
import javax.swing.JOptionPane;
public class principal {
    static Pessoa[] pessoas = new Pessoa[10]
    static int contador = 0;
    
    public static void main(String[] args){
    
    int opcao;
    
        do{
        String menu = """
        == MENU ==
        1-Inserir Pessoa
        2-Listar Pessoas
        0- Sair
        """;
        
        opcao= Integer.parseInt(JOptionPane.showInputDialog(menu));
        
        switch (opcao)
            case 1:
               inserirPessoa();
            break;
            case 2:
                listarPessoas();
            break;
            case 0:
                JOptionPane.showMessageDialog(null, "Encerrando o sistema..");
            break;
            default:
                JOptionPane.showMessageDialog(null, "opção invalida");
        }
    }
            //Metodo para inserir pessoa
        public static void inserirPessoa(){
            
            if (contador< pessoas.length){
                String nome = JOptionPane.showInputDialog("Nome:");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade:"));
                String endereco = JOptionPane.showInputDialog("Endereço:")
                double salario = Double.parseDouble (JOptionPane.showInputDialog("Salário:"));
                
                pessoas[contador]= new Pessoa(nome, idade, endereco, salario);
                contador++;
                
                JOptionPane.showInputDialog(null,"Pessoa cadastrada com sucesso")
            }
            else{
                JOptionPane.showInputDialog(null, "Vetor cheio!");
            }
        }
        public static void listasPessoas(){
            if(contador == 0){
                JOptionPane.showMessageDialog(null,"Nenhuma pessoa cadastrada");
                return;
            }
            
            String lista = "===LISTA DE PESSOAS===\n\n";
            
            for (int i =0; i< contador; i++){
                lista += "ÍNDICE:" + i + "\n";
                lista += pessoas[i].exibirDados();
                lista += "\n------------------\n";
            }
            JOptionPane.showMessageDialog(null, lista);
        }/// do método
    } //da classe Principal