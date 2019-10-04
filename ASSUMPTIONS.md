1. the triangle nodes should have the following structure: value, left child, right child
2. the system of nodes should be built from the bottom to top so we can have a layered implementation of nodes and each node can store the actual object to child node
3. assumption 1 and 2 results in the root element will contain the whole triangle
4. the algorythm processes all possible paths and select the minimum path by final value of summarization of numbers
5. the path processing will be recursive which may end up incrased runtime but the code will be more clean
6. the path will be a distinct object(called Route) which stores the sequence of operators(step left or right) and the final value of summarization so we just have to select the most optimal one and processing the triangle with that one. Like this I can print out the values step by step and the value at the very end
7. Reading of file and processing of nodes will be sorted out to different classes for the sake of clean code
8. I stick with immutability and functional tools as much as I can but some places I used var instead of val because it resulted in a logically easier implementation