# Insertion sort

def insertion_sort(arr) :
    for i in range(1, len(arr)) :
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key :
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = key

x = [1,5,4,7,50,15,3,35,72,9]
insertion_sort(x)
print(x)

# Reverse

def insertion_sort_reverse(arr) :
    
    for i in range(1, len(arr)) :
        key = arr[i]
        j = i - 1

        while j >= 0 and arr[j] < key :
            arr[j+1] = arr[j]
            j -= 1

        arr[j+1] = key

x = [1,5,4,7,50,15,3,35,72,9]
insertion_sort_reverse(x)
print(x)

# Linear search

def search(arr, x) :
    for i in arr :
        if arr[i] == x :
            return i
            break
        else :
            return "NIL"

# Binary addition

def binary_addition(arr1, arr2) :
    arr1.insert(0, 0)
    arr2.insert(0, 0)
    arr = [0] * len(arr1)
    plus = 0

    for i in reversed(range(len(arr1))) :
        if plus + arr1[i] + arr2[i] == 0 : arr[i] = 0; plus = 0
        elif plus + arr1[i] + arr2[i] == 1 : arr[i] = 1; plus = 0
        elif plus + arr1[i] + arr2[i] == 2 : arr[i] = 0; plus = 1
        else : arr[i] = 1 ; plus = 1

    return arr

arr1 = [1,0,0,0,0,1]
arr2 = [1,0,0,0,0,1]
print(binary_addition(arr1, arr2))

# Selection sort

def selection_sort(arr) :
    for i in range(len(arr)):

        for j in range(i+1, len(arr)):

            if arr[i] > arr[j] :
                arr.insert(0, arr[j])
                del arr[j+1]

arr = [5,44,3,52,331]
selection_sort(arr)
print(arr)
        
# Merge sort

def merge_sort(arr):
    
    if len(arr)>1:
        mid = len(arr)//2
        L = arr[:mid]
        R = arr[mid:]

        merge_sort(L)
        merge_sort(R)
        
        i=j=k=0       
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
                arr[k]=L[i]
                i += 1
            else:
                arr[k]=R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k]=L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k]=R[j]
            j += 1
            k += 1
    
x = [1,8,5,34,6,87,6,4,3,6,8]
merge_sort(x)
print(x)
