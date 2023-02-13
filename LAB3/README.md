Lab 3
Setup Details
By this time, I hope all of you will be able to pull the changes (if any from the GitHub site) and push the changes to GitHub after coding.
For lab 3, similarly, for other labs, you need to create a folder named "Lab 3," inside which you will have the code and the README.md documentation file.
Make sure you are using comments in the code and documenting the results, how to run the code, what the code is, what the constraints for your code are, the flow chart of the program, and making the document beautiful.
If not, you can modify the README.md files of the other labs' README.md files to make the documentation proper (It will also be considered for marking).

Try out GitHub code spaces for this lab !!

Todays Lab
Create a java program, that stores the details of a student (Name, Register Number, Email, Class, Department).
You can use a two-dimensional array to store the details.
HINT: String arr[] = {{"Alwin","1847207","alwin@christ.in","MCA","Computer Science"},{"Balagangadhar","2011204","bala@christ.in","MDS","Data Science"}}

You need to have functions to:
Collect the details of the student
Display the details of the student
Search the details of the student
With the help of a menu-driven main function, you need to access these functions inside your class and perform the operations.

Whenever you are entering the details of a student, you need to enter the value into a static global string array, that stores the names that the user has entered. Searching this array will help you to find if the details of the student are already entered into the program.

You will have a function to perform this search operation, which can be used to implement two functionality in the code
To check if the name is already entered
While searching for a name, you can identify the index of the two-dimensional array to print the details directly.
In the end, you will have
Four functions inside your lab program class including your main class
One static String array storing the names (note the program can store up to 1024 students)
One two-dimensional string array storing the details of up to 1024 students
A menu-driven main method implementing the functions and functionality
Plan your program with a flow chart before starting with coding.
Since you are using functions, plan what should be the returning values and how to implement them.




The above code is designed to store and manage the details of students using a two-dimensional string array. The program has a menu-driven main method that provides options to the user to collect, display, and search for student details. The program uses four functions to perform these operations:

1.collectStudentDetails(): This function collects the details of a student from the user and stores them in the two-dimensional array. The function checks whether the name of the student is already entered by searching the static global string array storing the names. If the name is not already entered, the function stores the details of the student in the two-dimensional array. If the name is already entered, the function displays a message indicating that the student details are already entered.

2.displayStudentDetails(): This function displays the details of a student based on the input from the user. The function calls the searchStudentDetails() function to find the index of the two-dimensional array where the details are stored. If the details are found, the function displays them on the screen. If the details are not found, the function displays a message indicating that the student details are not found.

3.searchStudentDetails(): This function searches for the details of a student based on the name, register number, email, class, or department entered by the user. The function searches the two-dimensional array and returns the index of the array where the details are stored. If the details are not found, the function returns -1.

4.isNameAlreadyEntered(): This function searches the static global string array storing the names of the students to check whether the name is already entered or not. If the name is already entered, the function returns true. If the name is not already entered, the function returns false.

When the program is executed, the main method displays a menu to the user. The user can select an option to collect, display, or search for student details. The program calls the appropriate function based on the user's input and performs the operation. The program repeats this process until the user chooses to exit the program.
