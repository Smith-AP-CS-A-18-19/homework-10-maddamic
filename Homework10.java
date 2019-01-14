import java.util.ArrayList;

public class Homework10 {

	/* Finish the constructor and create any necessary instance
	 * variables. The constructor should create and save a
	 * 2D array of int values with the designated rows and
	 * columns
	 */
	 private int rr;
	 private int cc;

	int[][] arr;

	public Homework10(int rows, int cols) {
		rr = rows;
		cc = cols;
		arr = new int[rr][cc];
	}

	/* Fill the stored array with increasing values. The
	 * value at [0, 0] should be n, the value at [0, 1]
	 * should be n + 1, and so on, filling the array in
	 * row major order. Return the filled array
	 */
	public int[][] problem1(int n) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				arr[r][c] = n;
				n++;
			}
		}
		return arr;
	}

	/* Return row r of the stored array
	 */
	public int[] problem2(int r) {
		return arr[r];
	}

	/* Find and return the sum of the indicated cell and its
	 * four cardinal neighbors (up, down, left, right). Ensure
	 * you account for the possiblity of the cell not having one
	 * or more neighbors
	 */
	public int problem3(int r, int c) {
		int sum = arr[r][c];
		if (r + 1 < arr.length) {
			sum += arr[r + 1][c];
		}
		if (c + 1 < arr[r].length) {
			sum += arr[r][c + 1];
		}
		if (r - 1 > 0) {
			sum += arr[r - 1][c];
		}
		if (c - 1 > 0) {
			sum += arr[r][c - 1];
		}
		return sum;
	}

	/* Create and return an ArrayList that contains the
	 * elements from the indicated column
	 */
	public ArrayList<Integer> problem4(int c) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int r = 0; r < arr.length; r++) {
			list.add(arr[r][c]);
		}
		return list;
	}

	/* Calculate and return the sum of the integers in
	 * the supplied ArrayList
	 */
	public int problem5(ArrayList<Integer> aList) {
		int sum = 0;
		for (int i = 0; i < aList.size(); i++) {
			sum += aList.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		boolean passed = true;
		Homework10 hw10 = new Homework10(5, 7);

		int[][] arr2D = hw10.problem1(4);
		if (arr2D[3][3] == 28) {
			System.out.println("Pass 1");
		} else {
			System.out.println("Fail 1");
			passed = false;
		}

		int[] arr1D = {32, 33, 34, 35, 36, 37, 38};
		int[] prob2 = hw10.problem2(4);
		boolean p2p = true;
		if (prob2.length != arr1D.length) {
			p2p = false;
		} else {
			for (int i = 0; i < prob2.length; i++) {
				if (prob2[i] != arr1D[i]) {
					p2p = false;
				}
			}
		}
		if (p2p) {
			System.out.println("Pass 2");
		} else {
			System.out.println("Fail 2");
			passed = false;
		}

		if (hw10.problem3(2, 2) != 100) {
			System.out.println("Fail 3.1");
			passed = false;
		} else if (hw10.problem3(4, 0) != 90) {
			System.out.println("Fail 3.2");
			passed = false;
		} else {
			System.out.println("Pass 3");
		}

		ArrayList<Integer> al = hw10.problem4(4);
		if (al.get(2) == 22) {
			System.out.println("Pass 4");
		} else {
			System.out.println("Fail 4");
			passed = false;
		}

		int p5 = hw10.problem5(al);
		if (p5 == 110) {
			System.out.println("Pass 5");
		} else {
			System.out.println("Fail 5");
			passed = false;
		}

		if (passed) {
			System.out.println("All Pass");
		} else {
			System.out.println("Fail");
		}

	}
}
