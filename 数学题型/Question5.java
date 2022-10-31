class Solution {
    public String longestPalindrome(String s) {
        String res = "";

		for(int i = 1; i <= s.length(); i++){

			int j = 0;
			while(i + j <= s.length()){
				String sub = s.substring(j, j + i);
				if(Pan(sub)){
					if(sub.length() > res.length()){
						res = sub;
						break;
					}
				}
				j++;
			}
		}
        return res;
    }

    public static boolean Pan(String sub){
		int left = 0;
		int right = sub.length() - 1;

		while(right > left){
			if(sub.charAt(left) != sub.charAt(right))
				return false;
			left++;
			right--;
		}

		return true;
	}
}