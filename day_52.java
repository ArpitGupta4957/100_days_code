import java.util.HashSet;
class day_52 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2)) return true;
            if (i % 2 == 0 && set.contains(i / 2)) return true;
            set.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        day_52 d = new day_52();
        int[] arr = {10, 2, 5, 3};
        System.out.println(d.checkIfExist(arr));
    }
}