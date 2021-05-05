package proj4;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main extends MaxHeap<String> 
{
  public static void main(String[] args) throws IOException 
  {
    Integer[] randomNumArray = new Integer[100];
    Scanner scannerForS = new Scanner(new File("C:\\Users\\diego\\Desktop\\Proj4fol\\data_random.txt"));
    while(scannerForS.hasNextInt())
    {
      for (int i = 0; i < 100; i ++)
      randomNumArray[i] = scannerForS.nextInt();
    }

    Integer[] sortedNumArray = new Integer[100];
    Scanner scannerForSeqSor = new Scanner(new File("C:\\Users\\diego\\Desktop\\Proj4fol\\data_sorted.txt"));
    while(scannerForSeqSor.hasNextInt())
    {
      for (int i = 0; i < 100; i ++)
      sortedNumArray[i] = scannerForSeqSor.nextInt();
    }

    //create four heaps for sequetially added method and for reheap method
    MaxHeapInterface<Integer> randomSeqHeap = new MaxHeap<Integer>(100);
    MaxHeapInterface<Integer> randomSmartHeap = new MaxHeap<Integer>(randomNumArray);
    MaxHeapInterface<Integer> sortedSeqHeap = new MaxHeap<Integer>(100);
    MaxHeapInterface<Integer> sortedSmartHeap = new MaxHeap<Integer>(sortedNumArray);

    for(int currentNum: randomNumArray)
    {
        randomSeqHeap.add(currentNum);
    }
    for(int currentNum: sortedNumArray)
    {
        sortedSeqHeap.add(currentNum);
    }

    writeData(randomSeqHeap,randomSmartHeap,"Random.txt");
    writeData(sortedSeqHeap,sortedSmartHeap,"Sorted.txt");
  }

  public static void writeData(MaxHeapInterface<Integer> SeqHeap, MaxHeapInterface<Integer> OptHeap, String fileName) throws IOException
  {
    //get sorted heap arrays as object arrays
    Object[] sequentialOutput = SeqHeap.getHeap();
    Object[] optimalOutput = OptHeap.getHeap();

        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(fileName));
  
        //Start of sequential 
        outputWriter.append("Heap built using sequential insertions: ");
  
        for (int i = 1; i < 11; i++) {
          outputWriter.append(String.valueOf(sequentialOutput[i]));
          if (i < 10)
          {
            outputWriter.append(",");
          }
        }			outputWriter.append("...");
        outputWriter.append("\nNumber of swaps in the sequential heap creation: " + SeqHeap.getNumSwapsS() + "\n");

        for(int i = 1; i < 11; i++)
        {
          SeqHeap.removeMax();
        }
        outputWriter.append("Heap after 10 removals: ");
        sequentialOutput = SeqHeap.getHeap();
  
        for (int i = 1; i < 11; i++) {
          outputWriter.append(String.valueOf(sequentialOutput[i]) +"");
          if (i < 10)
          {
            outputWriter.append(",");
          }
        }

        // Start of optimal
        outputWriter.append("\nHeap built using optimal insertions: ");
  
        for (int i = 1; i < 11; i++) {
          outputWriter.append(String.valueOf(optimalOutput[i]));
          if (i < 10)
          {
            outputWriter.append(",");
          }
        }			outputWriter.append("...");
  
        outputWriter.append("\nNumber of swaps in the optimal heap creation: " + OptHeap.getNumSwaps() + "\n");

        for(int i = 1; i < 11; i++)
        {
          OptHeap.removeMax();
        }
        outputWriter.append("Heap after 10 removals: ");
        optimalOutput = OptHeap.getHeap();
  
        for (int i = 1; i < 11; i++) {
          outputWriter.append(String.valueOf(optimalOutput[i]));
          if (i < 10)
          {
            outputWriter.append(",");
          }
        }
        outputWriter.append("...");
        outputWriter.flush();  
        outputWriter.close(); 
  }
}
