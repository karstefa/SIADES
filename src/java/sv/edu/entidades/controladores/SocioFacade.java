/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.entidades.controladores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.entidades.Socio;

/**
 *
 * @author rgluis
 */
@Stateless
public class SocioFacade extends AbstractFacade<Socio> {
    @PersistenceContext(unitName = "AplicacionWebCooperativaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    public Socio obtenerPorUsuarioContrasenia(String usuario, String contrasenia){
        String jpql = "select s from Socio s where s.usuario = :usuario and s.contrasenia= :contrasenia";
        Socio s = null;
        try{
            Query q  = getEntityManager().createQuery(jpql);
            q.setParameter("usuario", usuario);
            q.setParameter("contrasenia", contrasenia);
            s=(Socio)q.getSingleResult();
        }catch(javax.persistence.NoResultException ne){}
        catch(Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public SocioFacade() {
        super(Socio.class);
    }
    
}
