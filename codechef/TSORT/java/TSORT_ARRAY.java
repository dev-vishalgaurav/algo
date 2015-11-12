public class TSORT{
    public static void main(String[] args){
        int maxRange = 1000001;
        int[] list = new int[maxRange]
        int inputs = 
    }
}



maxValue = 1000001
inputValue = int(raw_input())
sortedList = [0] * maxValue
for each in range(inputValue):
    number =  int(raw_input())
    sortedList[number] = sortedList[number] + 1
printList = ""
for number in range(maxValue):
    while(sortedList[number] > 0):
        printList =  printList + str(number) + "\n"
        sortedList[number] = sortedList[number] - 1
print printList
        
