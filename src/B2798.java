    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class B2798 {
        static int[] numbers;
        static int n;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]); // 카드의 개수
            int target = Integer.parseInt(input[1]); // 만들어야하는 수
            input = br.readLine().split(" ");
            numbers = new int[n];
            for(int i=0;i<n;i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }
            int maxValue = Integer.MIN_VALUE;
            for(int i=0;i<n-2;i++) {
                for(int j=i+1;j<n-1;j++) {
                    for(int k=j+1;k<n;k++) {
                        int current = numbers[i] + numbers[j] + numbers[k];
                        if(current<=target) {
                            maxValue = Math.max(maxValue,current);
                        }
                    }
                }
            }
            System.out.println(maxValue);
        }
    }
