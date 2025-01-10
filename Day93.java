import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day93 {
    //Words Subsets (leetcode)
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int[] res = new int[26];

        for (String j : words2){
            int[] count = new int[26];
            for (char c : j.toCharArray())
                count[c - 'a']++;
            for (int i = 0; i < 26; i++)
                res[i] = Math.max(res[i], count[i]);
        }
        
        for (String j : words1){
            int count[] = new int[26], i = 0;
            for (char c : j.toCharArray())
                count[c - 'a']++;
            for (i = 0; i < 26; i++)
                if (count[i] < res[i])
                    break;
            if (i == 26) ans.add(j);
        }
        return ans;
    }

    //Count distinct elements in every window (gfg)
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length, j=0;
        
        for(int i=0; i<n; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i],0)+1);
            
            if(i >= k-1){
                ans.add(mp.size());
                mp.put(arr[j], mp.get(arr[j])-1);
                
                if(mp.get(arr[j]) == 0){
                    mp.remove(arr[j]);
                }
                j++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Day93 obj = new Day93();
        String[] words1 = {"amazon","apple","facebook","google","leetcode"}; //["amazon","apple","facebook","google","leetcode"]
        String[] words2 = {"l","e"}; 
        System.out.println(obj.wordSubsets(words1,words2));

        int arr[] = {1,2,1,3,4,2,3}, k = 4;
        System.out.println(obj.countDistinct(arr, k));
    }
}
