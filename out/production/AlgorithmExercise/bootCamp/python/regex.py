import re

# EXERCISE 0
print("<<<<EXERCISE 0>>>>")

data = """
Heo 920713-1090612
Liz 990212-2013041
"""

pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******", data))

# .  : [^\n]
# \d : [0-9]
# \D : [^0-9]
# \s : [\t\n\r\f\v]
# \S : [^\t\n\r\f\v]
# \w : [a-zA-Z0-9_]
# \W : [^a-zA-Z0-9_]
# ^  : from head
# $  : from tail
# \A : from head for entire string
# \Z : from tail for entire string
# \b : boundary with whitespace
# \B : boundary with ^whitespace

# EXERCISE 1
print("<<<<EXERCISE 1>>>>")

hello = """Hello. My name is Sunny Heo. I am musician, mathmatician, physicist and warp drive engineer.
"""

intro1 = re.compile("Hello")
print(1, intro1.match(hello))
print(2, intro1.search(hello))
print(3, intro1.findall(hello))
print(4, intro1.finditer(hello))

intro2 = re.compile("[Hello]")
print(5, intro2.match(hello))
print(6, intro2.search(hello))
print(7, intro2.findall(hello))
print(8, intro2.finditer(hello))

# EXERCISE 2
print("<<<<EXERCISE 2>>>>")

p = re.compile('[a-z]+')
print(1, p.match('python'))
print(2, p.match('3 python'))
print(3, p.search('python'))
print(4, p.search('3 python'))



# EXERCISE 3
print("<<<<EXERCISE 3>>>>")

p = re.compile('[a-z]+')
print(1, p.findall("life is too short"))
print(2, p.finditer("life is too short"))
x = p.finditer("life is too short")
for i in x :
    print(i)

# EXERCISE 4
print("<<<<EXERCISE 4>>>>")

p = re.compile('[a-z]+')
m = p.match('python')
print(1, m.group())
print(2, m.start())
print(3, m.end())
print(4, m.span())

print(5, re.compile('[a-z]+').match('python').group())
# print(6, re.compile('[a-z]+').match(hello).group())
# AttributeError: 'NoneType' object has no attribute 'group'
print(7, re.compile('[a-z]+').search(hello).group())
print(8, re.compile('[a-zA-z]+').match(hello).group())

# EXERCISE 5
print("<<<<EXERCISE 5>>>>")

p = re.compile('[a-z]+')
m = p.match('python')
# print(0, m.group())
# AttributeError: 'NoneType' object has no attribute 'group'
m = p.search('3 python')
print(1, m.group())
print(2, m.start())
print(3, m.end())
print(4, m.span())

# EXERCISE 6
print("<<<<EXERCISE 6>>>>")

p = re.compile('a.b')
m = p.match('a\nb')
print(m)

print(1, re.compile('a.b', re.DOTALL).match('a\nb').group())
print(2, re.compile('[a-z]', re.IGNORECASE).match('python').group())
print(3, re.compile('[a-z]', re.IGNORECASE).match('PYTHON').group())

# EXERCISE 7
print("<<<<EXERCISE 7>>>>")

data = """python one
life is too short
python two
you need python
python three"""

print(1, re.compile("^python\s\w+").findall(data))
print(2, re.compile("^python\s\w+", re.MULTILINE).findall(data))

# .  : [^\n]
# \d : [0-9]
# \D : [^0-9]
# \s : [\t\n\r\f\v]
# \S : [^\t\n\r\f\v]
# \w : [a-zA-Z0-9_]
# \W : [^a-zA-Z0-9_]
# ^  : from head
# $  : from tail
# \A : from head for entire string
# \Z : from tail for entire string
# \b : boundary with whitespace
# \B : boundary with ^whitespace

# EXERCISE 8
print("<<<<EXERCISE 8>>>>")

