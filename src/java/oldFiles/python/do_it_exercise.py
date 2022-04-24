# Q1
print("<<Q1>>")

x = 'a:b:c:d'
print('#'.join(x.split(':')))

# Q2
print("<<Q2>>")

a = {'A': 90, 'B':80}
a['C'] = 70
print(a['C'])

# Q3
print("<<Q3>>")

a = [1,2,3]
print(id(a))
a += [4, 5]
print(id(a))
a = a + [4, 5]
print(id(a))

b = [1,2,3]
print(id(b))
b.extend([4, 5])
print(id(b))

# Q4
print("<<Q4>>")

A = [20, 55, 67, 82, 45, 33, 90, 87, 100, 25] ; y = 0
while A :
    a = A.pop()
    if a >= 50 : y += a

print(y)

# Q5
print("<<Q5>>")

def pibo(x) :
    arr = [0, 1]
    while arr[-1] <= x :
        arr.append(arr[-2] + arr[-1])
    del arr[-1]
    return arr

print(pibo(15))

# Q6
print("<<Q6>>")

x = map(int, input().split(','))
y = 0
for i in x : y += i
print(y)

#Q7
print("<<Q7>>")

print('Enter number : ', end = ' ')
x = int(input())
for i in range(1, 10) :
    print(x*i, end = ' ')
print()

#Q8
print("<<Q8>>")

f_r = open("abc.txt", "r")
lines = f_r.readlines()
print(lines)
f_r.close()


f_w = open("abc.txt", "w")
for i in reversed(range(0, len(lines))) :
    f_w.write(lines[i])
f_w.close()

f_r = open("abc.txt", "r")
while True :
    line = f_r.readline()
    if not line : break
    print(line)

#Q9
print("<<Q9>>")

f_r = open('sample.txt', 'r')
arr = []
while True :
    line = f_r.readline()
    if not line : break
    arr.append(line)
f_r.close()

sum = 0
for i in arr :
    sum += int(i)
average = str(sum/len(arr))

f_w = open('result.txt', 'w')
f_w.write(average)
f_w.close()

#Q10
print("<<Q10>>")

class Calculator() :
    def __init__(self, arr) :
        self.arr = arr
        
    def setdata(self, arr) :
        self.arr = arr

    def sum(self) :
        y = 0
        for i in self.arr : y += i
        return y

    def avg(self) :
        return sum(self.arr)/len(self.arr)

cal1 = Calculator([1,2,3,4,5])
cal2 = Calculator([6,7,8,9,10])
print(cal1.sum())
print(cal1.avg())
print(cal2.sum())
print(cal2.avg())

#Q11
print("<<Q11>>")
# import module
# from module import function
# from module import function1, function2
# from module import*
#import sys
# sys.path.append("C:/.../module")
# import module
# set PYTHONPATH="C:/.../folder"
# import module

#Q12
print("<<Q12>>")

result = 0
try :
    [1,2,3][3]
    "a" + 1
    4/0
except TypeError:
    result += 1
except ZeroDivisionError:
    result += 2
except IndexError:
    result += 3
finally:
    result += 4

print(result)

#Q13
print("<<Q13>>")

def DashInsert(x):
    k = 0
    for i in range(len(x)-1):
        x = list(x)
        a1 = int(x[i+k]) ; a2 = int(x[i+k+1])
        if a1%2 == 0 and a2%2 == 0:
            x.insert(i+k+1, '*')
            k += 1
        elif a1%2 == 1 and a2%2 == 1:
            x.insert(i+k+1, '-')
            k += 1

    y = ''
    for i in x :
        y += i

    return y

x = '4546793'
print(DashInsert(x))

#Q14
print("<<Q14>>")

def condense(x) :
    x += '0'
    arr = []
    k = 1
    for i in range(len(x)-1) :
        if x[i] == x[i+1] :
            k += 1
        else :
            arr.append(x[i])
            arr.append(str(k))
            k = 1

    y = ''
    for i in arr :
        y += i
    return y

print(condense('aaabbcccccca'))

#Q15
print("<<Q15>>")

def dupli_find(x) :
    x = list(str(x))
    for i in range(len(x)) :
        a = x.pop(i)
        if a in x :
            return False
        else :
            return True

print(dupli_find('012345679'))
        
#Q16
print("<<Q16>>")

def morse(x) :
    morse = {'.-' : 'A',
             '-...' : 'B',
             '-.-.' : 'C',
             '-..' : 'D',
             '.' : 'E',
             '..-.' : 'F',
             '--.' : 'G',
             '....' : 'H',
             '..' : 'I',
             '.---' : 'J',
             '-.-' : 'K',
             '.-..' : 'L',
             '--' : 'M',
             '-.' : 'N',
             '---' : 'O',
             '.--.' : 'P',
             '--.-' : 'Q',
             '.-.' : 'R',
             '...' : 'S',
             '-' : 'T',
             '..-' : 'U',
             '...-' : 'V',
             '.--' : 'W',
             '-..-' : 'X',
             '-.--' : 'Y',
             '--..' : 'Z',
             '' : ' '}
    x = x.split(' ')
    a = []
    for i in x:
        a.append(morse.get(i))
    y =''
    for i in a :
        y += i
    return y

print(morse('.... .  ... .-.. . . .--. ...  . .- .-. .-.. -.--'))

#Q17
print("<<Q17>>")

import re

p = re.compile('a[.]{3,}b') # . in [] is literal
p.match('acccb')
p.match('a....b')
p.match('aaab')
p.match('a.cccb')

#Q18
print("<<Q18>>")

p = re.compile("[a-z]+")
m = p.search("5 python")
print(m.group())
print(m.span())
print(m.start())
print(m.end()) # since python do not count the last index

#Q19
print("<<Q19>>")

data = """
park 010-9999-9988
kim 010-9909-7789
lee 010-8789-7768
"""

a = re.compile(r"(\d{3})[-](\d{4})[-]\d{4}$", re.MULTILINE)
print(a.sub("\g<1>-\g<2>-****", data))

#Q20
print("<<Q20>>")

data = """
hsymyth@naver.com
hsymyth@google.com
hsymyth@google.com
"""
a = re.compile(".*[@].*[.](?!net$).*$", re.MULTILINE)
print(a.findall(data))

