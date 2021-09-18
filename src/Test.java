import java.util.*;


public class Test {


    public static void main(String[] args){
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        HashSet<String> menus = new HashSet<String>();
        for(String x : orders){
            menus.add(x);
        }
        List<String> menuList = new ArrayList<String>(menus);
        int[] chk = new int[menus.size()];

        for(int i=0; i<menuList.size(); i++){
            String menu = menuList.get(i);
            for(int j=0; j<orders.length; j++){
                boolean chkFlag = true;
                //if(menu.length() < orders[j].length()) continue;
                for(char x : menu.toCharArray()){
                    if(orders[j].indexOf(x) == -1){
                        chkFlag = false;
                        break;
                    }
                }
                if(chkFlag) chk[i]++;
            }
        }

        for(int i=0; i<menuList.size(); i++){
            String menu = menuList.get(i);
            boolean chkFlag = false;
            for(int x : course){
                if(menu.length() == x) chkFlag = true;
            }
            if(!chkFlag) chk[i] = 0;
        }

        ArrayList<String> tmp = new ArrayList<String>();
        for(int i=0; i<menuList.size(); i++){
            if(chk[i] != 0) tmp.add(menuList.get(i));
        }
        String[] answer = tmp.toArray(new String[0]);
        Arrays.sort(answer);

    }
}
