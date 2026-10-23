class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var strMap = new HashMap<String, List<String>>();

        for (var str: strs) {
            var keyArr = new int[26];

            for (var c: str.toCharArray()) {
                keyArr[((int) c) - 'a']++;
            }

            var key = Arrays.toString(keyArr);
            strMap.putIfAbsent(key, new ArrayList<>());
            strMap.get(key).add(str);
        }

        return strMap.values().stream().toList();
    }
}
