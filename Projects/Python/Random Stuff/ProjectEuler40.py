numbers = [str(i) for i in range(200_000)]

digits = []
for i in range(len(numbers)):
    digits += [int(d) for d in numbers[i]]

print(digits[1] * digits[10] * digits[100] * digits[1000] * digits[10000] * digits[100000] * digits[1000000])