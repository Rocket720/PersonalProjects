from mpl_toolkits import mplot3d
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import cm
from matplotlib.ticker import LinearLocator, FormatStrFormatter
import openpyxl

fig = plt.figure()
ax = fig.gca(projection="3d")
#plt.show()

X = np.arange(-5, 5, 0.25)
Y = np.arange(-5, 5, 0.25)
X, Y = np.meshgrid(X, Y)
Z = np.sqrt(X**2 + Y**2)

surf = ax.plot_surface(X,Y,Z, cmap = cm.coolwarm, linewidth=0, antialiased=False)

plt.show()