# Algorithms
##Search:
###Binary Search:  

>O(n) = log n

 Given a sort array of elements, we search an element X.
 - We have to split array in two sub-arrays  (first array, second array), and get the element it is at the middle Y.
 - Then we ask if X = Y. We have found it!!!
 - if X > Y we go on our search in second array
 - if X < Y  we go on our search in first array
 - Repeat recursively

###Breadth First Search

 Given a graph of type tree and we search an element X
 - Put first level in a FIFO
 - Get first and check if it is our element
 - If it is not our element added their child in the FIFO
 - Check next element in the FIFO
 - Repeat recursively
 - If it is not a tree we have to avoid cycles with some control


###Dijkstra's
 
Given a weighted graph without cycles and negative values
 - Create tables to store: graph, costs by node (initialize how long it takes to get this node since the start), parents by node (initialize start node)
 - Find the lowest cost node in costs table: node X
 - Calculate for every neighbors of this node X new costs
 - if it less than old, store this new costs and this node X like parent for this node
 - Marked node X as processed
 - Repeat again recursively, finding the lowest cost node avoiding processed nodes



##Sort:
###Select Sort: 
>O(n) = n^2

Given a unsorted array of elements.
 - Scanning the array every time to find out the smallest element
 - Repeat recursively

###Quick Sort: 
>O(n) = n log n

 Given a unsorted array of elements.
 - Shorting an array with divide and conquer.
 - Select a pivot
 - Divide array in two sub-arrays, elements less than the pivot and elements greater than the pivot
 - Repeat recursively

