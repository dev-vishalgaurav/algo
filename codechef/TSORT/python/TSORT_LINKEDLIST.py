class LinkedItem:
    def __init__(self,item,nextItem = None):
        self.item = item
        self.nextItem = nextItem
class LinkedList:
    head = None
    item = None
    def __inti__(self,head = None):
        self.head = head
    
def turboSort():
    inputValue = int(raw_input())
    sortedList = LinkedList()
    for each in range(inputValue):
        number =  int(raw_input())
        addToList(number,sortedList)
    printList(sortedList)
def printList(items):
    currentItem = items.head
    printList = ""
    while(currentItem != None):
        printList =  printList + str(currentItem.item) + "\n"
        currentItem = currentItem.nextItem
    print printList
    
def addToList(number,items):
    currentItem = items.head
    prevItem = None
    stop = False
    while(currentItem != None and not stop):
        if(currentItem.item >= number):
            stop = True
        else:
            prevItem = currentItem
            currentItem = currentItem.nextItem

    newItem = LinkedItem(number)
    if(prevItem == None) :
        newItem.nextItem = items.head
        items.head = newItem
    else:
        newItem.nextItem = currentItem
        prevItem.nextItem = newItem

turboSort()

        
