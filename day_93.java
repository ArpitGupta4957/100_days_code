public class day_93 {
    //Minimum Length of String After Operations (leetcode)
    public int minimumLength(String s) {
        int ch[] = new int[26];
        int len = 0;

        for(char c : s.toCharArray()){
            ch[c - 'a']++;
        }

        for(int i : ch){
            if(i == 0){
                continue;
            }
            else if (i % 2 == 0){
                len += 2;
            }
            else{
                len++;
            }
        }
        return len;
    }

    //Container With Most Water
    public int maxWater(int arr[]) {
        int ans = 0;
        int i = 0, j = arr.length-1;
        
        while(i<j){
            int h = Math.min(arr[i], arr[j]);
            int w = j - i;
            ans = Math.max(ans, h*w);
            
            if(arr[i] < arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }

    public static void main(String args[]){
        day_93 d = new day_93();
        System.out.println(d.minimumLength("abaacbcbb"));

        int arr[] = {1,5,4,3};
        System.out.println(d.maxWater(arr));
    }
}
