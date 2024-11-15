# mp-sorting-maven

An exploration of sorting in Java.

Authors

* Princess Alexander
* Samuel A. Rebelsky (starter code)

Acknowledgements

* _Forthcoming_.

This code may be found at <https://github.com/princess-d-alexander/mp-sorting-maven>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------

A Creative Sorting Algorithm

The AlexanderPrincessSort algorithm combines the simplicity of bubble sort with the efficiency of merge sort. Descritopn below:

    Bubble Sort: First, we apply a single pass of bubble sort to the array. Bubble sort is fast for small or nearly sorted arrays because it checks adjacent elements and swaps them if they're out of order. If no swaps are made in a pass, we know the array is already sorted and can stop early.

    Merge Sort: If the array isn’t sorted after the bubble sort pass, we use merge sort. This breaks the array into smaller subarrays, sorts them, and then merges them back together in order. Merge sort is better for larger or more disordered arrays, ensuring efficiency even when the data is not nearly sorted.

By combining these two approaches, BubbleMergeSort adapts to the data, making it faster for small or partially sorted arrays while still being efficient for larger, more out of order ones.

Notes on using Copilot (or other AI)
------------------------------------

For information about how to implement the Dutch Sorting Algorithm I used the following website:
https://www.javatpoint.com/daa-dutch-national-flag 

FOr information about bubble sort:
https://hackajob.com/talent/blog/how-to-sort-in-java-selection-insertion-bubble

