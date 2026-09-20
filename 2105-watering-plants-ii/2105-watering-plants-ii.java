class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int refills=0;
        int curA=capacityA;
        int curB=capacityB;
        int i=0;
        int j=plants.length-1;
         while (i <= j) {
            if (i == j) {
                if (curA >= curB) {
                    if (curA < plants[i]) {
                        refills++;
                        curA = capacityA;
                    }
                    curA -= plants[i];
                } else {
                    if (curB < plants[i]) {
                        refills++;
                        curB = capacityB;
                    }
                    curB -= plants[i];
                }
                break;
            }

            if (curA < plants[i]) {
                refills++;
                curA = capacityA;
            }
            curA -= plants[i];
            i++;

            if (curB < plants[j]) {
                refills++;
                curB = capacityB;
            }
            curB -= plants[j];
            j--;
        }

        return refills;
    }
};
