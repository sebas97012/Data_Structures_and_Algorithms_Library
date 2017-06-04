package org.tec.algo.sort;

public class mergesort {
    public static LinkedList mergeSort(LinkedList list){
        LinkedList temp = new LinkedList();
        while(temp.getSize() != list.getSize()){
            temp.insertAtFirst(0);
        }
        return mergeSort(list,temp,0,list.getSize()-2);
    }
    private static LinkedList mergeSort(LinkedList list,LinkedList temp,int left, int right){
        if(left < right){
            int center = (left + right)/2;

            mergeSort(list,temp,left,center);
            mergeSort(list,temp,center+1,right);
            mergeListas(list,temp,left,center+1,right);

            return list;
        }
        return null;

    }
    private static LinkedList mergeListas(LinkedList list, LinkedList temp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int leftTemp = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (list.getElement(left).getDataT().compareTo(list.getElement(right).getDataT()) <= 0) {
                temp.getElement(leftTemp++).setDataT(list.getElement(left++).getDataT());
            } else {
                temp.getElement(leftTemp++).setDataT(list.getElement(right++).getDataT());
            }
        }
        while (left <= leftEnd) {
            temp.getElement(leftTemp++).setDataT(list.getElement(left++).getDataT());
        }
        while (right <= rightEnd) {
            temp.getElement(leftTemp++).setDataT(list.getElement(right++).getDataT());
        }
        for (int i = 0; i < num; i++, rightEnd--) {
            list.getElement(rightEnd).setDataT(temp.getElement(rightEnd).getDataT());
        }
        return list;
    }
}
