def inputTest():
    inputValue = raw_input().split()
    n, k = int(inputValue[0]), int(inputValue[1])
    count = 0 
    for each in range(n):
        if(int(raw_input())% k == 0):
            count = count + 1
    return count
print inputTest()

        
