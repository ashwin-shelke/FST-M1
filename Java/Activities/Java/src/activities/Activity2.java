package activities;

public class Activity2 {
	public static void main(String[] args) {
		int sum=0;
		int[]numbers = {10, 77, 10, 54, -11, 10};
		for (int i=0;i<numbers.length;i++) {
			if(numbers[i]==10) {
				sum=sum+numbers[i];
			}
		}
		if(sum==30) {
			System.out.println("Sum of value is:"+sum);
		}
	}

}
