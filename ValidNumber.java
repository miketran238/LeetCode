class Solution {
    public boolean isNumber(String s) {
        String str = s.trim();
        String regEx = "[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))([e|E][+-]?[0-9]+)?";
        return str.matches(regEx);
    }
}
