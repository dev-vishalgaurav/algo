def fctrlTest():
    inputValue = int(raw_input())
    for each in range(inputValue):
        number =  int(raw_input())
        print getFactorial(number)
def getFactorial(number):
    factorial = 1
    for eachNumber in range(2,number+1):
        factorial = factorial * eachNumber
    return factorial
fctrlTest()

        
