/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Douglas Glover
 */
package base;
import com.sun.jdi.CharValue;

import java.util.Scanner;
/*
An expert system is a type of artificial intelligence program that uses a knowledge base and a set of rules to perform a task that a human expert might do.
Many websites are available that will help you self-diagnose a medical issue by answering a series of questions.
And many hardware and software companies offer online troubleshooting tools to help people solve simple technical issues before calling a human.

Create a program that walks the user through troubleshooting issues with a car. Use the following decision tree to build the system:

@startuml
if (Is the car silent when you turn the key?) then (yes)
    if (Are the battery terminals corroded?) then (yes)
        :Clean terminals and try starting again.;
        stop
    else (no)
        :Replace cables and try again.;
        stop
    endif
else (no)
    if (Does the car make a slicking noise?) then (yes)
        :Replace the battery.;
        stop
    else (no)
        if (Does the car crank up but fail to start?) then (yes)
            :Check spark plug connections.;
            stop
        else (no)
            if (Does the engine start and then die?) then (yes)
                if (Does you car have fuel injection?) then (yes)
                    :Get it in for service.;
                    stop
                else (no)
                    :Check to ensure the choke is opening and closing.;
                    stop
                endif
            else (no)
                :This should not be possible.;
                stop
            endif
        endif
    endif
endif
@enduml

Example Output

Is the car silent when you turn the key? y
Are the battery terminals corroded? n
The battery cables may be damaged.
Replace cables and try again.

Constraint

Ask only questions that are relevant to the situation and to the previous answers. Don’t ask for all inputs at once.

Challenge

Investigate rules engines and inference engines. These are powerful ways to solve complex problems that are based on rules and facts.
Identify a rules engine for your programming language and use it to solve this problem
 */
public class App {
    Scanner in = new Scanner(System.in);
    static App myApp = new App();
    public static void main(String[] args) {
        myApp.troubleshoot();
    }
    void troubleshoot() {

        if (myApp.prompt("Is the car silent when you turn the key? "))
        {
            if (myApp.prompt("Are the battery terminals corroded? "))
            {
                System.out.print("Clean terminals and try starting again.");
            }
            else
            {
                System.out.print("Replace cables and try again.");
            }
        }
        else
        {
            if (myApp.prompt("Does the car make a slicking noise? "))
            {
                System.out.print("Replace the battery.");
            }
            else
            {
                if (myApp.prompt("Does the car crank up but fail to start? "))
                {
                    System.out.print("Check spark plug connections.");
                }
                else
                {
                    if (myApp.prompt("Does the engine start and then die? "))
                    {
                        if (myApp.prompt("Does you car have fuel injection? "))
                        {
                            System.out.print("Get it in for service.");
                        }
                        else
                        {
                            System.out.print("Check to ensure the choke is opening and closing.");
                        }
                    }
                    else
                    {
                        System.out.print("This should not be possible.");
                    }
                }
            }
        }
    }
    boolean prompt(String question)
    {
        while (true)
        {
            System.out.print(question);
            String input = in.nextLine();
            char c = input.charAt(0);

            if (c == 'Y' || c == 'y')
                return true;
            else if (c == 'N' || c == 'n')
                return false;
        }
    }
}
