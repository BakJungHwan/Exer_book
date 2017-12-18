class  ComparedString
{
	public static void main(String[] args) 
	{
		String a = "ABC";
		String b = "BAC";
		String c = "ABC";

		System.out.println(a == c);
		System.out.println();

		System.out.println(a.charAt(0) == b.charAt(1));
		System.out.println(a.charAt(0));
		System.out.println(b.charAt(1));
		System.out.println();
		
		System.out.println(a.substring(0,1) == b.substring(1,2));
		System.out.println(a.substring(0,1));
		System.out.println(b.substring(1,2));
		System.out.println();

		System.out.println("A" == "A");
	}
}
