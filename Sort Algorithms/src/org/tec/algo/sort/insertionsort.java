package org.tec.algo.sort;

public class insertionsort {


	public static LinkedList insertionSort(LinkedList list){
		int i;
		int j;
		Comparable key;

		for (j = 1; j < list.getSize(); j++) {
			key = list.getElement(j).getDataT();
		    i = j-1;

		    while (i >= 0){
		      //if (key.compareTo( ((Ingrediente) lista.obtenerPorPosicion(i).getDataT()).getNombre()) > 0) {///////////////////////
				if(key.compareTo(list.getElement(i).getDataT()) > 0){
		        break;
		      }
		      swap(i+1,i,list);
		      i--;
		    }
		    list.getElement(i+1).setDataT(key);
		    i--;
		}
		return list;
	}

	public static void swap(int pos1, int pos2, LinkedList list){
		Node link1 = list.getElement(pos1);
		Node link2 = list.getElement(pos2);
		Node temp = new Node(link1.getDataT());
		link1.setDataT(link2.getDataT());
		link2.setDataT(temp.getDataT());
	}
}


