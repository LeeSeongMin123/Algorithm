import java.util.*;
import java.io.*;

public class Main {
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] a = new int [n];
		Integer [] b = new Integer [n];
		
		int result = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) 
			b[i] = Integer.parseInt(st2.nextToken());
		
		Arrays.sort(a);
		Arrays.sort(b);

		for(int i=0; i<n; i++) 
			result += a[i] * b[n-1-i];

		bw.write(Integer.toString(result));
		
		bw.flush();
	}
}
