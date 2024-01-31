import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algorithm_1316{
    public static boolean checkNum(char[] arr){
        String str = "";
        for(int i =0; i<arr.length;i++){
            if(str.indexOf(arr[i])<0){
                str+=arr[i];
            }else if(arr[i-1]!=arr[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int cnt = 0;
        n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n;i++){
            arr[i] = br.readLine();
        }
        for(String str : arr){
            char[] strArray = str.toCharArray();
            if(checkNum(strArray)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}