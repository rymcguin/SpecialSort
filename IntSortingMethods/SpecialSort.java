package IntSortingMethods;

public class SpecialSort extends Sort {
    static final int MIN = 15;

    void algorithm() {
        boolean sorted = true;
        int i;
        for (i = 1; i < this.data.length; i++) {
            if (this.data[i - 1] > this.data[i]) {
                sorted = false;
                break;
            }
        }
        if (!sorted) {
            sort(this.data, 0, this.data.length - 1);
        }
    }
    
    void sort(int arr[], int left, int right) {
        if (left < right){
            if ((right - left) > MIN) {
                int mid = ((left + right) / 2);
                sort(arr, left, mid);
                sort(arr, mid + 1, right);
                merge(arr, left, mid, right);  
            } else {
                insertSort(arr, left, right);
            }
        }
    }

    void merge(int arr[], int left, int mid, int right){

        int L[] = new int[mid - left + 1];
        int R[] = new int[right - mid];

        int rSize = R.length;
        int lSize = L.length;

        for (int i = 0; i < lSize; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < rSize; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;

        int k = left;
        while (i < lSize && j < rSize) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < lSize){
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < rSize) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    void insertSort(int array[], int first, int last) {
         for (int i = first; i < last; i++){
            int j = i+1;
            int B = array[i+1];
                while ((j > first) && (array[j-1] > B)){
                    array[j] = array[j-1];
                    j--;
                }
            array[j] = B;
        }
    }
    
    public String getAuthor() {
    	/* You MUST change the following line of code if you want credit.*/
        return "rcm421 and nrs221";
    }

}

