package test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(b.readLine());
        for(int i=0; i<N; i++) {
            System.out.printf("CountryCode=%s,LocalAreaCode=%s,Number=%s\n", b.readLine().split("[ -]"));
        }
    }
}