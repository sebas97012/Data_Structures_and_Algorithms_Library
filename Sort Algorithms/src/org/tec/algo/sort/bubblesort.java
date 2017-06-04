package org.tec.algo.sort;

public class bubblesort {
	public static LinkedList bubbleSort(LinkedList list){
		int x = list.getSize();
		return bubbleSortAux(list,x-1);
	}
	private static LinkedList bubbleSortAux(LinkedList list, int nElements){
    	int in;
    	int out;
    	for (out = nElements; out >= 1; out--){
    		for (in = 0; in < out; in++){
				if(list.getElement(in).getDataT().compareTo(list.getElement(out).getDataT())>0){
    				swap(in,out,list);
    			}
    		}}
    		return list;

    	}
	public static void swap(int pos1, int pos2, LinkedList list) {
        Node link1 = list.getElement(pos1);
        Node link2 = list.getElement(pos2);
        Node temp = new Node(link1.getDataT());
        link1.setDataT(link2.getDataT());
        link2.setDataT(temp.getDataT());
    }
}
