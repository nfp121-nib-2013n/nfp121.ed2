import java.util.Iterator ;

public class ListeP_Rec extends ListePointAbstract
{
    private Maillon elem;

    public  Object car() throws ListeVideException {
        if (listeVide()) 
            throw new ListeVideException();

        return elem.valeur();
    }

    public  void cdr() throws ListeVideException {
        if (listeVide()) 
            throw new ListeVideException();

        elem = elem.suite();
        nbreElements--;
    }

    public  void cons(Object obj){
        if (obj == null) 
            return;

        if (elem == null) {
            elem = new Maillon(obj);
            nbreElements = 1;
        }
        else if (elem.valeur() == null) {
            elem = new Maillon(obj, elem.suite());
            nbreElements = 1;
        }
        else {
            elem = new Maillon(obj, elem);
            nbreElements ++;
        }
    }

    public  void conc(ListePointInterface liste ){
        if (liste == null) 
            return;
        if (liste.listeVide()) 
            return;

        Maillon maillon = elem;
        while (maillon.suite() != null)
            maillon = maillon.suite();

        for (int i = 0; i < liste.longueur(); i += 1) {
            maillon.modifSuite(new Maillon(liste.getValue(i)));
            maillon = maillon.suite();
            nbreElements++;
        }
    }

    public Object getValue(int index){
        int compteur = 0;
        Maillon maillon = elem;

        while (maillon.suite() != null && index != compteur){
            maillon = maillon.suite();
            compteur ++;
        }

        return maillon.valeur();
    }

    public  void renverse(){
        if (listeVide()) 
            return;
        if (longueur() == 1) 
            return;

        ListeP_Rec lst = new ListeP_Rec();
        Iterator<Object> it = iterator();
        while (it.hasNext()) lst.cons(it.next());

        elem = lst.elem;
    }

    public  boolean membre(Object objet){
        if(objet == null) 
            return false;
        if (listeVide()) 
            return false;

        Maillon temp = elem;
        while (temp != null){
            if (temp.valeur().equals(objet)) 
                return true;
            temp = temp.suite();
        }

        return false;
    }

    public String toString(){
        if (listeVide())
            return "[]";

        String result = "[";
        Iterator<Object> it = iterator();
        while (it.hasNext())
        {
            Object valeur = it.next();
            result += valeur.toString() + ", ";
        }

        return result.substring(0, result.lastIndexOf(",")) + "]";
    } 

    /*
    // Ces trois méthodes existent dans la classe ListePointAbstract
    public  boolean listeVide(){
        return nbreElements == 0;
    }

    public  int longueur(){
        return nbreElements;
    }

    public boolean equals(Object obj){
        if (obj == null) 
            return false;
        if(!(obj instanceof ListePointInterface)) 
            return false;

        ListePointInterface lst = (ListePointInterface)obj;
        if(longueur() != lst.longueur()) 
            return false;

        // Dans le cas où l'ordre des éléments n'est pas important
        for (int i = 0; i < longueur(); i += 1)
        {
            if (!membre(lst.getValue(i)))  
                return false;
        }
        return true;

        // Si l'ordre des éléments est important:

        // Solution sans utilisation de toString()
        for (int i = 0; i < longueur(); i += 1)
            if ((elem != null) && !elem.valeur().equals(lst.getValue(i)))
                return false;

       // Solution avec utilisation toString()
       return this.toString().equals(lst.toString());
    }
     */

    public Object clone() throws CloneNotSupportedException {
        ListeP_Rec lst = (ListeP_Rec) super.clone();
        lst.elem = (Maillon) elem.clone();

        return lst;
    }

    public Iterator<Object> iterator(){
        return new Iterator<Object>(){
            Maillon temp = elem;

            public boolean hasNext(){
                return temp != null;
            }

            public Object next(){
                if(temp == null) return null;
                Object obj = temp.valeur();
                temp = temp.suite();
                return obj;
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }

        };
    }

    private class Maillon implements Iterable<Object>, Cloneable
    {
        private Object valeur;
        private Maillon suite;

        public Maillon(Object valeur){
            this.valeur=valeur;
            this.suite=null;
        }

        public Maillon(Object valeur,Maillon suite){
            this.valeur=valeur;
            this.suite=suite;
        }

        public Object valeur(){
            return valeur;
        }

        public Maillon suite(){
            return suite;
        }

        public void modifSuite(Maillon m){
            suite = m;
        }

        public boolean equals(Object that){
            if (that == null) 
                return false;
            if (!(that instanceof Maillon)) 
                return false;

            Maillon maillonThat = (Maillon)that;
            Object valeurThis = valeur();
            Object valeurThat = maillonThat.valeur();

            if ((valeurThis == null) && (valeurThat != null)) 
                return false;
            if ((valeurThis != null) && !valeurThis.equals(valeurThat))
                return false;

            return (this.suite() == maillonThat.suite());
        }

        public String toString(){
            return ((valeur() != null) ? "NULL" : valeur().toString());
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon maillon = (Maillon) super.clone();
            return maillon;
        }

        public java.util.Iterator iterator(){
            return new java.util.Iterator(){            
                Maillon temp = new Maillon(valeur , suite);

                public boolean hasNext(){
                    return temp != null;
                }

                public Object next(){
                    if (temp == null) return null;
                    Object obj = temp.valeur();
                    temp = temp.suite();
                    return obj;
                }

                public void remove(){
                    throw new UnsupportedOperationException();
                }

            };
        }
    }
}