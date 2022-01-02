def insertion_sort(x) :
    for i in range(1, len(x)) :
        key = x[i]
        j = i-1
        while j>=0 and x[j] > key:
            x[j+1] = x[j]
            j -= 1
        x[j+1] = key

y = []
len = int(input())
for _ in range(len) : y.append(int(input()))
insertion_sort(y)
for i in y : print(i)
