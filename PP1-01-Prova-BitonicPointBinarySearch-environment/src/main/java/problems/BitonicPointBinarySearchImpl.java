package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

  @Override
  public T bitonicPoint(T[] array) {
    if (array == null || array.length == 0) {
      return null;
    }

    // Como a especificação pede uma busca binária e um método recursivo, o meu
    // bitonicPoint chama uma busca binária recursiva no array inteiro.
    return buscaBinaria(array, 0, array.length - 1);
  }

  public T buscaBinaria(T[] array, int leftIndex, int rightIndex) {
    if (array.length == 0) {
      return null;
    }

    // Como é uma busca binária O(log n), vamos analisar sempre o elemento do
    // meio(middle) para chamar a recursão apenas na esquerda OU apenas na direita,
    // com objetivo de reduzir o tempo para O(log n).
    int middle = (leftIndex + rightIndex) / 2;

    // Se o middle for o único elemento do array, retorno ele mesmo.
    if (rightIndex == leftIndex) {
      return array[middle];
    }

    // Se o middle for menor que o seu sucessor, eu chamo a busca binária para a
    // parte direita do array.
    if (array[middle].compareTo(array[middle + 1]) < 0) {
      return buscaBinaria(array, middle + 1, rightIndex);
    }

    // Se o middle não for menor que o seu sucessor (não entrou no If de cima) e só
    // tiver 2 elementos no array
    // (middle == 0), o middle é o maior e será retornado.
    if (middle == 0) {
      return array[middle];
    }

    // Se o middle for menor que o seu antecessor, eu chamo a busca binária para a
    // parte esquerda do array.
    if (array[middle].compareTo(array[middle - 1]) < 0) {
      return buscaBinaria(array, leftIndex, middle - 1);
    }

    // Caso não seja menor de que nenhum de seus adjascente, ele é o objeto bitônico
    // e deve ser retornado.
    return array[middle];
  }

}