import cv2

cap = cv2.VideoCapture(0)
cap.set(3,1280) #Sets Width
cap.set(4,720) #Sets Height
# cap.set(5, 60) #Sets Frame Rate
# cap.set(10,100) #Sets Brightness

while True:
    _, img = cap.read()
    cv2.imshow("LIVE", img)
    if cv2.waitKey(1) == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()