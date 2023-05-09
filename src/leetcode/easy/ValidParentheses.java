package leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '{' || c == '[' || c == '(')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				char popped = stack.pop();
				if (c == '}' && popped != '{')
					return false;
				if (c == ')' && popped != '(')
					return false;
				if (c == ']' && popped != '[')
					return false;
			}
		}
		return stack.isEmpty();
		
		//0 ms solution
		/*
		 * char []ch = new char[s.length()];
		 * 
		 * if(s.length()%2!=0){ return false; }
		 * 
		 * int index = 0; for(int i=0; i<s.length(); i++){ char c = s.charAt(i);
		 * if(c=='{' || c=='(' || c=='['){ ch[index] = c; index++; } else if(index==0){
		 * return false; } else if(ch[index-1]=='{' && c=='}'){ index--; } else
		 * if(ch[index-1]=='(' && c==')'){ index--; } else if(ch[index-1]=='[' &&
		 * c==']'){ index--; } else{ return false; }
		 * 
		 * if(index<0){ return false; } } if(index == 0){ return true; } else{ return
		 * false; }
		 */
	}
	
}
