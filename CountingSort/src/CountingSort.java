/**
 * Sort int array in O(n) 
 * Is faster that Java Sorter 
 * Class is singelton
 * 
 * @author Betaa
 *
 */
public class CountingSort {

	private static CountingSort instance = null;

	private CountingSort() {

	}

	public static CountingSort getInstance() {
		if (instance == null) {
			instance = new CountingSort();
		}
		return instance;
	}

	public int[] countingSort(int[] aList, int k) {
		int[] cList = new int[k + 1];
		int[] bList = new int[aList.length];

		for (int i = 0; i <= k; i++) {
			cList[i] = 0;
		}

		for (int j = 0; j < aList.length; j++) {
			cList[aList[j]] = cList[aList[j]] + 1;

		}
		for (int m = 1; m < cList.length; m++) {
			cList[m] = cList[m] + cList[m - 1];

		}

		for (int n = aList.length - 1; n >= 0; n--) {

			bList[cList[aList[n]] - 1] = aList[n];
			cList[aList[n]] = cList[aList[n]] - 1;
		}

		return bList;

	}

}
