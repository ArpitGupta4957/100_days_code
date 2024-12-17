import java.util.PriorityQueue;

class day_67 {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; // Frequency array to store count of characters
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i = 0;i<26;i++){
            if(count[i]>0){
                pq.offer((char)('a'+ i));
            }
        }
        
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int freq = Math.min(repeatLimit, count[ch - 'a']);

            for(int i = 0;i<freq;i++){
                sb.append(ch);
            }
            count[ch - 'a'] -= freq;

            if(count[ch - 'a'] > 0 && !pq.isEmpty()){
                char nextChar = pq.poll();
                sb.append(nextChar);

                count[nextChar - 'a']--;

                if(count[nextChar - 'a']>0){
                    pq.offer(nextChar);
                }
                pq.offer(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        day_67 obj = new day_67();
        System.out.println(obj.repeatLimitedString("bb", 2));
    }
}