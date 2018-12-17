import java.util.Scanner;
import java.lang.Math;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;


class undo                                                                     //for undo operation
{
	public char matrix[][]=new char[20][20];
	public int ar[]=new int [8];
	public int art[]=new int[18];
	public char r;
	int h;
	public void push(char mat[][],int m,int n,int rep[],int g,char rot,int arr[],int o,int y)          //push operation in stack
	{
		int i,j;
		for(i=0;i<m;i++)
			{
				for(j=0;j<n;j++)
					{
					matrix[i][j]=mat[i][j];
					}
			}
		for(i=0;i<g;i++)
		{
			ar[i]=rep[i];
		}
		for(i=0;i<18;i++)
		{
			art[i]=arr[i];
		}
		r=rot;
		h=y;
	}
	public char makeprev(char mat[][],int m,int n,int rep[],int g,char e,int arr[],int o,int so[],int len)      //go from current to previous state of program
	{
		int i,j;
		for(i=0;i<m;i++)
			{
				for(j=0;j<n;j++)
					{
					mat[i][j]=matrix[i][j];
					}
			}
		for(i=0;i<g;i++)
		{
			rep[i]=ar[i];
		}
		for(i=0;i<18;i++)
		{
			arr[i]=art[i];
		}
	e=r;
	so[0]=h;
	return e;
	}
}
class redo
{
	public char matrix[][]=new char[20][20];
	public int ar[]=new int [8];
	public int art[]=new int[18];
	public char r;
	int h;
	public void push(char mat[][],int m,int n,int rep[],int g,char rot,int arr[],int o,int y)          //push operation in stack
	{
		int i,j;
		for(i=0;i<m;i++)
			{
				for(j=0;j<n;j++)
					{
					matrix[i][j]=mat[i][j];
					}
			}
		for(i=0;i<g;i++)
		{
			ar[i]=rep[i];
		}
		for(i=0;i<18;i++)
		{
			art[i]=arr[i];
		}
		r=rot;
		h=y;
	}
	public char makeprev(char mat[][],int m,int n,int rep[],int g,char e,int arr[],int o,int so[],int len)      //go from current to previous state of program
	{
		int i,j;
		for(i=0;i<m;i++)
			{
				for(j=0;j<n;j++)
					{
					mat[i][j]=matrix[i][j];
					}
			}
		for(i=0;i<g;i++)
		{
			rep[i]=ar[i];
		}
		for(i=0;i<18;i++)
		{
			arr[i]=art[i];
		}
	e=r;
	so[0]=h;
	return e;
	}
	
}
class shape										
{
	public char s;				//s identifies shape of object
	public char rotation;
	public int cord[]=new int[8];				//array for storing points
	
