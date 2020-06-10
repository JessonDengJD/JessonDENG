	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Scanner;
	import java.util.Set;
public class SplitWords {


		static List<String> list = new ArrayList<>();
		static List<String> list1 = new ArrayList<>();
		static List<String> list2=	Arrays.asList(new String[] 
				{"i", "like", "sam", "sung", "samsung","mobile"});
	    static Set<String> set = new HashSet<>();
	    static int maxLen = 0;
	    static boolean[] array;
	    static String s;
	    private static String s1,s2;;

	    public static void main(String[] args) {
	    	
	    	@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in); 
	    	System.out.println("please input words and split with , ");
	    	s1=sc.nextLine();
	    	String [] st=s1.split(",");
	    	for(int i=0;i<st.length;i++)
	    	{
	    		list1.add(st[i]);
	    	}
	    	System.out.println("please input  character string ");
	    	s2=sc.nextLine();
	    	outPut(s2,list1);
	    	}
	    	public static void  outPut(String s,List<String> wordDict) {
	    		boolean b=wordDict.addAll(list2);
	    		if(b) {
	    		List<String> res = wordSeparate(s,wordDict);
			    for (int i = 0; i < res.size(); i++) {
				System.out.println(res.get(i));
			    }
			}
		}
	    
	    public static List<String> wordSeparate(String ss, List<String> wordDict) {
	    	s = ss;
	        array = new boolean[s.length() + 1];
	        array[0] = true;
	        for (String word : wordDict) {
	            set.add(word);
	            maxLen = Math.max(maxLen, word.length());
	        }            
	        
	        for (int i = 0; i < s.length(); i++) {
	            if (array[i]) {
	                for (int j = i + 1; j <= Math.min(i + maxLen, s.length()); j++) {
	                    if (set.contains(s.substring(i, j)))
	                        array[j] = true;
	                }                
	            }
	        }
	        if (array[array.length - 1]) split(new StringBuilder(), 0);
	        return list;
	    }
	    
	    private static void split(StringBuilder sb, int start) {
	        if (start >= s.length()) {
	            list.add(sb.substring(0, sb.length() - 1));
	            return;
	        }        
	        if (array[start]) {
	            for (int i = start + 1; i <= Math.min(start + maxLen, s.length()); i++) {
	                String word = s.substring(start, i);
	                if (set.contains(word)) {
	                    sb.append(word + " ");
	                    split(sb, i);
	                    sb.delete(sb.length() - 1 - word.length(), sb.length());
	                }
	            }
	        }
	    }
	    

	    
	}


