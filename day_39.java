class day_39 {
    public int[] decrypt(int[] code, int k) {
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }

        int n = code.length;
        int[] result = new int[n];

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                result[i] = greaterSum(code, k, i + 1);
            }
        } else {
            for (int i = 0; i < n; i++) {
                result[i] = lesserSum(code, Math.abs(k), i - 1);
            }
        }

        return result;
    }

    private int greaterSum(int[] code, int k, int start) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += code[(start + i) % code.length];
        }
        return sum;
    }

    private int lesserSum(int[] code, int k, int start) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += code[(start - i + code.length) % code.length];
        }
        return sum;
    }
    public static void main(String[] args) {
        day_39 d = new day_39();
        int[] code = { 5, 7, 10 };
        int k = 4;
        int[] result = d.decrypt(code, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}