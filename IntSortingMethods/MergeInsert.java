package IntSortingMethods;

public class MergeInsert extends Sort {
    static final int MIN = 15;

    void algorithm() {
        boolean sorted = true;
        int len = this.data.length;
        int i;
        for (i = 1; i < len; i++) {
            if (this.data[i - 1] > this.data[i]) {
                sorted = false;
                break;
            }
        }
        if (!sorted) {
            int[] helper = new int[len];
            mergeSort(this.data, helper, 0, len - 1);
        }
    }

    public static void mergeSort(int arr[], int helper[], int first, int last) {
        if (first < last) {
           if ((last - first) > MIN) {
                int mid = ((first + last) / 2);
                mergeSort(arr, helper, first, mid);
                mergeSort(arr, helper, mid + 1, last);
                merge(arr, helper, first, mid, last);
            } else {
                insertSort(arr, first, last);
            }
        }
    }

    public static void merge(int arr[], int[] helper, int first, int mid, int last) {
        int i = 0;
        for (i = first; i <= last; i++) {
            helper[i] = arr[i];
        }

        int r = mid + 1;
        int l = first;
        int counter = first;

        while (l <= mid && r <= last) {
            if (helper[l] <= helper[r]) {
                arr[counter] = helper[l++];
            } else {
                arr[counter] = helper[r++];
            }
            counter++;
        }
        while (l <= mid) {
            arr[counter++] = helper[l++];
        }

    }

    public static void insertSort(int array[], int first, int last) {
        int i;
        int j;
        int temp;
        for (i = first; i < last; i++) {
            j = i + 1;
            temp = array[j];
            while ((j > first) && (array[j - 1] > temp)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    public String getAuthor() {
        /* You MUST change the following line of code if you want credit.*/
        return "rcm421 and nrs221";
    }

}
