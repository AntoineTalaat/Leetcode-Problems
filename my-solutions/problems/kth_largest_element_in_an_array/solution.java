
import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {       
        MaxHeap<Integer> h=new MaxHeap<>();
        //sort nums
        for(int i=0;i<nums.length;i++) h.add(nums[i]);        
        ArrayList<Integer> sorted = new ArrayList();        
        for(int i=0;i<nums.length;i++) sorted.add(h.pullMax());
        return sorted.get(k-1);
    }
}

public class MaxHeap <T extends Comparable>{
    int size=0;
    ArrayList<T> storage;
    public MaxHeap(){
        storage=new ArrayList<T>();
    }
    public void add(T element){
        storage.add(element);
        size++;
        heapifyUp(size-1);
    }
    public T pullMax(){
        T temp=storage.get(0);
        storage.set(0,storage.get(this.size-1));
        storage.remove(this.size-1);
        this.size--;
        this.heapifyDown(0);
        return temp;
    }
    private void heapifyDown(int index){
        int maxInd;
        T max;
        if(size-1>=getRightSonIndex(index)) {
            maxInd=getMaxIndex(getRightSonIndex(index),getLeftSonIndex(index));
            max= storage.get(maxInd);
        }
        else if(size-1>=getLeftSonIndex(index)){
            maxInd=getLeftSonIndex(index);
            max=storage.get(getLeftSonIndex(index));
        }
        else return;
        while(storage.get(index).compareTo(max)<0){
            swap(index,maxInd);
            index=maxInd;

            if(size-1>=getRightSonIndex(index)) {
                maxInd=getMaxIndex(getRightSonIndex(index),getLeftSonIndex(index));
            }
            else if(size-1>=getLeftSonIndex(index)){
                maxInd=getLeftSonIndex(index);
            }
            else return;
            max= storage.get(maxInd);
        }
    }
    private void heapifyUp(int index){
        while (index > 0 && storage.get(getParentIndex(index)).compareTo(storage.get(index))<0){
            swap(getParentIndex(index),index);
            index=getParentIndex(index);
        }
    }
    private int getMaxIndex(int index1,int index2){
        if(storage.get(index1).compareTo(storage.get(index2))>0)
            return index1;
        else return index2;
    }
    private void swap(int i1,int i2){
        T temp = storage.get(i1);
        storage.set(i1,storage.get(i2));
        storage.set(i2,temp);
    }
    private int getParentIndex(int sonIndex){
        //parent is 0 sons are 1 2
        //parent is 1 sons are 3 4
        //sons are 2*i+1 for left
        //2*i+2 for right
        //then parent is i = (son-1)/2 or (son-2)/2 ..
        return (sonIndex-1)/2;
    }

    private int getLeftSonIndex(int parentIndex){
        return 2*parentIndex+1;
    }

    private int getRightSonIndex(int parentIndex){
        return 2*parentIndex+2;
    }

}
