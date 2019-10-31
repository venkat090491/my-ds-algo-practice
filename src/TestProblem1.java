
import java.util.*;
class TestProblem1 {
    String solution(String S) {
        int[] occurrences = new int[26];
        for (char ch : S.toCharArray()) {
            occurrences[ch - 'a']++;
        }

        char best_char = 'a';
        int  best_res  = 0;

        for (int i = 1; i < 26; i++) {
            if (occurrences[i] > best_res) {
                best_char = (char)((int)'a' + i);
                best_res  = occurrences[i];
            } else if(occurrences[i] == best_res) {
                best_res = occurrences[i];
            }
        }

        return Character.toString(best_char);
    }

    public static void main(String[] args) {
        /*TestProblem1 t1 = new TestProblem1();
        System.out.println(t1.solution("ccdd"));*/

        boolean flag = false;
        if(flag) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        int val = 'r'-'a';
        int checker = 0;
        //System.out.println(val);
        //System.out.println(1<<17);
        System.out.println(131072 & (1<<val));
        checker |= (1<<val);
        //System.out.println(0 | (1<<17));


    }
}
