class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        if (chars.length == 1) {
            return 1;
        }

        var cur = chars[0];
        var modId = 0;
        int i = 0;

        //[a,a,a,a,a,a,b,c,c,c,c]

        while (i < chars.length) {
            cur = chars[i];
            Integer curLen = 0;

            while (i < chars.length && chars[i] == cur) {
                i++;
                curLen++;
            }

            var lenChars = curLen.toString().toCharArray();
            chars[modId] = cur;
            
            if (curLen > 1) {
                for (var c: lenChars) {
                    modId++;
                    chars[modId] = c;
                }
            }

            modId++;
        }

        return modId;
    }
}