package com.example.myapplication;

import java.util.Scanner;

public class Project2 {
    public static Scanner input = new Scanner(System.in);
   public static String[] words = {"ellma","armut","kivi","domates","kavun"};
   public static char[] trueWord;
   public static int characterNumber = 1;
   public static char[] word ;
   public static int point;
   public static boolean ansver=false;
 public  static void main(String args []) {
  giveSomeSpace(2);
     boolean check=true;


     System.out.println("Oyuna başlamak için \"1\" e \n edit modu için \"0\" a basınız");

     if (input.nextInt() == 0)
         editingWords();


     while (true) {

         word();
         editingCharacterNumber();
         giveSomeSpace(0);
         gameStart();

         while(true){

             for (char s:word
             ) {
                 System.out.print(s);

             }



             boolean isTheyGiveAnsver=gameContinue();
             if(check()){
                 check=false;
                 break;}


             if(point<1 || !isTheyGiveAnsver){

                 break;}






         }
         String trueWordString="";
         for (char a:trueWord
         ) {trueWordString+=a;

         }



         if(!check){
             giveSomeSpace(0);
             System.out.println("Çok fazla harf istediniz");
             continue;

         }
         if(!ansver||point<=0){
             giveSomeSpace(3);
             System.out.println("Oyunu Kaybettiniz  Doğru cevap: "+trueWordString+ "\n Tekrar denemek için \"1\" Programı kapatmak için\"0\" a basınız");
             if(input.nextInt()==0)
                 break;}
         else{
             giveSomeSpace(4);
             System.out.printf("\nTebrikler %d Puan kazandınız",point);
             System.out.println("\n Tekrar denemek için \"1\" Programı kapatmak için\"0\" a basınız");
             if(input.nextInt()==0)
                 break;
         }
     }
giveSomeSpace(5);
 }











    public static void editingWords(){
        System.out.println("Oyuna kendi kelimelerinizi eklemek istermisiniz\n eklemek için \"1\" devam etmek için \"0\" a basınız");
        if(input.nextInt()==1){
            System.out.println("oyun içinde kullanmak istediğiniz kelimeleri yazınız\n 5 adet kelime girmeniz gerekmektedir");

            for (int i = 0 ; i<words.length;i++) {
                words[i] = input.next();

            }}
        for (int i = 0; i <10 ; i++) {
            System.out.println();
        }





    }
    public static void editingCharacterNumber(){
        System.out.println("Oyuna kaç harfle başlamak istersiniz ");

        while(true) {


            characterNumber = input.nextInt();

            if (characterNumber >= trueWord.length){
                System.out.println("girdiğiniz çok fazla başka bir değer giriniz");

            }
            else{

                break;}
        }


    }

    public static void word(){
        int a =(int) (Math.random()*5);
        String b=words[a];

        trueWord = new char[b.length()];
        for(int i = 0;i<b.length();i++){
            trueWord[i]=b.charAt(i);





        }




    }
    public static void gameStart(){

        int count=0;
        word = new char[trueWord.length];

        for(int i = 0 ; i<word.length;i++){
            word[i]='-';

        }

        while(characterNumber>0) {


            int x = (int) (Math.random() * word.length);
            for (int i = 0; i <word.length ; i++) {
                if(trueWord[x]==trueWord[i]){
                    word[i]=trueWord[x];

                }

            }




            characterNumber--;
        }
        for (char f:word
        ) {
            if (f=='-')
                count++;
        }
        point=count;
        System.out.println("Alabileceğiniz maksimum puan : "+point);


    }

    public static boolean gameContinue(){

        System.out.println(" \nHarfinizi giriniz\n   Cevabı tahmin etmek için \"0\" a basınız");
        String z = input.next();
        char a = z.charAt(0);
        int t=0;

        for (int i = 0; i <1 ; i++) {

            int count = 0;

            if(a=='0') {
                gameEnd();
                return false;

            }

            boolean zz = false;
            for (int c = 0; c <word.length ; c++) {
                if (trueWord[c] == a) {
                    for (int j = c; j <word.length ; j++) {
                        if(word[j]==a)
                            zz=true;
                        if(trueWord[j]==a&&word[j]=='-'){

                            word[j]=trueWord[j];
                            count++;


                        }
                    }
                }
                else
                    t++;

                giveSomeSpace(0);

            }
            if(zz)
                System.out.println("Bu harfi Daha önce kullandınız");
            point-=count;

            if(t==word.length) {
                System.out.println("Yazdığınız karakter bulunamadı");
                System.out.println("Puan Kaybettiniz ");
                point--;
            }
            System.out.printf("Puan : %d",point);
            System.out.println();
        }

        return true;
    }

    public static void gameEnd(){

        giveSomeSpace(1);
        System.out.println("Tahmininizi Giriniz");

        String s = input.next();
        for (int i = 0; i<trueWord.length ; i++) {
            if(trueWord.length==s.length()){

                if(trueWord[i]==s.charAt(i))
                    ansver=true;
                else{
                    ansver=false;
                    break;
                }
            }
            else
                ansver=false;
            break;

        }







    }

