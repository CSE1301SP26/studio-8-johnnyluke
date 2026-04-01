package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	private Question[] questions;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		 int total = 0;

        for (Question q : questions) {
            total += q.getAnswer().length();
        }

        return total;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		Scanner scanner = new Scanner(System.in);
        int totalPoints = 0;

        for (Question q : questions) {
            q.displayPrompt();

            String userAnswer = getUserAnswer(scanner);

            int points = q.checkAnswer(userAnswer);

            System.out.println("Points earned: " + points);

            totalPoints += points;
        }

        System.out.println("You have earned " + totalPoints +
                " out of " + getTotalPoints() + " points.");

        scanner.close();
    }
	
	
	public static void main(String[] args) {
		// Create questions array
        Question[] questions = new Question[3];

        // Question 1: Multiple Choice
        questions[0] = new MultipleChoiceQuestion("What is the capital of France?","2",1,new String[]{"Berlin", "Paris", "Rome", "Madrid"});

        // Question 2: Multiple Choice
        questions[1] = new MultipleChoiceQuestion("What is 5 + 3?","3",1,new String[]{"6", "7", "8", "9"});

        // Question 3: Select All
        questions[2] = new SelectAllQuestion("Which of the following are colors?","14",new String[]{"Red", "Dog", "Car", "Blue"});

        // Create quiz
        Quiz quiz = new Quiz(questions);
	}
}
