import os

dir = "C:\\Users\\am680\\Downloads\\GOT Season 7"
for filename in os.listdir(dir):
    print(filename)
    name = "GOT S" + filename[18:19] + "E" + filename[21:22] + ".mkv"
    print(name)
    os.rename(os.path.join(dir, filename), name)
