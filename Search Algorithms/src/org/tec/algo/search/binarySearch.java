package org.tec.algo.search;

public class binarySearch{
    public static Comparable binarySearch1(LinkedList list,Comparable input){
        return binarySearchAux(list, input,0, list.getSize()-1);
    }

    private static Comparable binarySearchAux(LinkedList list, Comparable input, int minIndex, int maxIndex){
        Comparable compare1 = input;
        while(maxIndex >= minIndex){
            int middle = (maxIndex + minIndex)/2;
            Comparable compare= list.getElement(middle).getDataT();
            if(compare.compareTo(compare1) < 0){
                minIndex = middle+1;
            }else if(compare.compareTo(compare1) > 0){
                maxIndex = middle-1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}
