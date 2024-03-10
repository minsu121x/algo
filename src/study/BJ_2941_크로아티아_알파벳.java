package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941_크로아티아_알파벳 {
    public static void main(String[] args) throws IOException {
        int count=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split("");
        for(int i=0;i<str.length;i++){
            switch (str[i]){
                case "c":
                    if(i+1< str.length&&str[i+1].equals("=")){//c=
                        i++;
                        count++;
                    }
                    else if(i+1< str.length&&str[i+1].equals("-")){//c-
                        i++;
                        count++;
                    }
                    else{//그냥 c
                        count++;
                    }
                    break;
                case "d":
                    if(i+2< str.length&&str[i+1].equals("z")&&str[i+2].equals("=")){//dz=
                        i+=2;
                        count+=1;
                    }
                    else if(i+1< str.length&&str[i+1].equals("-")){//d-
                        i++;
                        count++;
                    }
                    else{//그냥 d
                        count++;
                    }
                    break;
                case "l", "n":
                    if(i+1< str.length&&str[i+1].equals("j")){
                        i++;
                        count++;
                    }
                    else{
                        count++;
                    }
                    break;
                case "s", "z":
                    if(i+1< str.length&&str[i+1].equals("=")){
                        i++;
                        count++;
                    }
                    else{
                        count++;
                    }
                    break;
                default:count++;
            }
        }

        System.out.println(count);
    }
}
