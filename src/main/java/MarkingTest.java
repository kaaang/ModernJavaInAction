public class MarkingTest {
    public static void main(String[] args) {
        String email = "shinhyeok.kang@dshare.co.kr";
        String result = emailMarking(email);

        System.out.println(emailMarking("A@A.com"));
        System.out.println(emailMarking("AA@AA.com"));
        System.out.println(emailMarking("AAA@AAA.com"));
        System.out.println(emailMarking("AAAA@AAAA.com"));
        System.out.println(emailMarking("AAAAA@AAAAA.com"));
        System.out.println(emailMarking("AAAAAA@AAAAAA.com"));
        System.out.println(emailMarking("A@A.co.kr"));
        System.out.println(emailMarking("AA@AA.co.kr"));
        System.out.println(emailMarking("AAA@AAA.co.kr"));
        System.out.println(emailMarking("AAAA@AAAA.co.kr"));
        System.out.println(emailMarking("AAAAA@AAAAA.co.kr"));
        System.out.println(emailMarking("AAAAAA@AAAAAA.co.kr"));


        System.out.println(result);
    }

    private static String emailMarking(String email) {
        String tmp = "";

        String[] emailSplit = email.split("@");
        String[] domainSplit = emailSplit[1].split("\\.");

        tmp += wordMarking(emailSplit[0], false) + "@" + wordMarking(domainSplit[0], true) + ".";
        for (int i = 1; i < domainSplit.length; i++) {
            tmp += domainSplit[i];
            if(i != domainSplit.length-1){
                tmp += ".";
            }
        }


        return tmp;
    }

    private static String check(String word) {
        switch (word.length()){
            case 1 :
                return word;
            case 2 :
                return word.substring(0,1) + "*";
            case 3 :
                return word.substring(0,1) + "*" + word.substring(2,word.length());
            case 4 :
                return word.substring(0,1) + "**" + word.substring(3,word.length());
            default :
                return word.substring(0,1) + "***" + word.substring(4,word.length());
        }
    }

    private static String wordMarking(String word, boolean emailCheck) {
        int length = word.length();
        if(word.length() == 1) return emailCheck ? "*" : word;
        if(word.length() == 2) return word.substring(0,1) + "*";

        String star = "";
        int count = word.length()>4 ? 4 : word.length()-1;
        for (int i = 1; i < count; i++) {
            star += "*";
        }
        return word.substring(0,1) + star + word.substring(count,length);
    }

}
