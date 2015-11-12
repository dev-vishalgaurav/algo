def atmWithdrawal():
    inputValue = raw_input().split()
    withdrawal, amount = float(inputValue[0]), float(inputValue[1])
    if(withdrawal % 5 == 0  and withdrawal < (amount - 0.5)):
        print "%.2f" %(amount - withdrawal - 0.5)
    else:
        print "%.2f" % amount
