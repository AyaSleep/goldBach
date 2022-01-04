import java.util.*;
import java.lang.*;
class Main {
  public static void main(String[] args) {
    int[] a = new int[1000000];
    for (int i = 0; i < a.length; i++){
      a[i] = i+1;
    }
    sieve(a);
    goldbach(a);
  }
  public static void sieve(int[] array){
    array[0] = 0;
    for (int z = 1; z < Math.sqrt(array.length); z++){
      if (array[z] == 0)
        continue;
      for (int u = z+array[z]; u < array.length; u+=array[z]){
        array[u] = 0;
      }
    }

    for (int prime : array){
      if (prime != 0)
        System.out.print(prime + " ");
    }
  
  }
  public static void goldbach(int[] array){
    array[0] = 0;
    ArrayList<Integer> nevo = new ArrayList<Integer>();
    nevo.add(0);
    for (int z = 1; z < Math.sqrt(array.length); z++){
      if (array[z] == 0)
        continue;
      for (int u = z+array[z]; u < array.length; u+=array[z]){
        array[u] = 0;
      }
    }
    for (int zz = 1; zz < array.length; zz++){
      if (array[zz] == 0)
        continue;
      nevo.add(array[zz]);
    }
    for (int h = 4; h <= 1000000; h+=2){
      for (int b = 1; b < nevo.size(); b++){
        int temp = h - nevo.get(b);
        if(nevo.contains(temp)){
          System.out.println(nevo.get(b) + " + " + temp + " == " + h);
          break;
        }
      }
    }
  }
}

// {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}
//           x     x     x      x       x       x       x
//                 x        x           x           x
//           E
