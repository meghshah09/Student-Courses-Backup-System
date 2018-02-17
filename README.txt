
Assignment 1 - Student Course Backup System is Solely done by Megh Shah (B00715432) and have tried my best to keep the code easy to understand and flexible for future use.

--------------------------------------------------------------------------

## To clean:
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.
-----------------------------------------------------------------------
## To compile: 
ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## I used this to run my code
ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<path>/input.txt -Darg1=<path>/delete.txt -Darg2=<path>/output1.txt -Darg3=<path>/output2.txt -Darg4=<path>/output3.txt

Description: Will run the program with above line of code ONLY. Also, Note it will just take fileName input as input.txt, delete.txt,output1.txt,output2.txt and output3.txt
If files are inside studentCoursesBackup/.... (which also has src folder), then <path> = ./<fileName>
input.txt and delete.txt Files should be present in the mention directory. (empty files will be fine but if the files are not present Program will not execute).
It will be fine if you do not have output1.txt, output2.txt, output3.txt in the directory as long as you mention in the arguments.
(It will create with the given file name at given directory)

-----------------------------------------------------------------------

## Created tarball for submission with following command.

tar -cvf Megh_Shah_assign1.tar Megh_Shah_assign_1/
gzip Megh_Shah_assign_1.tar

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.ù"

[Date: 2/13/2108]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

1) HashSet - used for maintaing the courses. Avoids duplicates Data
	Time Complexity - The underlying data structure for HashSet is hashtable.
	So, (average or usual case) time complexity for add, remove and look-up operation of HashSet takes O(1) time.

2) ArrayList - Used for Storing the fileData line by line and also for mainting the list of observers attached to particular node.
		Worst Case Time Complexity - O(1) for adding a element in a list. O(n) for removal of data from array list since we go through each element.
		Getting an element from Array List take O(1).
 
3) Binary Search Tree - Maintains the Student Records. Each Node Consists of Data(int) and Courses(HashSet) for storing the information of the students.
		Time Complexity - BST takes O(log n) in Average Case for Searching, Insertion and Deletion and O(n) in Worst Case for insertion, Searching and Deletion.
		BST Provides Sorted Array when we do Inorder Traversal.

		Justification - First, Getting the best Performance is not the ultimate goal in Programing. So, even if AVL or other tree gives better performance and consumed less
		less space then BST, if it's more complicated. More Complicated code takes longer to write , harder to understand and more likely to contain bugs and will be error prone.
		Now, if i compare AVL tree with simple binary search tree (BST) without balancing, then AVL will consume more memory 
		(each node has to remember its balance factor) and each operation can be slower (because you need to maintain the balance factor and sometimes perform rotations).
		And AVL tree and BST have Same Average Case Time Complexity. So if there is a trade off between Worst case and Complextiy in Understanding/Implementation. I choosed
		BST, Since i am not sure whether Worst case will even happen or not but what i am sure is that AVL tree will be difficult to Extend Futher.  
		Similar Average Case and Simplicity in coding and Understanding made me to choose to BST over AVL.

4) Observer Pattern - Observer Pattern is used in this Assignment Mainly for two purposes.
			a) Insertion of Course in already Existing Node.(BU_ID)
			b) Deletion of Course from a Node (particular BU_ID)

5) Have choosed Iterative Method for insertion, deletion and searching the node. Mainly because as per my knowledge recursive method are expensive and hard to understand for someone
	who is not familiar with this system.

-----------------------------------------------------------------------

list of citations (urls, etc.) from where you have taken code

For Binary Search Tree (insert , Find , Delete Function) references of this particular code was used :
https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/ 
