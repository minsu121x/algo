package 조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class P131_BJ4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String str="";
        double total=0;//비율 계산을 위한 total 계산
        HashMap<String,Double> treeName=new HashMap<>();
        while((str=br.readLine())!=null&&str.length()>0) {
            if(treeName.containsKey(str)){// 이미 저장된 이름이면
                treeName.put(str,treeName.get(str)+1);//숫자 하나 추가
            }
            else{
                treeName.put(str,1.0);//처음 나온 이름이면 저장
            }
            total++;
        }
        List<String> sortTreeName=new ArrayList<>(treeName.keySet());
        Collections.sort(sortTreeName);
        for(String key:sortTreeName){
            double been=treeName.get(key)/total*100;
            String result=String.format("%.4f",been);
            System.out.println(key+ " "+result);

        }
}

}
