package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SegmentedSieve {
    public static ArrayList<Integer> sieve(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] is_prime = new boolean[n+1];
        for(int i=0;i<=n;i++)
            is_prime[i]=true;
        for(int i=2;i<=n;i++){
            if(is_prime[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    is_prime[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(is_prime[i])
                primes.add(i);
        }
        return primes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> primes = sieve((int)Math.sqrt(m));
            boolean[] is_prime = new boolean[m-n+1];
            for(int i=0;i<m-n+1;i++)
                is_prime[i]=true;
            for(Integer prime:primes) {
                int first = (n/prime)*prime;
                if(first<n)
                    first+=prime;
                for(int idx = Math.max(prime*prime, first);idx<=m;idx+=prime) {
                    is_prime[idx - n] = false;
                }
            }
            if(n==1)
                is_prime[0]=false;
            for(int i=0;i<m-n+1;i++) {
                if(is_prime[i])
                    System.out.println(i+n);
            }
            System.out.println();
        }
    }
}
