package dat.backend.model.persistence;

public class CheckString {

    public static int stringToInt(String num){
        int ans = 0;
        String toInt ="";

        if (num.contains(".")){
            for(int i=0; i<=num.length() ;++i){
                if('.' == num.charAt(i)) {
                    break;
                }
                toInt += num.charAt(i);
            }
        }
        else{
            toInt = num;
        }

        ans = Integer.parseInt(toInt);

        return ans;
    }
}
