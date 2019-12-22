// Scramble String
// 递归+map做cache
// 时间复杂度O(n^3)，空间复杂度O(n^3), TLE
public class Solution {
    public boolean isScramble(String s1, String s2) {
        cache.clear();
        return isScramble(s1, 0, s1.length(), s2, 0);
    }

    final private HashMap<Triple, Boolean> cache = new HashMap<>();

    private boolean isScramble(String s1, int begin1, int end1,
                               String s2, int begin2) {
        final int length = end1 - begin1;
        final int end2 = begin2 + length;

        if (length == 1) return s1.charAt(begin1) == s2.charAt(begin2);

        for (int i = 1; i < length; ++i)
            if ((getOrUpdate(s1, begin1, begin1 + i, s2, begin2)
                    && getOrUpdate(s1, begin1 + i, end1, s2, begin2 + i))
                    || (getOrUpdate(s1, begin1, begin1 + i, s2, end2 - i)
                    && getOrUpdate(s1, begin1 + i, end1, s2, begin2)))
                return true;

        return false;
    }

    boolean getOrUpdate(String s1, int begin1, int end1,
                     String s2, int begin2) {
        Triple key = new Triple(begin1, end1, begin2);
        if (!cache.containsKey(key)) {
            boolean result = isScramble(s1, begin1, end1, s2, begin2);
            cache.put(key, result);
            return result;
        } else {
            return cache.get(key);
        }
    }
    static class Triple {
        private int i;
        private int j;
        private int k;

        public Triple(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
        @Override
        public int hashCode() {
            int hash = 0;
            hash = i * 31 + j;
            hash = hash * 31 * k;
            return hash;
        }
        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (this.hashCode() != other.hashCode()) return false;
            if (!(other instanceof Triple)) return false;
            Triple o = (Triple)other;
            return this.i == o.i && this.j == o.j && this.k == o.k;
        }
    }
}