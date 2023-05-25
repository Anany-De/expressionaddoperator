//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String S;
            S = br.readLine();

            int target;
            target = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<String> res = obj.addOperators(S, target);
            Collections.sort(res);
            for (String s : res) System.out.print(s + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution {
    public static ArrayList<String> addOperators(String S, int target) {
        // code here
        ArrayList<String> result = new ArrayList<>();
        helper(S, target, 0, 0, 0,"",result);
        return result;
    }

    private static void helper(String n, int t, int index, long v, long pOp, String str, ArrayList<String> list){
        if (index == n.length()){
            if (v == t){
                list.add(str);
            }
            return;
        }
        long currOp = 0;
        for (int i = index; i < n.length(); i++){
            if (i != index && n.charAt(index) == '0')
                break;

            currOp = currOp* 10 +(n.charAt(i) - '0');

            if(index == 0)
                helper(n, t, i+1, currOp,currOp, Long.toString(currOp), list);
            else{
                helper(n, t, i+1, v + currOp, currOp, str + '+' + currOp, list);
                helper(n, t, i+1, v - currOp, -currOp, str + '-' + currOp, list);
                helper(n, t, i+1, v - pOp + pOp * currOp, pOp * currOp, str + '*' + currOp, list);
            }
        }
    }
}