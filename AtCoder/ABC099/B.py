x = input().split()
a = int(x[0])
b = int(x[1])
c = sum([a for a in range(b-a+1)])
print(c-b)
