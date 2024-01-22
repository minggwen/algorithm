import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class DigitTest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1},{-1,-1},{1,1},{0,0}};
        int n;
        int m;
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<n; n++){
            m = Integer.parseInt(st.nextToken());
            for(int j = 0; j<n;j++){
                String map[][] = new String[n][n];
            }
        }

    }

}
