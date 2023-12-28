public class Student {
    private String name;
    private int[] grades;
    
    // Constructor to initialize the student's name
    public Student(String name) {
        this.name = name;
        this.grades = new int[0]; // Initializing an empty array for grades
    }
    
    // Method to add a grade to the student's grades array
    public void addGrade(int grade) {
        int[] newGrades = new int[grades.length + 1];
        System.arraycopy(grades, 0, newGrades, 0, grades.length);
        newGrades[grades.length] = grade;
        grades = newGrades;
    }
    
    // Method to calculate the average grade of the student
    public double calculateAverageGrade() {
        if (grades.length == 0) {
            return 0.0; // Return 0 if there are no grades
        }
        int total = 0;
        for (int grade : grades) {
            total += grade;
        }
        return (double) total / grades.length;
    }
    
    // Method to get the grade status of the student
    public String getGradeStatus() {
        double averageGrade = calculateAverageGrade();
        return (averageGrade >= 60) ? "Pass" : "Fail";
    }

    public static void main(String[] args) {
        // 1.1 Create an object of the Student class with the name "John" and add grades
        Student john = new Student("John");
        john.addGrade(80);
        john.addGrade(75);
        john.addGrade(90);
        john.addGrade(85);
        
        // 1.2 Iterate through the student's grades array and calculate total grade points
        int totalGradePoints = 0;
        for (int grade : john.grades) {
            totalGradePoints += grade;
        }
        System.out.println("Total Grade Points: " + totalGradePoints);
        
        // 1.3 Count the number of occurrences of the letter 'l' in the string "Hello, World!"
        String text = "Hello, World!";
        int letterLCount = 0;
        for (char ch : text.toCharArray()) {
            if (ch == 'l') {
                letterLCount++;
            }
        }
        System.out.println("Number of occurrences of 'l': " + letterLCount);
        
        // 1.4 Create an array called numbers and calculate the sum of the numbers
        int[] numbers = {5, 10, 15, 20, 25};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum of numbers: " + sum);
    }
}