	public shape(char shape,char r)                  //constructor declaration
	{
		s=shape;
		rotation=r;
	}
	public void dismiss(char mat[][],int r,int c)
	{	
	    mat[cord[0]][cord[1]]=mat[cord[2]][cord[3]]=mat[cord[4]][cord[5]]=mat[cord[6]][cord[7]]=' ';
	}
 public int assign(char [][]mat,int c,int r,int rep[],int f)       //assign initial coordinates to shape
	{
		int assigned=0;
		if(s=='l')
		{
			if(mat[1][8]==' ' && mat[1][9]==' ' && mat[1][10]==' ' && mat[1][11]==' ')
			{
				cord[0]=cord[2]=cord[4]=cord[6]=1;
				cord[1]=8;
				cord[3]=9;
				cord[5]=10;
				cord[7]=11;
				assigned=1;
			}
			else
			{
				assigned=0;
			}
		}
  		else if(s=='L')
		{
			if(mat[1][8]==' ' && mat[1][9]==' ' && mat[1][10]==' ' && mat[2][10]==' ')
			{
				cord[0]=cord[2]=cord[4]=1;
				cord[1]=8;
				cord[3]=9;
				cord[5]=10;
				cord[6]=2;
				cord[7]=10;
				assigned=1;
			}
			else
			{
				assigned=0;
			}
		}
		else if(s=='b')
		{
			if(mat[1][8]==' ' && mat[1][8]==' ' && mat[2][9]==' ' && mat[2][9]==' ')
			{
			cord[0]=cord[2]=1;
			cord[4]=cord[6]=2;
			cord[1]=cord[5]=8;
			cord[3]=cord[7]=9;
			assigned=1;
			}
			else
			{
				assigned=0;
			}
		}
		else if(s=='c')
		{
			if(mat[1][8]==' ' && mat[1][9]==' ' && mat[2][9]==' ' && mat[2][10]==' ')
			{
			cord[0]=cord[2]=1;
			cord[1]=8;
			cord[3]=cord[5]=9;
			cord[4]=cord[6]=2;
			cord[7]=10;
			assigned=1;
			}
			else
			{
				assigned=0;
			}
		}
		else if(s=='d')
		{
			if(mat[1][10]==' ' && mat[1][9]==' ' && mat[2][9]==' ' && mat[2][8]==' ')
			{
			cord[0]=cord[2]=1;
			cord[4]=cord[6]=2;
			cord[1]=10;
			cord[3]=cord[5]=9;
			cord[7]=8;
			assigned=1;
			}
			else
			{
				assigned=0;
			}
		}
		for(int j=0;j<8;)
		{
			int y=cord[j];
			int z=cord[j+1];
			mat[y][z]='#';
			j=j+2;
		}
		for(int i=0;i<8;i++)
		{
			rep[i]=cord[i];
		}
	return assigned;		
	}
	public void assignfromstack(int rep[],int g,char e)	//retrieve point's coordinates from undo stack
	{
		for(int i=0;i<8;i++)
		{
			cord[i]=rep[i];
		}
			rotation=e;
	}
	public int tonum(char[] gfg,int len,int i,char r,int s[],int size)
	{
		int d=0,sum=0;
		while(gfg[i]!=r)
	{
		d=(int)gfg[i]-48;
		
		sum=sum*10+d;
		i++;
	}
	i++;
	s[0]=i;
	return sum;
	}
	public void assignfromfile(char [][]mat,int c,int r,int rep[],int f,char[]gfg,int len,int arr[],int h)
	{
		int i=0;
		int s[]=new int[1];
		i=5;
		int j=0,sum=0,k=0,a=0,b=0,d=0;
		while(gfg[i]!=':')
		{
			i++;
		}
		i++;
		while(gfg[i]!='\n')
		{
			sum=0;
			sum=tonum(gfg,len,i,'-',s,1);
			a=sum;
			i=s[0];
			sum=tonum(gfg,len,i,',',s,1);
			i=s[0];
			b=sum;
			mat[a][b]='#';
			
		}
		i++;
		while(gfg[i]!=':')
		{
			i++;
		}
		i++;
		sum=0;
		while(gfg[i]!='\n')
		{sum=0;
			sum=tonum(gfg,len,i,'-',s,1);
			arr[j]=sum;
			i=s[0];
			j++;	
		}
		i++;
		while(gfg[i]!=':')
		{
			i++;
		}
		i++;
		rotation=gfg[i];
		
		i++;
		while(gfg[i]!=':')
		{
			i++;
		}
		i++;
		while(gfg[i]!='\0')
		{sum=0;
			sum=tonum(gfg,len,i,'-',s,1);
			a=sum;
			i=s[0];
			sum=0;
			sum=tonum(gfg,len,i,',',s,1);
			b=sum;
			i=s[0];
			cord[k]=a;
			cord[k+1]=b;
			mat[a][b]='#';
			k=k+2;
			
		}
		
		for(i=0;i<8;i++)
		{
			rep[i]=cord[i];
		}
		
		
	}
	public int move(char mat[][],int r,int c,char ch,int arr[],int g,int rep[],int f)	//move object
	{int i=0;
	if(ch=='d')                        //right movement
	  {
		if(mat[cord[0]][cord[1]+1]==' ' && mat[cord[2]][cord[3]+1]==' ' && mat[cord[4]][cord[5]+1]==' ' && mat[cord[6]][cord[7]+1]==' ')
		{
			 for(i=0;i<8;i++)
			{
				if(i%2!=0)
				{
					cord[i]++;
				}
			}
		}
	}
	else if(ch=='a')               //left movement
	{
		if(mat[cord[0]][cord[1]-1]==' ' && mat[cord[2]][cord[3]-1]==' ' && mat[cord[4]][cord[5]-1]==' ' && mat[cord[6]][cord[7]-1]==' ')
		{
			for(i=0;i<8;i++)
			{
				if(i%2!=0)
				{
					cord[i]--;
				}
			}
		}	
	}
	else if(ch=='s')                    //down movement
	{
	
	  for(i=0;i<8;i++)
		{
			if(i%2==0)
			{
				cord[i]++;
			}
		}
	}
			
	for(i=0;i<8;i++)	
	{
		rep[i]=cord[i];
	}
	
	if(mat[cord[0]+1][cord[1]]!=' ' || mat[cord[2]+1][cord[3]]!=' ' || mat[cord[4]+1][cord[5]]!=' ' || mat[cord[6]+1][cord[7]]!=' ')
	{
	
	
	for(int j=0;j<8;)
		{
			int y=cord[j];
			
			arr[y-1]++;
			int z=cord[j+1];
			mat[y][z]='#';
			j=j+2;
		}
	return 2;
	}
	else if(mat[cord[0]][cord[1]]==' ' && mat[cord[2]][cord[3]]==' ' && mat[cord[4]][cord[5]]==' ' && mat[cord[6]][cord[7]]==' ')
	{
	for(int j=0;j<8;)
		{
			int y=cord[j];
			int z=cord[j+1];
			mat[y][z]='#';
			j=j+2;
		}
	return 1;
	}
	else
	{
		return 0;
	}
	}
	
	
	
	 
}
class lines extends shape                            //for straight line
{
	
