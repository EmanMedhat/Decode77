package decodelz77;

public class DecodeLZ77 {

    public static void main(String[] args) {
       
		
        String str = "<0,0,a><0,0,b><2,1,a><3,2,b><5,3,b><1,10,a>";
        //test 2 << "<0,0,a><0,0,b><2,1,a><3,2,b><5,3,b><2,2,b><5,5,b><1,1,a>"
        String num="",decom="";
        String [] nchar = new String[100] ;
        int [] pos =  new int[100];
        int [] ln= new int[100];

        int len=str.length();
        int l=0,r=1,i=0;
        boolean c=true;
          while(len>=0){
              while(true)
              {   if(str.length()>r)
              {    r++;}
                  len--;
                      if(str.substring(r-1,r).equals(",")||str.substring(r-1,r).equals(">")||str.substring(r-1,r).equals("<"))
                            { l++;
                            break;}
                    }

              if(str.substring(r-1,r).equals(">")) {
                      nchar[i]=str.substring(r-2,r-1);
                       // System.out.println("nchar");
                     // System.out.println(nchar[i]);
                      i++;
                      if((r+1)>str.length())
                      break;
                      r++;
                      l=r-1;
              }
              else 
                      {  num=str.substring(l,r-1);
                        l=r-1;

              if(c)
                    {   
                 pos[i]=Integer.parseInt(num);
               //System.out.println("pos= ");
               //  System.out.println(pos[i]);
                        c=false;
                    }

              else 
                {  
                    ln[i] = Integer.parseInt(num);
                 // System.out.println("len= ");
                 // System.out.println(ln[i]);
                c=true;}
                    }
       }
          decom+=nchar[0];
      for(int j=1;j<i;j++) {
              if(ln[j]>pos[j]) {
                      int p=decom.length()-pos[j];
                      int l1=p+pos[j];
                      while(ln[j]>0) {
                              decom+=decom.substring(p,l1);
                              ln[j]-=pos[j];
                              p+=pos[j];
                              l1+=pos[j];
                      }
              }
              else if(pos[j]>0)
              { int p=decom.length()-pos[j];
              int l1=p+ln[j];
                   decom+=decom.substring(p,l1);}

                   decom+=nchar[j]; 		
      }
      System.out.println(decom);
	       
}

	}
    
    

