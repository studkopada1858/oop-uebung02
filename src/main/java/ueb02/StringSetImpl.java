package ueb02;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;

public class StringSetImpl implements StringSet{
    class Element {
        String str="";
        Element left;
        Element right;
        Element(String strin, Element left, Element right){
            this.str=strin;
            this.left=left;
            this.right=right;

        }

    }

    private Element root =null;

    private static int counter=0;

    @Override
    public boolean add(String s) {


        if (root == null) {
            root = new Element(s,null,null) ;
            counter++;
            return true;
        }
        Element it =root;
        while (it != null) {
            if (s.equals(it.str)) {
                return false;
            }
            if (s.compareTo(it.str) > 0) {
                if(it.right==null){
                    it.right=new Element(s,null,null);
                    counter++;
                    return true;
                }else if (s.compareTo(it.str) > 0){
                    it=it.right;
                }}
            else if(s.compareTo(it.str)<0){
                 if(it.left==null){
                     it.left =new Element(s,null,null);
                     counter++;
                     return true;
                 }else if (s.compareTo(it.str)<0){
                     it=it.left;
                 }
             }
            }



    return false;
    }

        @Override
        public boolean contains (String s){
            if(root==null){
            return false;}

            Element it=root;

            while(it !=null){
                if(s.equals(it.str)){
                    return true;
                }
                if(s.compareTo(it.str)>0){
                    it=it.right;

                }else{
                    it=it.left;
                }


            }
            return false;
        }

        @Override
        public String remove (String s){
            return null;
        }

        @Override
        public int size () {
            return counter;
        }
    }
