import numpy as np

class NeuralNetwork:
    
    def __init__(self, i, h1, h2, o):
        this.inputs=i
        this.hidden1=h1
        this.hidden2=h2
        this.output=o

        this.weights_ih1 = np.array(2*np.random.random(h1, i)-1)
        this.bias_ih1 = np.array(2*np.random.random(h1)-1)
        this.weights_h1h2 = np.array(2*np.random.random(h2, h1)-1)
        this.bias_h1h2 = np.array(2*np.random.random(h2)-1)
        this.weights_h2o = np.array(2*np.random.random(o, h2)-1)
        this.bias_h2o = np.array(2*np.random.random(o)-1)
        
        this.learning_rate = 0.1

    def sigmoid(self, x):
        return 1/(1+np.exp(-x))

    def sigmoid_derivative(self, x):
        return x * (1-x)    
        
    def feedforward(self, data):

        

    