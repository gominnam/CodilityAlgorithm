package Programmers.Level2;

public class TheSongJustNow {
    class Music{
        int time;
        String title;
        public Music(int time, String title){
            this.time = time;
            this.title = title;
        }
    }

    public String solution(String m, String[] musicinfos) {
        StringBuilder answer = new StringBuilder("(None)");
        Music music = new Music(-1, "");
        for(String str : musicinfos){
            String[] splitStr = str.split(",");
            String splitStart[] = splitStr[0].split(":");
            String splitEnd[] = splitStr[1].split(":");
            int start = Integer.parseInt(splitStart[0])*60 + Integer.parseInt(splitStart[1]);
            int end = Integer.parseInt(splitEnd[0])*60 + Integer.parseInt(splitEnd[1]);
            int time = end-start;
            StringBuilder expansionMelody = new StringBuilder(splitStr[3]);
            while(expansionMelody.length() < 3000){
                expansionMelody.append(expansionMelody);
            }
            String[] parseMelody = expansionMelody.toString().split("#");
            expansionMelody.setLength(0);
            for(int i=0, cnt=1; i<parseMelody.length; i++){
                boolean flag = false;
                for(int j=0; j<parseMelody[i].length(); j++){
                    expansionMelody.append(parseMelody[i].charAt(j));
                    if(cnt++ == time) {
                        if(parseMelody[i].length()-1 == j) expansionMelody.append("#");
                        flag = true;
                        break;
                    }
                }
                if(flag) break;
                expansionMelody.append("#");
            }
            String melody = expansionMelody.toString();
            while(melody.contains(m)){
                int endIdx = melody.indexOf(m)+m.length();
                if(melody.length() > endIdx && melody.charAt(endIdx) == '#'){
                    melody = melody.substring(endIdx);
                    continue;
                }
                if(time > music.time){
                    music.time = time;
                    music.title = splitStr[2];
                }
                break;
            }
        }
        if(music.time != -1){
            answer.setLength(0);
            answer.append(music.title);
        }
        return answer.toString();
    }

    public static void main(String[] args){
        TheSongJustNow tsjn = new TheSongJustNow();
        String m = "ABCDEFG";
        String[] board = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.print(tsjn.solution(m, board));
    }
}
/*
실패한 TEST CASE:
String m = "CC#BCC#BCC#BCC#B";
String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

==> "FOO"
 */
