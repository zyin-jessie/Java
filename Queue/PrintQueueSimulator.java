package Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class PrintJob {
	 private int jobId;
	 private String documentName;
	 private int pages;
	 
	 public PrintJob(int jobId, String documentName, int pages) {
		 this.jobId = jobId;
		 this.documentName = documentName;
		 this.pages = pages;
	 }
	 
	 public int getJobId() {
		 return jobId;
	 }
	 public String getDocumentName() {
		 return documentName;
	 }
	 public int getPages() {
		 return pages;
	 }
	 public String toString() {
		 return "Job ID: " + jobId + ", Document: " + documentName + ", Pages: "
		 + pages;
	 }
}

class PrintQueue {
	 private Queue<PrintJob> queue = new LinkedList<>();
	 
	 public void addJob(PrintJob job) {
		 queue.offer(job);
	 }
	 
	 public PrintJob processJob() {
		 return queue.poll();
	 }
	 
	 public PrintJob peekNextJob() {
		 return queue.peek();
	 }
	 
	 public void displayAllJobs() {
		 
		 if (queue.isEmpty()) {
			 System.out.println("Queue is empty.");
		} else {
			 for (PrintJob job : queue) {
				 System.out.println(job);
			 }
		}
	}
}
public class PrintQueueSimulator {

	public static void main(String[] args) {
		PrintQueue queue = new PrintQueue();
		Scanner input = new Scanner(System.in);
		int options = 0;
		
		while (options != 5) {
			System.out.println("============================");
			System.out.println("1: Add print job to queue");
			System.out.println("2: Process print Job");
			System.out.println("3: Show next job");
			System.out.println("4: Display all jobs in queue");
			System.out.println("5: Exit");
			System.out.println("============================");
			System.out.print("Choose number [1-5]: ");
			options = input.nextInt();
			input.nextLine(); 
			
			switch (options) {
				case 1:
			 		System.out.print("Job ID: ");
			 		int jobId = input.nextInt();
			 		
			 		System.out.print("Document Name: ");
			 		String documentName = input.next();
			 		
			 		System.out.print("Number of pages: ");
			 		int pages = input.nextInt();
			 		
			 		System.out.println("");
			 		PrintJob job = new PrintJob(jobId, documentName, pages);
			 		queue.addJob(job);
			 		
			 		System.out.println("Added job: " + job);
			 		break;
			 	case 2:
			 		PrintJob processedJob = queue.processJob();
			 		 if (processedJob != null) {
			 			 System.out.println("Processed job: " + processedJob);
		 			 } else {
		 				 System.out.println("No jobs to process.");
		 			 }
			 		break;
			 	case 3:
			 		 PrintJob nextJob = queue.peekNextJob();
			 		 
			 		 if (nextJob != null) {
			 			 System.out.println("Next job: " + nextJob);
			 		 } else {
			 			 System.out.println("No jobs in the queue.");
			 		 }
			 		 break;
			 	case 4:
			 		 queue.displayAllJobs();
			 		 break;
			 	case 5:
			 		 System.out.println("Exit");
			 		 break;
			 	default:
			 		 System.out.println("Invalid Input");
			 }
		}
		input.close();
	}
}
		 
