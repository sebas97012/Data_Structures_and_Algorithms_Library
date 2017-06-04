package org.tec.algo.sort;

public class SelectionSort {
    public static LinkedList selectionSort(LinkedList list){
        for (int i =0; i < list.getSize()-2; i++){
            int pointer = i;
            for(int pos1 = i+ 1; pos1 < list.getSize()-2; pos1++){
                if(list.getElement(pos1).getDataT().compareTo(list.getElement(pointer).getDataT()) < 0){
                    pointer = pos1;
                }
            }
            Comparable minNum = list.getElement(pointer).getDataT();
            list.getElement(pointer).setDataT(list.getElement(i).getDataT());
            list.getElement(i).setDataT(minNum);
        }
        return list;
    }
}

