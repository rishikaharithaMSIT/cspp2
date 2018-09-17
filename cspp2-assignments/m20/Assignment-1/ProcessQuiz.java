import java.util.Scanner;

class ProcessQuiz {
	/**
	 * Loads questions.
	 *
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public void loadQuestions(final Scanner scan,
									 final Quiz quiz, final int q) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		int noOfInputs = q;
		final int three = 3;
		final int four = 4;
		final int five = 5;
		if ( q <= 0) {
			System.out.println("Quiz does not have questions");
			return;
		}
		while (noOfInputs > 0) {
			String line = scan.nextLine();
			String[] questions = line.split(":");
			String[] choices = questions[1].split(",");

			// String exceptions = checkExceptions(
			//     questions[0], choices,
			//     Integer.parseInt(questions[2]),
			//     Integer.parseInt(questions[3]),
			//     Integer.parseInt(questions[4]));
			// if(exceptions != null) {
			//  System.out.println(exceptions);
			//  return;
			// }
			if (questions.length != five) {
				System.out.println("Error! Malformed question");
				return;
			}
			if (choices.length <= 1) {
				System.out.print("trick question  does not ");
				System.out.print("have enough answer choices");
				System.out.println();
				return;
			}
			if (Integer.parseInt(questions[2]) < 1
					||  Integer.parseInt(questions[2]) > four) {
				System.out.print("Error! Correct answer choice number is ");
				System.out.print("out of range for question text 1");
				System.out.println();
				return;
			}
			if (questions[0].equals("")) {
				System.out.println("Error! Malformed question");
				return;
			}
			if (Integer.parseInt(questions[three]) < 0) {
				System.out.println("Invalid max marks for " + questions[0]);
				return;
			}
			if (Integer.parseInt(questions[four]) > 0) {
				System.out.println("Invalid penalty for " + questions[0]);
				return;
			}
			Question question = new Question(
				questions[0], choices,
				Integer.parseInt(questions[2]),
				Integer.parseInt(questions[three]),
				Integer.parseInt(questions[four]));
			quiz.addQuestion(question);

			noOfInputs--;
		}
		System.out.println(q + " are added to the quiz");


	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public void startQuiz(final Scanner scan,
								 final Quiz quiz, final int q) {
		// write your code here to display the quiz questions on the console.
		// read the user responses from the console using scanner object.
		// store the user respone in the question object
		int noOfChoices = 0;
		try {
			while (noOfChoices < q) {
				String line = scan.nextLine();
				String[] responses = line.split(" ");

				Question ques = quiz.getQuestion(noOfChoices);
				ques.setResponse(responses[1]);

				System.out.println(ques.getQuestionText() + "(" +
								   ques.getMaxMarks() + ")");
				for (int i = 0; i < ques.getChoice().length - 1; i++) {
					System.out.print(ques.getChoice()[i] + "	");
				}
				System.out.print(ques.getChoice()
								 [ques.getChoice().length - 1]);
				System.out.println();
				System.out.println();
				noOfChoices++;
			}
		} catch (Exception e) {
			return;
		}
	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.
		int totalScore = 0;
		int noOfQuestions = quiz.getSize();
		for (int i = 0; i < noOfQuestions; i++) {
			Question ques = quiz.getQuestion(i);
			System.out.println(ques.getQuestionText());
			String[] choice = ques.getChoice()
							  [ques.getCorrectAnswer() - 1].split(" ");
			//System.out.println(choice[1] + "-" + ques.getResponse());
			if (choice[1].equals(ques.getResponse())) {
				totalScore += ques.getMaxMarks();
				System.out.println(" Correct Answer! - Marks Awarded: "
								   + ques.getMaxMarks());
			} else {
				totalScore += ques.getPenalty();
				System.out.println(" Wrong Answer! - Penalty: "
								   + ques.getPenalty());
			}
		}
		if (noOfQuestions != 0) {
			System.out.println("Total Score: " + totalScore);
		}


	}
}