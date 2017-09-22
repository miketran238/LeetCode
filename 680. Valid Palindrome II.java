//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
//Example 1:
//Input: "aba"
//Output: True

//Example 2:
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.

//Note:The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

//************************************* Beats 95.38% *************************************/
class Solution {
    char[] a;
    public boolean validPalindrome(String s) 
    {
        a = s.toCharArray();
        for( int i = 0, j = a.length-1; i < j; i++,j-- )
        {
            if( a[i] != a[j] )
            {
                return isPal(i+1,j) || isPal(i,j-1);
            }
        }
        return true;
    }
    public boolean isPal(int i, int j)
    {
        while ( i < j )
        {
            if ( a[i] != a[j]) return false;
            i++; j--;
        }
        return true;
    }
}
