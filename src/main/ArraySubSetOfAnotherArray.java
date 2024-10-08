package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ArraySubSetOfAnotherArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long[] a1 = new long[(int)(n)];
            long[] a2 = new long[(int)(m)];


            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String[] inputLine1 = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }

            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));

        }
    }
}

class Compute {
    public String isSubset(long[] a1, long[] a2, long n, long m) {
        HashMap<Long,Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hm.put(a1[i], hm.getOrDefault(a1[i], 0)+1);
        }

        for(int i = 0; i < m; i++){
            if(hm.containsKey(a2[i])){
                if(hm.get(a2[i]) == 1){
                    hm.remove(a2[i]);
                } else {
                    hm.put(a2[i], hm.get(a2[i]) - 1);
                }
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}