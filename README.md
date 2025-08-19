 **Assignment Documentation**  
 #1. Ensure your repository includes setup instructions and an updated README.md --> **Done**  
 #2. Find the short description of my approach to solving each task  
   **Task-1 (Delete vendor)**  
   My approch is, deleting a vendor should happen from where we are displaying all the vender, So I place the delete button infornt of every row in
   vender table, which changes the state in store to open the dilog confirm box, before final delete.
   Delete is happening based on the id, if that id is not availble, it will throw the exception, on the UI saying,--> "Vendor with id <id> not found"
   and if it is available then a message will be displayed "<Vendor-name> Vendor deleted successfully !"
   From spring boot side, I have written a custom exception handler which will handle for all the delete request, where we are trying to delete the resource based on the id
   and will return an object with message which will be used to display to UI.

   **Task-2 (Fix the UI bug - Button Add Vendor duplicate entry)**
   For this bug, I have taken an local boolean state in the component, which will disable the add vendor button once it is clicked, and will again enable it once the            resetForm setTimer function is excuted, till then, it will keep showing the submiiting text on the button. Since the button is disabled, user won't be able to click          multiple times

   **Task-3 (Unique Emails)**
   To ensure the email across system, My approch is :
   1- Firstly, the unique constraint should be put at table level or entity level in our case, because, one system interect with many other system, if some other system            tries to insert the vendor details directly in our system, then it will throw the error.
   2- From api perpective side, I have created global exception handler which handle the DataIntegrityViolationException as we have put the unique constrain on the email           column, so this is the second level of check.
   3- Even the point 2 will not come into picture, as while submitting the form, I am checking if requested email already exit in db or not, if yes, then I am return a             message stating that the particular email id already registered.
      so Firt level of security is at DB or entity level, then at api level. 

#3. Highlight any assumptions, trade-offs, or challenges encountered during development.
    Yes, I have faced challenge while working on the fronted end side, as it was the first time for me I was working on the vue js, for which I have no idea how it work. 
    Still I don't know much about vue js, but from my past experience from react js, it help me to understand the logic behind the vue js.
    
#4. In your readme.md file, also answer the following questions:
    **What do I love most about being a software engineer.**
    Honestly, what I love most about being a software engineer is that I get to solve problems in creative ways. I enjoy learning new things all the time and it feels 
    great to turn ideas into something real that people actually use.
    
  **What is most important to me when it comes to working in a team**
    For me, the most important thing when working in a team is open communication and collaboration. I believe that when everyone shares ideas, gives constructive feedback,      and aligns on goals, it helps avoid misunderstandings and makes the work smoother. Along with that, mutual respect and trust are equally important.
    
   **What is the worst part of being a software engineer.**
    For me, one of the more challenging parts of being a software engineer is dealing with ambiguity—sometimes requirements aren’t clear, or priorities change midway. 
    It can be frustrating because it slows down progress. Another tough aspect is debugging issues that are hard to reproduce, which can take a lot of time and patience.

**Note--> Task-4  I haven't done anything. I am currently leaning it.**
**My Current ongoing learning stack**
 1- Docker and kubernetes.( completing target-October)
 2- Azure cloud.(Completing target October)
 3- AIML & GenAI(Pursing from IIT institute, it's 9 month program)  
