from math import *
from statistics import *

mass_gc = [36.4769, 36.4773, 36.4765]
mass_gcs = [57.8420, 57.8411, 57.8409]
mass_a = [59.1202, 59.1175, 59.1186]
temp = [23.9, 24, 24.1]
vol_t = [4.01, 3.95, 3.98]

mass_w = []
for x in range(3):
    mass_w.append(mass_a[x]-mass_gcs[x])
print("Mass of Water: ", mass_w)

dens_w = [0.9973240, 0.9972994, 0.9972747]
print("Density of Water: ", dens_w)

vol_w = []
for x in range(3):
    vol_w.append(mass_w[x]/dens_w[x])
print("Volume of Water: ", vol_w)

vol_s = []
for x in range(3):
    vol_s.append(vol_t[x]-vol_w[x])
print("Volume of Sample: ", vol_s)

mass_s = []
for x in range(3):
    mass_s.append(mass_gcs[x]-mass_gc[x])
print("Mass of Sample: ", mass_s)

dens_s = []
for x in range(3):
    dens_s.append(mass_s[x]/vol_s[x])
print("Density of Sample: ", dens_s)

print("\nStats: ")
print("Avg Densitiy: ", mean(dens_s))
# print("StDev Density: ", stdev(densities))