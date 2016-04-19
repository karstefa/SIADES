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
import sv.edu.entidades.Empleado;
import sv.edu.entidades.Socio;

/**
 *
 * @author rgluis
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {
    @PersistenceContext(unitName = "AplicacionWebCooperativaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Empleado obtenerPorUsuarioContrasenia(String usuario, String contrasenia){
        String jpql = "select e from Empleado e where e.usuario = :usuario and e.contrasenia= :contrasenia";
        Empleado em = null;
        try{
            Query q  = getEntityManager().createQuery(jpql);
            q.setParameter("usuario", usuario);
            q.setParameter("contrasenia", contrasenia);
            em=(Empleado)q.getSingleResult();
        }catch(javax.persistence.NoResultException ne){}
        catch(Exception e){
            e.printStackTrace();
        }
        return em;
    }
    
    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
}
