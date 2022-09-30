class Solution {
  	// main function
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        rec(list, "(", n - 1, n);
        return list;
    }
    
	// axiom : if start == end == 0, add str in list.
	// IDEA :
	// In well-formed parentheses
	// close character(")") has to be bigger than open character("(")
	// So, we can solve this problem with recursion.
    public void rec(List<String> list, String str, int start, int end) {
        if(start == 0 && end == 0) {
            list.add(str);
        }
        
        if(start > 0) {
            rec(list, str + "(", start - 1, end);
        }
        if(end > start) {
            rec(list, str + ")", start, end - 1);
        }
    }
}