charref = re.compile(r'&[#](0[0-7]+|[0-9]|x[0-9a-fA-F]+);')
charref = re.compile(r"""
&[#]                    # Start of a numeric entity reference
(
    0[0-7]+             # Octal form
    |[0-9]+             # Decimal form
    |x[0-9a-fA-f]+      # Hexadecimal form
)
;                       # Trailing semicolon
""", re.VERBOSE)

print(re.compile(charref).match("7777"))

# EXERCISE 9
print("<<<<EXERCISE 9>>>>")

p = re.compile('\\\\section')
p = re.compile(r'\\section')

# EXERCISE 10
print("<<<<EXERCISE 10>>>>")

print(re.compile('Crow|Servo').match('CrowHello'))

# EXERCISE 11
print("<<<<EXERCISE 11>>>>")

data = """python one
life is too short
python two
you need python
python three"""
print(1, re.compile('^Life').match('Life is too short'))
print(2, re.compile('^Life').match('My Life'))
print(3, re.compile("^python", re.MULTILINE).findall(data))
print(4, re.compile("three$").search(data))
print(5, re.compile("\Apython").search(data))
print(6, re.compile("\Zthree").search(data))
print(7, re.compile(r'\bclass\b').search('No class at all'))
print(8, re.compile(r'\Bclass\B').search('No class at all'))

# EXERCISE 12
print("<<<<EXERCISE 12>>>>")

print(1, re.compile('(ABC)+').search('ABCABCABC OK?'))
print(2, re.compile(r"\w+\s+\d+[-]\d+[-]\d+").search("park 010-1234-1234"))
print(3, re.compile(r"(\w+)\s+\d+[-]\d+[-]\d+").search("park 010-1234-1234").group(1))
print(4, re.compile(r"(\w+)\s+(\d+[-]\d+[-]\d+)").search("park 010-1234-1234").group(2))
print(5, re.compile(r"(\w+)\s+(\d+)[-](\d+[-]\d+)").search("park 010-1234-1234").group(2))
print(6, re.compile(r"\w+\s+\d+[-]\d+[-]\d+").search("park 010-1234-1234"))
print(7, re.compile(r"(?P<name>\w+)\s+\d+[-]\d+[-]\d+").search("park 010-1234-1234").group('name'))
print(8, re.compile(r"(?P<word>\b\w+)\s+(?P=word)").search('Paris in the the spring').group())
print(9, re.compile(r"(\b\w+)\s+\1").search("Paris is in the the spring"))

# EXERCISE 13
print("<<<<EXERCISE 13>>>>")

print(1, re.compile(".+(?=:)").search("http://www.google.com").group())
print(2, re.compile(".*[.].*$").search("file.net").group())
print(3, re.compile(".*[.][^b].*$").search("file.tar").group())
print(4, re.compile(".*[.]([^b]..|.[^a].|..[^t])$").search("file.bar").group())
print(5, re.compile(".*[.]([^b]..|.[^a].|..[^t])$").search("file.bar").group())
print(6, re.compile(".*[.]([^b].?.?|.[^a]?.?|..?[^t]?)$").search("file.bar").group())
print(7, re.compile(".*[.](?!bat$).*$").search("file.bar").group())
print(8, re.compile(".*[.](?!bat$|exe$).*$").search("file.bar").group())

# EXERCISE 14
print("<<<<EXERCISE 14>>>>")

print(1, re.compile('(blue|white|red)').sub('colour', 'blue socks and red shoes', count = 1))
print(2, re.compile(r'(?P<name>\w+)\s+(?P<phone>(\d+)[-](\d+)[-]\d+)').sub("\g<phone>\g<name>", "park 010-1234-1234"))

def hexrepl(match) :
    value = int(match.group())
    return hex(value)

print(3, re.compile(r"\d+").sub(hexrepl, "Call 65490 for printing, 49152 for user code."))

# EXERCISE 15
print("<<<<EXERCISE 15>>>>")

s = '<html><head><title>Title<\title>'

print(1, re.compile('<.*>').match(s).span())
print(2, re.compile('<.*?>').match(s).span())
