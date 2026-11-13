class Solution {
    HashMap<Integer, List<Integer>> courses = new HashMap();
    Set<Integer> seen = new HashSet();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (var i = 0; i < numCourses; i++) {
            courses.putIfAbsent(i, new ArrayList());
        }

        for (var p: prerequisites) {
            courses.putIfAbsent(p[0], new ArrayList());
            courses.get(p[0]).add(p[1]);
        }

        for (var i = 0; i < numCourses; i++) {
            if (!canPass(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean canPass(int i) {
        if (seen.contains(i)) {
            return false;
        }

        if (courses.get(i).isEmpty()) {
            return true;
        }

        seen.add(i);

        for (var pre: courses.get(i)) {
            if (!canPass(pre)) {
                return false;
            }
        }

        seen.remove(i);
        courses.put(i, new ArrayList());

        return true;
    }
}
