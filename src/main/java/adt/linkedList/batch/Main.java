package adt.linkedList.batch;

import java.sql.Array;

import util.GenericException;

public class Main {

	public static void main(String[] args) throws GenericException {
		
		BatchLinkedListImpl teste = new BatchLinkedListImpl<Integer>();
		teste.insert(3);
		teste.insert(9);
		teste.insert(4);
		teste.insert(2);
		
		Integer[] array = {15,28,7,11};
		//teste.inserirEmBatch(0, array);
		teste.removerEmBatch(1,3);
		System.out.println(teste.toStringFromHead());
		System.out.println("3,9,15,28,7,11,4,2");
	}

}
