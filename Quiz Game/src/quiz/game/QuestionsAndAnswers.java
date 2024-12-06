package quiz.game;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class QuestionsAndAnswers {

    public void fillQuestionsAndAnswers(String[][] questions, String[][] correctAns) {

        // Fill questions array
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        questions[10][0] = "Which keyword is used to inherit a class in Java?";
        questions[10][1] = "implements";
        questions[10][2] = "inherits";
        questions[10][3] = "extends";
        questions[10][4] = "super";

        questions[11][0] = "Which method is used to start a thread execution?";
        questions[11][1] = "run()";
        questions[11][2] = "execute()";
        questions[11][3] = "start()";
        questions[11][4] = "init()";

        questions[12][0] = "Which of the following is not a Java feature?";
        questions[12][1] = "Object-oriented";
        questions[12][2] = "Portable";
        questions[12][3] = "Use of pointers";
        questions[12][4] = "Dynamic";

        questions[13][0] = "Which of the following is a type of polymorphism in Java?";
        questions[13][1] = "Compile-time polymorphism";
        questions[13][2] = "Execution-time polymorphism";
        questions[13][3] = "Static polymorphism";
        questions[13][4] = "Both Compile-time and Execution-time polymorphism";

        questions[16][0] = "Which of the following is used to synchronize threads in Java?";
        questions[16][1] = "synchronized keyword";
        questions[16][2] = "Thread.sleep()";
        questions[16][3] = "wait() method";
        questions[16][4] = "notify() method";

        questions[15][0] = "What is the base class for all exception classes in Java?";
        questions[15][1] = "Throwable";
        questions[15][2] = "Exception";
        questions[15][3] = "RuntimeException";
        questions[15][4] = "Error";

        questions[16][0] = "Which Java keyword is used to define a constant variable?";
        questions[16][1] = "static";
        questions[16][2] = "const";
        questions[16][3] = "final";
        questions[16][4] = "volatile";

        questions[17][0] = "Which collection class does not allow duplicate elements?";
        questions[17][1] = "List";
        questions[17][2] = "Set";
        questions[17][3] = "Queue";
        questions[17][4] = "Map";

        questions[18][0] = "Which Java feature ensures the execution of only the required code for a task?";
        questions[18][1] = "Encapsulation";
        questions[18][2] = "Abstraction";
        questions[18][3] = "Inheritance";
        questions[18][4] = "Polymorphism";

        questions[19][0] = "What is the size of an int variable in Java?";
        questions[19][1] = "8 bits";
        questions[19][2] = "16 bits";
        questions[19][3] = "32 bits";
        questions[19][4] = "64 bits";

        questions[20][0] = "Which operator is used to create an object in Java?";
        questions[20][1] = "new";
        questions[20][2] = "create";
        questions[20][3] = "make";
        questions[20][4] = "allocate";

        questions[21][0] = "Which of the following is a reserved keyword in Java?";
        questions[21][1] = "goto";
        questions[21][2] = "null";
        questions[21][3] = "friend";
        questions[21][4] = "virtual";

        questions[22][0] = "What does the keyword 'super' refer to in Java?";
        questions[22][1] = "The current object";
        questions[22][2] = "The superclass object";
        questions[22][3] = "A static method";
        questions[22][4] = "A final variable";

        questions[23][0] = "Which method is used to stop a thread's execution permanently?";
        questions[23][1] = "wait()";
        questions[23][2] = "sleep()";
        questions[23][3] = "stop()";
        questions[23][4] = "terminate()";

        questions[24][0] = "What is the parent class of all classes in Java?";
        questions[24][1] = "Object";
        questions[24][2] = "Class";
        questions[24][3] = "Runtime";
        questions[24][4] = "Throwable";

        questions[25][0] = "Which of these can be used to fully abstract a class from its implementation?";
        questions[25][1] = "Abstract class";
        questions[25][2] = "Interface";
        questions[25][3] = "Both Abstract class and Interface";
        questions[25][4] = "None of the above";

        questions[26][0] = "Which keyword is used to define a method that cannot be overridden?";
        questions[26][1] = "static";
        questions[26][2] = "final";
        questions[26][3] = "protected";
        questions[26][4] = "private";

        questions[27][0] = "What is the default value of a boolean variable in Java?";
        questions[27][1] = "true";
        questions[27][2] = "false";
        questions[27][3] = "null";
        questions[27][4] = "0";

        questions[28][0] = "Which of the following is not a valid access modifier in Java?";
        questions[28][1] = "protected";
        questions[28][2] = "private";
        questions[28][3] = "public";
        questions[28][4] = "default";

        questions[29][0] = "Which method is called to garbage collect an object in Java?";
        questions[29][1] = "delete()";
        questions[29][2] = "gc()";
        questions[29][3] = "dispose()";
        questions[29][4] = "System.gc()";

        questions[30][0] = "What is the result of 10 / 3 in Java?";
        questions[30][1] = "3";
        questions[30][2] = "3.33";
        questions[30][3] = "4";
        questions[30][4] = "Error";

        questions[31][0] = "Which of these is not a primitive data type in Java?";
        questions[31][1] = "int";
        questions[31][2] = "String";
        questions[31][3] = "float";
        questions[31][4] = "double";

        questions[32][0] = "Which of the following creates a List in Java?";
        questions[32][1] = "List myList = new List();";
        questions[32][2] = "List myList = new ArrayList();";
        questions[32][3] = "List myList = new LinkedList();";
        questions[32][4] = "Both ArrayList and LinkedList";

        questions[33][0] = "Which is the default thread priority in Java?";
        questions[33][1] = "1";
        questions[33][2] = "5";
        questions[33][3] = "7";
        questions[33][4] = "10";

        questions[34][0] = "Which of the following is not part of the Java Collection Framework?";
        questions[34][1] = "ArrayList";
        questions[34][2] = "HashMap";
        questions[34][3] = "TreeSet";
        questions[34][4] = "Hashtable";

        questions[35][0] = "Which class is used to read text from a file in Java?";
        questions[35][1] = "FileReader";
        questions[35][2] = "FileInputStream";
        questions[35][3] = "BufferedReader";
        questions[35][4] = "Scanner";

        questions[36][0] = "Which of the following is not a valid state of a thread in Java?";
        questions[36][1] = "Running";
        questions[36][2] = "Blocked";
        questions[36][3] = "Ready";
        questions[36][4] = "Waiting";

        questions[37][0] = "Which keyword is used to handle exceptions in Java?";
        questions[37][1] = "catch";
        questions[37][2] = "try";
        questions[37][3] = "throw";
        questions[37][4] = "finally";

        questions[38][0] = "Which annotation is used to suppress warnings in Java?";
        questions[38][1] = "@SuppressWarnings";
        questions[38][2] = "@Deprecated";
        questions[38][3] = "@Override";
        questions[38][4] = "@SafeVarargs";

        questions[39][0] = "Which is the most restrictive access modifier in Java?";
        questions[39][1] = "private";
        questions[39][2] = "protected";
        questions[39][3] = "public";
        questions[39][4] = "default";

        // Fill answers array
        correctAns[0][0] = "JDB";
        correctAns[1][0] = "int";
        correctAns[2][0] = "java.util package";
        correctAns[3][0] = "Marker Interface";
        correctAns[4][0] = "Heap memory";
        correctAns[5][0] = "Remote interface";
        correctAns[6][0] = "import";
        correctAns[7][0] = "Java Archive";
        correctAns[8][0] = "java.lang.StringBuilder";
        correctAns[9][0] = "Bytecode is executed by JVM";
        correctAns[10][0] = "extends";
        correctAns[11][0] = "start()";
        correctAns[12][0] = "Use of pointers";
        correctAns[13][0] = "Both Compile-time and Execution-time polymorphism";
        correctAns[14][0] = "InterruptedException";
        correctAns[15][0] = "Throwable";
        correctAns[16][0] = "final";
        correctAns[17][0] = "Set";
        correctAns[18][0] = "Abstraction";
        correctAns[19][0] = "32 bits";
        correctAns[20][0] = "new";
        correctAns[21][0] = "goto";
        correctAns[22][0] = "The superclass object";
        correctAns[23][0] = "stop()";
        correctAns[24][0] = "Object";
        correctAns[25][0] = "Interface";
        correctAns[26][0] = "final";
        correctAns[27][0] = "false";
        correctAns[28][0] = "default";
        correctAns[29][0] = "System.gc()";
        correctAns[30][0] = "3";
        correctAns[31][0] = "String";
        correctAns[32][0] = "Both ArrayList and LinkedList";
        correctAns[33][0] = "5";
        correctAns[34][0] = "Hashtable";
        correctAns[35][0] = "FileReader";
        correctAns[36][0] = "Ready";
        correctAns[37][0] = "catch";
        correctAns[38][0] = "@SuppressWarnings";
        correctAns[39][0] = "private";

        // Create a list of indices for questions
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            indices.add(i);
        }

        // Shuffle the indices to randomize the order of questions
        Collections.shuffle(indices);

        // Create temporary arrays to hold the shuffled questions and answers
        String[][] shuffledQuestions = new String[questions.length][5];
        String[][] shuffledAnswers = new String[correctAns.length][1];

        // Reorder the questions and answers based on shuffled indices
        for (int i = 0; i < indices.size(); i++) {
            shuffledQuestions[i] = questions[indices.get(i)];
            shuffledAnswers[i] = correctAns[indices.get(i)];
        }

        // Replace the original arrays with the shuffled ones
        for (int i = 0; i < questions.length; i++) {
            questions[i] = shuffledQuestions[i];
            correctAns[i] = shuffledAnswers[i];
        }
    }
}
