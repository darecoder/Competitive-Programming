package com.CB.Bitmasking;

import java.util.Scanner;

public class InclusionExclusion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        long[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        while (t-- > 0){
            long n = s.nextLong();
            long ans = 0;
            long subsets = (1 << 8) - 1;
            /* 8 because no. of elements in primes are 8,
            and total combinations will be formed as 2^8 - 1 */

            for (long i = 1; i <= subsets; i++) {
                long denom = 1;
                long setBits = countSetBits(i);

                for (int j = 0; j <= 7; j++) {
                    if ((i & (1 << j)) == 1){
                        denom = denom * primes[j];
                    }
                }

                if ((setBits & 1) == 1){
                    ans += (n / denom);
                }else {
                    ans -= (n / denom);
                }
            }
            System.out.println(ans);
        }

    }

    public static long countSetBits(long n) {
        if (n == 0)
            return 0;
        else
            // if last bit set add 1 else add 0
            return (n & 1) + countSetBits(n >> 1);
    }
}
