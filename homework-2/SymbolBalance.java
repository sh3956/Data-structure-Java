import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;


public class SymbolBalance {

        public static BalanceError checkFile(String pathToFile) throws IOException{
            File file = new File(pathToFile);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            char currentSymbol = '0';
 
            // some variables that we need to proceed the process
            int lineNumber = 0;
            boolean readq = true; // in quotes or not
            boolean readc = true; // in comment or not
            // this is the stack to store symbols
            ArrayStack<Character> symStack = new ArrayStack<>();
           
            while(true) {
            	String str = reader.readLine();
            	//readq = true; // quotes can not reach to the next line: add may result in different result in test 6
            	// when start a new line
            	if(str!= null) {
            		lineNumber += 1; // line number += 1
            		char[] charArray = str.toCharArray(); // make string into an array of char
            		//System.out.println(charArray);
                		
            		for (int i=0; i< charArray.length; i++) {
            			currentSymbol = charArray[i];
            			
            			// check right comment and right quote first: check whether we are out comment or out quotes
            			if(i+1 <= charArray.length-1 && charArray[i]== '*' && charArray[i+1] == '/') {
            				if (symStack.isEmpty()) 
            					return new EmptyStackError(lineNumber);
            				else if (symStack.top()!='*') 
            					return new MismatchError(lineNumber, currentSymbol, symStack.pop());
            				else {
            					symStack.pop();
            					readc = true;
            				}
            			}
            			else if(charArray[i]=='"' && readq == false) {
            				if(symStack.isEmpty())
            					return new EmptyStackError(lineNumber);
            				else if (symStack.top()!= '"')
            					return new MismatchError(lineNumber, currentSymbol, symStack.pop());
            				else {
            					symStack.pop();
            					readq = true;	
            				}
            			}
            			// After checking that we are out of comments and quotes	
            			else if(readc == true && readq == true) {
                 			// check whether is the left condition: (, [, /*, 
            				if (currentSymbol == '"'){
                                readq = false;
                                symStack.push(currentSymbol);
                            }
                            else if (i+1 <= charArray.length-1 && currentSymbol == '/' && charArray[i+1] == '*'){
                                readc = false;
                                symStack.push('*');
                            }   
                            else if ( currentSymbol == '(' || currentSymbol == '[' || currentSymbol == '{') 
                                symStack.push(currentSymbol);
                        
                			// check whether is the right condition : where the mismatch error would occur
            				if (currentSymbol ==']' || currentSymbol=='}' || currentSymbol ==')'){
                                // empty stack error 
                                if(symStack.isEmpty()) {
                                	return new EmptyStackError(lineNumber);
                                }
                                 switch(currentSymbol){            
                                         case ']' :
                                             if(symStack.top() != '[')
                                            	 return new MismatchError(lineNumber, currentSymbol, symStack.pop());
                                             else
                                            	 symStack.pop();
                                             break;
                                         case '}' :
                                             if(symStack.top() != '{')
                                            	 return new MismatchError(lineNumber, currentSymbol, symStack.pop());
                                             else
                                            	 symStack.pop();
                                             break;
                                         case ')':
                                             if(symStack.top() != '(')
                                            	 return new MismatchError(lineNumber, currentSymbol, symStack.pop());
                                             else
                                            	 symStack.pop();
                                             break;
                                         default:
                                             break;              
                                 }                   
                            }			
            			}
   
            		}
   	
            	}
            	
            	// when reach the end of file
            	// The only possible to return a NonEmptyStackError
            	else if(str==null) {
            		if (!symStack.isEmpty()) {
            			return new NonEmptyStackError(currentSymbol, -1);
            		}
            		reader.close();
                	return null;		
             	}
            	
            }
 
        }
    
        public static void main(String[] args){
            try {
        		 String path = args[0];
                 if (checkFile(path) == null)
                     System.out.println("OK");
                 else 
                     System.out.println(checkFile(path));
        		} catch (IOException e) {
        			System.out.println("No such file.");
        		}
           
            
        }
    
}