#Q20
print("<<Q20>>")

import re

data = """
hsymyth@naver.com
hsymyth@google.com
hsymyth@google.com
"""
a = re.compile(".*[@].*[.](?!net$).*$", re.MULTILINE)
print(a.findall(data))


