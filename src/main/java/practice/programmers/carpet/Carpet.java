package practice.programmers.carpet;

import java.util.ArrayList;
import java.util.List;

public class Carpet {

	public static void main(String[] args) {
		
		System.out.println(doubleRectangle2(12, 3)[0]);
		System.out.println(doubleRectangle2(12, 3)[1]);

	}

	 // Output = {length, width}
	static int[] doubleRectangle(int outer, int inner) {
		int totalBlock = outer + inner;
		int totalSqrt = (int)Math.sqrt(totalBlock);
		while(totalBlock % totalSqrt != 0) {
			totalSqrt++;
		}
		int length = totalSqrt;
		int width = totalBlock/totalSqrt;
        int[] answer = new int[2];
        if(length >= width) {
        	answer[0] = length;
        	answer[1] = width;
        }else {
        	answer[1] = length;
        	answer[0] = width;
        }
        return answer;
	}
	
	
// && (x-2)*(y-2) == inner) 
	static int[] doubleRectangle2(int brown, int yellow) {
		if(yellow == 1) {
			return new int[] {3, 3};
		}
		List<YellowCarpet> YellowCarpets = new ArrayList<>();
		for(int yellowHeight = 1; yellowHeight <= yellow/2; yellowHeight++) {
			if(yellow%yellowHeight == 0) {
				YellowCarpets.add(new YellowCarpet(yellowHeight, yellow/yellowHeight));
			}
		}
		for(YellowCarpet i : YellowCarpets) {
			if(((i.height + 2) * (i.width + 2) - yellow) == brown) {
				int[] answer = {i.width + 2, i.height + 2};
				return answer;
			}
		}
		return null;
	}
	
}

class YellowCarpet {
	int height;
	int width;
	
	public YellowCarpet(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
}