	public lines(char shape,char r)
	{
		super(shape,r);	
	}
         public char rotate(char mat[][],int r,int c,char cd)		//rotation of line
	{
		if(rotation=='N')
		{
			if((cord[0]-1)!=0 && mat[cord[6]+2][cord[7]]==' ')
			{
				cord[0]=cord[0]-1;
				cord[1]=cord[5]=cord[7]=cord[3];
				cord[4]=cord[4]+1;
				cord[6]=cord[6]+2;
				rotation=cd='R';	
			}
		}
		else if(rotation=='R')
		{
			if((cord[1]-1)!=0 && mat[cord[2]][cord[3]+2]==' ')
			{
				cord[0]=cord[4]=cord[6]=cord[2];
				cord[1]=cord[3]-1;
				cord[5]=cord[3]+1;
				cord[7]=cord[3]+2;
			}
		rotation=cd='N';
	
		}
		mat[cord[0]][cord[1]]=mat[cord[2]][cord[3]]=mat[cord[4]][cord[5]]=mat[cord[6]][cord[7]]='#';
		return cd;
	}
	
}
class hammer extends shape                                         //for L shape
{
	public hammer(char shape,char r)
	{	super(shape,r);	
	}
         public char rotate(char mat[][],int r,int c,char cd)
	{
		if(rotation=='N')
		{
			if((cord[2]-1)!=0 && mat[cord[2]+1][cord[3]]==' ' && mat[cord[0]+1][cord[1]]==' ')
			{
				cord[0]=cord[2]-1;
				cord[1]=cord[5]=cord[3];
				cord[4]=cord[6]=cord[2]+1;
				cord[7]=cord[3]-1;
				rotation=cd='S';
			}
			
		}
		else if(rotation=='S')
		{
			if(mat[cord[2]][cord[3]+1]==' ' && mat[cord[2]][cord[3]+2]==' ')
			{
				cord[4]=cord[6]=cord[2];
				cord[5]=cord[3]+1;
				cord[7]=cord[3]+2;
			rotation=cd='T';	
			}
			
		}
		else if(rotation=='T')
		{
			if(mat[cord[2]+1][cord[3]]==' ' && mat[cord[2]+2][cord[3]]==' ')
			{
				cord[0]=cord[4];
				cord[1]=cord[5];
				cord[4]=cord[2]+1;
				cord[5]=cord[7]=cord[3];
				cord[6]=cord[2]+2;
				rotation=cd='O';	
			}
		}
		else if(rotation=='O')
		{
			if(mat[cord[2]][cord[3]-1]==' '&& mat[cord[0]+1][cord[1]]==' ')
			{
				cord[4]=cord[0];
				cord[5]=cord[1];
				cord[1]=cord[3]-1;
				cord[6]=cord[0]+1;
				cord[7]=cord[5];
				rotation=cd='N';
			}
		}
		mat[cord[0]][cord[1]]=mat[cord[2]][cord[3]]=mat[cord[4]][cord[5]]=mat[cord[6]][cord[7]]='#';
		return cd;
	}
}
class stair extends shape                        //for zig-zag shape
{
	
