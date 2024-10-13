import java.util.InputMismatchException;
import java.util.Scanner;

class CommentToLongException extends Exception {
    public CommentToLongException(String message) {
        super(message);
    }
}

public class CustomerFeedbackSystem {
    public static void main(String[] args) {

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
            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:
                        if (feedbackCounter < feedback.length) {
                            try {
                                while (feedbackRating[feedbackCounter] < 1 || feedbackRating[feedbackCounter] > 5) {
                                    System.out.println("Enter rating only from 1-5");
                                    feedbackRating[feedbackCounter] = scanner.nextInt();
                                }
                                if (feedbackRating[feedbackCounter] > 1 || feedbackRating[feedbackCounter] < 5) {
                                    System.out.println("Rating added");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Only numbers from 1-5 can be entered");
                                scanner.nextLine();
                                feedbackRating[feedbackCounter] = scanner.nextInt();
                            }
                            scanner.nextLine();
                            System.out.println("Enter Feedback");
                            feedback[feedbackCounter] = scanner.nextLine();
                            feedbackCounter++;
                            System.out.println("Feedback Added");
                        } else {
                            System.out.println("Feedback limit of 5 is reached");
                        }

                case 2:
                    System.out.println("Show Feedbacks");
                    for (int i = 0; i < feedbackCounter; i++) {
                        System.out.println("Feedback rating: " + feedbackRating[i]+ ", feedback comment: " + (feedback[i]));
                    }
                    if (feedbackCounter < feedback.length) {
                        System.out.println("No feedbacks added");
                    }
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 3);
        scanner.close();
    }
}






