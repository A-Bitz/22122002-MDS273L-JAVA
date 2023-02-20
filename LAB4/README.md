Lab 4

Create a new folder 'Lab 4', in your repository that will hold today's program, README.md.

Todays Program

Write a JAVA Menu driven program that does the following:
You can ONLY have the below variables as global variables
Account Number
Account Holder Name
Account Balance
You MUST have the below as functions
To initialize the customer
To deposit money
To withdraw money
To print the transactions
To print account summary
Your menu will have the following operations once the customer is created
To deposit money
To withdraw money
To print the transactions
To print account summary

Algorithm

1.	Declare a class called BankAccount with the following global variables: accountNumber, accountHolderName, accountBalance, transactionList, transactionCount.
2.	Define a method called initializeCustomer which takes in the following parameters: accountNumber, accountHolderName, initialDeposit.
3.	Inside initializeCustomer, set the accountNumber, accountHolderName, and accountBalance global variables to their respective parameters.
4.	Create a transactionList array of size 100 and set transactionCount to 0.
5.	Add the initialDeposit to the transactionList and increment transactionCount.
6.	Define a method called depositMoney which takes in the following parameter: amount.
7.	Add the amount to the accountBalance.
8.	Add the amount to the transactionList and increment transactionCount.
9.	Define a method called withdrawMoney which takes in the following parameter: amount.
10.	Check if amount is greater than accountBalance. If it is, print "Insufficient Balance". If not, subtract amount from accountBalance.
11.	Add the negative amount to the transactionList and increment transactionCount.
12.	Define a method called printTransactions.
13.	Print "Transaction History:".
14.	Iterate through the transactionList array and for each element, check if it is positive or negative. If it is positive, print "Deposited: " and the value of the element. If it is negative, print "Withdrawn: " and the absolute value of the element.
15.	Define a main method.
16.	Create an instance of the BankAccount class.
17.	Create a Scanner object for user input.
18.	Prompt the user to enter their account number, name, and initial deposit.
19.	Call initializeCustomer with the user's input.
20.	Enter a do-while loop to display the menu options.
21.	Prompt the user to select an option.
22.	Use a switch statement to execute the corresponding method based on the user's selection: depositMoney, withdrawMoney, printTransactions, or exit.
23.	If the user selects an invalid option, print "Invalid Option. Try again."
24.	Continue looping until the user selects exit.




