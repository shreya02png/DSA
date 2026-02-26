import java.util.Stack;
public class EvaluatePostfix  {

    public int evaluatePostfix(String[] arr) {

        Stack<Integer> st=new Stack<>();
        
        for(String s:arr){
            if(s.equals("+") || s.equals("-")|| s.equals("*") || 
            s.equals("/") || s.equals("^")){
                int b=st.pop();
                int a=st.pop();
                if(s.equals("+")){
                    st.push(a+b);
                }
                else if(s.equals("^")){
                    st.push((int)Math.pow(a,b));
                }
                else if(s.equals("-")){
                    st.push(a-b);
                }
                else if(s.equals("*")){
                    st.push(a*b);
                }
                else{
                    st.push(Math.floorDiv(a,b));
                    
                }
            }
                else{
                    st.push(Integer.valueOf(s));
                }
        
        }
        return st.pop();
    }

    public static void main(String[] args) {
        EvaluatePostfix ep=new EvaluatePostfix();
        String[] arr={"2", "1", "+", "3", "*"};
        System.out.println(ep.evaluatePostfix(arr));
    }
}
