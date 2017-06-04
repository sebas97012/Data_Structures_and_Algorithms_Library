package org.tec.algo.sort;

public class quicksort {
    public static void swap(int pos1, int pos2, LinkedList list) {
        Node link1 = list.getElement(pos1);
        Node link2 = list.getElement(pos2);
        Node temp = new Node(link1.getDataT());
        link1.setDataT(link2.getDataT());
        link2.setDataT(temp.getDataT());
    }
	public static LinkedList quickSort(LinkedList list) {
		int x = list.getSize();
		return quicksortAux(list,0,x-1);
	}
	private static LinkedList quicksortAux(LinkedList list, int low, int high) {
        int i = low;
        int j = high;
        int pivot = low + (high-low)/2;
        Node lastPivot = list.getElement(pivot);

        while (i <= j) {
                //while (((String) ((Ingrediente) lista.obtenerPorPosicion(i).getDataT()).getNombre()).compareToIgnoreCase((String) ((Ingrediente) pivoteFinal.getDataT()).getNombre())<0) {
                  while(list.getElement(i).getDataT().compareTo(lastPivot.getDataT())<0){
                        i++;
                }

                //while (((String) ((Ingrediente) lista.obtenerPorPosicion(j).getDataT()).getNombre()).compareToIgnoreCase((String) ((Ingrediente) pivoteFinal.getDataT()).getNombre())>0) {
                  while(list.getElement(j).getDataT().compareTo(lastPivot.getDataT())>0){
                        j--;
                }

                if (i <= j) {
                        swap(i,j,list);
                        i++;
                        j--;
                }
        }

        if (low < j)
                quicksortAux(list, low,  j);
        if (i < high)
                quicksortAux(list, i, high);
        return list;
    }
}
