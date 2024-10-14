import java.util.InputMismatchException;
import java.util.Scanner;

class CommentTooLongException extends Exception {
    public CommentTooLongException(String message) {
        super(message);
    }
}

public class CustomerFeedbackSystem {
    public static int feedbackWordCounter(String feedback) {
        return feedback.trim().split("\\s+").length;
    }
    public static void main(String[] args) throws CommentTooLongException {
        String[] feedback = new String[5];
        int[] feedbackRating = new int[5];
        int feedbackCounter = 0;
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Customer Feedback System");
            System.out.println("1. Add Feedback");
            System.out.println("2. Show Feedbacks");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                    if (feedbackCounter < feedback.length) {
                        try {
                            while (feedbackRating[feedbackCounter] < 1 || feedbackRating[feedbackCounter] > 5) {
                                System.out.println("Enter rating from 1-5");
                                feedbackRating[feedbackCounter] = scanner.nextInt();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Only numbers from 1-5 can be entered");
                            scanner.nextLine();
                            feedbackRating[feedbackCounter] = scanner.nextInt();
                        }
                        scanner.nextLine();
                        System.out.println("Enter Feedback");
                        String userFeedback = scanner.nextLine();
                        int countedWords = feedbackWordCounter(userFeedback);
                        try {
                            if (countedWords > 5) {
                                throw new CommentTooLongException("");
                            }  else {
                                feedback[feedbackCounter] = userFeedback;
                                feedbackCounter++;
                            }
                            System.out.println("Feedback Added");
                        } catch (CommentTooLongException e) {
                            System.out.println("Comment cannot exceed 5 words. PLease try again.");
                        }
                    } else {
                        System.out.println("Feedback limit of 5 is reached");
                    }
                    break;

                case 2:
                    System.out.println("Show Feedbacks");
                    for (int i = 0; i < feedbackCounter; i++) {
                        System.out.println("Feedback rating: " + feedbackRating[i]+ ", feedback comment: " + (feedback[i]));
                    }
                    if (feedbackCounter == 0) {
                        System.out.println("No feedbacks added");
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, only  1-3 options are available");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }
}






