/*

Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.

Examples :

Input: s1 = "geeks", s2 = "kseeg"
Output: true
Explanation: Both the string have same characters with same frequency. So, they are anagrams.
Input: s1 = "allergy", s2 = "allergic"
Output: false
Explanation: Characters in both the strings are not same, so they are not anagrams.
Input: s1 = "g", s2 = "g"
Output: true
Explanation: Character in both the strings are same, so they are anagrams.
*/
//Naive approach
static boolean areAnagrams(String s1, String s2) {
        
        // Sort both strings
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        // Compare sorted strings
        return Arrays.equals(s1Array, s2Array);
    }

//Time Complexity: O(m*log(m) + n*log(n)), where m and n are length of string s1 and s2 respectively.


//Approach 2:
/*The idea is to use a hash map or dictionary count the frequency of each character in both the input strings. If the frequency of every character matches in both strings, then the strings are anagrams. 


First, count the occurrences of each character in first string.
Then, decrement the count for each character in the second string.
If the strings are anagrams, all positions in the frequency array should be zero as any non-zero position means that the frequency of that character is not same in both strings.*/

static boolean areAnagrams(String s1, String s2) {
        
        // Create a hashmap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // Count frequency of each character in string s1
        for (char ch : s1.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
  
        // Count frequency of each character in string s2
        for (char ch : s2.toCharArray()) 
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
  
        // Check if all frequencies are zero
        for (var pair : charCount.entrySet()) {
            if (pair.getValue() != 0) {
                return false;
            }
        }
        
        // If all conditions satisfied, they are anagrams
        return true;
    }

//Approach 3 . Instead of hashMap use frequency Array
// As the input strings can only have lowercase 
// characters, the maximum characters will be 26

    static final int MAX_CHAR = 26;

    static boolean areAnagrams(String s1, String s2) {
        int[] freq = new int[MAX_CHAR];

        // Count frequency of each character in string s1
        for (int i = 0; i < s1.length(); i++)
            freq[s1.charAt(i) - 'a']++;

        // Count frequency of each character in string s2
        for (int i = 0; i < s2.length(); i++)
            freq[s2.charAt(i) - 'a']--;

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }
