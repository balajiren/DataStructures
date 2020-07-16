package String;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
        public int compareVersion(String version1, String version2) {
        
        int result = 0;
        String[] strVersion1 = version1.split("\\.");
        String[] strVersion2 = version2.split("\\.");
        
        int n1 = strVersion1.length;
        int n2 = strVersion2.length;
        //Compare levels
        int i1, i2;
        for(int i=0;i<Math.max(n1,n2);i++) {
            i1 = i < n1 ? Integer.parseInt(strVersion1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(strVersion2[i]) : 0;
            if(i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        } 
          return 0;
        }

}
