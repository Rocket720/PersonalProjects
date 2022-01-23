from time import perf_counter

n = 1000

#Iterative Method
start = perf_counter()
switches = [False for _ in range(n)]

for i in range(2, n):
    for j in range(i, n, i):
        switches[j] = not switches[j]
        
for k in range(n):
    print("O" if switches[k]==False else "|", end=" ")

print("\nTime taken for Iterative Method: " + str(perf_counter() - start))

#Factor Method
start = perf_counter()

def factorMethod(n):
    factors = 0
    for f in range(1,n):
        if n%f==0:
            factors+=1
    return factors%2==1

switches = [factorMethod(num) for num in range(n)]
for k in range(n):
    print("O" if switches[k]==False else "|", end=" ")
    
FactorTime = perf_counter() - start
print("\nTime taken for Iterative Method: " + str(perf_counter() - start))
