package searching;

public class TestSearchingAlgorithms {

    public static void main(String[] args) {
        int[] arr = {10,2,3,4,5,6,7,8,9};
        TestSearchingAlgorithms tsa = new TestSearchingAlgorithms();
        //System.out.println(tsa.linearSearch(arr,5));
        //System.out.println(tsa.linearSearch(arr,15));
        //System.out.println(tsa.binarySearchIterative(arr, 10));
        //System.out.println(tsa.binarySearchIterative(arr,15));
        /*int length = arr.length;
        System.out.println(tsa.binarySearchRecursive(arr, 5, 0, length));
        System.out.println(tsa.binarySearchRecursive(arr, 15, 0, length));
        System.out.println(tsa.binarySearchRecursive(arr, 0, 0, length));*/
        System.out.println(tsa.linearSearchRecursive(arr, 10, 0));
        System.out.println(tsa.linearSearchRecursive(arr, 15, 0));
        System.out.println(tsa.linearSearchRecursive(arr, 0, 0));
    }

    public boolean linearSearchIterative(int[] arr, int x) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == x)
                return true;
        }
        return false;
    }

    public boolean linearSearchRecursive(int[] arr, int x, int index) {
        int length = arr.length;
        if(index > length-1)
            return false;
        if(arr[index] == x)
            return true;
        else
            return linearSearchRecursive(arr, x, index+1);
    }

    public boolean binarySearchIterative(int[] arr, int x) {
        int low = 0, high = arr.length;
        while(low < high) {
            int mid = (low+high)/2;
            if(arr[mid] == x)
                return true;
            else if(x > arr[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return false;
    }

    public boolean binarySearchRecursive(int[] arr, int x, int low, int high) {
        int mid = (low+high)/2;
        if(low >= high)
            return false;

        if(arr[mid] == x)
            return true;
        else if(x > arr[mid])
            return binarySearchRecursive(arr, x, mid+1, high);
        else
            return binarySearchRecursive(arr, x, low, mid);
    }
}
