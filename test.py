import math 
import random
# class ThreeDPoint:     
#     def __init__(self,x,y,z):         
#         self.x=x         
#         self.y=y         
#         self.z=z     
#     def dist(self,p2):         
#         x=self.x-p2.x         
#         y=self.y=p2.y         
#         z=self.z=p2.z         
#         return math.sqrt(x**2+y**2+z**2)     
#     def closest(self,lp):         
#         dl=[]         
#         for p in lp:             
#             dl.append(p)        

#         minval = dl[0]
#         index = 0
#         for x in range(len(dl)-1):             
#             if(dl[x]<minval):                 
#                 minval=dl[x]   
#                 index = x      
                         
#         return lp[index]

# p=ThreeDPoint(0,0,0) 
# d=p.dist(ThreeDPoint(2,3,6)) 
# print(d)

# name=input("Enter a name: \n")
# age=input("Enter your age: \n")
# color=input("Enter your favorite color: \n")
# funfact=input("Enter a fun fact: \n")
# print("Hi my name is " , name , ". I am " , age , " years old. My favorite color is " , color , ". " , funfact)

# x = int(input())
# if(x%2==0):
#     print("Even")
# else:
#     print("Odd")

# while(True):
#     #Handles User inputs
#     x= 0
#     o="+"
#     y=1

#     #Handles Math Logic
#     if(True):
#         pass

#     #Loop Controller
#     if(False):
#         pass

# import random

# bo = int(input("Best of how many rounds? (Needs to be an odd number) "))
# uwin = 0
# cwin = 0

# while(True):
#     comp = int(random.random()*3) #RPS Random Generator

#     #Number to RPS Conversion
#     if(comp==0):
#         comp="Rock"
#     elif(comp==1):
#         comp="Paper"
#     elif(comp==2):
#         comp="Scissors"

#     #User Input
#     user=input("Choose 'Rock', 'Paper', or 'Scissors'")

#     #Game Logic
#     if(user=="Rock" and comp=="Paper"):
#         cwin+=1
#     elif(user=="Rock" and comp=="Scissors"):
#         uwin+=1
#     elif(user=="Paper" and comp=="Rock"):
#         uwin+=1
#     elif(user=="Paper" and comp=="Scissors"):
#         cwin+=1
#     elif(user=="Scissors" and comp=="Rock"):
#         cwin+=1
#     elif(user=="Scissors" and comp=="Paper"):
#         uwin+=1
    
#     #Score Printing
#     print("Score: \n- User: ", uwin , "\n Computer: " , cwin)
    
#     #Best Of logic
#     if(uwin==(bo/2 + 0.5)):
#         print("User WINS!!!!!!!!")
#         break
#     elif(cwin==(bo/2 + 0.5)):
#         print("Computer WINS! You are bad at this game and you should feel ashamed, you worthless peice of trash. I bet you like killing turtles and wasting oxygen.")
#         break











#Normal Triangle
# size = 10
# for x in range(size):
#     for y in range(x):
#         print("*", end = " ")
#     print()

#Upside Down
# size = 10
# for x in range(size):
#     for y in range(size-x):
#         print("*", end = " ")
#     print()

#vertical mirror
# size = 10
# for x in range(size):
#     for y in range(size-x):
#         print(" ", end=" ")
#     for y in range(x):
#         print("*", end = " ")
#     print()

#corner mirror
# size = 10
# for x in range(size):
#     for y in range(x):
#         print("_", end = " ")
#     for y in range(size-x):
#         print("*", end=" ")
#     print()


# size = 10
# #Top Half
# for x in range(size):
#     #II
#     for y in range(size-x):
#         print("_", end=" ")
#     for y in range(x):
#         print("*", end = " ")
    
#     #I
#     for y in range(x):
#         print("*", end = " ")
#     print()

# #Bottom Half
# for x in range(size):
#     #III
#     for y in range(x):
#         print("_", end = " ")
#     for y in range(size-x):
#         print("*", end=" ")

#     #IV
#     for y in range(size-x):
#         print("*", end = " ")
#     print()

# cabinet = [[" "," "," "],
#            [" "," "," "],
#            [" "," "," "]]

# while(True):
#     for x in range(len(cabinet)):
#         for y in range(len(cabinet[0])):
#             print(cabinet[x][y], end = " | ")
#         print()

#     choice = input("Would you like to place or remove an item? ")
#     if(choice=="place"):
#         item = input("What item would you like to place")
#         s = int(input("Which shelf?"))-1
#         p = int(input("Which position"))-1
#         cabinet[s][p] = item
#     elif(choice=="remove"):
#         s = int(input("Which shelf?"))-1
#         p = int(input("Which position"))-1
#         cabinet[s][p] = " "

# plural = input("Enter a plural noun: ")
# adjective1 = input("Enter an adjective: ")

# print("Our ", plural," are packed for a hike in the ", adjective1," mountains")

#Numbers
# Equals: "==" Compares two values and returns True or False based on if they are equal.
# Less Than: "<" Compares two values and returns True or False based on if the left variable is less than the right variable
# Less Than or Equal to: "<=" Compares two values and returns True or False based on if the left variable is less than or equal to the right variable
# Greater Than: ">" Compares two values and returns True or False based on if the left variable is greater than the right variable
# Greater Than or Equal to: ">=" Compares two values and returns True or False based on if the left variable is greater than or equal to the right variable

#Boolean operators
# "and": takes two boolean expression on the left and right and returns true if both are "True" and false otherwise
# "or": takes two boolean expression on the left and right and returns true if at least one expression is "True" and false if both are false
# "not": switches the value of a boolean expression



# def size(self, node):
#     if(node.getLeft()==None and node.getRight()==None):
#         return 1
#     elif(node.getLeft()==None):
#         return 1 + self.size(node.getRight())
#     elif(node.getRight()==None):
#         return 1 + self.size(node.getLeft())
#     else:
#         return self.size(node.getRight()) + self.size(node.getLeft())

# guess = -1
# while(not guess==number):
#     guess = int(input("Guess a number 0-99"))
#     if(guess>number):

#     elif(guess<number):
    
#     elif(guess==number):


# guess = 0
# while(not guess == number):
#     if(guess>number):
#         print("guess lower")
        

# print("Hello my name is ",name)
# print("I am ", age, " years old")

board = [["*","*","X"],
         ["*","X","*"],
         ["X","*","*"]]

for y in range(board[0]):
    count = 0
    for x in range(board):
        if(board[x][y]==player):
            count+=1
    if(count==3):
        print(player, " wins")
        game = False

count = 0
for p in range(len(board)):
    if(board[p][p]==player):
        count+=1
if(count==3):
        print(player, " wins")
        game = False






