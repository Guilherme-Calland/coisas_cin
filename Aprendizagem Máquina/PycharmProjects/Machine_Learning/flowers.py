import csv
import random
import math
import operator

"""
# se quiser visualizar o conjunto de treinamento

with open('iris.txt', 'rt') as csvfile:
    lines = csv.reader(csvfile)
    for row in lines:
        print(', '.join(row))
"""


# dividir agora em conjunto de treinamento e conjunto de teste
# HOLD OUT
def loadDatasetHoldOut(filename, split, trainingSet = [], testSet = []):
    with open(filename, 'rt') as csvfile:
        lines = csv.reader(csvfile)
        dataset = list(lines)
        for x in range(len(dataset)-1):
            for y in range(4):
               dataset[x][y] = float(dataset[x][y]) #talvez transformar string em float
            if random.random() < split:
                trainingSet.append(dataset[x])
            else:
                testSet.append(dataset[x])


def euclidianDistance(instance1, instance2, length):
    distance = 0
    for x in range(length):
        distance += pow((instance1[x] - instance2[x]), 2)
    return math.sqrt(distance)

"""""
# testar distancia euclidiana
data1 = [2, 2, 2, 'a']
data2 = [4, 4, 4, 'b']
distance = euclidianDistance(data1, data2, 3)
print("Distance: " + repr(distance))
"""""

# KNN
def getNeighbors(trainingSet, testInstance, k):
    distances = []
    length = len(testInstance) - 1
    for t in range(len(trainingSet)):
        dist = euclidianDistance(testInstance, trainingSet[t], length)
        distances.append((trainingSet[t], dist))  # metodo append adiciona algo ao final da lista
    distances.sort(key=operator.itemgetter(1))  # sort (arruma) as distancias em ordem
    neighbors = []
    for x in range(k):
        neighbors.append(distances[x][0])  #arruma em x linhas
    return neighbors

"""""
# testar getNeighbors
trainSet = [[2, 2, 2, 'a'], [4, 4, 4, 'b']]
testInstance = [5, 5, 5]
k = 1
neighbors = getNeighbors(trainSet, testInstance, 1)
print(neighbors)
"""
# retorna a classe prevista
def getResponse(neighbors):
    classVotes = {}
    for x in range(len(neighbors)):
        response = neighbors[x][-1]
        if response in classVotes:
            classVotes[response] += 1
        else:
            classVotes[response] = 1
    sortedVotes = sorted(classVotes.items(), key=operator.itemgetter(1), reverse=True)
    return sortedVotes[0][0]
"""
# teste getResponse FUNCIONA
neighbors = [[1,1,1,'a'], [2,2,2,'w'], [3,3,3,'b'], [4, 4, 4,'w']]
response = getResponse(neighbors)
print(response)
"""
def getAccuracy(testSet, predictions):
    correct = 0
    for x in range(len(testSet)):
        if testSet[x][-1] == predictions[x]:
            correct += 1
    return(correct/float(len(testSet))) * 100.0

"""
# testar getAccuracy
testSet = [[1, 1, 1, 'a'], [2, 2, 2, 'a'], [3, 3, 3, 'b']]
predictions = ['a', 'a', 'w']
accuracy = getAccuracy(testSet, predictions)
print(accuracy)
"""

def loadDataset(filename, trainingSet = [], testSet = []):
    with open(filename, 'rt') as csvfile:
        lines = csv.reader(csvfile)
        dataset = list(lines)
        for x in range(len(dataset)-1):
            for y in range(4):
               dataset[x][y] = float(dataset[x][y]) #talvez transformar string em float
            if x <= 0 & x < (len(dataset)-1)/10:
                testSet[x] = dataset[x]
            else:
                trainingSet[x] = dataset[x]

def main():
    # prepare data

    trainingSet = []
    testSet = []
    split = 0.67
    loadDatasetHoldOut('iris.txt', split, trainingSet, testSet)
    print("Train set: " + repr(len(trainingSet)))
    print("Test set: " + repr(len(testSet)))
    # generate predictions

    # loadDataset('iris.txt', trainingSet, testSet)
    predictions = []
    k = 3
    for x in range(len(testSet)):
        neighbors = getNeighbors(trainingSet, testSet[x], k)
        result = getResponse(neighbors)
        predictions.append(result)
       # print("> predicted = " + repr(result) + ", actual = " + repr(testSet[x][-1]))
    accuracy = getAccuracy(testSet, predictions)
    print("Accuracy: " + repr(accuracy) + "%")

main()
