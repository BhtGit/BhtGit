import logging

x = 123
y = 321
if x == y:
    print(x)
else:
    print(y, x)
s = '0123456789'
print(s[2:6:3])
print(s * 2)
print('a' + 'b', 'c')

list1 = [1, 2, 3]
list2 = [4, 6, 7]
list3 = list1 + list2
list4 = [list1, list2]
print(list1)
print(list2)
print(list3)
print(list4)
list1[0] = 0
print(list1)
print(list3)
print(list4)
print(4 not in list1)
print(4 in list3)

dictionary = {"x": 1, 'y': 2}
dictionary['z'] = 3
dictionary.setdefault('a', 5)
print(dictionary)
print(dictionary.get('x'))
print(dictionary['x'])

print(2 ** 3)

print(not True or True)


def function1(parameter):
    print(parameter)
    return


parameter1 = 'wtf'
parameter2 = 321
function1(parameter1)
function1(parameter2)
function1(dictionary)


def function2(*parameters):
    for parameter in parameters:
        if parameter == 3:
            print('asd')
            break
        print(parameter)
    return


print(function2('a', 'b', 'c', 3))

try:
    inputStr = input("快nm输入：")
    num1 = 1
    str1 = '2'
    print(inputStr)
    inputStr += str1
    print(inputStr)
    print(int(inputStr) + num1)
except ValueError as err:
    logging.exception(err)

