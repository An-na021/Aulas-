/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ex03;
import javax.swing.JOptionPane;
/**
 *
 * @author Annam
 */

class no_pilha {
    public int valor;
    public no_pilha proximo;

    public no_pilha() {
        valor = 0;
        proximo = null;
    }
}

class pilha {
    private no_pilha topo;

    public pilha() {
        topo = null;
    }

    public void push(int v) {
        no_pilha temp_no = new no_pilha();
        if (temp_no != null) {
            temp_no.valor = v;
            temp_no.proximo = topo;
            topo = temp_no;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Não foi possível inserir...");
        }
    }

    public int pop() {
        if (topo != null) {
            int v = topo.valor;
            topo = topo.proximo;
            return v;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilha vazia...");
            return -1;
        }
    }

    public void printall(String nomePilha) {
        if (topo == null) {
            javax.swing.JOptionPane.showMessageDialog(null, nomePilha + " está vazia...");
            return;
        }
        no_pilha temp_no = topo;
        String str = nomePilha + ":\n";
        while (temp_no != null) {
            str += temp_no.valor + "\n";
            temp_no = temp_no.proximo;
        }
        javax.swing.JOptionPane.showMessageDialog(null, str);
    }

    public no_pilha getTopo() {
        return topo;
    }

    public void setTopo(no_pilha topo) {
        this.topo = topo;
    }
    public void concatenar(pilha outraPilha) {
        if (outraPilha.getTopo() == null) {
            return;
        }
        if (this.topo == null) {
            this.topo = outraPilha.getTopo();
            return;
        }
        no_pilha atual = this.topo;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = outraPilha.getTopo();
    }
}

public class Ex03 {
    public static void main(String[] args) {
        pilha pilhaMeninos = new pilha();
        pilha pilhaMeninas = new pilha();
        pilha pilhaConcatenada = new pilha();

        int op;
        do {
            String menu = "1 - Empilhar nota de Menino (Pilha 1)\n" +
                          "2 - Empilhar nota de Menina (Pilha 2)\n" +
                          "3 - Concatenar e Imprimir Todas\n" +
                          "4 - Sair\n" +
                          "Escolha uma opção:";
            op = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    int notaM = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite a nota do menino:"));
                    pilhaMeninos.push(notaM);
                    break;
                case 2:
                    int notaF = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Digite a nota da menina:"));
                    pilhaMeninas.push(notaF);
                    break;
                case 3:
                    pilhaMeninos.printall("Pilha 1 (Meninos)");
                    pilhaMeninas.printall("Pilha 2 (Meninas)");
		    pilha temp1 = copiarPilha(pilhaMeninos);
                    pilha temp2 = copiarPilha(pilhaMeninas);
                    temp1.concatenar(temp2);
                    temp1.printall("Pilha Concatenada (Meninos + Meninas)");
                    break;
            }
        } while (op != 4);
    }
    public static pilha copiarPilha(pilha p) {
        pilha nova = new pilha();
        no_pilha atual = p.getTopo();
        pilha aux = new pilha();
        while (atual != null) {
            aux.push(atual.valor);
            atual = atual.proximo;
        }
        no_pilha atualAux = aux.getTopo();
        while (atualAux != null) {
            nova.push(atualAux.valor);
            atualAux = atualAux.proximo;
        }
        return nova;
    }
}

