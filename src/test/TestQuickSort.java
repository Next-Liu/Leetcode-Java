package test;

public class TestQuickSort {
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
    public void QuickSort(int[] arr,int low, int high){
        if(low<high){
            int part = partition(arr,low,high);
            QuickSort(arr,low,part-1);
            QuickSort(arr,part+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        TestQuickSort testQuickSort = new TestQuickSort();
        testQuickSort.QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
