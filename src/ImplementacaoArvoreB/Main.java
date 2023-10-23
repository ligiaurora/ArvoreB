package ImplementacaoArvoreB;

public class Main {
    public static void main(String[] args) {
        ArvoreB arvoreB = new ArvoreB();

        // Adicionar números à árvore
        arvoreB.Inserir(43);
        arvoreB.Inserir(31);
        arvoreB.Inserir(37);
        arvoreB.Inserir(47);
        arvoreB.Inserir(61);
        arvoreB.Inserir(20);
        arvoreB.Inserir(30);
        arvoreB.Inserir(32);
        arvoreB.Inserir(33);
        arvoreB.Inserir(40);
        arvoreB.Inserir(41);
        arvoreB.Inserir(42);
        arvoreB.Inserir(44);
        arvoreB.Inserir(45);
        arvoreB.Inserir(50);
        arvoreB.Inserir(60);
        arvoreB.Inserir(62);
        arvoreB.Inserir(63);
        arvoreB.Inserir(64);
        
        System.out.println("----------");
        System.out.println("Árvore B");
        System.out.println("----------");

        // Mostrar os números adicionados em ordem
        System.out.println("Números adicionados:");
        arvoreB.Imprimir_Valores();

        // Excluir números da árvore
        arvoreB.excluir(42);
        arvoreB.excluir(47);
        arvoreB.excluir(61);

        // Mostrar os números após a exclusão
        System.out.println("\nNúmeros após a exclusão: 42, 47, 61");
        arvoreB.Imprimir_Valores();

        // Realizar uma busca por um número na árvore
        int resultado = 45;
        arvoreB.busca(resultado);
    }
}