    public  static void giveSomeSpace(int x){

       if(x ==0)
        for (int i = 0; i <2; i++) {
            System.out.println("" +
                    "⠏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹\n" +
                    "⡆⠀⠀⠀⠀⠀⠠⣶⡶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⣾⡖⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠐⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⠿⣶⡄⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣷⣶⠿⠁⢀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣷⣷⣶⠿⠟⠃⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠨⣿⠀⠀⠀⠀⠀⠀⠀⢀⣴⡾⠛⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠨⣿⠀⠀⠀⠀⠀⠀⠀⠑⠉⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠨⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠨⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⢿⣦⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⢨⣿⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠁⠀⠀⢻⣷⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⠀⠀⢈⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⡇⠀⠀⠀⣶⣶⣾⣿⣶⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸\n" +
                    "⣧⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣼");
        }

if(x == 1)
    System.out.println("" +
            "⠀⠀⠀         ⠀⢠⣤⣶⣿⣿⣷⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⠿⠿⠿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣿⣿⡿⠁⠀⠀⠀⠘⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠋⠁⠀⠀⠀⢀⣴⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣤⣄⠀⠀⠀⣠⣾⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⢰⣿⠏⠉⢹⣿⠀⢀⣾⣿⣿⡿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠈⠛⠀⣰⣿⠟⠀⢸⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠇⠀⠀⠀⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢶⣶⠀⠀⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⢿⣿⣿⠇");




        if(x==2)
            System.out.println("" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡟⣛⣛⢛⣛⣛⣛⣛⢛⣛⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⡿⣣⣾⣿⣿⣿⡿⠸⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⣵⣿⣿⣿⣿⣿⢸⣿⢎⣿⣿⣿⣿⣿⣿⣿⡿⠛⢿⡿⠿⢿⣿⠟⠻⣿⠻⣿⠟⢿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⡷⢀⢺⣿⣿⣿⣿⣿⣿⣿⠇⠀⠈⡇⢰⠀⡟⠀⠀⢻⠀⠈⠀⢸⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣟⣼⡽⣧⠻⣿⣿⣿⣿⣿⣿⣠⣶⣄⣅⣠⣴⣇⣴⣦⣸⣠⣶⣄⣼⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⠇⣿⣿⣿⣿⡿⠛⢻⡿⠛⠻⠛⢿⠟⢻⡟⠛⢿⡿⠛⠛⢿⡟⠛⢿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡷⣿⣿⣿⣿⣿⣿⢏⣾⣌⢿⣿⣿⠃⠠⠈⡧⢈⠐⠀⠈⠀⢸⠁⠄⠘⡇⢰⡦⢼⠁⠄⠸⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⢿⣿⣿⣿⣿⣿⣼⣿⣿⣧⣿⣿⣤⣶⣤⣥⣤⣤⣤⣷⣧⣬⣤⣶⣤⣷⣤⣤⣮⣴⣶⣤⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⡇⣷⡝⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣗⣛⣛⣊⣛⣛⣛⣛⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ");




        if(x==3)
            System.out.println("" +
                    "⠀⣤⣶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣤⠀\n" +
                    "⠘⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⠃\n" +
                    "⠀⠈⠻⣿⣿⣿⣿⣦⡀⠀⠀⢀⣴⣿⣿⣿⣿⠟⠁⠀\n" +
                    "⠀⠀⠀⠈⠻⣿⣿⣿⣿⣦⣴⣿⣿⣿⣿⠟⠁⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⢀⣴⣿⣿⣿⣿⠟⠻⣿⣿⣿⣿⣦⡀⠀⠀⠀\n" +
                    "⠀⢀⣴⣿⣿⣿⣿⠟⠁⠀⠀⠈⠻⣿⣿⣿⣿⣦⡀⠀\n" +
                    "⢠⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⡄\n" +
                    "⠀⠛⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠿⠛⠀ ");



        if(x==4)
            System.out.println("" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⢀⣠⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠟⠁⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⡿⠁⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠋⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠟⠁⠀⠀⠀⠀⠀⠀\n" +
                    "⣤⣶⣶⣶⡀⠀⠀⠀⣰⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠘⣿⣿⣿⣇⠀⣠⣾⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠘⣿⣿⣿⣾⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠘⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠈⢻⡿⠃⠀⠀⠀");


        if(x==5)
            System.out.println("" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⣿⣿⡿⠿⣿⣿⡿⠿⢿⡿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⠀⣤⣤⡄⠀⢹⣷⡀⠘⡿⠁⢠⣿⡇⠀⣤⣤⣤⣼⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⠀⣀⣀⡀⠐⢿⣿⣿⡄⠀⢠⣿⣿⡇⠀⣀⣀⣀⣸⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⠀⠿⠿⠟⠀⣸⣿⣿⡇⠀⣿⣿⣿⡇⠀⠿⠿⠿⢿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣾⣿⣿⣿⣷⣶⣿⣿⣿⣷⣶⣶⣶⣶⣾⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ ");

    }











    public static boolean check(){

        int count=0;
        for (int i = 0; i <word.length ; i++) {
            if(word[i]=='-')
                count++;
        }
        if(count==0)
            return true;



        return false;






    }


   }









