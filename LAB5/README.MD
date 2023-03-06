Below is an encryption/decryption standard in which the letters in the message will be replaced with the letters in the cypher row

-----------------------------------------------------------
PLAIN |A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|
------------------------------------------------------------
CYPHER |X|Y|Z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|
------------------------------------------------------------

Plaintext:  THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG

Ciphertext: QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD

You are supposed to create a menu-driven program that can encrypt or decrypt a message that the user wishes to transfer.
Your program should have two functions, one for encryption and another for decryption. Each function will accept a string message and return the encrypted or decrypted message.


EXPLAINATION OF THE PROGRAM:
The main function first displays a menu with options for encryption and decryption. It then reads the user's choice and input message using the Scanner class.

The encrypt function takes the input message and maps each letter to its corresponding cipher letter using the 2D array. It then returns the encrypted message.

The decrypt function takes the encrypted message and maps each letter to its corresponding plain letter using the 2D array. It then returns the decrypted message.

In the main function, if the user selects encryption, it calls the encrypt function and displays the encrypted message. If the user selects decryption, it calls the decrypt function and displays the decrypted message. If the user enters an invalid choice, it displays an error message and exits the program.

Overall, the code is a simple implementation of a substitution cipher using a 2D array in Java.

