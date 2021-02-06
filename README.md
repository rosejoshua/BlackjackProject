## Blackjack Project

###Description

This is a simple console-based Java application source code for simulating single-round Blackjack between a computer dealer and human player. Special care was taken to apply newly learned OOP principles of design. This program will not account for soft/hard aces and as a result, aces are always valued at 11. The author will update the program to handle variable ace values once the logic has been developed.

### Topics and Technologies Used

* OOP
* ArrayList
* for, for-each, while, and do-while loops
* enum
* interface
* toString()
* StringBuilder

###How to Run

Download all Java class files, compile, and run BlackjackApplication. Follow prompts in the console.

### Lessons Learned

This is the most complex program I have developed thus far due to the multiple class, interface and enum files. The BlackjackApplication run() method and associated helper methods have much more code than I think would be needed if this were a completely optimized build. I had multiple issues trying to prevent duplicate print statements related to scores of 21. This was mainly a result of breaking up score-related print statement functionality between methods contained in run() and helper methods outside of run(). In hindsight, this was definitely a mistake as solving one print statement issue inside of a helper method often created a new one as the program continued in run(). The next time I write a program similar to this, I will take care to plan my main application logic much more thoroughly before writing code, placing much less functionality in my run() method and moving that code to a consolidated collection of helper methods. I think recursive methods could prove useful in the future for condensing code.
