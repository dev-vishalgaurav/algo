/**
 * https://www.interviewbit.com/problems/gas-station/
 */
public class Solution {
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
	  if(gas == null || cost == null || gas.size() != cost.size() || gas.size() == 0) return -1;
      int prevRemaining = 0, remaining = 0, total = 0, start = 0;
      for(int i = 0; i<gas.size(); i++){
           remaining = (gas.get(i) - cost.get(i));
           if(prevRemaining >= 0){
               prevRemaining += remaining;
           }else{
               prevRemaining = remaining;
               start = i;
           }
           total += remaining;
       }
       if(total >=0) return start;
       return -1;
	}
	/**
	 * Editorial 
	 */
	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
	    if(gas == null || cost == null || gas.size() != cost.size() || gas.size() == 0) return -1;
        int n = gas.size(), sumGas = 0, sumCost = 0, start = 0, tank = 0;
        for (int i = 0; i < n; i++) {
            sumGas += gas.get(i);
            sumCost += cost.get(i);
            tank += gas.get(i) - cost.get(i);
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return (sumGas < sumCost ) ? -1 : start%n;
	}
}
