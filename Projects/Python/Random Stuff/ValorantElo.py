import webbrowser
import pyautogui
import time

webbrowser.open('http://127.0.0.1:5000', new=1, autoraise=True)
time.sleep(.5)
pyautogui.click(x=418, y=537)
time.sleep(.1)
pyautogui.click(x=949, y=793)
    
    