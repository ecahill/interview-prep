public class Mergesort {
	private int[] numbers;
	private int[] helper;

	public Mergesort(int[] numbers){
		this.numbers = numbers;
	}

	public void sort(){
		int length = numbers.length;
		this.helper = new int[length];
		mergesort(0, length-1);
	}

	public void mergesort(int low, int high){
		if (low < high){
			int middle = low + (high-low)/2;
			mergesort(low, middle);
			mergesort(middle+1, high);
			merge(low, middle, high);
		}
	}

	public void merge(int low, int middle, int high){
		for (int i = low; i <= high; i++){
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while(i <= middle && j <= high){
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			}
			else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
	}

	public static void main(String[] args) {
		int[] nums = {5, 10, 1, 3, 2, 7, 4, 9, 6};
		Mergesort ms = new Mergesort(nums);
		ms.sort();
		for (int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}