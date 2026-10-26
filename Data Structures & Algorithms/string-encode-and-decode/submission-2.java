class Solution {
    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) {
            return "-1";
        }

        var sep = "||SEP||";
        var sb = new StringBuilder();
        var i = 0;
        var size = strs.size();

        for (var s : strs) {
            i++;
            sb.append(s);

            if (i < size) {
                sb.append(sep);
            }
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("-1")) {
            return Collections.emptyList();
        }

        var strs = str.split("\\|\\|SEP\\|\\|", -1);

        return Arrays.asList(strs);
    }
}
