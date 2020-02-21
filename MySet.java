import java.util.*;
public class MySet extends LinkedList{

 //add method add()without duplication
 public void add(int item){
  if(!isFound(item))
   addLast(item);
 }
 
 public MySet union(MySet set){
 
 MySet union = new MySet();
 Node p = this.head;
 while(p != null)
  {
   union.add(p.getItem());
   p = p.getNext();
  }
 //proceed to argument object
 Node p2 = set.head;
 while(p2 != null){
  union.add(p2.getItem());
  p2 = p2.getNext();
 }
 return union;
 }
 
 public MySet intersection(MySet set){
   MySet inter = new MySet();
   //Node p = this.head;
   Node p2 = set.head; 
   /*while(p!=null){
      while(p2!=null){
         if(p.getItem()==p2.getItem())
         inter.add(p.getItem());
         p2 = p2.getNext();
      }
      p = p.getNext();
      p2 = set.head;
   }*/
   while(p2!=null){
      if(isFound(p2.getItem()))
      inter.add(p2.getItem());
      p2 = p2.getNext();
   }
   return inter;
 }
 
 public MySet difference(MySet set){
   MySet diff = new MySet();
   Node p = this.head;
   //Node p2 = set.head;
   while(p!=null){
      //while(p2!=null){
         if(!set.isFound(p.getItem()))
         diff.add(p.getItem());
         //p2 = p2.getNext();
      //}
      p = p.getNext();
      //p2 = set.head;
   }
   return diff;
 }
 public boolean isSubset(MySet set){
   boolean check = true;
   Node p2 = set.head;
   while(p2!=null){
      if(!this.isFound(p2.getItem())){
         check = false;
         break;
      }
      p2 = p2.getNext();
   }
   return check;
 }
 public int cardinality(){
   return getCount();
 }
 
 public static void main(String []args){
  Scanner sc = new Scanner(System.in);
  int [] A = new int[4];
  int [] B = new int[4];
  MySet setA = new MySet();
  MySet setB = new MySet();
  
  for(int i=0; i<A.length; i++){
   A[i] = sc.nextInt();
  }
  for(int i=0; i<A.length; i++){
   B[i] = sc.nextInt();
  }
  setA.add(A[0]);
  setA.add(A[1]);
  setA.add(A[2]);
  setA.add(A[3]);
  setB.add(B[0]);
  setB.add(B[1]);
  setB.add(B[2]);
  setB.add(B[3]);
  /*
  setA.add(1);
  setA.add(2);
  setA.add(3);
  setA.add(4);
  setB.add(4);
  setB.add(3);
  setB.add(2);
  setB.add(1);
  */
  System.out.println("setA contains : " + setA);
  System.out.println("setB contains : " + setB);
  System.out.println("setA.union(setB) = " + setA.union(setB));
  System.out.println("setA.intersection(setB) = " + setA.intersection(setB));
  System.out.println("setA.difference(setB) = " + setA.difference(setB));
  System.out.println("setA.isSubset(setB) = " + setA.isSubset(setB));
  System.out.println("|setA| = " + setA.cardinality());
  System.out.println("|setB| = " + setB.cardinality());
 }

}