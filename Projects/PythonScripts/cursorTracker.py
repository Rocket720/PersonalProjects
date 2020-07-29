import pygame

pygame.init()
pygame.display.set_caption("CursorBeGone")
# create a surface on screen that has the size of 240 x 180
screen = pygame.display.set_mode((1280,720))
     
# define a variable to control the main loop
running = True
     
# main loop
while running:
    
    
    # event handling, gets all event from the event queue
    for event in pygame.event.get():
        # only do something if the event is of type QUIT
        if event.type == pygame.QUIT:
            # change the value to False, to exit the main loop
            running = False