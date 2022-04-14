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

# Searching problem

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
        
            
            
