package 조민수;
import java.io.*;

public class P100_BJ16968_차량번호판1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String [] st=br.readLine().split("");
        int result=1;
        String index=st[0];
        if(index.equals("c")){
            result=result*26;
        }
        else{
            result=result*10;
        }
        for(int i=1;i<st.length;i++){
            if(st[i].equals("c")){
                result=result*26;
                if(st[i].equals(index)){
                    result-=26;
                }
                index=st[i];
            }
            else{
                result=result*10;
                if(st[i].equals(index)){
                    result-=10;
                }
                index=st[i];
            }
        }
        System.out.println(result);
    }
}
