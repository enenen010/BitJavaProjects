package com.bit;

class MyErr extends Exception{
   MyErr(){
      super("내가 정한 메시지");
   }
}

public class Ex33 {

   public static void main(String[] args) {
      try {
      func(4,4);
      }catch(Exception e) {
         e.printStackTrace();
//      }catch(ClassNotFoundException e) {
//         System.out.println("던진 에러를 받아서 처리");
      }
   
   }
//런타임은 실행해봐야 알음, 강제성이 없음
//런타임이 아닌 것은 이미 에러를 수반하고 있음 -> try-catch 강제화
   private static void func(int i, int j) 
         throws ClassNotFoundException, MyErr {
//      try {
      if(i/j==1) {         //미리 확인하여 특정 조건에서만 에러처리
         MyErr err = new MyErr();
         throw err;
         
//         ClassNotFoundException err=new ClassNotFoundException();
//         throw err;
      }
      int su=i/j;
//      }catch(ArithmeticException e) {
//         
//      }
      
   }

}