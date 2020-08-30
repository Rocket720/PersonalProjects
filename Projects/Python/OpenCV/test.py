import cv2

cap = cv2.VideoCapture(0)
cap.set(3,1280)
cap.set(4,720)
cap.set(10,100)

while True:
    _, img = cap.read()
    cv2.imshow("LIVE", img)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break