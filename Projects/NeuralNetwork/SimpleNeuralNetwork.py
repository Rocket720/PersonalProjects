import numpy as np
from sympy import *


def sigmoid(n):
    return 1 / (1 + np.exp(-n))


def NN(m1, m2, w1, w2):
    z = m1 * w1 + m2 * w2
    return sigmoid(z)


def evaluate(inputs, weights):
    layers = [inputs]
    for i in range(len(weights)):
        layers.append(sigmoid(np.dot(layers[i], weights[i])))
    return layers[-1]


def cost(o, e):
    return (o - e) ** 2


def c_slope(o, e):
    return 2 * (o - e)


if __name__ == '__main__':
    LAYERS = [2, 2, 1]  # Makes an array of the nodes in each layer

    weights = []  # Generates random weights for connection
    for i in range(len(LAYERS) - 1):
        weights.append(2 * np.random.random((LAYERS[i], LAYERS[i + 1])) - 1)

    m1 = 3  # Length
    m2 = 1.5  # Width
    w1 = w2 = b = 1
    realColor = 0  # 0-1 Red to Blue
    for i in range(1000):
        guess = NN(m1, m2, w1, w2)
        w1 = w1 - 0.1 * cost(guess, realColor)
        w2 = w2 - 0.1 * cost(guess, realColor)
        b = b - 0.1 * cost(guess, realColor)
        # b = b - .1 * slope(b, 16)
        print(guess)
    print(str(w1) + "w1 " + str(w2) + "w2 " + str(b) + "b ")
