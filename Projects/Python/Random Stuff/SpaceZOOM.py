import pygame
from pygame import mouse
from pygame import draw
import random
import math

pygame.init()
pygame.display.set_caption("Space Zoom")

WIDTH, HEIGHT = 1280, 720
screen = pygame.display.set_mode((WIDTH,HEIGHT)) # create a surface on screen that has the size of 1280 x 720
pygame.mouse.set_visible(True)

stars = []
for x in range(100):
    stars.append([[WIDTH/2, HEIGHT/2], random.random()*2*math.pi])


running = True
while (running):

    speed = mouse.get_pos()[0]/WIDTH

    for x in  range(len(stars)):
        star = stars[x]

        draw.ellipse(screen, pygame.Color(255,255,255), pygame.Rect(star[0][0], star[0][1], 1, 1))

        star = [[star[0][0] - speed*math.cos(star[1]), star[0][1] + speed*math.sin(star[1])], star[1]]

        if(star[0][0]<=0 or star[0][0]>=WIDTH or star[0][1]<=0 or star[0][1]>=HEIGHT):
            star = [[WIDTH/2,HEIGHT/2], random.random()*2*math.pi]

        stars[x] = star
    
    
    pygame.display.update()
    screen.fill(pygame.Color(0,0,0))
    # event handling, gets all event from the event queue
    for event in pygame.event.get():
        # only do something if the event is of type QUIT
        if event.type == pygame.QUIT:
            # change the value to False, to exit the main loop
            running = False
