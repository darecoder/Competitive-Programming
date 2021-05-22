package com.company._11_Greedy;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] balloons = {{7,10}, {1,5}, {3,6}, {2,4}, {1,4}};
        System.out.println(findMinArrowShots(balloons));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        //compare points on the basis of their ending position
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
