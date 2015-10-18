import random
def printMultiplicationTable(tableUpto, lastMultiple):
    rowCount = 1 
    while(rowCount <= lastMultiple):
        columnCount = 1
        print(getMultiplicationRow(rowCount,tableUpto))
        rowCount = rowCount + 1
        

def getMultiplicationRow(rowNumber, lastColumn):
    columnCount = 1
    rowString = ""
    while(columnCount <= lastColumn):
        rowString = rowString + str(rowNumber * columnCount) + "\t"
        columnCount = columnCount + 1
    return rowString


def find(str,ch,index):
    while(index < len(str)):
        if str[index] == ch:
            return index
        index = index + 1
    return -1


def findAll(str,ch,startIndex):
    firstIndex = find(str,ch,startIndex)
    if(firstIndex == -1):
        return
    else:
        print(firstIndex)
        findAll(str,ch,firstIndex + 1)

def getRandomDistribution(listSize,numOfBuckets):
    bucketArray = [0]*numOfBuckets
    for eachCount in range(listSize):
        newRandom = random.random()
        index = int(newRandom * numOfBuckets)
        if(index < 0):
            index = 0
        elif(index >= numOfBuckets):
            index = numOfBuckets
        bucketArray[index] = bucketArray[index] + 1 
    print(bucketArray)
    return bucketArray

def printGraphOfDistribution(resultArray, distributionSize):
    import string
    for number in resultArray:
        count = int(number / distributionSize)
        print(getStringOfChars("*",count))

def getStringOfChars(displayChar,size):
        printString = ""
        for char in range(size):
            printString = printString + displayChar
        return printString
previous = {0:0, 1:1} 
def fibonacci(n):
    if(previous.__contains__(n)):
        return previous[n]
    else:
        print("fibonacci of " + str(n))
        newValue = fibonacci(n-1) + fibonacci(n-2)
        previous[n] = newValue
        return newValue
        
def fibonacciFor(n):
    first,fibo = 1,0
    for count in range(n):
        first,fibo = fibo,first + fibo
    return fibo
    
def getSumOfEvenFibonaccis(maxValue):
    sumAll = 0
    fibo = 0
    count = 0
    while(fibo <= maxValue):
        fibo = fibonacciFor(count)
        if(fibo % 2 == 0 ):
            sumAll = sumAll + fibo
        count = count + 1
    return sumAll

def isNumberPrime(number):
    import math
    factorCount, maxRangeOfFactor = 0, int(math.sqrt(number))
    factor  = maxRangeOfFactor
    if(number > 1):
        while(factor > 0 ):
            if(number%factor == 0):
                factorCount = factorCount + 1
            factor = factor - 1
            if(factorCount > 1):
                break
    return factorCount == 1
def getLargestPrimeFactor(number):
    import math
    checkUpto = int(math.sqrt(number))
    factorTrack = checkUpto
    largestFactor = -1 
    while(factorTrack > 0 ):
        if((number % factorTrack == 0) and isNumberPrime(factorTrack)):
            largestFactor = factorTrack
            break
        factorTrack = factorTrack -1
    return largestFactor

def isNumberPalindrome(number):
    return str(number)==str(number)[::-1]
def isFactorInRange(number,lower, higher):
    count = higher 
    while(count >= lower):
        if((number % count == 0) and ((number/count) >= lower) and ((number/count) <= higher)):
            return True
        count = count - 1

def largestPalendromeForRange(lower,higher):
    largestNumber = higher*higher
    while(largestNumber > lower*lower):
        if(isNumberPalindrome(largestNumber) and isFactorInRange(largestNumber,lower,higher)):
            return largestNumber
        largestNumber = largestNumber - 1
def largestPalendromeFor3Digit1():
    firstLoop = 999
    secondLoop = 999
    while(firstLoop >= 100):
        while (secondLoop >= 100):
            print(str(firstLoop) + " * "  + str(secondLoop))
            multi = firstLoop * secondLoop
            if(isNumberPalindrome(multi)):
                return multi
            secondLoop = secondLoop - 1
        secondLoop = 999
        firstLoop = firstLoop - 1

def getMaxMultipler(number,maxRange):
    multi = number
    while((multi*number) <= maxRange):
        multi = multi * number
    return multi
def getSmallestNumberDivisibleByAll(upto):
    import math
    counter,number =  1, 1
    while (counter < upto):
        if(isNumberPrime(counter)):
            number = number * getMaxMultipler(counter,upto)
        counter = counter + 1
    return number
#n*(n+1)/2
def getSumOfNaturalNumbers(maxRange):
    return (maxRange * (maxRange + 1))/2
#n*(n+1)(2n+1)/6
def getSumOfSquaresOfNaturalNumbers(maxRange):
    return ((maxRange) * (maxRange + 1) * ((2*maxRange) + 1))/6
def getSquaresDiff(maxRange):
    return int(((getSumOfNaturalNumbers(maxRange)**2) - getSumOfSquaresOfNaturalNumbers(maxRange)))
def getNthPrimeNumber(n):
    count,tracker,lastPrime = 0,2,0
    while(count<n):
        if(isNumberPrime(tracker)):
            count = count + 1
            lastPrime = tracker
        tracker = tracker + 1
    return lastPrime
def getLargestMultiplication(number,digitRange):
    multiplication, start,end = 0, 0, digitRange
    numberInString = str(number)
    length = len(numberInString)
    while(end < length):
        split = numberInString[start:end]
        end,start,localMulti =  end + 1,start + 1,1
        if("0" in split):
            localMulti = 0
            continue
        for number in split:
            localMulti = int(number) * localMulti
        if(multiplication < localMulti):
            multiplication = localMulti
    return multiplication

def getPythagoreanTripletsWhoseSumisIs(totalSum):
    hypo = totalSum - 1
    while (hypo > 1):
        firstSide = hypo - 1
        while(firstSide > 1):
            secondSide = (totalSum - (firstSide + hypo))
            if((secondSide > 0) and (hypo**2 == (firstSide**2 + secondSide**2))):
                return hypo * firstSide * secondSide
            firstSide = firstSide - 1 
        hypo = hypo - 2 #hypotaneous is always odd

