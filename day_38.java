class day_38 {
    public int[] resultsArray(int[] nums, int k) {
            if (nums == null || nums.length < k) {
                return new int[0];
            }

        int arr[]=new int[nums.length-k+1];
        int i=0;
        int j=k-1;
        int a=0;
        while(j<nums.length){
            if(solved(nums,i,j)){
                arr[a]=nums[j];
            }
            else{
                arr[a]=-1;
            }
            i++;
            j++;
            a++;
        }
        return arr;
    }

    private boolean solved(int nums[],int start,int end){
        for(int i=start;i<end;i++){
            if(nums[i]+1!=nums[i+1]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        day_38 d = new day_38();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int[] result = d.resultsArray(nums, k);
    
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}