class Solution {

    static void printNTo1(int n) {
        if (n == 0) return;   

        System.out.println(n); 
        printNTo1(n - 1);     
    }

    public static void main(String[] args) {
        printNTo1(5);
    }
}
