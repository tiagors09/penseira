package com.br.tiagors09.penseira.motores;

import java.util.Scanner;

import com.br.tiagors09.penseira.modelo.Pensamento;
import com.br.tiagors09.penseira.modelo.Penseira;

public class Shell {
    private boolean shellAtivo;
    private Scanner en;
    private Pensamento p;

    public Shell() {
        shellAtivo = true;
        en = new Scanner(System.in);
    }

    public void run() {
        while (shellAtivo) {
            System.out.println("= PENSEIRA v1 - TIAGO R SOUSA =");
            System.out.println("1 - GUARDAR PENSAMENTO\n"
            +"2 - MUDAR PENSAMENTO\n"
            +"3 - ESQUECER PENSAMENTO\n"
            +"4 - LER PENSAMENTO\n"
            +"5 - VER TODOS PENSAMENTOS\n"
            +"6 - SAIR");
            System.out.print("$");
            String op = en.nextLine();
            switch (op) {
                case "1":
                    p = new Pensamento();
                    System.out.print("Nova descrição: (50 letras max.)");
                    p.setDescricao(en.nextLine());
                    System.out.print("Numa escala de 1-10 quão importante é? ");
                    p.setPrioridade(en.nextInt());
                    Penseira.getInstance().guardar(p);
                    break;
                case "2":
                    p = new Pensamento();
                    System.out.println("Qual o id do pensamento? ");
                    p.setId(Integer.parseInt(en.nextLine()));
                    System.out.println("Nova descrição: (50 letras max.)");
                    p.setDescricao(en.nextLine());
                    System.out.println("Nova prioridade: ");
                    p.setPrioridade(en.nextInt());
                    Penseira.getInstance().mudar(p);
                    break;
                case "3":
                    System.out.println("Digite o ID do pensamento: ");
                    Penseira.getInstance().esquecerPensamento(en.nextInt());
                    break;
                case "4":
                    System.out.println("Digite o ID do pensamento: ");
                    var pAux = Penseira.getInstance().lerPensamento(en.nextInt());
                    if(pAux != null) System.out.println(pAux);
                    else System.out.println("Não há pensamento com o id informado.");
                    break;
                case "5":
                    for (Pensamento p : Penseira.getInstance().verTodosPensamentos())
                        System.out.println(p);
                    break;
                case "6":
                    System.exit(1);
                    break;
                default:
                    break;
            }
        }
    }
}
