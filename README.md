# Comparison of Complexity of Bubble Sort vs Selection sort

Check the complexity of the algorithms using number of operations performed. Your program should indicate the number of operations for inputs of different sizes. You are to run the algorithms on data of 3 different sizes i.e. n=500, n=5,000, and n=15,000, and for best, and worst cases. This data should be read from a text file. 

## Overview of Implementation

The program has following functions.

`void main(String[] args)` starting point of program.

`List<Integer> generateRandomData(int n)` function to generate random dataset, returns list of integers. Random numbers are generated in the range `0 .. MAX_DATA_VALUE - 1` inclusive. Current dataset is generated with `MAX_DATA_VALUE = 1000` (which is editable).

`void writeDataToFile(List<Integer> data)` function to write data to file, returns void.

`List<Integer> readDataFromFile(String filename)` function to read data from file, returns list of integers.

`Operation bubbleSort(List<Integer> A)` and `Operation selectionSort(List<Integer> A)` function to sort dataset, returns object of class Operation defined as:

```
static class Operation {
    int comparison;
    int swap;
}
``` 

## How to Run the Program

* The input dataset is read from files having naming convention `input-file-X-Y.txt` where `X` denotes one of `random`, `sorted` or `reverse`, and `Y` denotes the size of dataset `500`, `5000` and `15000`.
* Current program in `main.java` runs algos on `random` dataset.
* Change name of file `input-file-X-Y.txt` at `line:39` and `line:49` in `main.java` to run for _random_, _presorted_ and _reverse-sorted_ dataset.

## Output of Program

Here is output of the program in case of _random_, _presorted_ and _reverse-sorted_ dataset.

#### When dataset is random:
<pre>
Bubble Sort 	size: 500		comparisons: 124315			swaps: 62905
Bubble Sort 	size: 5000		comparisons: 12484620		swaps: 6381182
Bubble Sort 	size: 15000		comparisons: 112473585		swaps: 56374559
<br>
Selection Sort 	size: 500		comparisons: 124750			swaps: 496
Selection Sort 	size: 5000		comparisons: 12497500		swaps: 4989
Selection Sort 	size: 15000		comparisons: 112492500		swaps: 14973
</pre>
#### When dataset is presorted:
<pre>
Bubble Sort 	size: 500		comparisons: 499			swaps: 0
Bubble Sort 	size: 5000		comparisons: 4999			swaps: 0
Bubble Sort 	size: 15000		comparisons: 14999			swaps: 0
<br>
Selection Sort 	size: 500		comparisons: 124750			swaps: 0
Selection Sort 	size: 5000		comparisons: 12497500		swaps: 0
Selection Sort 	size: 15000		comparisons: 112492500		swaps: 0
</pre>
#### When dataset is reverse sorted:
<pre>
Bubble Sort 	size: 500		comparisons: 124750			swaps: 124623
Bubble Sort 	size: 5000		comparisons: 12497500		swaps: 12485013
Bubble Sort 	size: 15000		comparisons: 112492395		swaps: 112380218
<br>
Selection Sort 	size: 500		comparisons: 124750			swaps: 284
Selection Sort 	size: 5000		comparisons: 12497500		swaps: 3447
Selection Sort 	size: 15000		comparisons: 112492500		swaps: 10650
</pre>