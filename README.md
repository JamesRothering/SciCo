SciCo
=====

SciCo is code that helps put the science back into computer science.


0. Commencement and Current Status 

SciCo was envisioned by James Rothering in January 2013 and formal development commenced on February 4, 2013. For Current Status see below, #3 "Help/Documentation.

1. Description: 

SciCo is the code-name (pun intended!) for this project to enable more scientific study, analysis, and discussion of code. On StackOverflow people are always asking questions, and being told they need to post an SSCCE -- that is, a Simple Self-Contained Compileable Example. Well, extending from this idea, I envision a Social Web site built around such code snippets. The extension comes from the addition of the notion of a minimal pair. In linguistics, a minimal pair is a scientific use of comparison and contrast to identify a minimal discriminable unit. So, to apply this to computer languages, a pair of SSCCEs would identify one language principle. The first would fail to compile, the second would show the correct linguistically significant change to correct the syntax problem. Notice that, as I envision this, the failing code example will actually fail in the compiler before being added to the database. And the solution will also be compiler-verified prior to acceptance as a solution. Layered on top of all this, will be a social network carrying on the discussion, but always rooted in code rather than just questions. 

There are a number of Use Cases for such a code repository discussion network. This is a representative sampling, merely to help the reader get the vision. 
1. New language learners would have a forum for acquiring new languages systematically.
2. Problems and issues can be discussed in a more code-centric fashion.
3. Abstract principles such as "good code" versus "bad code" can be demonstrated by examples of each, to compare and contrast with each other.
4. Search can be performed by code elements as well as metadata.
5. A "quiz mode" allows students to improve their knowledge of the boundary-cases of a computer language, by presenting only code snippets (without the discussion text or syntax highlighting) and asking "will this compile". Of course, the answer could be yes or no. Furthermore, runtime problems can also be predicted: "will this run without exception?" Or, "what will the output of this be?" To check ones answer, one clicks a button to see the compiler output or the runtime output, and to receive the graded feedback. 

2. Installation/Hosting
At present, thanks to the kind sponsorship of Codojo, AWS hosting will be provided at  www.codojo.me/SciCo. Hosting will reside here during alpha and beta version development, until a sufficient level functionality is reached to be deemed an MVP (Minimal Viable Product. At some point the code-name may be changed and a separate web site provided. 

3. Help/Documentation
Github holds all project documentation under source control. See the "Documentation" directory for all such project development artifacts, such as product backlog, tutorials, etc. Most importantly, to determine current project status look to Documentation/Status. To contact the author, email to jr AT jamesrothering.com

4. Contribution Guidelines
At present this is a solo endeavor. Please contact the author with desired features and/or comments. 

5. Development Approach
This is an agile development working off a product backlog, using Test Driven Development and a Continuous Integration environment. As new code is pushed to github, the website -- once it reaches alpha -- will reflect the latest features. 
 
