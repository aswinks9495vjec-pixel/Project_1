class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) return findMedianSortedArrays(b, a);

        int m = a.length, n = b.length;
        int l = 0, r = m;

        while (l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            int al = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int ar = (i == m) ? Integer.MAX_VALUE : a[i];
            int bl = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int br = (j == n) ? Integer.MAX_VALUE : b[j];

            if (al <= br && bl <= ar)
                return ((m + n) % 2 == 0)
                        ? (Math.max(al, bl) + Math.min(ar, br)) / 2.0
                        : Math.max(al, bl);
            else if (al > br) r = i - 1;
            else l = i + 1;
        }
        return 0;
    }
}
