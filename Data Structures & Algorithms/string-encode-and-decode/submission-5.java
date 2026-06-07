class Solution {

    // ["", "2345", "2#", "#3#"] => ["0#4#23452#2#3##3#"]
    // ["HelloWorld", "Great"] -> [10#HelloWorld5#Great]
    // r = 2
    // l = 0
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str.length()+"#"+str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int l = 0;
        int r = 0;

        while (r < str.length()) {
            if (str.charAt(r) == '#') {
                int sLen = Integer.parseInt(str.substring(l, r));
                int endIdx = (r + sLen) + 1;
                String s = str.substring(r+1, endIdx);
                res.add(s);

                l = r + sLen + 1;
                r = l + 1;
            }
            else r++;
        }
        return res;
    }
}
