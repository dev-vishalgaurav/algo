def holesTest():
    inputValue = int(raw_input())
    for each in range(inputValue):
        print getHoles(raw_input())
def getHoles(string):
    holes = 0 
    holesArraySingle = "ADOPQR"
    holesArrayDouble = "B"
    for char in string:
        if(char in holesArrayDouble):
            holes = holes + 2
        elif(char in holesArraySingle ):
            holes = holes + 1
    return holes
holesTest()
