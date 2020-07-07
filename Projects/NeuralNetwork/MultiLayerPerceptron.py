import numpy as np

class NeuralNetwork:
    
    def __init__(self, structure): #structure[784, 64, 64, 10]
        # self.inputs=structure[0]
        # self.hidden1=h1
        # self.hidden2=h2
        # self.output=structure[len(structure)-1]

        self.weights = []
        self.bias = []

        for x in range(len(structure)-2):
            self.weights.append(np.array(2*np.random.random(structure[x+1], structure[x])-1)) #Generates weight matrix based on layers with values (-1,1)
            self.bias.append(np.array(2*np.random.random(structure[x+1])-1)) #Generates weight matrix based on layers with values (-1,1)
        
        self.learning_rate = 0.1

    def sigmoid(self, x):
        return 1/(1+np.exp(-x))

    def sigmoid_derivative(self, x):
        return x * (1-x)    
    
    def feedforward(self, data):

        

    
nn = NeuralNetwork([784, 64, 64, 10])

x, y = fetch_openml('mnist_784', version=1, return_X_y=True)
x = (x/255).astype('float32')
y = to_categorical(y)

x_train, x_val, y_train, y_val = train_test_split(x, y, test_size=0.15, random_state=42)
