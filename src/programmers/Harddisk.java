package SaturdaySection;

import java.util.ArrayList;
import java.util.List;

public class Harddisk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int solution(int[][] jobs) {
		
		List<Job> jobList = new ArrayList<>();
		for(int i = 0; i<jobs.length; i++) {
			jobList.add(new Job(jobs[i][0], jobs[i][1]));
		}
		
		int startTime = 0;
		while(!jobList.isEmpty()) {
			List<Job> jobListSub = new ArrayList<Job>();
			for(int i = 0; i<jobList.size(); i++) {
				if(jobList.get(i).getRequestTime() <= startTime) {
					jobListSub.add(jobList.get(i));
				}
			}
		}
		return 0;
	}

}

class Job{
	private int requestTime;
	private int executingTime;
	
	public Job(int requestTime, int executingTime) {
		this.requestTime = requestTime;
		this.executingTime = executingTime;
	}
	public int getRequestTime() {
		return requestTime;
	}
	public int getExecutingTime() {
		return executingTime;
	}
	public void setRequestTime(int requestTime) {
		this.requestTime = requestTime;
	}
	public void setExecutingTime(int executingTime) {
		this.executingTime = executingTime;
	}
	
	
}
