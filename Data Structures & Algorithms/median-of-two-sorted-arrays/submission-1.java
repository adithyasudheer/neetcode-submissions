class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        
        int n=nums1.length,m=nums2.length;
        int lo1=0,hi1=n, mid1,mid2, left1,left2,right1,right2;
        double res=0.0;
        while(lo1<=hi1)
        {
            mid1=lo1+(hi1-lo1)/2;
            mid2=(m+n+1)/2-mid1;
            left1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            left2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            right1=(mid1==n)?Integer.MAX_VALUE:nums1[mid1];
            right2=(mid2==m)?Integer.MAX_VALUE:nums2[mid2];

            if(left1<=right2 && left2<=right1)
            {                
                if((m+n)%2==0)
                {
                    res= (double)(Math.max(left1,left2)+Math.min(right1,right2))/2;
                }
                else
                    res=Math.max(left1,left2);
                break;
            }
            else if(left1>right2)
                hi1=mid1-1;
            else
                lo1=mid1+1;
        }
        return res;
    }
}
