public class ExpressionTree {
    
    protected class ExpressionNode {
        String value;
        ExpressionNode left;
        ExpressionNode right;
        
        ExpressionNode(String value){
            this.value = value;
            this.left = null;
            this.right = null;    
        }
        
    }
    protected ExpressionNode root;
    
    // constructor method to construct an expression tree
    public ExpressionTree(String postfix) {
        
        ExpressionNode operand;
        ExpressionNode operator;
        
        String[] stringArray = postfix.split(" "); // convert the postfix string into a charArray
        ArrayStack<ExpressionNode> oper = new ArrayStack<>();

        for(int i=0; i< stringArray.length; i++){
        	
            if(!isOperator(stringArray[i])){
                operand = new ExpressionNode(stringArray[i]);
                oper.push(operand);
            }else {
                operator = new ExpressionNode(stringArray[i]); // as a root
                operator.right = oper.pop();
                operator.left = oper.pop();
                oper.push(operator);
            }
        }
        root = oper.top(); // root of the whole tree
        oper.pop();
    }   
    
     // method to check whether this is an operator or not  
     private boolean isOperator(String s){
            return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
        }    
    
    // method to return the postorder
    private String postOrder(ExpressionNode t) { 
        if (t == null)
            return "";
        return String.valueOf(postOrder(t.left)) + String.valueOf(postOrder(t.right)) + String.valueOf(t.value)+" ";

    }     
      
    // this is method to recursively evaluate the tree
    public int evaluate(ExpressionNode node) {
    	int left_sum;
    	int right_sum;
    	
    	if (node == null)
    		return 0;
    	else if (node.right == null && node.left == null)
    		return Integer.valueOf(node.value);
    	else {
    		left_sum = evaluate(node.left);
    		right_sum = evaluate(node.right);
    		if (node.value.equals("+"))
    	        return left_sum + right_sum;
    	      
    	    else if (node.value.equals("-")) 
    	    	return left_sum - right_sum;
    	        
    	    else if (node.value.equals("*"))
    	        return left_sum * right_sum ;
    	      
    	    else
    	        return left_sum / right_sum;	
    	}
    }
    // this is a method to obtain the output
    public int eval() {
        return evaluate(root);
    }
    
    // when use tree.getPostfix() can obtain a postfix expression of this tree
    public String getPostfix() {
        return postOrder(root);
    }
    
    public static void main (String[] args) {
    	String example = "34 2 - 5 *";
    	ExpressionTree exampleTree = new ExpressionTree(example);
    	System.out.println(exampleTree.getPostfix());
    	System.out.println(exampleTree.eval());
    	
    	
    }
    
    
    
    
}