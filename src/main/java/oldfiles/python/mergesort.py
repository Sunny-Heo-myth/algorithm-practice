def merge_sort(arr) :
    if len(arr) > 1 :
        mid = len(arr)//2
        L = arr[:mid]
        R = arr[mid:]
        merge_sort(L)
        merge_sort(R)
    
        i = 0
        j = 0
        k = 0
        while i < len(L) and j < len(R) :
            if L[i] < R[j] :
                arr[k] = L[i]
                i += 1
            else :
                arr[k] = R[j]
                j += 1
            k += 1
            
        while i < len(L) :
            arr[k] = L[i]
            i += 1
            k += 1
        
        while j < len(R) :
            arr[k] = R[j]
            j += 1
            k += 1

x = [5, 9, 2, 4, 3, 6, 7, 1, 8, 0, 30, 20, 33, 0, 2, 213]
merge_sort(x)
print(x)
