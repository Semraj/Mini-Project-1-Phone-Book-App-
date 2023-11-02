public class SolutionLeetCode {

    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    int x=scanner.nextInt();
        public boolean isPalindrome ( int x){
            originalNumber = x;
            int palNumber = 0;

            while (x > 0) {
                singleDigit = x % 10;
                x = x / 10;
                palNumber = palNumber + singleDigit;
            }

            if (originalNumber == palNumber)
                return true;
            else
                return false;
        }
    }
