import json
import re
import urllib.request
import webbrowser

api_key = "cAmgbVyKaw43yBx9UOmCpwFAR4RxEzzwQ8DFebJY"



#APOD
apodLink = "https://api.nasa.gov/planetary/apod?api_key=" + api_key
rawData = json.loads(urllib.request.urlopen(apodLink).read())
imageURL = rawData["hdurl"]
title = rawData["title"]
exp = rawData["explanation"]

print(rawData)
print()
print(title + ": " + imageURL)
print(exp)
webbrowser.open(imageURL)

#Earth
# earthLink =  "https://api.nasa.gov/planetary/earth/assets?lon=41.05&lat=73.69&date=2018-01-01&&dim=0.10&api_key=" + api_key
# #rawData = json.loads(urllib.request.urlopen(earthLink).read())
# print(earthLink)
# #imageURL = rawData["url"]
# webbrowser.open(imageURL)





