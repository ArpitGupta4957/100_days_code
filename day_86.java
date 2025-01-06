class day_85 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int sum = 0;
        int right_one = 0;

        for(int i = 0;i<n;i++){
            if(boxes.charAt(i) == '1'){
                sum += i;
                right_one++;
            }
        }

        int[] arr = new int[n];
        int prefix_sum = 0;
        int left_one = 0;

        for(int i = 0;i<n;i++){
            int moves = sum+prefix_sum;
            arr[i] = moves;

            if(boxes.charAt(i) == '1'){
                left_one++;
                right_one--;
            }

            sum -= right_one;
            prefix_sum += left_one;
        }
        return arr;
    }
    public static void main(String[] args) {
        day_85 d = new day_85();
        String boxes = "110";
        int[] res = d.minOperations(boxes);
        for(int i : res){
            System.out.print(i+" ");
        }
    }
}