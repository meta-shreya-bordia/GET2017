package session2;

/**
 * @Class	Sorting
 * sort question text alphabetically
 * using comparable interface
 * */
public class Sorting {
	public static void sortQuestionsFromText(Questions[] question_object) {
		doQuickSort(question_object, 0, question_object.length);
	}

	public static void doQuickSort(Questions[] questions, int start, int end) {
		int pivotPoint;

		if (start < end) {
			pivotPoint = partition(questions, start, end);

			doQuickSort(questions, start, pivotPoint - 1);
			doQuickSort(questions, pivotPoint + 1, end);
		}
	}

	private static int partition(Questions[] questions, int start, int end) {
		Questions pivot;
		int endoflist;
		int mid = (start + end) / 2;

		swap(questions, start, mid);

		pivot = questions[start];
		endoflist = start;

		for (int scan = start + 1; scan <= end; scan++) {
			if (questions[scan].compareTo(pivot) < questions[start].compareTo(pivot)) {
				endoflist++;
				swap(questions, endoflist, scan);
			}
		}
		swap(questions, start, endoflist);
		return endoflist;
	}

	private static void swap(Questions[] questions, int startIndex, int endIndex) {
		Questions q = questions[startIndex];
		questions[startIndex] = questions[endIndex];
		questions[endIndex] = q;
	}
}	
		
/**		System.out.println("\nSorted Order Of Questions");
		
		for (int index = 0; index < question_object.length-1; index++) {
			for(int j= index+1; j < question_object.length; j++) {
				if(question_object[index].compareTo(question_object[j]) > 0)
			}
		}
		
	/**	System.out.println("\nQuestions before sorting");
		
		Iterator<Questions> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().question_text);
		}
		
		System.out.println("\nQuestions after sorting:");
		
		itr = list.iterator();
		int i = 1;
		while (itr.hasNext()) {
			String[] split_one = itr.next().question_text.split("\\. ");
			System.out.println("Q" + i + ". " + split_one[1]);
			i++;
		}
	}
}

/***
	public static void doQuickSort(Questions[] questions, int start, int end) {
		int pivotPoint;

		if (start < end) {
			pivotPoint = partition(questions, start, end);

			doQuickSort(questions, start, pivotPoint - 1);
			doQuickSort(questions, pivotPoint + 1, end);
		}
	}

	private static int partition(Questions[] questions, int start, int end) {
		Questions pivot;
		int endoflist;
		int mid = (start + end) / 2;

		swap(questions, start, mid);

		pivot = questions[start];
		endoflist = start;

		for (int scan = start + 1; scan <= end; scan++) {
			if (questions[scan].compareTo(pivot) < questions[start].compareTo(pivot)) {
				endoflist++;
				swap(questions, endoflist, scan);
			}
		}
		swap(questions, start, endoflist);
		return endoflist;
	}

	private static void swap(Questions[] questions, int startIndex, int endIndex) {
		Questions q = questions[startIndex];
		questions[startIndex] = questions[endIndex];
		questions[endIndex] = q;
	}
}
**/