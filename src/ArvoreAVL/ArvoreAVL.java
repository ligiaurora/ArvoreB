package ArvoreAVL;

public class ArvoreAVL {
    private class Nodo {
        private int dado, altd, alte;
        private Nodo dir, esq;

        public Nodo(int dado) {
            this.dado = dado;
            dir = esq = null;
            altd = alte = 0;
        }
    }

    Nodo raiz;

    public ArvoreAVL() {
        raiz = null;
    }

    public void inserir(int dado) {
        raiz = inserirDado(raiz, dado);
    }

    private Nodo inserirDado(Nodo raiz, int dado) {
        if (raiz == null) {
            raiz = new Nodo(dado);
            return raiz;
        }
        if (dado < raiz.dado) {
            raiz.esq = inserirDado(raiz.esq, dado);
            if (raiz.esq.altd > raiz.esq.alte) {
                raiz.alte = raiz.esq.altd + 1;
            } else {
                raiz.alte = raiz.esq.alte + 1;
            }
            raiz = balanceamento(raiz);
        } else if (dado > raiz.dado) {
            raiz.dir = inserirDado(raiz.dir, dado);
            if (raiz.dir.altd > raiz.dir.alte) {
                raiz.altd = raiz.dir.altd + 1;
            } else {
                raiz.altd = raiz.dir.alte + 1;
            }
            raiz = balanceamento(raiz);
        }
        return raiz;
    }

    private Nodo balanceamento(Nodo raiz) {
        int balance = raiz.altd - raiz.alte;
        int subTreeBalance;
        if (balance == 2) {
            subTreeBalance = raiz.dir.altd - raiz.dir.alte;
            if (subTreeBalance >= 0) {
                raiz = rotacao_esquerda(raiz);
            } else {
                raiz.dir = rotacao_direita(raiz.dir);
                raiz = rotacao_esquerda(raiz);
            }
        } else if (balance == -2) {
            subTreeBalance = raiz.esq.altd - raiz.esq.alte;
            if (subTreeBalance <= 0) {
                raiz = rotacao_direita(raiz);
            } else {
                raiz.esq = rotacao_esquerda(raiz.esq);
                raiz = rotacao_direita(raiz);
            }
        }
        return raiz;
    }

    private Nodo rotacao_esquerda(Nodo raiz) {
        Nodo aux1, aux2;
        aux1 = raiz.dir;
        aux2 = aux1.esq;
        raiz.dir = aux2;
        aux1.esq = raiz;
        if (raiz.dir == null) {
            raiz.altd = 0;
        } else if (raiz.dir.alte > raiz.dir.altd) {
            raiz.altd = raiz.dir.alte + 1;
        } else {
            raiz.altd = raiz.dir.altd + 1;
        }
        if (aux1.esq.alte > aux1.esq.altd) {
            aux1.alte = aux1.esq.alte + 1;
        } else {
            aux1.alte = aux1.esq.altd + 1;
        }
        return aux1;
    }

    private Nodo rotacao_direita(Nodo raiz) {
        Nodo aux1, aux2;
        aux1 = raiz.esq;
        aux2 = aux1.dir;
        raiz.esq = aux2;
        aux1.dir = raiz;
        if (raiz.esq == null) {
            raiz.alte = 0;
        } else if (raiz.esq.alte > raiz.esq.altd) {
            raiz.alte = raiz.esq.alte + 1;
        } else {
            raiz.alte = raiz.esq.altd + 1;
        }
        if (aux1.dir.alte > aux1.dir.altd) {
            aux1.altd = aux1.dir.alte + 1;
        } else {
            aux1.altd = aux1.dir.altd + 1;
        }
        return aux1;
    }

    public void mostrarEmOrdem() {
        mostrandoOrdenado(raiz);
    }

    public void mostrandoOrdenado(Nodo raiz) {
        if (raiz != null) {
            mostrandoOrdenado(raiz.esq);
            System.out.println(raiz.dado);
            mostrandoOrdenado(raiz.dir);
        }
    }
    
    public void remover(int dado) {
        raiz = removerDado(raiz, dado);
    }

    private Nodo removerDado(Nodo raiz, int dado) {
        if (raiz == null) {
            return raiz;
        }

        if (dado < raiz.dado) {
            raiz.esq = removerDado(raiz.esq, dado);
        } else if (dado > raiz.dado) {
            raiz.dir = removerDado(raiz.dir, dado);
        } else {
            if (raiz.esq == null || raiz.dir == null) {
                Nodo temp = (raiz.esq != null) ? raiz.esq : raiz.dir;

                if (temp == null) {
                    temp = raiz;
                    raiz = null;
                } else {
                    raiz = temp;
                }
            } else {
                Nodo temp = encontrarMenorNodo(raiz.dir);
                raiz.dado = temp.dado;
                raiz.dir = removerDado(raiz.dir, temp.dado);
            }

            if (raiz == null) {
                return raiz;
            }

            raiz.alte = Math.max(altura(raiz.esq), altura(raiz.dir)) + 1;
            raiz.altd = Math.max(altura(raiz.esq), altura(raiz.dir)) + 1;

            raiz = balanceamento(raiz);
        }

        return raiz;
    }

    private Nodo encontrarMenorNodo(Nodo nodo) {
        Nodo atual = nodo;
        while (atual.esq != null) {
            atual = atual.esq;
        }
        return atual;
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return Math.max(nodo.alte, nodo.altd);
    }
    
    public int encontrarMaiorChave() {
        Nodo currentNode = raiz;
        while (currentNode.dir != null) {
            currentNode = currentNode.dir;
        }
        return currentNode.dado;
    }

    public boolean buscar(int chave) {
        return buscarNaArvore(raiz, chave);
    }

    private boolean buscarNaArvore(Nodo raiz, int chave) {
        if (raiz == null) {
            return false;
        }
        if (raiz.dado == chave) {
            return true;
        } else if (chave < raiz.dado) {
            return buscarNaArvore(raiz.esq, chave);
        } else {
            return buscarNaArvore(raiz.dir, chave);
        }
    }
}

