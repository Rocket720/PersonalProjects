import pygame
from pygame import mouse
from pygame import draw
import random
import math

pygame.init()
pygame.display.set_caption("Cursor Tracker")

WIDTH, HEIGHT = 1280, 720

screen = pygame.display.set_mode((WIDTH,HEIGHT)) # create a surface on screen that has the size of 1280 x 720
pygame.mouse.set_visible(False)
target = (WIDTH/2, HEIGHT/2)
target_size = 100
targets_hit = 0
font = pygame.font.Font("freesansbold.ttf", 32)
clock = pygame.time.Clock()
t0 = pygame.time.get_ticks()

MODE = "strafeTrack"

# define a variable to control the main loop
running = True
    
# main loop
while running:
    pos = mouse.get_pos()
    #print(pos)

    #Claculate distance
    dist = ((pos[0]-target[0])**2+(pos[1]-target[1])**2)**0.5


    if(MODE == "reflexShot"):
        #Draws targets
        if(dist<=target_size/2):
            target_size = random.randint(10,200)
            target = (random.randint(int(target_size/2), int(WIDTH-target_size/2)), random.randint(int(target_size/2), int(HEIGHT-target_size/2)))
            targets_hit+=1
        draw.ellipse(screen, pygame.Color(255, 0, 0), pygame.Rect(target[0]-(target_size/2), target[1]-(target_size/2), target_size, target_size))

    elif(MODE == "strafeTrack"):
        target_size = 100
        angle_to_cursor = -math.atan2(-(target[1]-pos[1]),-(target[0]-pos[0]))
        print("Angle: ", math.degrees(angle_to_cursor), "\nDist: ", dist)
        step = 1 * (75/dist)
        target = (target[0] - step*math.cos(angle_to_cursor), target[1] + step*math.sin(angle_to_cursor))
       
        #Bounds 
        if (target[0]<=target_size/2):
            target = (target_size/2,target[1])
        elif (target[0]>=WIDTH-target_size/2):
            target=(WIDTH-target_size/2,target[1])    
        if (target[1]<=target_size/2):
            target=(target[0],target_size/2)
        elif(target[1]>=HEIGHT-target_size/2):
            target=(target[0],HEIGHT-target_size/2)



        draw.ellipse(screen, pygame.Color(255, 0, 0), pygame.Rect(target[0]-(target_size/2), target[1]-(target_size/2), target_size, target_size))

    


    #Draws crosshair
    # draw.aaline(screen, pygame.Color(0,0,255), (0,pos[1]), (WIDTH, pos[1]), 1)
    # draw.aaline(screen, pygame.Color(255,0,0), (pos[0], 0), (pos[0], HEIGHT), 1)
    draw.ellipse(screen, pygame.Color(0,255,0), pygame.Rect(pos[0]-10, pos[1]-10, 20, 20), 1)

    #F3 menu
    fps = font.render("FPS: " + str(int(clock.get_fps())), True, (255,255,255))
    screen.blit(fps, (0,0))
    score = font.render("Score: " + str(targets_hit), True, (255,255,255))
    screen.blit(score, (0,25))
    targets_per_sec = font.render("TPS: " + str(int(1000* targets_hit/(pygame.time.get_ticks()-t0))), True, (255,255,255))
    screen.blit(targets_per_sec, (0,50))

    
    clock.tick()

    pygame.display.update()
    screen.fill(pygame.Color(0,0,0))
    # event handling, gets all event from the event queue
    for event in pygame.event.get():
        # only do something if the event is of type QUIT
        if event.type == pygame.QUIT:
            # change the value to False, to exit the main loop
            running = False