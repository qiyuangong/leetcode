// Max Points on a Line
// 暴力枚举法，以边为中心，时间复杂度O(n^3)，空间复杂度O(1)
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;
        int result = 0;

        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int sign = 0;
                int a = 0, b = 0, c = 0;
                if (points[i].x == points[j].x) sign = 1;
                else {
                    a = points[j].x - points[i].x;
                    b = points[j].y - points[i].y;
                    c = a * points[i].y - b * points[i].x;
                }
                int count = 0;
                for (int k = 0; k < points.length; k++) {
                    if ((0 == sign && a * points[k].y == c +  b * points[k].x) ||
                            (1 == sign&&points[k].x == points[j].x))
                        count++;
                }
                if (count > result) result = count;
            }
        }
        return result;
    }
}