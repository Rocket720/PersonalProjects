import numpy as np
        
RANGE = 1000000

o = np.around(np.exp(np.sqrt(np.log(RANGE)*np.log(np.log(RANGE)))))
comparisons = 0

list=[]
for x in range(2,RANGE):
    list.append(x)

# print(list)

for x in range(len(list)-1):
        y=x+1
        while(y<len(list)):
            # print("Comparing indexes",x,"and",y)
            if(list[y]%list[x]==0):
                r = list.pop(y)
                # print("Removed",r)
                # print(list)
                comparisons+=1
                continue
            y+=1

print("There are",len(list), "prime numbers between 0 and", RANGE)
print("There were", comparisons, "comparisons made to find", len(list), "prime numbers" )