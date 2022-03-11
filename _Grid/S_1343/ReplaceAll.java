package _Grid.S_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ReplaceAll {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String polyomino = br.readLine();

		polyomino = polyomino.replaceAll("XXXX", "AAAA");
		polyomino = polyomino.replaceAll("XX", "BB");
		
		if(polyomino.contains("X")) {
			sb.append(-1);
		}
		else {
			sb.append(polyomino);
		}
		
		System.out.println(sb);
	}

}
