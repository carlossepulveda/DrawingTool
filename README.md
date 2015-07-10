# DrawingTool
A simple drawing tool.

#How does it work?
You have to create a input file where you will specify each command that you want execute over a canvas. A "painter"
object is responsible of reading the commands and depending on type of command, the painter select a processor
which it is responsible of validate and execute the command. After executing each command, the "painter" use a 
"printer" object for printing the output in a file.

<b>Painter</b> = Responsible of general managing<br/>
<b>Commands</b> = Encapsulate commands lines<br/>
<b>Processors</b> = Execute commands<br/>
<b>Printer</b> = Responsible of printing the data in file<br/>

###Type of commands
<b>Create command</b> = It initializes a new canvas. For instance "C 20 4"<br/>
<b>Line command</b> = It creates a line. For instance "L 1 2 6 2"<br/>
<b>Rectangle command</b> = It creates a rectangle. For instance "R 16 1 20 3"<br/>
<b>Bucket command</b> = Bucket fill out . For instance "B 10 3 o"<br/>

###Type of processors
<b>Line processor</b> = It processes Line commands<br/>
<b>Rectangle processo</b>r = It processesRectangle commands<br/>
<b>Bucket processor</b> = It processes Bucket commands<br/>

#How to run?

####Requirements
Java 8.

You can execute the jar file (DrawingTool-1.0.jar) and to specify the input file path (java -jar DrawingTool-1.0.jar someinput.txt) 
otherwise the input file it will be assumed as "input.txt" after of execution, an output file will be generated.
