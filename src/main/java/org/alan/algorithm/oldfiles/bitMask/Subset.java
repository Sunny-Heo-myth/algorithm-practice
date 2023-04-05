package org.alan.algorithm.oldfiles.bitMask;

public class Subset {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {3,4,5,7,8,9};

        for(int i = 0; i < (1<<n); i++){
            System.out.print("{ ");
            for(int j = 0; j<n; j++){
                if((i & (1<<j)) != 0){
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
