def recur_insert(arr) :
    if len(arr) != 1 :
        a = arr[-1] ; print(a)
        arr = arr[:-1] ; print(arr)
        recur_insert(arr)
    else :
        


x = [1,3,6,2,4,5]
recur_insert(x)


    
        
        
