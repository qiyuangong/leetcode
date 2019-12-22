// Max Points on a Line
// 暴力枚举，以点为中心，时间复杂度O(n^2)，空间复杂度O(n^2)
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int result = 0;

        HashMap<Double, Integer> slope_count = new HashMap<>();
        for (int i = 0; i < points.length-1; i++) {
            slope_count.clear();
            int samePointNum = 0; // 与i重合的点
            int point_max = 1;    // 和i共线的最大点数

            for (int j = i + 1; j < points.length; j++) {
                final double slope; // 斜率
                if (points[i].x == points[j].x) {
                    slope = Double.POSITIVE_INFINITY;
                    if (points[i].y == points[j].y) {
                        ++ samePointNum;
                        continue;
                    }
                } else {
                    if (points[i].y == points[j].y) {
                        // 0.0 and -0.0 is the same
                        slope = 0.0;
                    } else {
                        slope = 1.0 * (points[i].y - points[j].y) /
                                (points[i].x - points[j].x);
                    }
                }

                int count = 0;
                if (slope_count.containsKey(slope)) {
                    final int tmp = slope_count.get(slope);
                    slope_count.put(slope, tmp + 1);
                    count = tmp + 1;
                } else {
                    count = 2;
                    slope_count.put(slope, 2);
                }

                if (point_max < count) point_max = count;
            }
            result = Math.max(result, point_max + samePointNum);
        }
        return result;
    }
}