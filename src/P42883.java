class P42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int remove = k;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (sb.length() > 0 
                   && remove > 0 
                   && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                remove--;
            }
            sb.append(c);
        }
        // 아직 제거 못한 게 있으면 뒤에서 제거
        return sb.substring(0, sb.length() - remove);
    }
}
