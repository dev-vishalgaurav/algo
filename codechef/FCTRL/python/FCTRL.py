def fctrlZeros():
    inputValue = int(raw_input())
    for each in range(inputValue):
        number =  int(raw_input())
        count = 0 
        while number > 0 :
            count = count + int(number / 5)
            number = int(number/5)
        print count
fctrlZeros()

        
