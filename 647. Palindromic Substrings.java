//Given a string, your task is to count how many palindromic substrings in this string.
//The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//Example 1:
//Input: "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".

//Example 2:
//Input: "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//************** Beats 63.89% ************** //

//Strategy: Loop On then extending from each index
//First loop looking for the same character (eg: aa)
//Second loop looking for palindrome (eg: aba )
class Solution {
    char[] chars;
    int count;
    int len; 
    public int countSubstrings(String s) 
    {
        chars = s.toCharArray();
        len = s.length();
        if ( len == 0 )
            return 0;
        for( int i = 0; i < len; i++)
        {
            eP(i);
        }
        return count;
    }
    public void eP(int i )
    {
        int j = i;
        int k = i;
        while(k < len-1 && chars[k] == chars[k+1]) //ext forward 
        {
            count++;
            k++;
        }
        while ( j >= 0 && k < len && chars[j] == chars[k] ) //ext both way
        {
            count++;
            j--;
            k++;
        }
    }
}
