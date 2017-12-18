import java.util.*;

class Boardcover 
{
	public static final int[][][] shape = {{{1,0},{0,0},{0,1}},
										{{0,0},{0,1},{1,1}}, 
										{{1,-1},{0,0},{1,0}}, 
										{{1,0},{0,0},{1,1}}};

	public static final int PUT = 1;
	public static final int PICK = 0;

	public static int countCoverMethod(char[][] map)
	{
		int ret=0;
		int freeX = -1;
		int freeY = -1;

		for(int i=0; i<map.length; ++i)
		{
			for(int j=0; j<map[0].length; ++j)
			{
				if(map[i][j]=='.')
				{
					freeX = i;
					freeY = j;
					break;
				}
			}
			if(freeX!=-1)
			{
				break;
			}
		}

		if(freeX==-1)
		{
			ret+=1;
			return ret;
		}
		
		for(int i=0;i<shape.length;++i)
		{
			if(cover(freeX, freeY,map,i,PUT))
			{
				ret += countCoverMethod(map);
				cover(freeX,freeY,map,i,PICK);
			}
		}
		return ret;
	}




	public static boolean cover(int freeX, int freeY, char[][] map, int type,int option)
	{
		int mx;
		int my;
		char block;
		boolean canCover=true;

		if(option == PICK)
		{
			block = '.';
		}
		else
		{
			block ='#';

			for(int j=0; j<3; ++j)
			{	
				mx = freeX + shape[type][j][0];
				my = freeY + shape[type][j][1];
				if(map[mx][my]!='.')
				{
					canCover=false;
					break;
				}
			}
		}

		if(!canCover)
		{
			return false;
		}
		else
		{
			for(int j=0; j<3; ++j)
			{
				mx = freeX + shape[type][j][0];
				my = freeY + shape[type][j][1];
				map[mx][my] = block;
			}
		}
		return true;
	}

	public static void printMap(char[][] map)
	{
		for(int i=0; i<map.length; ++i)
		{
			for(int j=0; j<map[0].length; ++j)
			{
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int countSpace(char[][] map)
	{
		int count = 0;
		for(int i=0; i<map.length; ++i)
		{
			for(int j=0; j<map[0].length; ++j)
			{
				if(map[i][j] =='.')
				{
					++count;
				}
			}
		}
		return count;
	}
	


	public static void main(String[] args) 
	{
		int C;
		int H;
		int W;
		int count;
		String temp;

		Scanner scan = new Scanner(System.in);
		
		C = scan.nextInt();

		for(int i=0; i<C; ++i)
		{
			H = scan.nextInt();
			W = scan.nextInt();
			
			char[][] map = new char[H][W];


			for(int j=0; j<H; ++j)
			{
				temp = scan.next();
				map[j] = temp.toCharArray();
			}
			
			count = countSpace(map);

			if(count % 3 != 0)
			{
				System.out.println(0);
				continue;
			}

			System.out.println(countCoverMethod(map));


		}

		scan.close();


	}
}