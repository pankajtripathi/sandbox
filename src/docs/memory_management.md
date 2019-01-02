### 1. What is Garbage Collection and what are its advantages?
Garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not,
and deleting the unused objects.   
The biggest advantage of garbage collection is that it removes the burden of manual memory allocation/deallocation 
from us so that we can focus on solving the problem at hand.


### 2. Are there any disadvantages of Garbage Collection?
Yes. Whenever the garbage collector runs, it has an effect on the application’s performance. This is because all other
threads in the application have to be stopped to allow the garbage collector thread to effectively do its work.   
Depending on the requirements of the application, this can be a real problem that is unacceptable by the client.
However, this problem can be greatly reduced or even eliminated through skillful optimization and garbage collector 
tuning and using different GC algorithms.


### 3. What is the meaning of the term “stop-the-world”?    
Depending on the needs of an application, “stop the world” garbage collection can cause an unacceptable freeze. 
This is why it is important to do garbage collector tuning and JVM optimization so that the freeze encountered is 
at least acceptable.


### 4. What are stack and heap? What is stored in each of these memory structures, and how are they interrelated?   
The stack is a part of memory that contains information about nested method calls down to the current position in the
program. It also contains all local variables and references to objects on the heap defined in currently executing 
methods.
The heap is a large bulk of memory intended for allocation of objects. When you create an object with the new keyword, 
it gets allocated on the heap. However, the reference to this object lives on the stack.


### 5. What is generational garbage collection and what makes it a popular garbage collection approach?   
Generational garbage collection can be loosely defined as the strategy used by the garbage collector where the heap 
is divided into a number of sections called generations, each of which will hold objects according to their “age” on
the heap.        
 
Whenever the garbage collector is running, the first step in the process is called marking. This is where the garbage 
collector identifies which pieces of memory are in use and which are not. This can be a very time-consuming process
if all objects in a system must be scanned.

As more and more objects are allocated, the list of objects grows and grows leading to longer and longer garbage
collection time. However, empirical analysis of applications has shown that most objects are short-lived.
        
With generational garbage collection, objects are grouped according to their “age” in terms of how many garbage 
collection cycles they have survived. This way, the bulk of the work spread across various minor and major collection 
cycles.    

Today, almost all garbage collectors are generational. This strategy is so popular because, over time, it has proven 
to be the optimal solution.


### 6. Describe in detail how generational garbage collection works
To properly understand how generational garbage collection works, it is important to first remember how Java heap
is structured to facilitate generational garbage collection.
    
The heap is divided up into smaller spaces or generations. These spaces are Young Generation, Old or Tenured Generation,
and Permanent Generation.    

The young generation hosts most of the newly created objects. The term “age” in generational garbage collection refers
to the number of collection cycles the object has survived.   

The old generation hosts objects that have lived in memory longer than a certain “age”. 

The permanent generation or more commonly called, PermGen, contains metadata required by the JVM 

Once an object survives a GC cycle it's moved to a section and once it reaches a threshold for young generation it is
moved to old generation.

### 7. How do you trigger garbage collection from Java code?
You, as Java programmer, can not force garbage collection in Java; it will only trigger if JVM thinks it needs a 
garbage collection based on Java heap size.

Before removing an object from memory garbage collection thread invokes finalize()method of that object and gives an 
opportunity to perform any sort of cleanup required. You can also invoke this method of an object code, however, there
is no guarantee that garbage collection will occur when you call this method.

### 8. What happens when there is not enough heap space to accommodate storage of new objects?
If there is no memory space for creating a new object in Heap, Java Virtual Machine throws OutOfMemoryError or more 
specifically java.lang.OutOfMemoryError heap space.


### 9. Describe strong, weak, soft and phantom references and their role in garbage collection.
By default, every object we create in a Java program is strongly referenced by a variable:
```StringBuilder sb = new StringBuilder();```   

Strongly referenced means they are not eligible for garbage collection. Now if we nullify sb then it becomes a weak 
reference and eligible for garbage collection.   
```sb = null```   

A soft reference can be created to the above object like this:   
```
StringBuilder sb = new StringBuilder();   
SoftReference<StringBuilder> sbRef = new SoftReference<>(sb);
sb = null;
```


