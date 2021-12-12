package SaturdaySection;

import java.util.Arrays;

public class August_14th {

	public static void main(String[] args) {
		
		int[] a = {1,2,3,2,3}; 
		Arrays.stream(solution(a)).forEach(System.out::println);


	}
	
	public static int[] solution(int[] prices) {
	    
        int lengthCount = prices.length;
        int[] answer = new int[lengthCount];
        
        for(int i = 0; i < answer.length; i++){
            int count = 0;
            
            for(int j = i+1; j < answer.length; j++){
                count++;
               if(prices[i] > prices[j]) {
            	   break;
               }
            }
            answer[i] = count;
        }
        return answer;
    }

}
