import java.util.HashMap;
import java.util.Map;

class day_80 {
    static public Map<Integer, Integer> mem = new HashMap<>();
    public int mincostTickets(int[] days, int[] costs) {
        return Math.min(costs[0]+solve(days, costs, 0, days[0]), 
        Math.min(costs[1]+solve(days, costs, 0, days[0]+6), costs[2]+solve(days, costs, 0, days[0]+29)));
    }

    private int solve(int[] days, int[] costs, int pos, int possible){
            if(pos>days.length-1) return 0;
            if(possible>=days[pos]) return solve(days, costs, pos+1, possible);
            if(mem.containsKey(pos)) return mem.get(pos);

            int one =  costs[0] + solve(days, costs, pos+1, days[pos]);
            int seven =  costs[1] + solve(days, costs, pos+1, days[pos]+6);
            int month =  costs[2] + solve(days, costs, pos+1, days[pos]+29);

            int result = Math.min(one, Math.min(seven, month));
            mem.put(pos, result);
            return result;
    }
    public static void main(String[] args) {
        day_80 d = new day_80();
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(d.mincostTickets(days, costs));
    }
}