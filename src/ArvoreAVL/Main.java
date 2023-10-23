package ArvoreAVL;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] largeDataset = generateRandomLargeDataset(1000000);
        ArvoreAVL tree = new ArvoreAVL();

        for (int data : largeDataset) {
            tree.inserir(data);
        }
        
        System.out.println("----------");
        System.out.println("Árvore AVL");
        System.out.println("----------");

        int maiorChave = tree.encontrarMaiorChave();
        int chaveMaiorQueMaiorChave = maiorChave + 1;

        long startTime = System.nanoTime();
        boolean encontrada = tree.buscar(chaveMaiorQueMaiorChave);
        long endTime = System.nanoTime();

        if (encontrada) {
            System.out.println("Chave encontrada: " + chaveMaiorQueMaiorChave);
        } else {
            System.out.println("Chave não encontrada: " + chaveMaiorQueMaiorChave);
        }

        System.out.println("Tempo de busca: " + (endTime - startTime) + " nanossegundos");

        // Inserção de 1.000.000 de elementos
        ArvoreAVL arvore = new ArvoreAVL();
        Random random = new Random();
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int novoDado = random.nextInt(10000000);
            arvore.inserir(novoDado);
        }
        endTime = System.nanoTime();
        System.out.println("Inserção de 1.000.000 elementos levou: " + (endTime - startTime) + " nanossegundos");
    }

  
    private static int[] generateRandomLargeDataset(int size) {
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = (int) (Math.random() * size * 2); 
        }
        return dataset;
    }
}