	public stair(char shape,char r)
	{		super(shape,r);
	}
         public char rotate(char mat[][],int r,int c,char cd)
	{
		if(rotation=='N')
		{
			if(mat[cord[2]-1][cord[3]]==' ')
			{
				cord[0]=cord[2]-1;
				cord[1]=cord[3];
				cord[4]=cord[2];
				cord[5]=cord[3]-1;
				cord[7]=cord[5];
				cord[6]=cord[4]+1;
			}
		rotation=cd='R';	
		}
		else if(rotation=='R')
		{
			if(mat[cord[2]][cord[3]-1]==' ' && mat[cord[2]+1][cord[3]+1]==' ')
			{
				cord[0]=cord[2];
				cord[1]=cord[3]-1;
				cord[4]=cord[2]+1;
				cord[5]=cord[3];
				cord[6]=cord[2]+1;
				cord[7]=cord[3]+1;	
			}
			rotation=cd='N';
		}
		mat[cord[0]][cord[1]]=mat[cord[2]][cord[3]]=mat[cord[4]][cord[5]]=mat[cord[6]][cord[7]]='#';
		return cd;
	}

}
class box extends shape                                      //for box
{
	
	public box(char shape)
	{
		super(shape,'q');
	}
}
class backstair extends shape			//for opp. zig-zag shape
{
	public backstair(char shape,char r)
	{
		super(shape,r);	
	}
	public char rotate(char mat[][],int m,int n,char cd)
	{
		if(rotation=='N')
		{
			if(mat[cord[0]+1][cord[1]]==' ' && mat[cord[0]+1][cord[1]+1]==' ' && mat[cord[0]+2][cord[1]+1]==' ')
			{
				cord[2]=cord[4]=cord[0]+1;
				cord[3]=cord[1];
				cord[5]=cord[7]=cord[3]+1;
				cord[6]=cord[0]+2;
				rotation=cd='R';	
			}
			
		}
			else if(rotation=='R')
			{
				if(mat[cord[0]][cord[1]-1]==' ' && mat[cord[0]+1][cord[1]-1]==' ' && mat[cord[0]+1][cord[1]-2]==' ' )
				{
					cord[2]=cord[0];
					cord[3]=cord[5]=cord[1]-1;
					cord[4]=cord[6]=cord[0]+1;
					cord[7]=cord[1]-2;
					rotation=cd='N';
				}
			}
		mat[cord[0]][cord[1]]=mat[cord[2]][cord[3]]=mat[cord[4]][cord[5]]=mat[cord[6]][cord[7]]='#';
		return cd;
		}
}      
class tetris1
{
  // A Java program begins with a call to main().
  public static void main(String args[]) 
  {
	char choice,loadornew;
	Scanner r=new Scanner(System.in);
	int y=0,undovar=0,ch=0,assigned=0,redovar=0;
	int[]arr=new int[18];
	int so[]=new int[1];
	int[]rep=new int[8];
	char e='N';
	Character cd=new Character('N');
	undo u[]=new undo[1000];
	redo re[]=new redo[100];
	char [][]mat=new char[20][20];
	lines lin=new lines('l',cd);                       //forming objects
	hammer ham=new hammer('L',cd);                     //first parameter for identifying shape and second for initial rotation.
	box b=new box('b');
	stair classic=new stair('c',cd);
	backstair next=new backstair('d',cd);
        createboard(mat,20,20);
	System.out.print("COntinue Saved game-y---start new Game-n");
	loadornew=r.next().charAt(0);
	System.out.print(loadornew);
	if(loadornew=='y')
	{assigned=1;
	System.out.print("\nLoading saved game\n");
		try
		{
		StringBuffer s=new StringBuffer();
		FileReader fr = new FileReader("//home//anmol//info.txt"); 
    		int k,leng=0; 
    		while ((k=fr.read()) != -1) 
		      	{
				 s=s.append((char)k);
			}
		String str2 = s.toString();
	  	char[] gfg = str2.toCharArray();
		y=(int)gfg[y]-48;
		System.out.println(y);
		leng=str2.length();
		if(y==1)
			lin.assignfromfile(mat,20,20,rep,8,gfg,leng,arr,18);
		else if(y==2)
			ham.assignfromfile(mat,20,20,rep,8,gfg,leng,arr,18);
		else if(y==3)
			b.assignfromfile(mat,20,20,rep,8,gfg,leng,arr,18);
		else if(y==4)
			classic.assignfromfile(mat,20,20,rep,8,gfg,leng,arr,18);
		else if(y==5)
			next.assignfromfile(mat,20,20,rep,8,gfg,leng,arr,18);
		}
	catch(Exception es)
	{
	} 	
	}
	System.out.print("Start game-\n");
	
	do    
	{	
		if(loadornew!='y')
		{y++;
		if(y==6)
		{
			y=1;
		}
		if(y==1)
			assigned=lin.assign(mat,20,20,rep,8);
		else if(y==2)
			assigned=ham.assign(mat,20,20,rep,8);
		else if(y==3)
			assigned=b.assign(mat,20,20,rep,8);
		else if(y==4)
			assigned=classic.assign(mat,20,20,rep,8);
		else if(y==5)
			assigned=next.assign(mat,20,20,rep,8);
		}
		loadornew='n';
		printboard(mat,20,20);
		int check=1;
		while(check>0)
		{
			if(ch==0)
			{
				if(undovar==900)
				{
					int i=10,j=0;
					for(i=10;i<undovar;i++)
					{
						u[j]=u[i];
						j++;
					}
					undovar=j;
				}
				u[undovar]=new undo();
				u[undovar].push(mat,20,20,rep,8,cd,arr,18,y);
				undovar++;
			}
			 if(check!=2)
			{
				if(y==1)
					lin.dismiss(mat,20,20);
				else if(y==2)
					ham.dismiss(mat,20,20);
				else if(y==3)
					b.dismiss(mat,20,20);
				else if(y==4)
					classic.dismiss(mat,20,20);
				else if(y==5)
					next.dismiss(mat,20,20);
			}
			else
			{
				break;
			}
			choice=r.next().charAt(0);
			if(choice=='a' || choice=='s' || choice=='d')
			{		ch=0;		
				if(y==1)
					check=lin.move(mat,20,20,choice,arr,18,rep,8);
				else if(y==2)
					check=ham.move(mat,20,20,choice,arr,18,rep,8);
				else if(y==3)
					check=b.move(mat,20,20,choice,arr,18,rep,8);
				else if(y==4)
					check=classic.move(mat,20,20,choice,arr,18,rep,8);
				else if(y==5)
					check=next.move(mat,20,20,choice,arr,18,rep,8);
			redovar=0;
			}
			else if(choice=='w')
			{ch=0;
				check=1;
			        if(y==1)
				cd=lin.rotate(mat,20,20,cd);
				else if(y==2)
				cd=ham.rotate(mat,20,20,cd);
				else if(y==4)
				cd=classic.rotate(mat,20,20,cd);
				else if(y==5)
				cd=next.rotate(mat,20,20,cd);
				redovar=0;
			}
			else if(choice=='u' && undovar>=1)
			{
				e=u[undovar-1].makeprev(mat,20,20,rep,8,e,arr,18,so,1);
				y=so[0];
				if(y==1)
				lin.assignfromstack(rep,8,e);
			else if(y==2)
				ham.assignfromstack(rep,8,e);
			else if(y==3)
				b.assignfromstack(rep,8,e);
			else if(y==4)
				classic.assignfromstack(rep,8,e);
			else if(y==5)
				next.assignfromstack(rep,8,e);
				ch=1;
			re[redovar]=new redo();
			re[redovar].push(mat,20,20,rep,8,e,arr,18,y);
			redovar++;
			undovar--;
			}
			else if(choice=='r' && redovar!=0)
			{
				e=re[redovar-1].makeprev(mat,20,20,rep,8,e,arr,18,so,1);
				y=so[0];
				if(y==1)
			lin.assignfromstack(rep,8,e);
			else if(y==2)
			ham.assignfromstack(rep,8,e);
			else if(y==3)
			b.assignfromstack(rep,8,e);
			else if(y==4)
			classic.assignfromstack(rep,8,e);
			else if(y==5)
			next.assignfromstack(rep,8,e);
			redovar--;
			}
			else if(choice=='x')
			{
				System.out.println("Saving data in file");
				try
				{FileWriter fileWriter=new FileWriter("info.txt");
				  PrintWriter printWriter = new PrintWriter(fileWriter);
				int i=0,j=0;
				printWriter.printf("%d\n",y);
				printWriter.print("Mat Points:");
				for(i=1;i<19;i++)
				{
					for(j=1;j<19;j++)
					{
						if(mat[i][j]=='#')
						printWriter.printf("%d-%d,",i,j);
					}
				}
				printWriter.printf("\nRow count:");
				for(i=0;i<18;i++)
				{
					printWriter.printf("%d-",arr[i]);
				}
					printWriter.printf("\nRotation:%c",e);
					printWriter.printf("\nPoints:");
				for(i=0;i<8;)
				{
					printWriter.printf("%d-%d,",rep[i],rep[i+1]);
					i=i+2;
				}
					
				System.out.println("File Saved");
				printWriter.close();
				fileWriter.close();
				 System.exit(0); 
			}
			catch(Exception ko){System.out.println(ko);}    
			}
						printboard(mat,20,20);			
		}
	
	remove1(arr,18,mat,20,20);
	printboard(mat,20,20);
	}while(assigned==1);
	System.out.print("Gameover");
  }
	
