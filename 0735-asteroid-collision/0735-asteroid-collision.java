class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            int current = asteroids[i];
            boolean alive = true;

            while (!s.isEmpty() && s.peek() > 0 && current < 0) {

                if (s.peek() < -current) {
                    s.pop();
                }
                else if (s.peek() == -current) {
                    s.pop();
                    alive = false;
                    break;
                }
                else {
                    alive = false;
                    break;
                }
            }

            if (alive) {
                s.push(current);
            }
        }

        int[] ans = new int[s.size()];

        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }
}