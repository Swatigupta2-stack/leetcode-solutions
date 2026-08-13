class Solution {
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l=0;
        int r= s.length()-1;
       while(l<r){
         char ch1 = s.charAt(l);
         char ch2 = s.charAt(r);
         if(ch1=='a'|| ch1=='e' || ch1=='i'|| ch1=='o'|| ch1=='u'||ch1=='A'|| ch1=='E' || ch1=='I'|| ch1=='O'|| ch1=='U')
         {
            if(ch2=='a'|| ch2=='e' || ch2=='i'|| ch2=='o'|| ch2=='u'||ch2=='A'|| ch2=='E' || ch2=='I'|| ch2=='O'|| ch2=='U'){
                char temp = ch1;
                sb.setCharAt(l, ch2);
                sb.setCharAt(r, temp);
                l++;
                r--;
            }
            else{r--;}
         }
         else{l++;}

       }
       s = sb.toString();
       return s;
    }
}