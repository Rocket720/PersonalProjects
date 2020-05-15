def factorial(a):
    if a == 1:
        return 1
    else:
        return a * factorial(a - 1)


def fibonacci(a):
    if a == 1:
        return 1
    else:
        return a + fibonacci(a - 1)


x = int(input("Enter your number: "))
print(factorial(x))
