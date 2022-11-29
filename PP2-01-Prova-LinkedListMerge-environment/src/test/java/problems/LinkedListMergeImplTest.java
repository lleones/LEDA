package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListMergeImplTest {
    LinkedListMergeImpl juntadorDeListas;
    SingleLinkedListNode lista1;
    SingleLinkedListNode lista2;
    SingleLinkedListNode lista3;

    @Before
    public void setUp() {
        this.juntadorDeListas = new LinkedListMergeImpl<>();

        this.lista1 = new SingleLinkedListNode<>(2,
                new SingleLinkedListNode<>(3, new SingleLinkedListNode<>(9, new SingleLinkedListNode<>())));

        this.lista2 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>(4,
                new SingleLinkedListNode<>(15, new SingleLinkedListNode<>(21, new SingleLinkedListNode<>()))));

        this.lista3 = new SingleLinkedListNode<>();
    }

    @Test
    public void testMergeGeral() {
        SingleLinkedListNode expectedNode = new SingleLinkedListNode<>(1,
                new SingleLinkedListNode<>(2,
                        new SingleLinkedListNode<>(3,
                                new SingleLinkedListNode<>(4,
                                        new SingleLinkedListNode<>(9, new SingleLinkedListNode<>(15,
                                                new SingleLinkedListNode<>(21, new SingleLinkedListNode<>())))))));
        assertEquals(expectedNode, this.juntadorDeListas.merge(lista1, lista2));
    }

    @Test
    public void testMergeVaziaENaoVazia() {
        assertEquals(lista1, juntadorDeListas.merge(lista1, lista3));
    }

    @Test
    public void testMergeDuasVazias() {
        assertEquals(new SingleLinkedListNode<>(), juntadorDeListas.merge(lista3, lista3));
    }

    @Test
    public void testMergeUmElemento(){
        this.lista2 = new SingleLinkedListNode<>(1, new SingleLinkedListNode<>());
        assertEquals(new SingleLinkedListNode<>(1, lista1), juntadorDeListas.merge(lista2, lista1));
    }

    
}
