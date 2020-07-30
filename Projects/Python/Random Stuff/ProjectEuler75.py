x = 6
list = [[[]]]
for c in range(x):
    print("c:" + str(c))
    for a in range(c):
        print("a:" + str(a))
        for b in range(a):
            print("b:" + str(b))
            sum = a + b + c
            if (pow(c, 2) == (pow(a, 2) + pow(b, 2)) and sum < x):
                list[sum] += [a, b, c]
                print(a + " " + b + " " + c)

print(list)
