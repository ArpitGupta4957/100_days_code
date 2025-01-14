import java.util.Arrays;

public class day_94 {
    //Find the Prefix Common Array of Two Arrays(leetcode)
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length, common = 0;
        int ans[] = new int[n];
        int count[] = new int[n+1];

        for(int i=0; i<n; i++){
            count[A[i]]++;
            if(count[A[i]] == 2){
                common++;
            }

            count[B[i]]++;
            if(count[B[i]] == 2){
                common++;
            }

            ans[i] = common;
        }
        return ans;
    }

    //Equilibirum Point(gfg)
    public static int findEquilibrium(int arr[]) {
        int n = arr.length;
        int right = 0, left = 0;
        for(int i : arr){
            right += i;
        }
        for(int j=0; j<n; j++){
            right -= arr[j];
            if(left == right){
                return j;
            }
            left += arr[j];
        }
        return -1;
    }

    public static void main(String[] args) {
        day_94 d = new day_94();
        int[] A = {1,3,2,4}, B = {3,1,2,4};
        int[] ans = d.findThePrefixCommonArray(A, B);
        System.out.println(Arrays.toString(ans));

        int arr[] = {1,2,0,3};
        System.out.println(findEquilibrium(arr));
    }
}
