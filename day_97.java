class day_97{
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int i : derived){
            xor ^= i;
        }
        return xor == 0;
    }
    public static void main(String args[]){
        day_97 obj = new day_97();
        int[] derived = {5, 3, 4, 8};
        System.out.println(obj.doesValidArrayExist(derived));
    }
}