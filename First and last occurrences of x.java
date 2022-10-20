/*
Ques. Given a sorted array arr containing n elements with possibly duplicate elements, the task is to find indexes of first and last occurrences of an element x in the given array.

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 

*/


//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        int index=binarySearch(0,n-1,arr,x);
        
        //System.out.println(index);
        int leftval=index;
        int prevleft=index;
        int rightval=index;
        int prevright=index;
        
        while(leftval!=-1){
        prevleft=leftval;
        leftval=binarySearch(0,leftval-1,arr,x);
        }
        while(rightval!=-1)
        {   prevright=rightval;
            rightval=binarySearch(rightval+1,n-1,arr,x);
        }
                 ArrayList<Long> al=new ArrayList<Long>();
        al.add(new Long(prevleft));
        al.add(new Long(prevright));
        return(al);
    }
    
    int binarySearch(int start,int end,long arr[],int x){
        if(start<=end)
        {
        int mid=0;
        int size=end-start+1;
        if(size%2==0)
        mid=(start+size/2)-1;
        else
        mid=start+size/2;
        
        //System.out.println("start is "+start+" ,end is "+end+" mid is "+mid);
        if((int)arr[mid]==x)
        {
        return mid; 
        }
        else
        if((int)arr[mid]>x)
        return binarySearch(start,mid-1,arr,x);
        else
        return binarySearch(mid+1,end,arr,x);
        }
        else
        return -1;
    }
}




//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends