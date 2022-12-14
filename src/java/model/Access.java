package model;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.HashMap;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Pet;

public class Access<E> implements Iterable<E> {

    public static EntityManager EM = Persistence.createEntityManagerFactory("PU").createEntityManager();

    public static Access<Pet> $Pet = new Access(Pet.class
    );

    // ---------------------------------------------------------------------- //
    private final Class<E> clazz;

    public final HashMap<String, Query> queries = new HashMap<>();

    // acesso.
    public Access(Class<E> clazz) {

        this.clazz = clazz;

        query("all", "");

    }
    // operacoes
    //excluir
    public void excluir(E e) {
        EM.getTransaction().begin();
        EM.remove(e);
        EM.getTransaction().commit();
    }

    //atualizar
    public void atualizar(E e) {
        EM.getTransaction().begin();
        EM.merge(e);
        EM.getTransaction().commit();
    }
    
    //adicionar
    public void adicionar(E e) {
        EM.getTransaction().begin();
        EM.persist(e);
        EM.getTransaction().commit();
    }

    public E get(Object pk) {
        return EM.find(clazz, pk);
    }
    // lista tudo.
    @Override
    public Iterator iterator() {
        return result("all").iterator();
    }

   

    public Query query(String name, String cond) {
        Query q = EM.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e " + cond);
        queries.put(name, q);
        return q;
    }

    public List<E> result(String queryName, Object... params) {
        Query q = queries.get(queryName);
        int i = 0;
        for (Parameter param : q.getParameters()) {
            q.setParameter(param, params[i++]);
        }
        return q.getResultList();
    }

}
