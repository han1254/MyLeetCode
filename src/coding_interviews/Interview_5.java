package coding_interviews;

public class Interview_5 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        char[] newChars = new char[chars.length * 3];
        int size = 0;
        for (char temp :
                chars) {
            if (temp == ' ') {
                newChars[size++] = '%';
                newChars[size++] = '2';
                newChars[size++] = '0';
            } else {
                newChars[size++] = temp;
            }
        }
        return new String(newChars, 0, size);

    }
}
