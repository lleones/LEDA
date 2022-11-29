package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImpl<T extends Comparable<T>> implements LinkedListMerge<T> {
    public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2) {

        // Head é o meu nó cabeça da minha lista já ordenada que vai ser construida nó a
        // nó e depois será retornada;;
        SingleLinkedListNode<T> head = new SingleLinkedListNode<T>();

        // IteratorNode é uma variável apontando para a mesma lista que vai me permitir
        // iterar
        // adicionando os meus elementos; ele não representa outra lista, é apenas uma
        // variável iteradora semelhante à variável "k" do mergeSort comum;
        SingleLinkedListNode<T> iteratorNode = head;

        // Seguindo a lógica do mergeSort tradicional eu faço antes um while que roda
        // ate que acabem os elemento de uma das listas;
        while (!node1.isNIL() && !node2.isNIL()) {
            if (node1.getData().compareTo(node2.getData()) < 0) {
                // Se a condição for cumprida, eu adiciono o elemento(setData do meu iterador)
                // na lista e coloco um novo nó vazio no final(setNext do iterador);
                iteratorNode.setData(node1.getData());
                iteratorNode.setNext(new SingleLinkedListNode<>());

                // Agora, faço a minha variável iteradora apontar para a nova posição vazia na
                // lista;
                iteratorNode = iteratorNode.getNext();

                // Depois de adicionado o elemento do node, eu dou um passo nessa lista e faço o
                // node1 apontar para o próximo elemento;
                node1 = node1.getNext();
            } else {
                iteratorNode.setData(node2.getData());
                iteratorNode.setNext(new SingleLinkedListNode<>());
                iteratorNode = iteratorNode.getNext();
                node2 = node2.getNext();
            }
        }

        // Agora eu faço mais dois laços while para adicionar na minha lista final os
        // elementos restantes das duas listas ordenadas;
        while (!node1.isNIL()) {
            iteratorNode.setData(node1.getData());
            iteratorNode.setNext(new SingleLinkedListNode<>());
            iteratorNode = iteratorNode.getNext();
            node1 = node1.getNext();
        }

        while (!node2.isNIL()) {
            iteratorNode.setData(node2.getData());
            iteratorNode.setNext(new SingleLinkedListNode<>());
            iteratorNode = iteratorNode.getNext();
            node2 = node2.getNext();
        }

        return head;

    }
}
