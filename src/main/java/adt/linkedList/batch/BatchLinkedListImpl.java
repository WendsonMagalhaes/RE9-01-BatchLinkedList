package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!!
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/*
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		if (!this.isEmpty()) {
			DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();
			int k = 0;
			if (posicao == 0) {
				this.insertFirst(elementos[0]);
				k = 1;
				auxNode = (DoubleLinkedListNode<T>) this.getHead();
			}
			for (int i = 1; i < posicao; i++) {
				auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
			}

			for (int j = k; j < elementos.length; j++) {

				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
				newNode.setData(elementos[j]);
				newNode.setPrevious(auxNode);

				newNode.setNext(auxNode.getNext());
				auxNode.setNext(newNode);
				auxNode = newNode;

			}
		}
	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		
		DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();

		if (posicao == 0) {
			for (int k = 0; k < quantidade; k++) {
				this.removeFirst();
			}
		} else {
			for (int i = 1; i < posicao; i++) {
				auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
			}
			for (int j = 0; j < quantidade; j++) {
				this.remove(auxNode.getNext().getData());
			}
		}
	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {

		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>) getHead();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result += " ";
			}

			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();

		}

		return result;
	}

	/*
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo,
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead()
	 * 
	 */
	public String toStringFromLast() {

		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();

		while (!aNode.isNIL()) {

			if (!result.isEmpty()) {
				result = " " + result;
			}

			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();

		}

		return result;
	}

	@Override
	public String toString() {
		return toStringFromHead();
	}

}