	public static void removeline(char mat[][],int m,int n,int line,int i)   //removing lines from matrix
	{	
		if(i==line+1)
		{return;
		}
		removeline(mat,m,n,line,i+1);
		for(int j=1;j<n-1;j++)
		{
			mat[i][j]=mat[i-1][j];
		}
	}
	public static void formarray(int []arr,int g,int i)         //shifting array elements after deleting a line
	{
		int j;
		for(j=i;j>0;j--)
		{
			arr[j]=arr[j-1];
		}
		arr[j]=0;
	}
	public static void remove1(int []arr,int g,char mat[][],int m,int n)        //check for lines that are full.
	{
		for(int i=17;i>=0;i--)
		{
			while(arr[i]>=18)
			{
				removeline(mat,20,20,i+1,2);
				formarray(arr,18,i);
			}
		}
	}
   public static void createboard(char [][]mat,int r,int c)
	{int i=0,j=0;
	for(i=0;i<20;i++)
	{
		for(j=0;j<20;j++)
		{
			if(i==19 || i==0 || j==19 || j==0)
			{
				mat[i][j]='*';	
			}
			else
			{
				mat[i][j]=' ';
			}
		}
	}
	}
	public static void printboard(char [][]mat,int r,int c)
	{
		System.out.print("\033[H\033[2J");
		int i=0,j=0;
	System.out.println("      u-undo     r-redo     ");
	for(i=0;i<20;i++)
	{
		for(j=0;j<20;j++)
		{
			System.out.print(mat[i][j]+" ");	
		}
		System.out.println();	
	}
	}
  }
