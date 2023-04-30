package miscallaneous;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String st = "Example Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index";
       /* System.out.println(st.equals("Anirudh"));
        CharSequence charSequence=new StringBuffer("Anirudh");
        System.out.println(st.contentEquals(charSequence));*/
//        System.out.println(st.endsWith("dh"));

        /*int n=76;
        System.out.println(String.valueOf((int)Math.pow(n,2)).endsWith(String.valueOf(n)));*/
           /* char[] c=new char[4];
            st.getChars(1,5,c,0);
        System.out.println(Arrays.toString(c));*/
//        String.format()
        /*int i=0,sum=0;
                while(i<st.length()){
                    int index=st.indexOf('i');
                    sum+=index;
                    System.out.print(sum+" , ");
                    st=st.substring(index+1);
                    i=index;
                }*/
//            int a=45;
//        System.out.printf("a value is %#d",a);
//        System.out.println(String.format("a value is %#d",a));
        /*String ab="dhvbbhvhfbhfv";
        System.out.println( ab.indexOf("bhf"));*/

            String str="Example";

//        System.out.println(str.offsetByCodePoints(2,4));
//        Character.offsetByCodePoints();
//        System.out.println( str.regionMatches(1,st,0,5));

//        System.out.println(str.replace("Ex","ex"));
//        System.out.println(str.startsWith("am",2));
             /*  String s= str.subSequence(0,3).toString();
        System.out.println(s);*/
        String s=String.valueOf(5);
//        System.out.println(s instanceof  String);

    }
}
