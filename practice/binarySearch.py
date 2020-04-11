def binarySearch(arr, k):
    n=len(arr)-1
    start=0
    end=n
    while (start<=end):
        mid=(start+end)//2
        if (arr[mid]==k):
            return mid
        elif (arr[mid]<k):
            start=mid+1
        else:
            end=mid-1
    
    return -1

arr=[1,3,5,7,12,13,19]
k=5
print(binarySearch(arr,k))
