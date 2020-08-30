import json
import re
import urllib.request

api_key = ""
channel_id = "UC-lHJZR3Gqxm24_Vd_AJ5Yw"

jsonLink = "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=" + channel_id + "&key=" + api_key
rawData = urllib.request.urlopen(jsonLink).read()
subs = json.loads(rawData)["items"][0]["statistics"]["subscriberCount"]
views = json.loads(rawData)["items"][0]["statistics"]["viewCount"]

# print(jsonLink)
print("Subscribers: " + subs + "\nViews: " + views)

