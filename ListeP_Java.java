import java.util.* ;

public class ListeP_Java extends ListePointAbstract
{
    private LinkedList liste= new LinkedList();

    public Object car() throws ListeVideException{
        if (listeVide()) 
            throw new ListeVideException();

        return liste.getFirst();
    }

    public void cdr() throws ListeVideException {
        if (listeVide()) 
            throw new ListeVideException();

        liste.removeFirst(); 
        nbreElements--;
    }

    public void cons(Object objet){
        if (objet == null) 
            return;

        liste.addFirst(objet); 
        nbreElements++;
    }

    public void conc(ListePointInterface li ){
        if(li == null) 
            return;

        for (int i = 0; i < li.longueur(); i += 1) {
            liste.add(li.getValue(i));
        }
    }

    public Object getValue(int index){
        return liste.get(index);
    }

    public void renverse() {
        if (listeVide()) 
            return;
        if (longueur() == 1) 
            return;

        // Solution en utilisant la liste elle-même
        try
        {
            Object temp = car();
            cdr();
            renverse();
            liste.add(temp);
        }
        catch (ListeVideException listeVideExc){}

        /*
         * // Solution en utilisant une autre LinkedList
         * LinkedList lst = new LinkedList();
         * Iterator<Object> it = iterator();
         * while (it.hasNext()) lst.addFirst(it.next());
         * liste = lst;
         */

    }

    public boolean membre(Object objet){
        return liste.contains(objet);
    }

    /* 
    // Ces trois méthodes existent déjà dans la classe ListePointAbstract
    public boolean listeVide(){
        return liste.isEmpty();
    }

    public int longueur(){
        return liste.size();
    }

    public boolean equals(Object obj){
        if(obj == null) 
            return false;        
        if(!(obj instanceof ListePointInterface)) 
            return false;

        ListePointInterface lst = (ListePointInterface)obj;
        if(longueur() != lst.longueur()) 
            return false;

        return liste.toString().equals(lst.toString());
    }
     */

    public Iterator<Object> iterator(){
        return this.liste.iterator();
    }

    public String toString(){
        return liste.toString();
    }

    public Object clone() throws CloneNotSupportedException{
        ListeP_Java lst = (ListeP_Java) super.clone();
        lst.liste = (LinkedList) liste.clone();

        return lst;
    }
}